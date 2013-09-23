require "test/unit"

def is_prime?(num)
  i = 2
  while i < (num / i + 1)
    if num.modulo(i).zero?
      return false
    end
    i += 1
  end
  true
end

def get_nth_prime(n)
  count = 0
  (2..Float::INFINITY).each do |num|
    if is_prime?(num)
      count += 1
      if count == n
        return num
      end
    end
  end
end

class SolveProblemSevenTests < Test::Unit::TestCase

  def test_is_prime
    assert is_prime?(7)
  end

  def test_is_not_prime
    assert !is_prime?(8)
  end

  def test_6th_prime
    sixth_prime = get_nth_prime(6)
    assert_equal 13, get_nth_prime(6),
                 "Expected 13 but got #{sixth_prime}"
  end
end

answer = get_nth_prime(10001)
puts "Answer is #{answer}"