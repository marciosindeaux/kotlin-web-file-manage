package com.sindeaux.file.manager.service.domain.services

import com.sindeaux.file.manager.service.domain.models.crypt.SourceEncryptModel
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

@Service
class CipherSecurityService {

    private fun generateEncodeKey() : SecretKey {
        val keyGenerator = KeyGenerator.getInstance("AES")
        keyGenerator.init(256)
        return keyGenerator.generateKey()
    }

    fun encryptSource(sourceText: String) : SourceEncryptModel {
        val generatedKey = generateEncodeKey()
        val encodedGeneratedKey =  Base64.getEncoder().encodeToString(generatedKey.encoded)
        val encodedText = Cipher.getInstance("AES")
            .also { it.init(Cipher.ENCRYPT_MODE, generatedKey) }
            .run { Base64.getEncoder().encodeToString(this.doFinal(sourceText.encodeToByteArray())) }
        return SourceEncryptModel(sourceText, encodedText, encodedGeneratedKey)
    }

}