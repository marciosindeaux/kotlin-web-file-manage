package com.sindeaux.file.manager.service.domain.services

import com.sindeaux.file.manager.service.commons.exceptions.UploadFileException
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.multipart.MultipartFile

@Service
class FileService {

    fun saveFile(file: MultipartFile) {
        val cleanedFileName = StringUtils.cleanPath(file.originalFilename.orEmpty())
        val extension = cleanedFileName.split(".").lastOrNull()

        runCatching {
            if(cleanedFileName.isBlank() || cleanedFileName.contains("..")) {
                throw UploadFileException("Invalid name file")
            }
            if(extension.isNullOrEmpty() || extension.equals(cleanedFileName, ignoreCase = true)) {
                throw UploadFileException("Invalid file extension")
            }

            
        }.getOrElse { ex ->
            throw UploadFileException("Unable to upload the file", ex)
        }
    }
}