class LastDigitsOfDivisors

  def solve(n, d, do_factorial = false)
    if do_factorial
      n = n.downto(1).inject(:*)
    end

    count = 0
    half = (n/2).floor
    (1..half).each do |i|
      if n % i == 0 && i.to_s.end_with?(d.to_s)
        count += 1
      end
      puts "n=#{n}, d=#{d}, i=#{i}, count=#{count}"
    end
    if n.to_s.end_with?(d.to_s)
        count += 1
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
      [ 50, 123, true, 17888],

    ].each do | n, d, do_factorial, expected |
      it "should return #{expected} for n=#{n} and d=#{d} factorial=#{do_factorial}" do
        actual = calc.solve(n, d, do_factorial)
        expect(actual).to eq(expected)
      end
    end
  end

end
