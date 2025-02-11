package com.sindeaux.file.manager.service.domain.models.files

import com.sindeaux.file.manager.service.application.web.responses.EncryptedFileResponse
import org.springframework.http.MediaType

data class SourceFileModel (
    val originalName: String,
    val encryptedName : String,
    val documentType: String? = MediaType.APPLICATION_OCTET_STREAM_VALUE,
    val documentSize: Long
) {
    fun toEncryptedFileResponse() = EncryptedFileResponse(
        encryptedName,
        documentType.orEmpty(),
        documentSize
    )
}