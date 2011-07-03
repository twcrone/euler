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

def sum = 0
(2..1999999).each {
	if(isPrime(it)) {
		sum += it
	}
} 
println sum