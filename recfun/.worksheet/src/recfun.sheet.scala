package recfun

object sheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(407); 
  def balance(chars: List[Char]): Boolean =  {
    def isBalance(count: Int, chars: List[Char]): Boolean = {
       if (chars.isEmpty)
    	   count == 0
       else
         if (chars.head == '(') isBalance(count + 1, chars.tail)
         else if (chars.head == ')') isBalance(count - 1, chars.tail)
         else isBalance(count, chars.tail)
    }
   isBalance(0, chars)
  };System.out.println("""balance: (chars: List[Char])Boolean""");$skip(24); val res$0 = 

balance(("()").toList);System.out.println("""res0: Boolean = """ + $show(res$0))}
  
}
