package me.lyzev.rsa

import me.lyzev.rsa.key.RSAKeyFactory

fun main() {
    val keys = RSAKeyFactory.generateKeyPair()
    val cipher = RSA(keys.first, keys.second)
    val msg = "Test"
    val encrypted = cipher.encrypt(msg.encodeToByteArray())
    val decrypted = String(cipher.decrypt(encrypted!!))
    println("public exponent -> ${keys.first.exp}")
    println("private exponent -> ${keys.second.exp}")
    println("modulus -> ${keys.first.mod}")
    println("encrypted -> $encrypted")
    println("decrypted -> $decrypted")
}