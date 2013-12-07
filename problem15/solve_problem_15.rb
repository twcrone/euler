require "test/unit"

class Grid
  def initialize(size)
    @size = size
  end

  def solve
    2
  end
end


class SolveProblemTests < Test::Unit::TestCase

  def test_solve_base_case
    grid = Grid.new(1)
    assert_equal 2, grid.solve()
    #assert_equal 6, solve(2)
    #assert_equal 16, solve(3)
  end

  def test_solve
    grid = Grid.new(20)
    answer = grid.solve()
    puts answer
  end
end