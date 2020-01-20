package recfun

object Main {

    /**
     * Exercise 1
     * Ecrire une fonction recursive qui renvoie vraie ssi une liste de caracteres est un palindrome
     */
    def isPalindrome(list: List[Char]): Boolean = ???

    /**
     * Exercise 2
     * Soit, d'après B.Werber, la suite débutant par 1 et telle que chaque terme soit l'énumération du terme  précédent,  énumération  constituée  simplement  par
     * le  nombre  de  fois  qu'un  chiffre  se trouve plusieurs fois écrit consécutivement. Ainsi à l'étape 111221, la lecture de gauche à droite de ce "mot" sera
     * 3 fois le chiffre 1 puis 2fois le chiffre 2 et enfin 1 fois le chiffre 1. L'étape suivante sera donc constituée par 312211.
     */
    def ant(etape: List[Int], nombreIteration: Int): List[Int] = ???

    /**
     * Exercise 3
     * Equilibrage des parentheses dans une chaine de caracteres.
     */
    def equili(chars: List[Char]): Boolean = ???

    /**
     * Exercise 4
     * Ecrire une fonction booleenne et recursive qui teste si une chaîne de caracteres donnee  est  une  anagramme  d'une
     * autre  chaine  de  caracteres  donnee.  Par  exemple : 'algorithme' est une anagramme de 'logarithme'
     */
    def isAnagramme(chars1: List[Char], chars2: List[Char]): Boolean = ???

    /**
     * Exercise 5
     * Ecrire une fonction recursive change qui détermine le nombre de façon differentes de payer une somme d’argents a l’aide
     * d’une liste de valeurs de billets disponibles. Nous supposerons que cette liste est donn ee de façon d ́ecroissante.
     * Par exemple : change (List(5, 10, 20, 50, 100, 200, 500),1790 ) = 1602321
     */
    def nombreDeChange(monnaies: List[Int], montant: Int): Int = ???
}
