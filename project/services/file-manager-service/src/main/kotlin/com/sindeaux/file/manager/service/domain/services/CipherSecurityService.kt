package com.sindeaux.file.manager.service.domain.services

import com.sindeaux.file.manager.service.domain.models.crypt.SourceEncryptModel
import com.sindeaux.file.manager.service.domain.security.ICryptographyResource
import org.springframework.stereotype.Service

@Service
class CipherSecurityService (
    private val cryptographyResource : ICryptographyResource
){

    fun encryptSource(sourceText: String) : SourceEncryptModel {
        return cryptographyResource.encrypt(sourceText)
    }
}