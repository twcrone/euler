/**
 * User: todd
 * Date: 1/23/12
 * Time: 10:01 PM
 */

package problem9

import std.io.*

fun main(args : Array<String>) {
    test()

    (1..999).foreach { a ->
        ((a + 1)..999).foreach { b ->
            ((b + 1)..999).foreach { c ->
                if(hasCorrectSum(a, b, c)) {
                    if(isTriplet(a, b, c)) {
                        println("Answer is ${a * b * c}")
                        println("Answer should have been 31875000")
                        System.exit(1)
                    }
                }
            }
        }
    }

}

fun test() {
    if(!isTriplet(3, 4, 5)) throw RuntimeException("3,4,5 should be triplet!")
    if(isTriplet(5, 4, 3)) throw RuntimeException("5,4,3 should NOT be triplet!")
}

fun isTriplet(a : Int, b : Int, c : Int) = a.squared() + b.squared() == c.squared()

fun Int.squared() = Math.pow(this.dbl, 2.dbl).int

// Illustrates Default parameter for 'sum'
fun hasCorrectSum(a : Int, b : Int, c : Int, sum : Int = 1000) = a + b + c == sum

