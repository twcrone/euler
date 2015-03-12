defmodule EulerProblemOne do

  def calculate(3), do: 3
  def calculate(n) do
    calculate(n - 1) + filter(n)
  end

  def filter(n) when rem(n, 3) == 0 or rem(n, 5) == 0, do: n
  def filter(_), do: 0
end

answer = EulerProblemOne.calculate(999)
IO.puts(answer)
