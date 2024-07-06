
Whenever we have concurrent programs that make sensible operations, like writing or reading to and from central memory, we need them to do this in a definite order to avoid having data inconsistency.
A well-known example that shows how this can happen is the [[producer-consumer_problem]].

## Interleaving
Interleaving of instructions happens when two processes access and modify a shared variable at the same time, this can cause a data inconsistency caused by the indeterminism of the order followed by the machine-level instructions.

## Race condition
When we have two or more processes that try to reach and use the same resource at the same time we have a situation called **race condition**, it's important to prevent this from happening and regulating the access to shared data one process at a time.

## Critical section
We call critical section a segment of code, owned by every process, where the shared variables and data are accessed and/or modified. Avoiding the race condition means allowing one process at a time to enter into its critical section.
To be a solution to the critical section problem, it has to respect 3 important requisites: ^29db16
- **Mutual exclusion**: if a process P is executing its critical section, no other process can do the same;
- **Progress**: if no process is executing its critical section, only the processes that need to execute it can participate in deciding who will be the next to; ^progress
- **Limited waiting**, it has to exist a limit in the number of times other processes can execute their critical section in the time-span that goes between the request of a process P to execute its own critical section and the guarantee of that request

Many algorithms have been written to solve these problems:
- [[Dijkstra's_algorithm_1]]
- [[Dijkstra's_algorithm_2]]
- [[Peterson's_algorithm]]
- [[Lamport's_bakery_algorithm]]


## Sinchronization Methods
Various methods have been found and are currently used for solving the critical section problem:
-  [[Atomic instructions]]
-  [[Semaphores]]
-  [[Monitors]]
-  [[Locks]]







