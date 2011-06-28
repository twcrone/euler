def isFactorOf(num, base) {
	return base % num == 0
}

def isPrime(BigInteger num) {
	BigInteger i = 2
	while(i < num / i) {
		if(num % i == 0) { 
			return false 
		}
		++i
	}
	true
}


BigInteger num = 600851475143
BigInteger factor = 0
BigInteger temp = num
for(def i = 2; i < temp; ++i) {
	if(isFactorOf(i, num)) {
		println temp
		temp = num / i
		if(isPrime(temp)) {
			factor = temp
			break
		}
		else if(isPrime(i)) {
			factor = i
		}
	}
}

println factor


