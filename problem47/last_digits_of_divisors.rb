
class LastDigitsOfDivisors

  def find(n, d)
    3
  end

  def factorial(n)
    n.downto(1).inject(:*)
  end

  def divisors(n)
    divisors = [1]
    (2..n).each do |i|
      if n % i == 0
        divisors << i
      end
    end
    divisors
  end

end

describe LastDigitsOfDivisors do

  let(:calc) { LastDigitsOfDivisors.new() }

  context "#find" do
    [
      # integer n, digits d, expected
      [ 84,    4,     3],
      # [ factorial(12),  12,    11],
      # [ factorial(50), 123, 17888],

    ].each do | n, d, expected |
      it "should return #{expected} for n=#{n} and d=#{d}" do
        actual = calc.find(n, d)
        expect(actual).to eq(expected)
      end
    end
  end

  context "#divisors" do
    [
      # integer n, digits d, expected
      [ 84, [1, 2, 3, 4, 6, 7, 12, 14, 21, 28, 42, 84]],
      # [ factorial(12),  12,    11],
      # [ factorial(50), 123, 17888],

    ].each do | n, divisors |
      it "should return #{divisors} for n=#{n}" do
        actual = calc.divisors(n)
        expect(actual).to eq(divisors)
      end
    end
  end
end
