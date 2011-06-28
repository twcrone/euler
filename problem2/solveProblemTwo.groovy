def term1 = 1
def term2 = 2
def next = 0
def sum = 2
def fourMillion = 4 * 1000000
while(term2 < fourMillion) {
	next = term1 + term2
	if(next % 2 == 0) {
		sum += next
	}
	term1 = term2
	term2 = next
}
println sum