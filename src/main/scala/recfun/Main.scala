package recfun

object Main {

   def main(args: Array[String]) {
        println("Pascal's Triangle")
        for (row <- 0 to 10) {
            for (col <- 0 to row)
                print(coefBinomial(col, row) + " ")
            println()
        }
    }

    /**
     * Exercise 1
     * Triangle de Pascal
     */
    def coefBinomial(col: Int, ligne: Int): Int = {
      (col, ligne) match {
        case (_,_) if (col > ligne || col < 0 || ligne < 0) => throw new IllegalArgumentException("Param�tres invalides") 
        case (0, _) => 1
        case (_, _) if col == ligne => 1
        case (_, _) => coefBinomial(col, ligne-1) + coefBinomial(col-1, ligne-1)
      }
    }
    
    /**
     * Exercise 2
     * Écrire une fonction récursive qui renvoie vraie ssi une liste de caractères est un palindrome
     */
    
    def isPalindrome(list: List[Char]): Boolean = {
      def renverse(myList: List[Char]): List[Char] = {
        myList match {
          case Nil => myList
          case elem::Nil => elem::Nil
          case _ => myList.last::renverse(myList.init)
        }
      }
      
      list == renverse(list)
    }    
    
     /**
     * Exercise 3
     * Soit, d'apr�s B.Werber, la suite d�butant par 1 et telle que chaque terme soit l'�num�ration du terme  pr�c�dent,  �num�ration  constitu�e  simplement  par
     * le  nombre  de  fois  qu'un  chiffre  se trouve plusieurs fois �crit cons�cutivement. Ainsi � l'�tape 111221, la lecture de gauche � droite de ce "mot" sera
     * 3 fois le chiffre 1 puis 2fois le chiffre 2 et enfin 1 fois le chiffre 1. L'�tape suivante sera donc constitu�e par 312211.
     */
    def ant(etape: List[Int], nombreIteration: Int): List[Int] = {
      
      // one iteration
      def once(_etape: List[Int], previous: Int, count: Int) : List[Int] = {
        _etape match {
          case Nil => count::previous::Nil
          case elem::reste if elem == previous => once(reste, elem, count+1) 
          case elem::reste if elem != previous => count::previous::once(reste, elem, 1)
        }
      }
      
      (etape, nombreIteration) match {
        case (Nil, _) => throw new IllegalArgumentException("Liste vide") 
        case (_, _) if nombreIteration <= 0 => etape
        case (elem::reste, _) if nombreIteration > 0 => ant(once(reste, elem, 1), nombreIteration-1)
      }
      
    }

    /**
     * Exercise 4
     * Équilibrage des parenthèses dans une chaîne de caractères.
     */
    def equili(chars: List[Char]): Boolean = {
      def _balance(myList: List[Char], opened: Long): Boolean = {
        (myList, opened) match {
          case (_, -1) => false
          case (elem::reste,_) if elem == '(' => _balance(reste, opened+1)
          case (elem::reste,_) if elem == ')' => _balance(reste, opened-1)
          case (elem::reste,_) => _balance(reste, opened)
          case (Nil, _) if opened == 0 => true
          case (Nil, _) if opened != 0 => false
        }
      }
      
      _balance(chars, 0) 
    }

    /**
     * Exercise 5
     * Écrire une fonction booléenne et récursive qui teste si une chaîne de caractères donnée  est  une  anagramme  d'une
     * autre  chaîne  de  caractères  donnée.  Par  exemple : 'algorithme' est une anagramme de 'logarithme'
     */
    def isAnagramme(chars1: List[Char], chars2: List[Char]): Boolean = {
      def count(needle: Char, myList: List[Char]): Long = {
        (needle, myList) match {
          case (needle, Nil) => 0
          case (needle, elem::reste) if elem == needle => 1 + count(needle, reste)
          case (needle, elem::reste) if elem != needle => count(needle, reste)
        }
      }
      
      def _isAnagramme(current: List[Char], chars1: List[Char], chars2: List[Char]): Boolean = {
        (current, chars2) match {
          case (Nil, Nil) => true
          case (elem::Nil, _) if count(elem, chars2) == count(elem, chars1) => true
          case (elem::Nil, _) if count(elem, chars2) != count(elem, chars1) => false
          case (elem::reste, _) if count(elem, chars2) == count(elem, chars1) => _isAnagramme(reste, chars1, chars2)
          case (elem::reste, _) if count(elem, chars2) != count(elem, chars1) => false         
        }
      }
      
      _isAnagramme(chars1, chars1, chars2)
      
    }

    /**
     * Exercise 6
     * Écrire une fonction récursive qui calcule le pgcd de deux entiers naturels a et b par la méthode d'Euclide
     */
    def pgcd(a: Int, b: Int): Int = { // j'avoue celle l� elle est crade
      def getDivisors(nb: Int, divisor: Int): List[Int] = {
        (nb, divisor, nb % divisor) match {
          case (_, _, _) if nb == divisor-1 => Nil
          case (_,_,_) if nb % divisor == 0 => divisor::getDivisors(nb, divisor+1)
          case (_,_,_) => getDivisors(nb, divisor+1)
        }
      }
      def intersection(listA: List[Int], listB: List[Int]): List[Int] = {
        (listA, listB) match {
          case (Nil, Nil) | (Nil, _) | (_, Nil) => Nil
          case (elemA::resteA, _) if listB.contains(elemA) => elemA::intersection(resteA, listB)
          case (elemA::resteA, _) if !listB.contains(elemA) => intersection(resteA, listB)
        }
      }
      def max(myList: List[Int]): Int = {
        def bigger(nb1: Int, nb2: Int) : Int = {
          if (nb1 > nb2) {
            nb1
          } else {
            nb2
          }
        }
        myList match {
          case Nil => throw new IllegalArgumentException("Liste vide")
          case elem::Nil => elem 
          case elem::reste => bigger(elem, max(reste))
        }
      }
      
      max(intersection(getDivisors(a, 1), getDivisors(b, 1)))
    }

    /**
     * Exercise 7
     * Écrire une fonction récursive change qui détermine le nombre de façon différentes de payer une somme d’argents a l’aide
     * d’une liste de valeurs de billets disponibles. Nous supposerons que cette liste est donnée de façon décroissante.
     * Par exemple : change (List(5, 10, 20, 50, 100, 200, 500),1790 ) = 1602321
     */
    
    def nombreDeChange(monnaies: List[Int], montant: Int): Int = {
      def emptyBefore(myList: List[Int], index: Int) : List[Int] = {
        
      }
      
      def biggest(myList: List[Int]) : Int = {
        def _biggest(myList: List[Int], indexMax: Int) : Int = {
          (myList(current), myList.size) match {
            case (_, 
          }
          if myList(current) != 0 && current > indexMax {
            
          } else {
            
          }
        }
        
        _biggest(myList, 0);
      }
      
      def next(monnaies: List[Int], previous: List[Int]) : List[Int] = {
      
      }
      
      def createEmptyList(size: Int) : List[Int] = {
         List.fill(size)(0)
      }
      
      next(monnaies, Nil)
    }

}
