import java.util.*;
import java.math.*;

class Problem10 {

  public static void main(String[] args) {
    Date start = new Date();
    System.out.println(start);
    new Problem10().test_solve();
    Date end = new Date();
    System.out.println(end);
    System.out.println("Took " + (end.getTime() - start.getTime()) + "ms");
  }

	boolean isPrime(BigInteger num, List<BigInteger> primes) {
		BigInteger factor = findFactor(num, primes);
		boolean isPrime =  factor == null;
		if(isPrime) {
			primes.add(num);
		}
		return isPrime;
	}

	BigInteger findFactor(BigInteger num, List<BigInteger> primes) {
		if(primes.isEmpty()) {
			return null;
		}

		int i = 0;
		BigInteger f = primes.get(i);
		BigInteger max = num.add(BigInteger.ONE);
		while(f.pow(2).compareTo(max) == -1) {
			if(num.mod(f) == BigInteger.ZERO) {
				return f;
			}
			f = primes.get(++i);
		}
		return null;
	}

	BigInteger sumPrimesBelow(BigInteger num) {
		BigInteger max = num.add(BigInteger.ONE);
		List<BigInteger> primes = new ArrayList<BigInteger>();
		BigInteger i = new BigInteger("2");
		BigInteger sum = BigInteger.ZERO;

		while(i.compareTo(max) == -1) {
			if(isPrime(i, primes)) {
				sum = sum.add(i);
			}
			i = i.add(BigInteger.ONE);
		}
		return sum;
	}

	BigInteger sumPrimesBelowCheat(BigInteger num) {
		BigInteger next = new BigInteger("2");
		BigInteger sum = BigInteger.ZERO;

		while(next.compareTo(num) == -1) {
			sum = sum.add(next);
			next = next.nextProbablePrime();
		}
		return sum;
	}

  BigInteger big(Integer i) {
    return new BigInteger(i.toString());
  }

	void test_solve() {
		System.out.println("Answer is" + sumPrimesBelow(big(2000000)));
		System.out.println("Answer should be 142913828922");
	}

}

