package funsets

object test {
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Int => Boolean, elem: Int)Boolean

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = (x => x == elem)
                                                  //> singletonSet: (elem: Int)Int => Boolean

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = (x => contains(s, x) | contains(t, x))
                                                  //> union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = (x => contains(s, x) & contains(t, x))
                                                  //> intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = (x => contains(s, x) & !contains(t, x))
                                                  //> diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = (x => contains(s, x) && p(x))
                                                  //> filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean

  val bound = 10                                  //> bound  : Int = 10




var a = Set(12, 1,2,3, 13)                        //> a  : scala.collection.immutable.Set[Int] = Set(1, 13, 2, 12, 3)



def exists(s: Set, p: Int => Boolean): Boolean = forall(s, x => s(x))
                                                  //> exists: (s: Int => Boolean, p: Int => Boolean)Boolean

  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
    println(a)
      if (a > bound){
       println("true")
       println(a)
       true
       
       }
      else if (contains(s, a) & !p(a)){
       println("false")
       println(a)
             false
      
      }
      else iter(a + 1)
    }
    iter(-bound)
  }                                               //> forall: (s: Int => Boolean, p: Int => Boolean)Boolean
  
  
  forall(a, x => x < 100)                         //> -10
                                                  //| -9
                                                  //| -8
                                                  //| -7
                                                  //| -6
                                                  //| -5
                                                  //| -4
                                                  //| -3
                                                  //| -2
                                                  //| -1
                                                  //| 0
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10
                                                  //| 11
                                                  //| true
                                                  //| 11
                                                  //| res0: Boolean = true
  
}