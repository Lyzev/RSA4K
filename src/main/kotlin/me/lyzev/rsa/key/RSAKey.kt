package me.lyzev.rsa.key

import java.math.BigInteger

abstract class RSAKey(val mod: BigInteger, val exp: Int) {

    /**
     * Checks if the modulus and the exponent are valid.
     *
     * @return modules and exponent are valid
     */
    abstract fun isValid(): Boolean

    abstract fun encodeToString(): String

    init {
        isValid()
    }
}