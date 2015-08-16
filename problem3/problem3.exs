ExUnit.start

defmodule Problem3Test do
  use ExUnit.Case, async: true

  def is_factor_of?(num, base) do
  	Kernel.rem(base, num) == 0
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

end
