def sum = 0
(1..1000).each { if (it % 3 == 0 || it % 5 == 0) { sum += it } }
println sum