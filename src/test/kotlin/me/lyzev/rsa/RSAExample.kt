package me.lyzev.rsa

import me.lyzev.rsa.key.RSAKeyFactory

/**
 * Example of RSA encryption and decryption.
 *
 * @author Lyzev
 */
fun main() {
    val keys = RSAKeyFactory.genKeyPair()
    val cipher = RSA(keys.first, keys.second)
    val msg = "Test"

    val encrypted = cipher.encrypt(msg.encodeToByteArray())
    val decrypted = String(cipher.decrypt(encrypted!!))

    println("public exponent -> ${keys.first.exp}")
    println("public modulus -> ${keys.first.mod}")
    println("private exponent -> ${keys.second.exp}")
    println("private modulus -> ${keys.second.mod}")
    println("encrypted -> $encrypted")
    println("decrypted -> $decrypted")
}