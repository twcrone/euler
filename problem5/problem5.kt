/**
 * User: todd
 * Date: 1/21/12
 * Time: 3:52 PM
 */

package problem5

import std.io.*

fun main(args : Array<String>) {
    val baseCaseAnswer = solveFor(10)
    println("Answer for base case is ${baseCaseAnswer}, should be 2520")
    val start = System.currentTimeMillis()
    val answer = solveFor(20)
    val end = System.currentTimeMillis()
    println("Answer is ${answer}, should be 232792560")
    println("Elapsed time ${end - start} milliseconds")
}

fun solveFor(upperBound : Int) : Int {
    var temp = upperBound * (upperBound + 1)
    while(true) {
        var answer = temp
        for(i in 2..upperBound) {
            if(temp % i != 0) {
                answer = 0
                break
            }
        }
        if(answer != 0) {
            return answer
        }
        temp += upperBound
    }
    return -1 // shouldn't get here I think
}