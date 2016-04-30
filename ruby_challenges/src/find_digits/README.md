#Find Digits

You are given a number N, you need to print the number of positions where digits exactly divides N.

###Input format

The first line contains T (number of test cases) followed by T lines (each containing N).

###Constraints
	1 <=T <= 15
	0 < N < 1010

###Output Format
For each test case print the number of positions in N where digits in that number exactly divides the number N in separate line.

*Note*

Same digits repeated twice, should be counted twice.

###Input

	1
	12
###Output

	2
###Explanation

* 2 digits in the number 12 divide the number exactly.
* Digits at ten's place, 1, divides 12 exactly in 12 parts, and
* digit at one's place, 2 divides 12 equally in 6 parts.

###Credits
Problem from [Hackerrank](https://www.hackerrank.com/challenges/find-digits).
This challenge was a part of [Pragyan 12](http://en.wikipedia.org/wiki/Pragyan).
