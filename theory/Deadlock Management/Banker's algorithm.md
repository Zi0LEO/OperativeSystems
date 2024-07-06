Banker's algorithm allows to manage more instances for type of resource in concurrent systems. 
An important precondition is that every process must declare all the resources it will need during its execution. 
## Needed data structures
Be **n** the number of processes and **m** the number of resources:
- **available** is an array of length m, where `available[ i ] == k` means that resource i has k available instances;
- **max** is a n x m matrix, where `max[ i ][ j ] == k` means that the process i can request at most k instances of the resource j;
- **allocation** is a n x m matrix, where `allocation[ i ][ j ] == k` means that the process i is currently holding k instances of the resource j;
- **need** is a n x m matrix, where `need[ i ][ j ] == k` means that the process i may need to acquire k instances of the resource j;
- **request$_i$** is an array of requests of process P$_i$, where `request[j] == k` means that P$_i$ needs k instances of the resource j.
From these definitions `max[i][j] == allocation[i][j] + need[i][j]`.

## Resources assignation
Here the banker's algorithm starts. Let's consider a process P$_i$:
- 1. If `request[j] <= need[i][j]`, go to point 2, otherwise, throw an error, because P$_i$ is requesting more resources than declared;
- 2. If `request[j] <= available[j]`, go to point 3, otherwise P$_i$ will need to wait, since there are not enough available resources;
- 3. Simulate the assignation of the requested resources to the process, by modifying the state as:
``` 
	need[i][j] -= request[j];
	allocation[i][j] += request[j];
	available[j] -= request[j];
```
If the system is in a [[#Checking for safe state|safe state]], then the resources are assigned to P$_i$, otherwise, P$_i$ will need to wait and the old allocation state is reinstated.

## Checking for [[Deadlock Management#Safe state|safe state]]
Be **work** and **finish** two arrays of length **m** and **n** respectively,
Step 1: initialize them as:
- `work = available`;
- `finish[i] = false`, this keeps track of the processes that can execute and terminate;

Step 2: look for an index i so that:
- `finish[i] ==  false`;
- `need[i] <= work[i]`, this means that even if the process will need some more resources than the ones already allocated, they will be at max the ones stored in need, and since work is more or equal to need, it will be able to use them;
if found go to step 3, otherwise skip to step 4.

Step 3: simulate the execution:
- `work[i] += allocation[i]`, this instruction simulates the termination of process i, thus releasing the allocated resources, that will become available;
- `finish[i] = true`;
go back to step 2.

Step 4: check for safe state:
- if `finish[i] ==  true` for each i, then the system is in a safe state, otherwise it is not.