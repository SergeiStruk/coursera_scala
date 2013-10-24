package forcomp

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
  println("Welcome to the Scala worksheet")
  

	
type Occurrences = List[(Char, Int)];$skip(89); 

val occ = List(('a', 2), ('c', 1), ('b', 1));System.out.println("""occ  : List[(Char, Int)] = """ + $show(occ ));$skip(13); 
val ch = 'b';System.out.println("""ch  : Char = """ + $show(ch ));$skip(11); val res$0 = 
"d" <= "c";System.out.println("""res0: Boolean = """ + $show(res$0));$skip(26); val res$1 = 
occ.dropWhile(_._1 <= ch);System.out.println("""res1: List[(Char, Int)] = """ + $show(res$1));$skip(22); 


val a = List() :+ 4;System.out.println("""a  : List[Int] = """ + $show(a ));$skip(21); 
val b = List(List());System.out.println("""b  : List[List[Nothing]] = """ + $show(b ));$skip(84); 

def combinations(occurrences: Occurrences): List[Occurrences] =
	combinations(occ);System.out.println("""combinations: (occurrences: forcomp.test.Occurrences)List[forcomp.test.Occurrences]""");$skip(61); 

for (i <- 1 to 10 if i % 2 == 0)
  println("Counting " + i);$skip(53); 
val occurrences = List(('a', 2), ('c', 1), ('b', 1));System.out.println("""occurrences  : List[(Char, Int)] = """ + $show(occurrences ));$skip(202); val res$2 = 

for {
        (ch, num) <- occurrences
        restOfOccurrences = occurrences.dropWhile(_._1 <= ch)
        restOfCombinations <- combinations(restOfOccurrences)
        i <- 0 to num
      } yield i;System.out.println("""res2: List[Int] = """ + $show(res$2))}




}
