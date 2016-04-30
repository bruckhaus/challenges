//Largest palindrome product
//Problem 4
//A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//
//Find the largest palindrome made from the product of two 3-digit numbers.

val p = (100 to 999).view.
  flatMap(i => (100 to 999).map(i *)).
  filter(n => n.toString == n.toString.reverse).
  max

assert (p == 906609)
