require "test/unit"

class SolveProblemXTests < Test::Unit::TestCase

  def triplet?(a, b, c)
    a**2 + b**2 == c**2
  end

  def test_triplet?
    assert triplet?(3, 4, 5), 'Should have returned true for triplet?(3, 4, 5)'
  end

  def sum_thousand?(a, b, c)
    a + b + c == 1000
  end

  def test_not_triplet?
    assert !triplet?(5, 4, 3), 'Should have returned false for triplet?(5, 4, 3)'
  end

  def test_get_answer
    (1..999).each do |c|
      (1..999).each do |a|
        (1..999).each do |b|
          if sum_thousand? a, b, c
            if triplet?(a, b, c) || triplet?(b, c, a) || triplet?(a, c, b)
              puts a*b*c
              return
            end
          end
        end
      end
    end
  end

end