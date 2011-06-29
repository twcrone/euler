def isPrime(BigInteger num) {
	BigInteger i = 2
	while(i < (num / i + 1)) {
		if(num % i == 0) { 
			return false 
		}
		++i
	}
	true
}

def count = 0
def next = 2

while(true) {
	if(isPrime(next)) {
		count++
		if(count == 10001) {
			break
		}
	}
	next++
}
println next
