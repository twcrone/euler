defmodule Problem2 do
  def solve_for(n), do: fib_sum(1, 2, 0, n)

  defp fib_sum(a, b, sum, upper) when a + b > upper, do: sum + b
  defp fib_sum(a, b, sum, upper) do
    fib_sum(b, a + b, add_even(b, sum), upper)
  end

  defp add_even(n, sum) when rem(n, 2) == 0, do: sum + n
  defp add_even(_, sum), do: sum
end

IO.puts(Problem2.solve_for(4_000_000))
