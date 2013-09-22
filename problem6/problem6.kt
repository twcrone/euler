/**
 * User: todd
 * Date: 1/22/12
 * Time: 6:32 PM
 */

package problem6

import std.io.*

fun main(args : Array<String>) {
    val diff = diffSums(100)
    println("Answer is ${diff}")
}

fun sumSquares(upperBound : Long) : Long {
    var sum : Long = 0
    for(i in 1..upperBound) {
        sum += Math.pow(i.dbl, 2.dbl)
    }
    return sum
}

fun squareSum(upperBound : Long) : Long {
    var sum : Long = 0
    for(i in 1..upperBound) {
        sum += i
    }
    return Math.pow(sum.dbl, 2.dbl).lng
}

fun diffSums(upperBound : Long) : Long {
    val sumSquares = sumSquares(upperBound)
    val squareSum = squareSum(upperBound)
    return squareSum - sumSquares
}