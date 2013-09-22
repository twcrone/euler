require "test/unit"

def is_palindromic_number(num)
  num_str = num.to_s
  return num_str == num_str.reverse
end

def find_largest_palindromic_number(digits)
  upper = 10 ** digits
  answer = 0
  temp = 0
  (0..upper).each do |i|
    (0..upper).each do |j|
      temp = i * j
      if temp > answer && is_palindromic_number(temp) then
        answer = temp
      end
    end
  end
  return answer
end

class TestSimpleNumber < Test::Unit::TestCase

  def test_is_palindromic_number
    assert is_palindromic_number(1001)
    assert !is_palindromic_number(1234)
  end

  def test_default_case
    count = find_largest_palindromic_number(2)
    assert count == 9009
  end

  def test_get_answer
    answer = find_largest_palindromic_number(3)
    assert  answer == 906609
  end
end