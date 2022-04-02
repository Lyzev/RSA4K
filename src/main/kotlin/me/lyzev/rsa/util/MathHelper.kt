package me.lyzev.rsa.util


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
}