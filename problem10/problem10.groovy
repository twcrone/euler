class Test extends GroovyTestCase {

	def isPrime(BigInteger num, primes) {
		//def factor = primes.find{ num.mod(it) == BigInteger.ZERO }
		def factor = findFactor(num, primes)
		def isPrime =  factor == null
		if(isPrime) {
			primes << num
		}
		isPrime
	}

	def findFactor(BigInteger num, primes) {
		if(primes.isEmpty()) {
			return null
		}

		def i = 0
		BigInteger f = primes[i]
		def max = num.add(BigInteger.ONE)
		while(f.pow(2).compareTo(max) == -1) {
			if(num.mod(f) == BigInteger.ZERO) {
				return f
			}
			f = primes[++i]
		}
		null
	}

	def sumPrimesBelow(BigInteger num) {
		def max = num.add(BigInteger.ONE)
		def primes = []
		def i = new BigInteger("2")
		def sum = BigInteger.ZERO

		while(i.compareTo(max) == -1) {
			if(isPrime(i, primes)) {
				sum = sum.add(i)
				//println "$i - $sum"
			}
			i = i.add(BigInteger.ONE)
		}
		sum
	}

	def sumPrimesBelowCheat(BigInteger num) {
		def next = new BigInteger("2")
		def sum = BigInteger.ZERO

		while(next.compareTo(num) == -1) {
			//println "$next - $sum"
			sum = sum.add(next)
			next = next.nextProbablePrime()
		}
		sum
	}

	void test_solve() {
		println "Answer is" + sumPrimesBelow(2000000)
		println "Answer should be 142913828922"
	}

	void test_is_prime() {
		def primes = [2,3,5,7]
		assertFalse isPrime(9, primes)
	}

  	void test_is_prime_optimized_true() {
		def primes = [2,3,5,7]
		def eleven = new BigInteger("11")
		assertTrue isPrime(eleven, primes)
		assertTrue '11 was not added to primes', primes.contains(eleven)
	}

	void test_is_prime_true() {
		def primes = [2,3,5]
		assertTrue isPrime(7, primes)
	}

	void test_is_prime_false() {
		def primes = [2,3,5,7]
		assertFalse isPrime(9, primes)
	}

	void test_sum_primes_below_10() {
		def sum = sumPrimesBelow(10)
		assertEquals 17, sum
	}
}

