sum = 0
(1..1000).each do |i|
  if i % 3 == 0 || i % 5 == 0
    sum += i
  end
end  
puts sum