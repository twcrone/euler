class Test extends GroovyTestCase {
	
	String add(String a, String b) {
		(Integer.parseInt(a) + Integer.parseInt(b)).toString()
	}
	
	void test_add() {
		def sum = add("1", "2")
		assertEquals "3", sum
	}
}