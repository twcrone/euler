class Test extends GroovyTestCase {

	def getPalindromicCount(String numberString) {
		if(numberString.equals(numberString.reverse())) {
			return numberString.length()
		}
		else {
			return 0
		}
	}


	void test_default_case() {
		def count = getPalindromicCount("9009")
		assertEquals 4, count
	}
	
	void test_non_palindromic_string_returns_zero() {
		def count = getPalindromicCount("9099")
		assertEquals 0, count
	}
}