var sum = 0
for (i <- 1 until 1000) {
	if (i % 3 == 0 || i % 5 == 0) {
		sum += i
	}
}
println(sum)