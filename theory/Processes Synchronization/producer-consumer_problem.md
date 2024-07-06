It consists of two threads operating on a common buffer, the first thread's job is to produce something and add it to a buffer, the second thread's job is to consume what is in the buffer.
Consider for simplicity that the buffer has a counter that keeps track of how many elements are in it.
The instructions at machine language will be something like:
>[!multi-column]
>```
>//Producer
>register1 = counter;
>register1 = register1 + 1;
>counter = register1
>```
>```
>//Consumer
>register1 = counter;
>register1 = register1 - 1;
>counter = register1
>```
>
If the two threads are not synchronized, an [[Processes Synchronization#Interleaving|interleaving]] of the instructions may happen.
The instructions above listed for example may interleave like this:
```
/*prod.*/   register1 = counter         //(register1 == 5)
/*prod.*/   register1 = register1 + 1   //(register1 == 6)
/*cons.*/   register2 = counter         //(register2 == 5)
/*cons.*/   register2 = register2 - 1   //(register2 == 4)
/*prod.*/   counter = register1         //(counter == 6)
/*cons.*/   counter = register2         //(counter == 4)
```
In the example, producer and consumer added and removed an element from the buffer, so the value of the buffer at the end of the operation should have been equal to the value of the buffer before of it. This did not happen due to the interleaving, leaving the buffer into an inconsistent state.

## Semaphores solution
Semaphores come to the rescue to solve this problem maintaining data consistency. 
We have, as before, two processes. We assign 3 semaphores to this problem, a "mutex" semaphore, that grants the [[Processes Synchronization#Critical section|mutual exclusion]] when accessing data, an "empty" semaphore, initialized to the buffer capacity, that handles the number of times consumers can consume in a row, and a "full" semaphore, that handles the number of times producers can produce in a row.
The code will look something like:
>[!multi-column]
>```
>//Producer
>while(true){
>	wait(empty);
>	wait(mutex);
>	buffer[in] = nextProduced;
>	in = (in + 1) % buffer.size();
>	signal(mutex);
>	signal(full);
>}
>```
>```
>//Consumer
>while(true){
>	wait(full);
>	wait(mutex);
>	nextConsumed = buffer[out];
>	out = (out + 1) % buffer.size();
>	signal(mutex);
>	signal(empty);
>}
>```
