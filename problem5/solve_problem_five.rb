require "test/unit"

def solve_for(upper)
  answer = upper
  until divisible_by_numbers_up_to(answer, upper)  do
    answer += upper
  end
  answer
end

def divisible_by_numbers_up_to(number, upper)
  (2..upper).all? { |i| number % i == 0 }
end

class SolveProblemXTests < Test::Unit::TestCase

  def test_simple_case
    solution = solve_for(2)
    assert_equal(2, solution, "Solution was #{solution} not 2520")  end


  def test_base_case
    solution = solve_for(10)
    assert_equal(2520, solution, "Solution was #{solution} not 2520")
  end

end

answer = solve_for(20)

puts "Answer is #{answer}"