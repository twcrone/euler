sum = 0
i = 1
while i <= 1000 do
  if i % 3 == 0 || i % 5 == 0
    sum += i
  end
  i += 1
end
puts sum