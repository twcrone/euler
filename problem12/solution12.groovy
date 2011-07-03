class Test extends GroovyTestCase {
	
	int getTriangle(n) {
		(1..n).inject(0) { sum, i -> sum + i }
	}
	
	int countDivisors(n) {
		//(1..i).count { i % it == 0 }
		def max = n
		def count = 0
		for (int i = 1; i < max; ++i) {
			if(n % i == 0) {
				count += 2
			}
			max = n / i
		}
		count
	}
	
	void test_solve() {
		def n = 1
		def t = 0
		def d = 0
		while(true) {
			t = getTriangle(n)
			d = countDivisors(t)
			println("n=$n,t=$t,d=$d")
			if(d > 500) {
				println t
				break
			}
			n++
		}
		assertEquals 76576500, t
	}
	
	void test_get_triangle() {
		def value = getTriangle(7)
		assertEquals 28, value
	}
	
	void test_count_divisors() {
		def count = countDivisors(28)
		assertEquals 6, count
	}
}