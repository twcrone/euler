class Test extends GroovyTestCase {
	
	def transformToInts(numStrs) {
		numStrs.collect{ Integer.parseInt(it) }
	}
	
	int sumDrop(nums) {
		int sum = nums.sum()
		sum / 10
	}
	
	void test_transform_to_ints() {
		def numStrs = ["1", "2", "3"]
		def expected = [1,2,3]
		def transformed = transformToInts(numStrs)
		assertEquals expected, transformed
	}
	
	void test_add_all_and_drop_ones_place() {
		def nums = [1,2,3,4]
		def sumDrop = sumDrop(nums)
		assertEquals 1, sumDrop
	}
	
	void test_add_all_and_drop_ones_place_with_carry_over() {
		def nums = [100,1,2,3,4,5,6,7,8,9,10]
		def sumDrop = sumDrop(nums)
		assertEquals 15, sumDrop
	}
}