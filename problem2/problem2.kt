/**
 * User: todd
 * Date: 1/21/12
 * Time: 3:10 PM
 */
package problem2

import java.util.*
import std.io.*

fun main(args : Array<String>) {
    var lastTerm = 1
    var nextTerm = 2
    var answer = 2
    while(nextTerm < 4000000) {
        val sum = lastTerm + nextTerm
        //printDebug(lastTerm, nextTerm, sum)
        if(sum % 2 == 0)
            answer += sum
        lastTerm = nextTerm
        nextTerm = sum
    }

    println("Answer is ${answer}")
}

// Unit returning function, Unit return type can be omitted
fun printDebug(lastTerm : Int, nextTerm : Int, sum : Int) : Unit {
    println("${lastTerm} + ${nextTerm} = ${sum}")
}