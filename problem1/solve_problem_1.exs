defmodule EulerProblemOne do

  def solve(n), do: Enum.reduce(1..n, 0, &sum/2)

  defp sum(n, sum) when rem(n, 3) == 0 or rem(n, 5) == 0, do: sum + n
  defp sum(_, sum), do: sum

end

IO.puts(EulerProblemOne.solve(999))
