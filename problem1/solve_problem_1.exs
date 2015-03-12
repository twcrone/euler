defmodule EulerProblemOne do

  def calculate(3), do: 3
  def calculate(n), do: filter(n) + calculate(n - 1)

  defp filter(n) when rem(n, 3) == 0 or rem(n, 5) == 0, do: n
  defp filter(_), do: 0

end

answer = EulerProblemOne.calculate(999)
IO.puts(answer)
