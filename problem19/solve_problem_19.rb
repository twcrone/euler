
class SundayCalculator
  def sunday?(year, month, day)
    false
  end
end

describe SundayCalculator, "#sunday?" do
  it "returns false for Jan 1, 1900" do
    calc = SundayCalculator.new()
    sunday = calc.sunday?(1900, 1, 1)
    expect(sunday).to eq(false)
  end

  it "returns true for Jan 6, 1900" do
    calc = SundayCalculator.new()
    sunday = calc.sunday?(1900, 1, 6)
    expect(sunday)
  end

end



#require "test/unit"
#
#class SolveProblemXTests < Test::Unit::TestCase
#
#  def sunday?(year, month, day)
#		false
#	end
#
#	def leap_year?(year)
#		year.modulo(4).zero?
#	end
#
#	def days_in_month(year, month)
#		case month
#		when 2
#		  if leap_year?(year)
#				return 29
#			else
#				return 28
#			end
#		when 9
#			return 30
#		when 4
#			return 30
#		when 6
#			return 30
#		when 11
#			return 30
#		else
#			return 31
#		end
#	end
#
#  def test_is_not_sunday
#    sunday = sunday?(1900, 1, 1)
#		assert !sunday
#  end
#
#	def test_is_sunday
#		sunday = sunday?(1900, 1, 7)
#		assert sunday
#	end
#end
