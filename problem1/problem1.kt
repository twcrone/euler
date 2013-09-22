/**
 * User: todd
 * Date: 1/21/12
 * Time: 11:40 AM
 */

package problem1

import java.util.*
import std.io.*

// Extension function on Int
fun Int.isDivisibleBy(num : Int) : Boolean = this % num == 0

fun main(args : Array<String>) {
    val expected = 233168
    var sum = 0
    for (x in 1..999)
        if(x.isDivisibleBy(5) || x.isDivisibleBy(3))
            sum += x
    println("Sum is ${sum}")
    if(sum != expected) throw RuntimeException("Sum should have been $expected")
}



