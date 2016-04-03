def htmlTagChecker(fileName)
  
  htmlContent  = File.read(fileName)
 
  allTags = []
  tags = []
  first_index = 0
  last_index  = 0
  durum = true
  
  i=0;
  
  while durum == true and i<=htmlContent.length
    
    char = htmlContent[i]

    
     if char == "<"
          first_index = i
     end
     
     if char == ">"
       
        last_index = i-first_index+1
         
        
         allTags.push(htmlContent[first_index,last_index])
        
      
      
      if(htmlContent[first_index+1] == "/")
       
        if !tags.empty?
           
          
          sTag = tags.last()
          sTag = sTag.to_s.split(//)
          sTag.shift(1)
          startTagStr = sTag.join('')
        
          
          fTag = htmlContent[first_index,last_index]
          fTag = fTag.to_s.split(//)
          fTag.shift(2)
          finishTagStr = fTag.join('')
          
          
          if startTagStr == finishTagStr
            tags.pop()
          else
            durum = false            
          end
          
        
        else
          durum = false
        end
     
      else
        tags.push(htmlContent[first_index,last_index])
      end
    end
    i += 1
  end
  
  puts "Dosya icerisinde bulunan tum HTML taglari : "
  writeTags(allTags)
  
  puts ""
  puts "HTML tag esleme sonucu : "
  
  if durum
    puts "HTML taglari dogru eslesmis"
  else
    puts "HTML taglari hatalidir."
  end

end

def writeTags(tags)
  for i in 0..tags.length
    puts tags[i]    
  end
end
  

htmlFileName = "index.html"
htmlTagChecker(htmlFileName)
