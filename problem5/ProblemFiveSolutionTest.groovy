class Test extends GroovyTestCase {
	
	def solveFor(upperBound) {
		def answer = 0
		def temp = upperBound * (upperBound + 1)
		while(true) {
			answer = temp
			(2..upperBound).each {
				if(temp % it != 0) {
					answer = 0
					return
				}
			}
			if(answer != 0) {
				return answer
			}
			temp += upperBound
		}
	}
	
	void test_base_case() {
		assertEquals 2520, solveFor(10)
	}
	
	void test_solution() {
		def start = System.currentTimeMillis()
		println solveFor(20)
		def end = System.currentTimeMillis()
		println "Elapsed time ${end - start} milliseconds"
	}
}