/**
 * User: todd
 * Date: 1/22/12
 * Time: 12:38 PM
 */

package problem4

import java.util.*
import std.io.*

fun main(args : Array<String>) {
    println(isPalindrome("10101"))
    println(isPalindrome("10011"))
    println(isPalindromicNumber(10101))
    println(isPalindromicNumber(10011))
    val answer = findLargestPalindromicNumber(3)
    println("Answer is ${answer}")
}

fun isPalindrome(s : String) : Boolean {
    var i = 0
    var j = s.length - 1
    while(i < j) {
        if(s[i] != s[j]) {
            return false
        }
        i++
        j--
    }
    return true
}

fun isPalindromicNumber(num : Long) : Boolean {
    return isPalindrome(num.toString())
}

fun findLargestPalindromicNumber(digits : Int) : Long {
    val upperBound = Math.pow(10.dbl, digits.dbl).lng
    var answer : Long = 0
    for (i in 0..upperBound) {
        for (j in 0..upperBound) {
            val temp = i * j
            if(temp > answer && isPalindromicNumber(temp)) {
                answer = temp
            }
        }
    }
    return answer
}