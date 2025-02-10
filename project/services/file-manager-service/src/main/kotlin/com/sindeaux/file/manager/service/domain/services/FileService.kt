package com.sindeaux.file.manager.service.domain.services

import com.sindeaux.file.manager.service.commons.exceptions.UploadFileException
import com.sindeaux.file.manager.service.domain.models.files.SourceFileModel
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

@Service
class FileService (
    @Value("\${resources.volume.upload.directory-name}")
    private val uploadDirectoryName: String,
    @Value("\${resources.volume.files.name-separator}")
    private val filenameSeparator: String,
    private val cryptoService: CipherSecurityService
){

    fun saveFile(file: MultipartFile) : SourceFileModel {

        val cleanedFileName = StringUtils.cleanPath(file.originalFilename.orEmpty())
        val extension = cleanedFileName.split(".").lastOrNull()

        runCatching {

            if(cleanedFileName.isBlank() || cleanedFileName.contains("..")) {
                throw UploadFileException("Invalid name file")
            }

            if(extension.isNullOrEmpty() || extension.equals(cleanedFileName, ignoreCase = true)) {
                throw UploadFileException("Invalid file extension")
            }

            val encryptedSource = cryptoService.encryptSource(cleanedFileName)
            val encryptedName = encryptedSource.generateSourceNameCombination(filenameSeparator)
                .plus(".${extension}")

            val sourceFileModel = SourceFileModel(
                cleanedFileName,
                encryptedName,
                file.contentType,
                file.size
            )

            createDirectoryIfNotExists().resolve(encryptedName)
                .also { target ->
                    Files.copy(file.inputStream, target, StandardCopyOption.REPLACE_EXISTING)
                }

            return sourceFileModel

        }.getOrElse { ex ->
            throw UploadFileException("Unable to upload the file", ex)
        }
    }


    private fun createDirectoryIfNotExists() : Path {
        runCatching {
            return Paths.get(uploadDirectoryName)
                .toAbsolutePath()
                .normalize()
                .also { Files.createDirectories(it) }
        }.getOrElse {
            throw UploadFileException("Unable to create local directory to manage the file", it)
        }
    }
}