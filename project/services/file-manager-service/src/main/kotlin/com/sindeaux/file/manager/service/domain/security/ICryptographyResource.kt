package com.sindeaux.file.manager.service.domain.security

import com.sindeaux.file.manager.service.domain.models.crypt.SourceEncryptModel
import javax.crypto.SecretKey

interface ICryptographyResource {
    fun generateSecretKey() : SecretKey
    fun encrypt(source : String) : SourceEncryptModel
}