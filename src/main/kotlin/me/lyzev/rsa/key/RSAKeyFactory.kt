package me.lyzev.rsa.key

import me.lyzev.rsa.key.types.RSAPrivateKey
import me.lyzev.rsa.key.types.RSAPublicKey
import me.lyzev.rsa.util.MathHelper
import java.math.BigInteger
import java.security.SecureRandom
import java.util.*


object RSAKeyFactory {

    val primes = sieveOfEratosthenes(2000)

    fun generateKeyPair(): Pair<RSAPublicKey, RSAPrivateKey> {
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
            // d is for private key exponent
            if (multiOfPhi % e == 0) {
                d = multiOfPhi / e
                break
            }
        }

        return RSAPublicKey(BigInteger.valueOf(n.toLong()), e) to RSAPrivateKey(BigInteger.valueOf(n.toLong()), d)
    }

    /**
     * A list of primes. (Source: https://github.com/eugenp/tutorials/blob/master/java-numbers-2/src/main/java/com/baeldung/prime/PrimeGenerator.java)
     */
    private fun sieveOfEratosthenes(n: Int): List<Int> {
        val prime = BooleanArray(n + 1) { true }
        var p = 2
        while (p * p <= n) {
            if (prime[p]) {
                var i = p * 2
                while (i <= n) {
                    prime[i] = false
                    i += p
                }
            }
            p++
        }
        val primeNumbers = LinkedList<Int>()
        for (i in 2..n)
            if (prime[i])
                primeNumbers.add(i)
        return primeNumbers
    }
}