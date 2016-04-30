#Knight's Dialer

To solve the Knight's Dialer challenge you must determine how many legal 7-digit phone numbers a chess knight can dial on a standard telephone dial pad.

###Legal 7-Digit Phone Numbers

Any sequence of 7 digits is considered a legal [7-digit phone number](https://en.wikipedia.org/wiki/Seven-digit_dialing).  The number may not, however, contain other characters, such as '*' or '#'.

###Chess Knight

A [chess knight](https://en.wikipedia.org/wiki/Knight_\(chess\)) can move 2 steps in any direction, that is, left, right, up, or down, followed by 1 step perpendicular to the initial direction.

###Standard Telephone Dial Pad

A [standard telephone dial pad](https://en.wikipedia.org/wiki/Telephone_keypad) is arranged in four rows and three columns of keys, running from top to bottom and left to right, like so:

	1 2 3
	4 5 6
	7 8 9
	* 0 #

###Example

The knight can dial the following legal 7-digit phone number:

	9, 4, 0, 6, 1, 8, 3

Explanation:

- The knight may start on any number key, such as '9' here.
- From '9' the knight can move to '4' because '4' is 2 keys to the left and 1 key up from '9'.
- Next, the night can move 2 keys down and 1 key right, reaching the '0' key.

The remaining moves are:

- 2 up, 1 right to 6
- 2 left, 1 up to 1
- 2 down, 1 right to 8
- 2 up, 1 right to 3