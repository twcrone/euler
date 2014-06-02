
class SundayCalculator
  def sunday?(year, month, day)
    day % 6 == 0
  end

end

describe SundayCalculator, "#sunday?" do

  let(:calc) { SundayCalculator.new() }

  [
    # year, month, day_of_month, expected_is_sunday
    [ 1900,  1,  1, false],
    [ 1900,  1,  6, true ]

  ].each do | year, month, day, expected |
    it "returns #{expected} for #{year}-#{month}-#{day} " do
      actual = calc.sunday?(year, month, day)
      expect(actual).to eq(expected)
    end
  end
  
end
