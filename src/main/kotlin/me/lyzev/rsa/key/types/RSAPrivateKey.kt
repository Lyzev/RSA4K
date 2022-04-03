package me.lyzev.rsa.key.types

import me.lyzev.rsa.key.RSAKey
import java.math.BigInteger

/**
 * Represents a private RSA key.
 */
class RSAPrivateKey(mod: BigInteger, exp: Int) : RSAKey(mod, exp) {

    /**
     * 1. The exponent should be smaller than the modulus
     * 2. The exponent should be at least 15
     */
    override fun isValid(): Boolean = exp >= 15 && exp < mod.toLong()

    override fun encodeToString(): String = "RSA-PRIVATE-KEY:$mod:$exp"
}