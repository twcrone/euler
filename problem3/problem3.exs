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
  	Problem3Test.get_largest_prime_factor(num, 1, 2)
  end

  def get_largest_prime_factor(num, current_factor, next_candidate) do
  	cond do
  		next_candidate > num / 2 -> current_factor
  	 	Problem3Test.is_prime_factor_of?(next_candidate, num) -> Problem3Test.get_largest_prime_factor(num, next_candidate, next_candidate + 1)
  		true -> Problem3Test.get_largest_prime_factor(num, current_factor, next_candidate + 1)
  	end
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
