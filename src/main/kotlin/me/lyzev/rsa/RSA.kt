package me.lyzev.rsa

import me.lyzev.rsa.key.types.RSAPrivateKey
import me.lyzev.rsa.key.types.RSAPublicKey
import java.math.BigInteger
import java.util.*

/**
 * Encrypts and decrypts messages using RSA.
 *
 * @author Lyzev
 * @param publicKey The public key to use for encryption.
 * @param privateKey The private key to use for decryption.
 */
class RSA(val publicKey: RSAPublicKey, val privateKey: RSAPrivateKey) {

    fun encrypt(ìn: String): String? = encrypt(ìn.encodeToByteArray())

    fun encrypt(`in`: ByteArray): String? {
        val out = mutableListOf<BigInteger>()
        for (byte in `in`)
            out += BigInteger.valueOf(byte.toLong()).pow(publicKey.exp).mod(publicKey.mod)
        return Base64.getEncoder().encodeToString(out.joinToString(" ").encodeToByteArray())
    }

    fun decrypt(`in`: String): ByteArray {
        val `in` = String(Base64.getDecoder().decode(`in`)).split(" ").map { BigInteger.valueOf(it.toLong()) }
        val out = ByteArray(`in`.size)
        for ((index, bigInteger) in `in`.withIndex())
            out[index] = bigInteger.pow(privateKey.exp).mod(privateKey.mod).toByte()
        return out
    }
}