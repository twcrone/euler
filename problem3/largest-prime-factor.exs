ExUnit.start

defmodule LargestPrimeFactor do
  use ExUnit.Case, async: true

  @moduledoc """

  Project Euler

  Largest prime factor
  Problem 3

  The prime factors of 13195 are 5, 7, 13 and 29.

  What is the largest prime factor of the number 600851475143 ?
  
  https://projecteuler.net/problem=3

  ## Example

    iex> LargestPrimeFactor.calculate_for(13195)
    29

  """

  @doc """
  Calculates the largest prime factor for a number.
  """
  def calculate_for(num) do
    get_largest_prime_factor(num, 2)
  end

  defp get_largest_prime_factor(num, divisor) do
    next_candidate = div(num, divisor)
    if is_factor_of?(divisor, num) && is_prime?(next_candidate) do
      next_candidate
    else
        get_largest_prime_factor(num, divisor + 1)
    end
  end

  defp is_factor_of?(factor, num) do
  	rem(num, factor) == 0
  end

  defp is_prime_factor_of?(factor, num) do
  	if is_prime?(factor) do
  		is_factor_of?(factor, num)
  	else
  		false
  	end
  end

  defp is_prime?(2), do: true

  defp is_prime?(num) when rem(num, 2) == 0, do: false

  defp is_prime?(num), do: is_prime?(num, 2)
  
  defp is_prime?(num, factor) when rem(num, factor) == 0, do: false

  defp is_prime?(num, factor) when factor < (num/factor), do: is_prime?(num, factor + 1)

  defp is_prime?(_num, _factor), do: true

  # Tests

  test "get largest prime factor for 600851475143" do
  	answer = calculate_for(600851475143)
  	IO.puts "Answer is #{answer}"
  	assert answer > 0
  end

  test "get largest prime factor" do
  	assert is_prime?(29)
  	assert is_factor_of?(29, 13195)
  	assert is_prime_factor_of?(29, 13195)
  	assert calculate_for(13195) == 29
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
