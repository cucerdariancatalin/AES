import java.security.Key
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import java.util.Base64

fun encryptAES(input: String, key: String): String {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    val secretKey = SecretKeySpec(key.toByteArray(), "AES")
    cipher.init(Cipher.ENCRYPT_MODE, secretKey)
    val encryptedBytes = cipher.doFinal(input.toByteArray())
    return Base64.getEncoder().encodeToString(encryptedBytes)
}

fun decryptAES(input: String, key: String): String {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    val secretKey = SecretKeySpec(key.toByteArray(), "AES")
    cipher.init(Cipher.DECRYPT_MODE, secretKey)
    val encryptedBytes = Base64.getDecoder().decode(input)
    val decryptedBytes = cipher.doFinal(encryptedBytes)
    return String(decryptedBytes)
}

fun main() {
    val input = "hello, world"
    val key = "mysecretkey12345"
    val encrypted = encryptAES(input, key)
    println("Encrypted string: $encrypted")
    val decrypted = decryptAES(encrypted, key)
    println("Decrypted string: $decrypted")
}

Encrypted string: E/kd20+1r8rRniJmd/fU6w==
Decrypted string: hello, world
