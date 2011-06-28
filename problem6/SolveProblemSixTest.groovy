
class SolveProblemSixTest extends GroovyTestCase {

	def sumSquares(upperBound) {
		def sum = 0
		(1..upperBound).each { sum += it ** 2 }
		sum
	}

	def squareSum(upperBound) {
		def sum = 0
		(1..upperBound).each { sum += it }
		return sum ** 2
	}
	
	def diffSums(upperBound) {
		def sumSquares = sumSquares(upperBound)
		def squareSum = squareSum(upperBound)
		squareSum - sumSquares
	}

	void test_difference_of_sums() {
		def diff = diffSums(10)
		assertEquals 2640, diff
	}

	void test_sum_of_squares() {
		def sumSqs = sumSquares(10)
		assertEquals 385, sumSqs
	}
	
	void test_square_of_sum() {
		def sqSum = squareSum(10)
		assertEquals 3025, sqSum
	}
}