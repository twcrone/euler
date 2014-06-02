
class SundayCalculator
  def sunday?(year, month, day)
    (day - first_sunday(year)) % 7 == 0
  end

  def leap_year?(year)
    if year % 100 == 0
      year % 400 == 0
    else
      year % 4 == 0
    end
  end

  def first_sunday(year)
    if year == 1900
      7
    else
      0
    end
  end

end

describe SundayCalculator do

  let(:calc) { SundayCalculator.new() }

  context "#sunday?" do
    [
      # year, month, day_of_month, expected_is_sunday
      [ 1900,  1,  1, false],
      [ 1900,  1,  7, true ]

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
  
  context '#first_sunday?' do
    [
      # year, expected_first_sunday
      [ 1900,  7 ],
      [ 1901,  6 ],
      [ 1902,  5 ],
      [ 1903,  4 ],
      [ 1904,  3 ],
      [ 1904,  1 ],

    ].each do | year, expected |
      it "#{year}'s first Sunday was January #{expected}" do
        actual = calc.first_sunday(year)
        expect(actual).to eq(expected)
      end
    end
    
  end

end
