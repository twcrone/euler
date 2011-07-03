class Test extends GroovyTestCase {
	
	def isTriplet(a, b, c) {
		a**2 + b**2 == c**2
	}
	
	def hasCorrectSum(a, b, c) {
		return (a + b + c == 1000)
	}
	
	void test_base_case() {
		assertTrue isTriplet(3, 4, 5)
	}
	
	void test_not_triplet() {
		assertFalse isTriplet(5, 4, 3)
	}
	
	void test_get_answer() {
		(1..999).each { c ->
			(1..999).each { a ->
				(1..999).each { b ->
					if(hasCorrectSum(a, b, c)) {
						if(isTriplet(a,b,c) || isTriplet(b,c,a) || isTriplet(a,c,b)) {
							println a*b*c
							return
						}
					}
				}
			}
		}
	}
}