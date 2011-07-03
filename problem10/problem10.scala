import java.math._

def isPrime(num : BigInteger): Boolean = {
	var i = new BigInteger("2")
	val ONE = new BigInteger("1")
	while(i.compareTo((num.divide(i))) < 0) {
		if(num.mod(i) == 0) { 
//			println(i)
			return false 
		}
		i = i.and(ONE)
	}
	true
}

var sum = 0
var count = 0
var i = new BigInteger("0")
(2 to 2000000).foreach(num =>
	i = new BigInteger(num)
	
	if(isPrime(i)) {
		sum += i
		count += 1
	}
)
println(count)
println(sum)
