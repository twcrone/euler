defmodule EulerProblemOne do

  def solve(n) when n == 1, do: IO.puts(1)

  def solve(n) when rem(n, 5) + rem(n, 3) == 0 do
    IO.puts("FizzBuzz")
    solve(n - 1)
  end

  def solve(n) when rem(n, 5) == 0 do
    IO.puts("Fizz")
    solve(n - 1)
  end

  def solve(n) when rem(n, 3) == 0 do
    IO.puts("Buzz")
    solve(n - 1)
  end

  def solve(n) do
    IO.puts(n)
    solve(n - 1)
  end
end

EulerProblemOne.solve(15)
