@groovy.transform.CompileStatic
class Test extends GroovyTestCase {

	boolean isPrime(BigInteger num, List<BigInteger> primes) {
		BigInteger factor = findFactor(num, primes)
		boolean isPrime =  factor == null
		if(isPrime) {
			primes << num
		}
		isPrime
	}

	BigInteger findFactor(BigInteger num, List<BigInteger> primes) {
		if(primes.isEmpty()) {
			return null
		}

		int i = 0
		BigInteger f = primes[i]
		BigInteger max = num.add(BigInteger.ONE)
		while(f.pow(2).compareTo(max) == -1) {
			if(num.mod(f) == BigInteger.ZERO) {
				return f
			}
			f = primes[++i]
		}
		null
	}

	BigInteger sumPrimesBelow(BigInteger num) {
		BigInteger max = num.add(BigInteger.ONE)
		List<BigInteger> primes = []
		BigInteger i = new BigInteger("2")
		BigInteger sum = BigInteger.ZERO

		while(i.compareTo(max) == -1) {
			if(isPrime(i, primes)) {
				sum = sum.add(i)
				//println "$i - $sum"
			}
			i = i.add(BigInteger.ONE)
		}
		sum
	}

	BigInteger sumPrimesBelowCheat(BigInteger num) {
		BigInteger next = new BigInteger("2")
		BigInteger sum = BigInteger.ZERO

		while(next.compareTo(num) == -1) {
			//println "$next - $sum"
			sum = sum.add(next)
			next = next.nextProbablePrime()
		}
		sum
	}

  BigInteger big(int i) {
    new BigInteger(i.toString())
  }

	void test_solve() {
		println "Answer is" + sumPrimesBelow(big(2000000))
		println "Answer should be 142913828922"
	}

	void test_is_prime() {
		List<BigInteger> primes = [big(2),big(3),big(5),big(7)]
		assertFalse isPrime(big(9), primes)
	}

  void test_is_prime_optimized_true() {
		def primes = [big(2),big(3),big(5),big(7)]
		def eleven = new BigInteger("11")
		assertTrue isPrime(eleven, primes)
		assertTrue '11 was not added to primes', primes.contains(eleven)
	}

	void test_is_prime_true() {
		def primes = [big(2),big(3),big(5)]
		assertTrue isPrime(big(7), primes)
	}

	void test_is_prime_false() {
    List<BigInteger> primes = [big(2),big(3),big(5),big(7)]
		assertFalse isPrime(big(9), primes)
	}

	void test_sum_primes_below_10() {
		BigInteger sum = sumPrimesBelow(big(10))
		assertEquals big(17), sum
	}
}

