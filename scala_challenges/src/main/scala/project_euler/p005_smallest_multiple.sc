// Smallest multiple
// Problem 5
// 2520 is the smallest number that can be divided by each
// of the numbers from 1 to 10 without any remainder.
// What is the smallest positive number that is evenly
// divisible by all of the numbers from 1 to 20?

val s = Range(1, Int.MaxValue).
  find(n => Range(2, 21).forall(n % _ == 0)).
  get

assert(s == 232792560)
