A Monitor is a high-level construct that allows data sharing between threads ensuring [[Processes Synchronization#Critical section|mutual exclusion]]. It can be implemented as a class that contains shared variables and methods to access them [[Atomic instructions|atomically]].
A monitor ensures that **only one process at a time can be active inside of it**.
To implement this, every instance of a monitor has a queue of threads waiting to access one of its methods.

### Conditions
Inside a monitor there can be a number of conditions that allow us to fine-grain control on the monitor. Each condition x has a separate queue, whenever a process p calls x.wait(), p's execution is suspended and put inside the x queue, where it will remain until another process frees the condition calling x.signal(). 
The notify() command will remove a process from the condition queue where it is assigned, and when all the conditions are "satisfied", the process will acquire control of the monitor.

### Hoare and Hansen
Let's suppose a process P executes x.signal() and there is a suspended process Q waiting for a signal on the condition x. Normally there would be no problem, but what if P executed the signal not as its last instruction?
Here comes the need to find a solution to avoid P and Q to be concurrently active in the monitor. 
- **Hansen's solution**, the process Q will wait for P to leave the monitor or wait in another condition;
- **[[Tony Hoare|Hoare]]'s solution**, the process P will wait for Q to leave the monitor or wait in another condition;
[[Tony Hoare|Hoare]]'s solution is preferred here because if we let P continue its execution, the condition that Q was waiting may be no more consistent when P finishes its execution.
A compromise we can find is to allow P to call signal just once, and once done, it will need to leave the monitor.
This solution is less powerful than Hoare's, because it prevents a process to call more signal during its execution.

### Problems Examples
- [[dining_philosophers_problem]]


### Java Monitors
Java doesn't have a particular monitor Object to be used. This is because the implementation of monitors in Java allows every object to become a monitor.
It's possible to introduce the keyword `synchronized` while declaring a method to allow only one thread at a time to execute that method at once. 
Basically if a [[thread]] T executes a `synchronized` method of an object O, no other thread can access **any other synchronized method of O**, until T will have left the method.
