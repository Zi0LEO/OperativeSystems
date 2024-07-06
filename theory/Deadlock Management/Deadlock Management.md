The deadlock state happens whenever a collection of blocked [[Processes management|processes]], each of which acquired a resource and is waiting to acquire another resource that is owned by a process of the same collection.


## Necessary conditions
For a deadlock to happen, the following conditions must happen:
- **[[Processes Synchronization#Critical section|Mutual exclusion]]**, just one process at once can use a selected resource;
- **Possession and waiting**, a process that already owns at least one resource is waiting to acquire other resources already owned by someone else;
- **Preemption impossibility**, a resource can be release only voluntarily by a process after this has terminated its operation with it;
- **Circular waiting**, it has to exist a collection of processes {P0, P1, ..., Pn} so that P0 is waiting for a resource owned by P1, P1 is waiting for a resource owned by P2, ..., Pn is waiting for a resource owned by P0.

## How to handle deadlock
We have multiple ways to handle deadlock situations:
- Preventing the system from entering a deadlock state;
- Allowing the system to enter in a deadlock state, detecting it and fixing it;
- Ignore the problem, thinking the system will never enter in a deadlock state. This is what most OS do, including [[Linux]] and [[Windows]].

### Preventing deadlock
We can prevent deadlock by not allowing one of the [[#Necessary conditions|four conditions]] to happen:
- ~~**Mutual exclusion**, we should allow multiple processes to access shared variables concurrently~~, not a good idea;
- **Possession and waiting**, we should grant that when a process asks for a resource, he does not already own one, or, way better, we should impone that processes can request and acquire all the resources they need only when all of these are not owned by someone else. Both these solutions may incur in starvation and low usage of resources;
- **Preemption impossibility**, if a process that already owns some resource cannot acquire all it needs, the OS should release all of the resources owned by the process and put them to the list of the resources it is waiting. 
- **Circular waiting**, we could impone an order to the resources collection and allow each process to only request resources in a growing numerical order.

### Safe state
The system is in a **safe state** if there is a possible sequence <P1, P2, ..., Pn> that includes all of the system's processes so that every request that a process Pi can make can be satisfied using the available resources plus the resources owned by every Pj, with j < i.

So, if Pi needs some resources not yet available, Pi will wait until every Pj has terminated, execute, and release the allocated resources so that P(i+1) can execute, and so on.
When a process requests an available resource, the OS has to decide if its allocation will leave the system in a **safe state**.

When the system is in a safe state, no deadlock will happen, so avoiding the deadlock means to ensure the system will never be left in an unsafe state.

### Algorithms to prevent deadlock
As we have seen, we have two possible scenarios:
- In case we have only one instance of each resource, we can prevent deadlock using the [[Graph of resource allocation#How to prevent deadlock|graph of resource allocation]].
- If we have more than one instance for each resource, the structure becomes more complex, and we need to use the [[Banker's algorithm]]

## Deadlock detection and recovery
This alternative consists into allowing the system to enter in a deadlock situation, detect it and recovering from it. It's important to remember that the following algorithm will only work in a system with single instance per resource.

### Detection
To detect the occurring of deadlock in a system we use a wait-for [[Graph|graph]], that is formed as follows:
- Nodes are processes;
- Oriented edges, such as (i,j), means that P$_i$ is waiting for the release of resources owned by P$_j$.
Periodically, the algorithm checks for the presence of cycles in the wait-for graph, if found it means that a deadlock has occurred.

### Recovery
We have two ways of recovering from a deadlock situation:
- [[#Termination of processes]];
- [[#Resources preemption]]

##### Termination of processes
In this solution, we can decide to:
- Terminate every process in deadlock;
- Terminate individual processes until the deadlock is solved
The decision of which process to kill first depends on various factors, such as priority, used resources, remaining execution time etc.

##### Resources preemption
In this solution, resources are removed one by one from a process and assigned to another, until the deadlock is solved, this obviously may give some problems:
- **Victim selection**, we need to decide from which process the resources will be removed;
- **Rollback**, we need to take the system back to its previous safe state, and take on from that;
- **Starvation**, we need to ensure the victim is not always the same process.