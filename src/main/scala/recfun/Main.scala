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
        case (_,_) if (col > ligne || col < 0 || ligne < 0) => throw new IllegalArgumentException("ParamËtres invalides") 
        case (0, _) => 1
        case (_, _) if col == ligne => 1
        case (_, _) => coefBinomial(col, ligne-1) + coefBinomial(col-1, ligne-1)
      }
    }
    
    /**
     * Exercise 2
     * √âcrire une fonction r√©cursive qui renvoie vraie ssi une liste de caract√®res est un palindrome
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
     * Soit, d'aprËs B.Werber, la suite dÈbutant par 1 et telle que chaque terme soit l'ÈnumÈration du terme  prÈcÈdent,  ÈnumÈration  constituÈe  simplement  par
     * le  nombre  de  fois  qu'un  chiffre  se trouve plusieurs fois Ècrit consÈcutivement. Ainsi ‡ l'Ètape 111221, la lecture de gauche ‡ droite de ce "mot" sera
     * 3 fois le chiffre 1 puis 2fois le chiffre 2 et enfin 1 fois le chiffre 1. L'Ètape suivante sera donc constituÈe par 312211.
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
     * √âquilibrage des parenth√®ses dans une cha√Æne de caract√®res.
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
     * √âcrire une fonction bool√©enne et r√©cursive qui teste si une cha√Æne de caract√®res donn√©e  est  une  anagramme  d'une
     * autre  cha√Æne  de  caract√®res  donn√©e.  Par  exemple : 'algorithme' est une anagramme de 'logarithme'
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
     * √âcrire une fonction r√©cursive qui calcule le pgcd de deux entiers naturels a et b par la m√©thode d'Euclide
     */
    def pgcd(a: Int, b: Int): Int = ???

    /**
     * Exercise 7
     * √âcrire une fonction r√©cursive change qui d√©termine le nombre de fa√ßon diff√©rentes de payer une somme d‚Äôargents a l‚Äôaide
     * d‚Äôune liste de valeurs de billets disponibles. Nous supposerons que cette liste est donn√©e de fa√ßon d√©croissante.
     * Par exemple : change (List(5, 10, 20, 50, 100, 200, 500),1790 ) = 1602321
     */
    
    def nombreDeChange(monnaies: List[Int], montant: Int): Int = ???

}
