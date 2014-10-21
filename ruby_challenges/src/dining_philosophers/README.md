#Dining Philosophers

Credits: Bala Paranj

This project illustrates the [Dining Philosophers Problem](http://en.wikipedia.org/wiki/Dining_philosophers_problem).

##Classes

The project implements the following classes that together illustrate how deadlocks can occur.

###Philosopher

The philosopher implements the `dine` method.  The `dine` method alternates in a `loop` between eating and thinking, using the `think` and `eat` methods, respectively.  They require two `chopsticks` for eating, and pick up first their left chopstick and then their right chopstick, if not in use by another philosopher.

###Chopstick

A chop stick can receive the messages `take` and `drop`, which `lock` and `unlock` a `mutex`, respectively.  When a first philosopher picks up a chopstick, the locking of the [mutex](http://en.wikipedia.org/wiki/Mutual_exclusion) prevents any other philosopher from picking up that same chopstick until the first philosopher drops and unlocks that chopstick.

###Table

The table initializes one chopstick per philosopher.  It also provides a diagnostic method `show_chopsticks` that shows the number of chopsticks in use.

###Driver

The driver initializes an array of philosophers and a table.  It then spawns a new thread that executes the `dine` method, each on one specific philosopher.  After spawning one thread for each philosopher the `driver` waits for the completion of all threads.  Lastly, the `driver` rescues exceptions and prints diagnostic information about the state of each philosopher and the use of chopsticks.  

##Deadlock

A deadlock can, and for all practical purposes, will occur if every philosopher picks up their left chop stick so that no philosopher has a right chock stick available.  That situation illustrates the deadlock problem:

* the expected behavior of the program is to print out a sequence of eating and thinking activities by specific philosopher until eventually the deadlock situation occurs, and

* the expected diagnostic output has each philosopher hungry holding their left chopstick, with all 5 chopsticks in use.

On a 2014 MacBook Pro, the deadlock occurs almost instantaneously, after typically a few hundred activities have successfully completed.
