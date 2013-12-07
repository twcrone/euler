require "test/unit"

class Grid

  def pascal(m, n)
    if n == 1
      (m+1)
    else
      pascal(m, n - 1) * (m + n) / n
    end
  end

  def solve(num)
    pascal(num, num)

  end
end


class SolveProblemTests < Test::Unit::TestCase

  def test_solve_one
    grid = Grid.new()
    assert_equal 2, grid.solve(1)
  end

  def test_solve_two
    grid = Grid.new()
    assert_equal 6, grid.solve(2)
  end

  def test_solve_three
    grid = Grid.new()
    assert_equal 20, grid.solve(3)
  end

  def test_solve_four
    grid = Grid.new()
    assert_equal 70, grid.solve(4)
  end

  def test_solve_five
    grid = Grid.new()
    assert_equal 252, grid.solve(5)
  end

    def test_solve
     grid = Grid.new()
     answer = grid.solve(20)
     puts answer
  end
end