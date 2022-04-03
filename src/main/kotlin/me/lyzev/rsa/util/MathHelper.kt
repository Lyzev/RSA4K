package me.lyzev.rsa.util

import java.util.*


/**
 * An auxiliary class for math functions.
 *
 * @author Lyzev
 */
object MathHelper {

    /**
     * Calculates the greatest common divisor of two integers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return greatest common divisor
     */
    fun gcd(a: Int, b: Int): Int {
        return if (a == 0) b else gcd(b % a, a)
    }

    /**
     * A list of primes. (Source: https://github.com/eugenp/tutorials/blob/master/java-numbers-2/src/main/java/com/baeldung/prime/PrimeGenerator.java)
     */
    fun sieveOfEratosthenes(n: Int): List<Int> {
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