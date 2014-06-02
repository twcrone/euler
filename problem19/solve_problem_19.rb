
class SundayCalculator
  def sunday?(year, month, day)
    day % 6 == 0
  end

end

describe SundayCalculator, "#sunday?" do
  
  let(:calc) { SundayCalculator.new() }
  let(:data) do 
    [
      # year, month, day_of_month, expected_is_sunday
      [ 1900,  1,  1, false],
      [ 1900,  1,  6, true]
    ]
  end

  it "returns false for Jan 1, 1900" do
    data.each do |row|
      year = row[0]
      month = row[1]
      day = row[2]
      expected = row[3]
      actual = calc.sunday?(year, month, day)
      expect(actual).to eq(expected)
    end

  end

end
