
This [[Edsger_Dijkstra|Dijkstra]]'s algorithm works when with 2 processes.
We have a shared variable turn, when turn == i, then *P*i can execute its [[Processes Synchronization#Critical section|critical section]], when *P*i is done, it changes the value of turn to j, and so on.

```
//Process Pi
while(true){
	while (turn !=i); //do nothing
	//Critical section
	turn = j;
	//Non-critical section
}
```
This algorithm, as simple as it is, does not respect the [[Processes Synchronization#^progress|progress]] requisite, in facts, there is a fierce alternation of the processes.
If for example process 1 just executed its critical section but is ready to execute again, it will have to wait for process 2, without the possibility to participate in the decision of who will execute next.