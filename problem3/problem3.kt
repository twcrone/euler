/**
 * User: todd
 * Date: 1/21/12
 * Time: 3:48 PM
 */

package problem3

import java.util.*
import std.io.*

fun main(args : Array<String>) {
    val start = System.currentTimeMillis()
    val num : Long = 600851475143
    var factor : Long = 0
    var i : Long = 2
    val upperBound = Math.sqrt(num.dbl) + 1
    while(i < upperBound) {
        val temp = num / i
        if(i.isFactorOf(num)) {
            println(temp)
            if(isPrime(temp)) {
                factor = temp
                break
            }
            else if(isPrime(i)) {
                factor = i
            }
        }
        i++
    }
    val end = System.currentTimeMillis()
    println("Answer is ${factor}")
    println("Answer should be 6857")
    println("Elapsed time ${end - start}")
}

// Single-expression Extension function
fun Long.isFactorOf(num : Long) : Boolean = (num % this == 0.lng)

fun isPrime(num : Long) : Boolean {
    var i : Long = 2
    val zero : Long = 0
    val upperBound = Math.sqrt(num.dbl) + 1
    while(i < upperBound) {
        if(num % i == zero) {
            return false
        }
        i += 1
    }
    return true
}

