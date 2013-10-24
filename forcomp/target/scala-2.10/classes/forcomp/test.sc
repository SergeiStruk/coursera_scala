package forcomp

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  

	
type Occurrences = List[(Char, Int)]

val occ = List(('a', 2), ('c', 1), ('b', 1))      //> occ  : List[(Char, Int)] = List((a,2), (c,1), (b,1))
val ch = 'b'                                      //> ch  : Char = b
"d" <= "c"                                        //> res0: Boolean = false
occ.dropWhile(_._1 <= ch)                         //> res1: List[(Char, Int)] = List((c,1), (b,1))


val a = List() :+ 4                               //> a  : List[Int] = List(4)
val b = List(List())                              //> b  : List[List[Nothing]] = List(List())

def combinations(occurrences: Occurrences): List[Occurrences] =
	combinations(occ)                         //> combinations: (occurrences: forcomp.test.Occurrences)List[forcomp.test.Occur
                                                  //| rences]

for (i <- 1 to 10 if i % 2 == 0)
  println("Counting " + i)                        //> Counting 2
                                                  //| Counting 4
                                                  //| Counting 6
                                                  //| Counting 8
                                                  //| Counting 10
val occurrences = List(('a', 2), ('c', 1), ('b', 1))
                                                  //> occurrences  : List[(Char, Int)] = List((a,2), (c,1), (b,1))/

for {
        (ch, num) <- occurrences
        restOfOccurrences = occurrences.dropWhile(_._1 <= ch)
        restOfCombinations <- combinations(restOfOccurrences)
        i <- 0 to num
      } yield i




}