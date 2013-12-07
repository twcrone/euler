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


# Initial attempt was brute force but ran out of resources so had to use pascal's triangle
#@size = num
#(2**(num*2))


#remove = 0
## (1..@size).each do |i|
##   remove += 2**i
## end
#
#base = (2**(@size *  2)) - 2 # - remove*2
#heads = [{x:0, y:0}]
#calc_all_next_heads(heads)
#end

#def calc_all_next_heads(heads)
#  all_next_heads = []
#  heads.each do |head|
#    next_heads = calc_next_heads(head)
#    all_next_heads.concat(next_heads)
#  end
#  if all_next_heads.empty?
#    heads.length
#  else
#    puts all_next_heads.length
#    calc_all_next_heads(all_next_heads)
#  end
#end
#
#def calc_next_heads(point)
#  next_heads = []
#  if point[:x] < @size
#    next_heads << {x:(point[:x] + 1), y: (point[:y])}
#  end
#  if point[:y] < @size
#    next_heads << {x:(point[:x]), y: (point[:y] + 1)}
#  end
#  next_heads
#end
