require "test/unit"

class SolveProblem16Tests < Test::Unit::TestCase

  def solve(num)
    num_s = num.to_s
    sum = 0
    num_s.each_char do |digit_s|
      digit = digit_s.to_i
      sum += digit
    end
    sum
  end

  def test_solve_base_case
    num = 2 ** 15
    answer = solve(num)
    assert_equal 26, answer
  end

  def test_solve
    num = 2 ** 1000
    answer = solve(num)
    puts answer
  end
end