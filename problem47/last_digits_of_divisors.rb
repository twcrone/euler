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

  def solve(n, d, do_factorial = false)
    if do_factorial
      n = n.downto(1).inject(:*)
    end

    count = 0
    (1..n).each do |i|
      if n % i == 0 && i.to_s.end_with?(d.to_s)
        count += 1
      end
    end
    count
  end

end

describe LastDigitsOfDivisors do

  let(:calc) { LastDigitsOfDivisors.new() }

  context "#solve" do
    [
      # integer n, digits d, factorial, expected
      [ 84, 4, false, 3],
      [ 12, 3, false, 1],
      [ 12, 12, true, 11],

    ].each do | n, d, do_factorial, expected |
      it "should return #{expected} for n=#{n} and d=#{d} factorial=#{do_factorial}" do
        actual = calc.solve(n, d, do_factorial)
        expect(actual).to eq(expected)
      end
    end
  end

end
