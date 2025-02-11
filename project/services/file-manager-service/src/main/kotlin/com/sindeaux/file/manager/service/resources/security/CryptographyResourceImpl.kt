package com.sindeaux.file.manager.service.resources.security

import com.sindeaux.file.manager.service.domain.models.crypt.SourceEncryptModel
import com.sindeaux.file.manager.service.domain.security.ICryptographyResource
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

@Component
class CryptographyResourceImpl (
    @Value("\${resources.security.cryptography.encrypt-algorithm}")
    private val encryptAlgorithm: String,
    @Value("\${resources.security.cryptography.key-size}")
    private val keySize : Int
): ICryptographyResource{

    override fun generateSecretKey(): SecretKey {
        val keyGenerator = KeyGenerator.getInstance(encryptAlgorithm)
        keyGenerator.init(keySize)
        return keyGenerator.generateKey()
    }

    override fun encrypt(source: String): SourceEncryptModel {
        val generatedKey = generateSecretKey()
        val encodedGeneratedKey =  Base64.getEncoder().encodeToString(generatedKey.encoded)
        val encodedText = Cipher.getInstance(encryptAlgorithm)
            .also { it.init(Cipher.ENCRYPT_MODE, generatedKey) }
            .run { Base64.getEncoder().encodeToString(this.doFinal(source.encodeToByteArray())) }
        return SourceEncryptModel(source, encodedText, encodedGeneratedKey)
    }
}