def is_factor_of(num, base) 
  return base % num == 0
end

def is_prime(num) 
  i = 2
  while i < (num / i) do
    if num % i == 0 then 
      return false 
    end
    i += 1
  end
  return true
end

def is_factor_of(num, base)
  base % num == 0
end

num = 600851475143
factor = 0
temp = num
i = 2

while i < temp do
  puts i
  if is_factor_of(i, num) then
    temp = num / i
    if is_prime(temp) then
      factor = temp
      break
    elsif is_prime(i) then
      factor = i
    end
  end
  i += 1
end

puts "Answer is #{factor}."

