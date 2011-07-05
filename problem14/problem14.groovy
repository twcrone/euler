class Test extends GroovyTestCase {

	private static final BigInteger TWO = new BigInteger("2")
	private static final BigInteger THREE = new BigInteger("3")
	private static final BigInteger ANSWER = new BigInteger("837799")

	def even(BigInteger n) {
		n.divide(TWO)
	}

	def odd(BigInteger n) {
		n.multiply(THREE).add(BigInteger.ONE)
	}

	def countChain(BigInteger n) {
		BigInteger count = BigInteger.ONE
		
		while(n != BigInteger.ONE) {
			if(n.mod(2) == 0) {
				n = even(n)
			}
			else {
				n = odd(n)
			}
			count = count.add(BigInteger.ONE)
			//println "$n - $count"
		}
		count
	}

	void test_solve() {
		BigInteger n = new BigInteger("1000000")
		BigInteger count = 0
		BigInteger biggestChain = 0
		BigInteger biggestChainNum = 0
		
		while(n.compareTo(BigInteger.ONE) != 0) {
			count = countChain(n)
			if(count.compareTo(biggestChain) == 1) {
				biggestChain = count
				biggestChainNum = n
			}
			if(biggestChainNum.compareTo(ANSWER) == 0) {
				break
			}
			println "$n [$biggestChainNum -> $biggestChain]"
			n = n.subtract(BigInteger.ONE)
		}
		println "Answer: n=$biggestChainNum, chain=$biggestChain"
	}

	void test_odd() {
		def answer = odd(3)
		assertEquals 10, answer
	}

	void test_event() {
		def answer = even(4)
		assertEquals 2, answer
	}
	
	void test_count_chain() {
		def count = countChain(new BigInteger("13"))
		assertEquals 10, count
	}
}