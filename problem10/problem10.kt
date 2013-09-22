/**
 * User: todd
 * Date: 1/24/12
 * Time: 7:16 PM
 */

package problem10

import std.io.*
import java.math.BigInteger

fun main(args : Array<String>) {
    val expected = BigInteger("142913828922")
    val answer = sumPrimesBelow(BigInteger("2000000"))
    println("Answer is $answer")
    if(!answer.equals(expected)) {
        throw RuntimeException("Answer SHOULD have been $expected")
    }

}

fun sumPrimesBelow(num : BigInteger) : BigInteger? {
    var sum : BigInteger? = BigInteger("0")
    var next : BigInteger? = BigInteger("2")
    while(next.lessThan(num)) {
        sum = sum?.add(next)
        next = next?.nextProbablePrime()
    }
    return sum
}

fun BigInteger?.lessThan(other : BigInteger?) : Boolean = this?.compareTo(other) == -1
