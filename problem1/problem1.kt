/**
 * User: todd
 * Date: 1/21/12
 * Time: 11:40 AM
 */

import java.util.*

fun main(args : Array<String>) {
    var sum = 0
    for (x in 1..999)
        if(x % 5 == 0 || x % 3 == 0)
            sum += x
    System.out?.println("Sum in ${sum}")
}
