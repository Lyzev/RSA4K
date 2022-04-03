package me.lyzev.rsa.key

import me.lyzev.rsa.key.types.RSAPrivateKey
import me.lyzev.rsa.key.types.RSAPublicKey
import me.lyzev.rsa.util.MathHelper
import java.math.BigInteger
import java.security.SecureRandom

/**
 * A factory for RSA keys.
 *
 * @author Lyzev
 * @see RSAPrivateKey
 * @see RSAPublicKey
 * @see RSAKey
 */
object RSAKeyFactory {

    private val primes = MathHelper.sieveOfEratosthenes(2000) // list of primes up to 2000

    /**
     * Generates a new RSA key pair.
     *
     * @return a new RSA key pair
     */
    fun genKeyPair(): Pair<RSAPublicKey, RSAPrivateKey> {
        val random1 = SecureRandom.getInstanceStrong().nextInt(primes.size)
        val random2 = if (SecureRandom.getInstanceStrong().nextBoolean())
            random1 - 1 - SecureRandom.getInstanceStrong().nextInt(random1)
        else
            random1 + 1 + SecureRandom.getInstanceStrong().nextInt(primes.size - random1 - 1)

        val q = primes[random1]
        val p = primes[random2]

        val n = q * p
        val phi = (p - 1) * (q - 1)

        var e = 2
        for (i in 2 until n) {
            e = i
            if (MathHelper.gcd(e, phi) == 1)
                break
        }

        var d = 0
        for (i in 0..9) {
            val multiOfPhi: Int = 1 + i * phi
            if (multiOfPhi % e == 0) {
                d = multiOfPhi / e
                break
            }
        }

        return RSAPublicKey(BigInteger.valueOf(n.toLong()), e) to RSAPrivateKey(BigInteger.valueOf(n.toLong()), d)
    }

    /**
     * Generates key from encoded format.
     *
     * @return a RSA key
     */
    fun genKey(`in`: String): RSAKey {
        return if (`in`.startsWith("RSA-PUBLIC-KEY"))
            genPublicKey(`in`)
        else if (`in`.startsWith("RSA-PUBLIC-KEY"))
            genPrivateKey(`in`)
        else
            throw IllegalArgumentException("Invalid key format")
    }

    /**
     * Generates public key from encoded format.
     *
     * @return a RSA public key
     */
    fun genPublicKey(`in`: String): RSAPublicKey {
        val n = BigInteger.valueOf(`in`.split(":")[1].toLong())
        val e = `in`.split(":")[2].toInt()
        return RSAPublicKey(n, e)
    }

    /**
     * Generates private key from encoded format.
     *
     * @return a RSA private key
     */
    fun genPrivateKey(`in`: String): RSAPrivateKey {
        val n = BigInteger.valueOf(`in`.split(":")[1].toLong())
        val d = `in`.split(":")[2].toInt()
        return RSAPrivateKey(n, d)
    }
}