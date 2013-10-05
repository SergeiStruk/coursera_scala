package recfun

object sheet {
 def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty || money < 0)
 			 0
    else if (money == 0){
       1
    }else {
       countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }                                               //> countChange: (money: Int, coins: List[Int])Int
  
  countChange(5, List(4,3,2,1))                   //> res0: Int = 6
  }