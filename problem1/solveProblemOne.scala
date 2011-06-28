var sum = 0
(1 to 1000).foreach(i=>
	if (i % 3 == 0 || i % 5 == 0) {
		sum += i
	}
)
println(sum)