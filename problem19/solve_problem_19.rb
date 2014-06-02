
class SundayCalculator
  def sunday?(year, month, day)
    day % 6 == 0
  end

  def leap_year?(year)
    if year % 100 == 0
      year % 400 == 0
    else
      year % 4 == 0
    end
  end

end

describe SundayCalculator do

  let(:calc) { SundayCalculator.new() }

  context "#sunday?" do
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

  context '#leap_year?' do
    [
      # year, expected_leap_year
      [ 2000, true  ],
      [ 1901, false ],
      [ 1900, false ],
      [ 1600, true  ],
      [ 1644, true  ],

    ].each do | year, expected |
      it "#{year} is #{'NOT' unless expected} a leap year" do
        actual = calc.leap_year?(year)
        expect(actual).to eq(expected)
      end
    end
    
  end
  
end
