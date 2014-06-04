def factorial(n)
  n.downto(1).inject(:*)
end


class LastDigitsOfDivisors

  def factorial(n)
    n.downto(1).inject(:*)
  end

  def find!(n, d)
    f = factorial(n)
    puts "Finding for #{f}"
    find(f, d)
  end

  def find(n, d)
    divisors = divisors(n)
    count = 0
    divisors.each do |val|
      if val.to_s.end_with?(d.to_s)
        count += 1
      end
    end
    count
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

  def solve(n, d, factorial = false)
    if factorial
      n = n.downto(1).inject(:*)
    end
    
    count = 0
    (1..n).each do |i|
      if n % i == 0 && val.to_s.end_with?(d.to_s)
        count += 1
      end
    end
    count
  end

end

describe LastDigitsOfDivisors do

  let(:calc) { LastDigitsOfDivisors.new() }

  context "#find" do
    [
      # integer n, digits d, expected
      [ 84, 4, 3],
      [ 12, 3, 1],

    ].each do | n, d, expected |
      it "should return #{expected} for n=#{n} and d=#{d}" do
        actual = calc.find(n, d)
        expect(actual).to eq(expected)
      end
    end
  end

  context "#find" do
    [
      # integer n, digits d, expected
      [ 84, 4, 3],
      [ 12, 3, 1],

    ].each do | n, d, expected |
      it "should return #{expected} for n=#{n} and d=#{d}" do
        actual = calc.find(n, d)
        expect(actual).to eq(expected)
      end
    end
  end

  context "#find!" do
    [
      # integer n, digits d, expected
      [ 12, 12, 11],
      # [ factorial(50), 123, 17888],

    ].each do | n, d, expected |
      it "should return #{expected} for n=#{n} and d=#{d}" do
        actual = calc.find!(n, d)
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
