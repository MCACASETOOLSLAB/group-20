group-20
========
A software that will serve as an interactive demonstration (e - learning) of the process synchronization problem using 
semaphores, busy waiting, spinlocks, monitors, critical section. 

problem-The dining philosophers problem
The dining philosophers problem is concurrent algorithm design to illustrate synchronization issues and techniques for resolving 
them.

Language used-java

problem statement-
Five silent philosophers sit at a table around a bowl of spaghetti. A fork is placed between each pair of adjacent 
philosophers. Each philosopher must alternately think and eat. However, a philosopher can only eat spaghetti when 
he has both left and right forks. Each fork can be held by only one philosopher and so a philosopher can use the 
fork only if it's not being used by another philosopher. After he finishes eating, he needs to put down both forks 
so they become available to others. A philosopher can grab the fork on his right or the one on his left as they become
available, but can't start eating before getting both of them.
Eating is not limited by the amount of spaghetti left: assume an infinite supply.
The problem is how to design a discipline of behavior  such that each philosopher won't starve; i.e., can forever 
continue to alternate between eating and thinking assuming that any philosopher cannot know when others may want to 
eat or think.

Issues

The problem was designed to illustrate the problem of avoiding deadlock, a system state in which no progress is possible. To see that designing a proper solution to this problem isn't obvious, consider the following proposal: instruct each philosopher to behave as follows:

    think until the left fork is available; when it is, pick it up;
    think until the right fork is available; when it is, pick it up;
    when both forks are held, eat for a fixed amount of time;
    then, put the right fork down;
    then, put the left fork down;
    repeat from the beginning.

This attempt at a solution fails: it allows the system to reach a deadlock state, in which no progress is possible.

This is the state in which each philosopher has picked up the fork to the left, waiting for the fork to the right to 
be put down. With the given instructions, this state can be reached, and when it is reached, the philosophers will 
eternally wait for each other to release a fork.[4]

Resource starvation might also occur independently of deadlock if a particular philosopher is unable to acquire both 
forks because of a timing problem. For example there might be a rule that the philosophers put down a fork after 
waiting ten minutes for the other fork to become available and wait a further ten minutes before making their next
attempt. This scheme eliminates the possibility of deadlock (the system can always advance to a different state) but 
still suffers from the problem of livelock. If all five philosophers appear in the dining room at exactly the same 
time and each picks up the left fork at the same time the philosophers will wait ten minutes until they all put their
forks down and then wait a further ten minutes before they all pick them up again.

Mutual exclusion is the core idea of the problem; the dining philosophers create a generic and abstract scenario useful
for explaining issues of this type. The failures these philosophers may experience are analogous to the difficulties 
that arise in real computer programming when multiple programs need exclusive access to shared resources. These issues
are studied in the branch of Concurrent Programming. The original problems of Dijkstra were related to external devices
like tape drives. However, the difficulties studied in the Dining philosophers problem arise far more often when 
multiple processes access sets of data that are being updated. Systems such as operating system kernels use thousands 
of locks and synchronizations that require strict adherence to methods and protocols if such problems as deadlock, 
starvation, or data corruption are to be avoided.


process execute:



type following command on command prompt


javac <fileName>.java
java <MainclassName>



According to  my program

javac diningProblem.java
java Main

 
 


  
