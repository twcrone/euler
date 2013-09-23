require "test/unit"

def diff_sums(upper)
  square_sum(upper) - sum_squares(upper)
end

def sum_squares(upper)
  (1..upper).inject(0) { |sum, val| sum += (val * val) }
end

def square_sum(upper)
  sum = (1..upper).inject(0) { |sum, val| sum += val }
  sum * sum
end

class SolveProblemSixTests < Test::Unit::TestCase

  def test_diff_of_sums
    diff = diff_sums(10)
    assert_equal(2640, diff, "Expected diff was 2640 but diff_sums returned #{diff}")
  end

  def test_sum_squares
    sum = sum_squares(10)
    assert_equal(385, sum, "Expected 385 but got #{sum}")
  end

  def test_square_sum
    square = square_sum(10)
    assert_equal(3025, square, "Expected 3025 and got #{square}")
  end
end

puts diff_sums(100)
