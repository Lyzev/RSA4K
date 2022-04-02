package me.lyzev.rsa.key.types

import me.lyzev.rsa.key.RSAKey
import java.math.BigInteger

class RSAPrivateKey(mod: BigInteger, exp: Int) : RSAKey(mod, exp) {

    override fun isValid(): Boolean {
        return true
    }

    override fun encodeToString(): String {
        TODO("Not yet implemented")
    }

}