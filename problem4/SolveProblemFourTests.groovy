class Test extends GroovyTestCase {

	def isPalindromicNumber(num) {
		def numStr = num.toString()
		numStr.equals(numStr.reverse())	
	}
	
	def findLargestPalindromicNumber(digits) {
		def upperBound = 10 ** digits
		def answer = 0
		def temp = 0
		(0..upperBound).each { i ->
			(0..upperBound).each { j-> 
				temp = i * j
				if(temp > answer && isPalindromicNumber(temp)) {
					answer = temp
				}
			} 
		}
		return answer
	}

	void test_default_case() {
		def count = findLargestPalindromicNumber(2)
		assertEquals 9009, count
	}
	
	void test_is_palindromic_number() {
		assertTrue isPalindromicNumber(10101)
		assertFalse isPalindromicNumber(1011)
	}
	
	void test_get_answer() {
		def count = findLargestPalindromicNumber(3)
		println count
	}
}