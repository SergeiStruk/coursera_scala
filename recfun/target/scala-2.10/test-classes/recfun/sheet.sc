package recfun

object sheet {
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
  }                                               //> balance: (chars: List[Char])Boolean

balance(("()").toList)                            //> res0: Boolean = true
  
}