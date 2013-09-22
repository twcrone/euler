require 'fileutils'

kotlin_euler_dir = ''
euler_project_dir = ''

Dir.foreach(kotlin_euler_dir) do |filename|
  src_loc = "#{kotlin_euler_dir}/#{filename}"
  dest_loc = "#{euler_project_dir}/#{filename.chomp('.kt')}/#{filename}"
  if filename != '.' && filename != '..'
    #puts "cp #{src_loc} #{dest_loc}"
    FileUtils.cp(src_loc, dest_loc, :verbose => true)
  end

end

puts "Done."