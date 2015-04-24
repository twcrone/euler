defmodule Fib do
  def fib(n), do: fib(1, 2, 0, n)

  defp fib(a, b, sum, upper) when a + b > upper, do: sum + b
  defp fib(a, b, sum, upper), do: fib(b, a + b, add_even(b, sum), upper)

  defp add_even(n, sum) when rem(n, 2) == 0, do: sum + n
  defp add_even(_, sum), do: sum
end

IO.puts(Fib.fib(4_000_000))
