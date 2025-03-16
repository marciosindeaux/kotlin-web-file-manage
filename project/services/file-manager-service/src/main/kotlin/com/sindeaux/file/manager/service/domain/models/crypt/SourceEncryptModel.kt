package com.sindeaux.file.manager.service.domain.models.crypt

data class SourceEncryptModel (
    val originalSource: String,
    val encryptedSource: String,
    val base64EncodedCypher: String
) {
    fun generateSourceNameCombination(separator: String) : String {
        return listOf(encryptedSource, base64EncodedCypher).joinToString(separator = separator)
    }
}