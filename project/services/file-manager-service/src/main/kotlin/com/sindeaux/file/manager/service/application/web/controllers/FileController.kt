package com.sindeaux.file.manager.service.application.web.controllers

import com.sindeaux.file.manager.service.application.web.responses.EncryptedFileResponse
import com.sindeaux.file.manager.service.domain.services.FileService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("file")
class FileController (
    private val fileService: FileService
) {

    @PostMapping("upload")
    fun uploadNewFile(@RequestParam("file") file : MultipartFile) : ResponseEntity<EncryptedFileResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                EncryptedFileResponse.fromSourceFileModel(
                    fileService.saveFile(file)
                )
            )
    }

}