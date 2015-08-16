ExUnit.start

defmodule Problem3Test do
  use ExUnit.Case, async: true

  def is_factor_of?(num, base) do
  	Kernel.rem(base, num) == 0
  end

  def is_prime_factor_of?(num, base) do
  	if Problem3Test.is_prime?(num) do
  		Problem3Test.is_factor_of?(num, base)
  	else
  		false
  	end
  end

  def is_prime?(num, factor) do
  	cond do
  	  num == 2 -> true
	  Problem3Test.is_factor_of?(factor, num) -> false
	  factor < (num/factor) -> is_prime?(num, factor + 1)
	  true -> true
	end
  end  

  def is_prime?(num) do
  	Problem3Test.is_prime?(num, 2)
  end

  def get_largest_prime_factor(num) do
  	Problem3Test.get_largest_prime_factor(num, 2)
  end

  def get_largest_prime_factor(num, divisor) do
  	if Kernel.rem(num, divisor) == 0 do
  		next_candidate = Kernel.div(num, divisor)
  		#IO.puts("#{num}, #{divisor}, #{next_candidate}")
  		if Problem3Test.is_prime?(next_candidate) do
  			next_candidate
  		else
  			Problem3Test.get_largest_prime_factor(num, divisor + 1)
  		end
  	else
		Problem3Test.get_largest_prime_factor(num, divisor + 1)
  	end
  end

  test "get largest prime factor for 600851475143" do
  	answer = Problem3Test.get_largest_prime_factor(600851475143)
  	IO.puts "Answer is #{answer}"
  	assert answer > 0
  end

  test "get largest prime factor" do
  	assert Problem3Test.is_prime?(29)
  	assert Problem3Test.is_factor_of?(29, 13195)
  	assert Problem3Test.is_prime_factor_of?(29, 13195)
  	assert Problem3Test.get_largest_prime_factor(13195) == 29
  end

  test "is a factor" do
    assert Problem3Test.is_factor_of?(2, 4)
  end

  test "is not a factor" do
    assert Problem3Test.is_factor_of?(3, 4) == false
  end

  test "is prime base case" do
  	assert Problem3Test.is_prime?(2)
  end

  test "is prime" do
  	assert Problem3Test.is_prime?(5)
  end

  test "is not prime" do
  	assert Problem3Test.is_prime?(4) == false
  end

  test "is not prime more in depth" do
  	assert Problem3Test.is_prime?(333) == false
  end

end
