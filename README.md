# TD3

## [**correction TD2**](https://github.com/poussard/ProgFonctionnelle_TD2/blob/master/correction.md)

Le but de ce TD est d'implémenter des méthodes 
* Une qui calcule les valeurs du triangle de Pascal. 
* une autre qui vérifie l'équilibrage des parenthèses dans une chaîne de caractères.

## Installation
* Télécharger le [**ZIP**](https://github.com/poussard/ProgFonctionnelle_TD3/archive/master.zip) ou cloner le projet avec la commande  git clone https://github.com/poussard/ProgFonctionnelle_TD3.git
* Décompresser le
* Importer le comme 'Existing Projects into Workspace'

## Liste des fichiers

    src
    |- main
    |  |- scala
    |  |  |- common
    |  |  |  |- package.scala
    |  |  |- recfun
    |  |  |  |- Main.scala             // Méthodes a implémenter
    |- test
    |  |- scala
    |  |  |- recfun
    |  |  |  |- AnagrammeSuite.scala   // Tests anagramme
    |  |  |  |- BalanceSuite.scala     // Tests équilibrage des parenthèses
    |  |  |  |- PalindromeSuite.scala  // Tests palindrome
    |  |  |  |- ChangeSuite.scala      // Tests change
    |  |  |  |- AntSuite.scala         // Tests ant


## Exercice: Parenthèses Balancing
Écrire une fonction récursive qui vérifie l'équilibrage des parenthèses dans une chaîne, que nous représentons comme une `List[Char]` pas une `String`. Par exemple, la fonction doit retourner `True` pour les chaînes suivantes:
* (if (zero? x) max (/ 1 x))
* I told him (that it’s not (yet) done). (But he wasn’t listening)

La fonction doit renvoyer `False` pour les chaînes suivantes:
* :-)
* ()) (

Le dernier exemple montre qu'il ne suffit pas de vérifier qu'une chaîne contient le même nombre d'ouverture et de fermeture entre parenthèses.

Faites cet exercice en mettant en œuvre la fonction de balance dans Main.scala. Sa signature est la suivante:
```scala
def balance(chars: List[Char]): Boolean
```
Il existe trois méthodes sur la `List[Char]` qui sont utiles pour cet exercice:
* `chars.isEmpty: Boolean` retourne si une liste est vide
* `chars.head: Char`       retourne le premier élément de la liste
* `chars.tail: List[Char]` retourne la liste sans le premier élément

Astuce: vous pouvez définir une fonction interne si vous avez besoin de passer des paramètres supplémentaires à votre fonction.

Test: Vous pouvez utiliser la méthode de toList qui convertir une String en une liste[Char]: par exemple, "(juste un) par exemple".ToList.

## Exercice: Palindrome
Un palindrome de lettres est  un texte ou un mot dont l'ordre des lettres reste le même qu'on le lise de gauche à droite ou de droite à gauche.
Écrire une fonction qui verifie d'un tableau de char est un palindrome
 
 ```scala
 def isPalindrome(list: List[Char]): Boolean 
 ``` 

## Exercice :  Compter le nombre de facon de rendre le change
 Ecrire une fonction recursive qui compte combien de facons differentes vous pouvez faire un change pour un montant, etant donne une liste de pieces de monnaie.
Par exemple,il y a 3 facons de donner le changement pour 4 si vous avez des pieces de 1 et 2:
* 1 + 1 + 1 + 1
* 1 + 1 + 2
* 2 + 2
   
 ```scala
  def nombreDeChange(montant: Int, monnaies: List[Int]): Int 
 ```
