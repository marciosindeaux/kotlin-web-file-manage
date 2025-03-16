package com.sindeaux.file.manager.service.application.web.responses

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.sindeaux.file.manager.service.domain.models.files.SourceFileModel

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class EncryptedFileResponse (
    val fileName: String,
    val fileType: String,
    val fileSize: Long
) {
    companion object {
        fun fromSourceFileModel(model: SourceFileModel) = EncryptedFileResponse(
            model.encryptedName,
            model.documentType.orEmpty(),
            model.documentSize
        )
    }
}