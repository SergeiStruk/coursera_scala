package funsets

object test {
  type Set = Int => Boolean;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(179); 

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: Int => Boolean, elem: Int)Boolean""");$skip(114); 

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = (x => x == elem);System.out.println("""singletonSet: (elem: Int)Int => Boolean""");$skip(194); 

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = (x => contains(s, x) | contains(t, x));System.out.println("""union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(203); 

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = (x => contains(s, x) & contains(t, x));System.out.println("""intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(195); 

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = (x => contains(s, x) & !contains(t, x));System.out.println("""diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(142); 

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = (x => contains(s, x) && p(x));System.out.println("""filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean""");$skip(18); 

  val bound = 10;System.out.println("""bound  : Int = """ + $show(bound ));$skip(31); 




var a = Set(12, 1,2,3, 13);System.out.println("""a  : scala.collection.immutable.Set[Int] = """ + $show(a ));$skip(73); 



def exists(s: Set, p: Int => Boolean): Boolean = forall(s, x => s(x));System.out.println("""exists: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(361); 

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
  };System.out.println("""forall: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(32); val res$0 = 
  
  
  forall(a, x => x < 100);System.out.println("""res0: Boolean = """ + $show(res$0))}
  
}
