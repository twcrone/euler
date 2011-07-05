import java.util._

def isPrime(num: BigInteger, primes: Set<BigInteger>) : Boolean = {
	val factor = primes.find{ num.mod(it) == BigInteger.ZERO }
	val isPrime =  factor == null
	if(isPrime) {
		primes.add(num)
	}
	isPrime
}

def set = new SortedSet<BigInteger>() 
set.add(new BigInteger("2"))
println(isPrime(3), set)
// def sumPrimesBelow(BigInteger num) {
// 	def max = num.add(BigInteger.ONE)
// 	def primes = []
// 	def i = new BigInteger("2")
// 	def sum = BigInteger.ZERO
// 	
// 	while(i.compareTo(max) == -1) {
// 		if(isPrime(i, primes)) {
// 			sum = sum.add(i)
// 			println "$i - $sum"
// 		}
// 		i = i.add(BigInteger.ONE)
// 	}
// 	sum
// }
