/**
 * User: todd
 * Date: 1/25/12
 * Time: 11:22 PM
 */

package problem12

import std.io.*

fun main(args : Array<String>) {
    var n : Long = 1
    var t : Long = 0
    while(true) {
        t = getTriangle(n)
        val d = countDivisors(t)
        //println("n=" + n + ",t=" + t + ",d=" + d)
        if(d > 500) {
            break
        }
        n++
    }
    println("Answer is $t")
}

fun getTriangle(n : Long) : Long {
    var sum : Long = 0
    for (i in 1..n) {
        sum = sum + i
    }
    return sum
}

fun countDivisors(n : Long) : Long {
    var max : Long = n
    var count : Long = 0
    var i : Long = 1
    while(i < max) {
        if(n % i == 0.lng) {
            count += 2
        }
        max = n / i
        i++
    }
    return count
}