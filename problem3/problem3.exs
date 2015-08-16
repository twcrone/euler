ExUnit.start

defmodule Problem3Test do
  use ExUnit.Case, async: true

  def is_factor_of?(num, base) do
  	Kernel.rem(base, num) == 0
  end

  test "stating something" do
    assert Problem3Test.is_factor_of?(2, 4)
  end

  test "stating something" do
    assert Problem3Test.is_factor_of?(3, 4) == false
  end

end
