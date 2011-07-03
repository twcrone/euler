def getTriangle(n : Int)= {
	var sum = 0
	(1 to n).foreach(i => sum = sum + i)
	sum
}

def countDivisors(n : Int)= {
	var max = n
	var count = 2
	var i = 1
//	for (int i = 1; i < max; ++i) {
	while(i < max) {
		if(n % i == 0) {
			count += 2
		}
		max = (n / i)
		i = i + 1
	}
	
	count
}

def solveProblem(targetCount : Int)= {
	var n = 1
	var t = 0
	var d = 0
	var continue = true
	
	while(continue) {
		t = getTriangle(n)
		d = countDivisors(t)
		println("n=" + n + ",t=" + t + ",d=" + d)
		if(d > targetCount) {
			continue = false
		}
		n = n + 1
	}
	t
}

val solution = solveProblem(500)
println("Solution is " + solution)
println("Should have been 76576500")