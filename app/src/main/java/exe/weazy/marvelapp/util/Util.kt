package exe.weazy.marvelapp.util

import java.security.MessageDigest


const val DEFAULT_PAGE_SIZE = 20
const val DEFAULT_PREFETCH_DISTANCE = 10
const val DEFAULT_CHARACTER_IMAGE_SIZE = "standard_amazing."


fun String.toMD5(): String {
    val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
    return bytes.toHex()
}

fun ByteArray.toHex(): String {
    return joinToString("") { "%02x".format(it) }
}