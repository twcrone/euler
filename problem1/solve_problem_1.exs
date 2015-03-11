defmodule EulerProblemOne do

  def solve(n) when n == 1, do: IO.puts(1)

  def solve(n) when n > 1 do
    IO.puts output(n, rem(n, 5) == 0, rem(n, 3) == 0)
    solve(n - 1)
  end

  def output(_, true, true), do: "FizzBuzz"
  def output(_, true, false), do: "Fizz"
  def output(_, false, true), do: "Buzz"
  def output(n, _, _), do: n
end

EulerProblemOne.solve(100)
