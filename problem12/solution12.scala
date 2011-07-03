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
// def t = getTriangle(7)
// println(t)
// println(countDivisors(t))
println("Starting...")
var n = 1
var t = 0
var d = 0

while(true) {
	t = getTriangle(n)
	d = countDivisors(t)
	println("n=" + n + ",t=" + t + ",d=" + d)
	if(d > 500) {
		println(t)
		System.exit(0)
	}
	n = n + 1
}

