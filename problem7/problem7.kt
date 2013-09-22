/**
 * User: todd
 * Date: 1/22/12
 * Time: 8:37 PM
 */

package problem7

import std.io.*

fun main(args : Array<String>) {
    var count = 0
    var next = 2.lng
    while(true) {
        if(isPrime(next)) {
            count++
            if(count == 10001) {
                break
            }
        }
        next++
    }
    println("Answer is ${next}")
}

fun isPrime(num : Long) : Boolean {
    var i = 2.lng
    while(i < (num / i + 1)) {
        if(num % i == 0.lng) {
            return false
        }
        ++i
    }
    return true
}

