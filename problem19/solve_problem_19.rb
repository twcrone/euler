
class SundayCalculator
  
  FIRST_DAYS = [1, 32, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335]
  FIRST_DAYS_LEAP_YEAR = [1, 32, 61, 92, 122, 153, 183, 214, 245, 275, 306, 336]

  def sunday?(year, month, day)
    (day - first_sunday(year)) % 7 == 0
  end

  def leap_year?(year)
    return year % 4 == 0 unless year % 100 == 0
    year % 400 == 0
  end

  def first_sunday(year)
    diff = year - 1900 + leap_year_count(year)
    diff %= 7 unless diff < 7
    7 - diff
  end

  def leap_year_count(year)
    count = 0
    1900.upto(year - 1) do |year|
      if leap_year?(year)
        count = count + 1
      end
    end
    count
  end

  def first_day_of_month?(year, day_of_year)
    return FIRST_DAYS.index(day_of_year) != nil unless leap_year?(year)
    FIRST_DAYS_LEAP_YEAR.index(day_of_year) != nil
  end

  def count_first_sundays(year)
    count = 0
    day = first_sunday(year)
    while day < 365
      if first_day_of_month?(year, day)
        count = count + 1
      end
      day = day + 7
    end
    count
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
  
  context '#first_sunday' do
    [
      # year, expected_first_sunday
      [ 1900,  7 ],
      [ 1901,  6 ],
      [ 1902,  5 ],
      [ 1903,  4 ],
      [ 1904,  3 ],
      [ 1905,  1 ],
      [ 1906,  7 ],
      [ 2000,  2 ],
      [ 2001,  7 ],
      [ 2002,  6 ],

    ].each do | year, expected |
      it "#{year}'s first Sunday was January #{expected}" do
        actual = calc.first_sunday(year)
        expect(actual).to eq(expected)
      end
    end
    
  end

  context '#first_day_of_month?' do
    [
      # year, day_of_year, expected_first_day_of_month
      [ 1900,  1, true ],
      [ 1900,  2, false ],
      [ 1900,  32, true ],
      [ 1900,  33, false ],
      [ 1900,  59, false ],
      [ 1900,  60, true ],

    ].each do | year, day_of_year, expected |
      it "#{year}'s #{day_of_year} was #{'NOT' unless expected} first day of a month" do
        actual = calc.first_day_of_month?(year, day_of_year)
        expect(actual).to eq(expected)
      end
    end
  end

  context '#count_first_sundays' do
    [
      # year, day_of_year, expected_first_day_of_month
      [ 1900,  2 ],
      [ 1901,  2 ],
      [ 1902,  1 ],
      [ 1903,  3 ],
      [ 1904,  1 ],


    ].each do | year, expected |
      it "#{year} had #{expected} first Sundays" do
        actual = calc.count_first_sundays(year)
        expect(actual).to eq(expected)
      end
    end
    
  end

  context '#solve' do 
    it 'should return correct answer' do 
      count = 0
      (1901..2000).each do |year|
        count += calc.count_first_sundays(year)  
      end
      expect(count).to eq(171)
    end
  end

end
