defmodule Pascal do
  def pascal(m, n) do
    if(n == 1) do
      (m+1)
    else
      pascal(m, n - 1) * (m + n) / n
    end
  end
end

sum = Pascal.pascal(20, 20)

IO.puts "#{sum}"