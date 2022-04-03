package me.lyzev.rsa.key

import java.math.BigInteger

/**
 * Represents an RSA key.
 */
abstract class RSAKey(val mod: BigInteger, val exp: Int) {

    /**
     * Checks if the modulus and the exponent are valid.
     *
     * @return modules and exponent are valid
     */
    abstract fun isValid(): Boolean

    /**
     * Encodes the key to a string.
     *
     * @return encoded key
     */
    abstract fun encodeToString(): String

    /**
     * Checks if the key is valid.
     */
    init {
        if (!isValid())
            throw IllegalArgumentException("Invalid key")
    }
}