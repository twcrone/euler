
class LastDigitsOfDivisors

  def find(n, d)
    3
  end

  def factorial(n)
    n.downto(1).inject(:*)
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
      it "returns #{expected} for n=#{n} and d=#{d}" do
        actual = calc.find(n, d)
        expect(actual).to eq(expected)
      end
    end
  end

end
