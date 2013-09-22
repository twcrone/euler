require "test/unit"

def solve_for(upper)
  (upper..Float::INFINITY).step(upper).find do |num|
    (2..upper).all? { |i| num.modulo(i).zero? }
  end
end

class SolveProblemFiveTests < Test::Unit::TestCase

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