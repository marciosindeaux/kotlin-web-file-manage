package com.sindeaux.file.manager.service.commons.exceptions

class UploadFileException(
    message : String,
    cause : Throwable? = null
) : RuntimeException(message, cause)