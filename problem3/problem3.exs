ExUnit.start

defmodule Problem3Test do
  use ExUnit.Case, async: true

  def is_factor_of?(factor, num) do
  	Kernel.rem(num, factor) == 0
  end

  def is_prime_factor_of?(factor, num) do
  	if is_prime?(factor) do
  		is_factor_of?(factor, num)
  	else
  		false
  	end
  end

  defp is_prime?(num, factor) do
  	cond do
  	  num == 2 -> true
      is_factor_of?(factor, num) -> false
	    factor < (num/factor) -> is_prime?(num, factor + 1)
	    true -> true
    end
  end  

  def is_prime?(num) do
  	is_prime?(num, 2)
  end

  def get_largest_prime_factor(num) do
  	get_largest_prime_factor(num, 2)
  end

  defp get_largest_prime_factor(num, divisor) do
  	if is_factor_of?(divisor, num) do
  		next_candidate = Kernel.div(num, divisor)
  		if is_prime?(next_candidate) do
  			next_candidate
  		else
  			get_largest_prime_factor(num, divisor + 1)
  		end
  	else
		get_largest_prime_factor(num, divisor + 1)
  	end
  end

  test "get largest prime factor for 600851475143" do
  	answer = get_largest_prime_factor(600851475143)
  	IO.puts "Answer is #{answer}"
  	assert answer > 0
  end

  test "get largest prime factor" do
  	assert is_prime?(29)
  	assert is_factor_of?(29, 13195)
  	assert is_prime_factor_of?(29, 13195)
  	assert get_largest_prime_factor(13195) == 29
  end

  test "is a factor" do
    assert is_factor_of?(2, 4)
  end

  test "is not a factor" do
    assert is_factor_of?(3, 4) == false
  end

  test "is prime base case" do
  	assert is_prime?(2)
  end

  test "is prime" do
  	assert is_prime?(5)
  end

  test "is not prime" do
  	assert is_prime?(4) == false
  end

  test "is not prime more in depth" do
  	assert is_prime?(121) == false
  end

end
