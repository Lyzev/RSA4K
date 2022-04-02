package me.lyzev.rsa

import java.math.BigInteger

fun main() {
    val q = 389
    val p = 521

    val n = q * p
    val phi = (p - 1) * (q - 1)

    var e = 2
    for (i in 2 until n) {
        e = i
        if (gcd(e, phi) == 1)
            break;
    }

    var d = 0
    for (i in 0..9) {
        val multiOfPhi: Int = 1 + i * phi
        // d is for private key exponent
        if (multiOfPhi % e == 0) {
            d = multiOfPhi / e
            break
        }
    }

    val msg = 123

    val MSG = BigInteger.valueOf(msg.toLong())
    val N = BigInteger.valueOf(n.toLong())

    val encrypted = MSG.pow(e).mod(N)
    val decrypted = BigInteger.valueOf(encrypted.longValueExact()).pow(d).mod(N)
    println("q: $q")
    println("p: $p")
    println("n: $n")
    println("phi: $phi")
    println("e: $e")
    println("d: $d")
    println("msg: $msg")

    println("Encrypted: $encrypted")
    println("Decrypted: $decrypted")
}

fun gcd(e: Int, z: Int): Int {
    return if (e == 0) z else gcd(z % e, e)
}