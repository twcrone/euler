term_1 = 1
term_2 = 2
next_num = 0
sum = 2
four_million = 4 * 1000000
while(term_2 < four_million) do 
  next_num = term_1 + term_2
  if next_num % 2 == 0 then
    sum += next_num
  end
  term_1 = term_2
  term_2 = next_num
end
puts sum
