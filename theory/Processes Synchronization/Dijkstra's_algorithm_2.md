This other solution from [[Edsger_Dijkstra |Dijkstra]] is very similar to the [[Dijkstra's_algorithm_1|other]].
It is implemented by a boolean array flag, whenever flag\[i] is true, Pi can execute its [[Processes Synchronization#Critical section|critical section]]  
```
//Process Pi

while(true){
	flag[i] = true;
	while flag[j]; //do nothing
	//critical section
	flag[i] = false;
	//non-critical section
}
```
The problem of this algorithm is that when both of the processes are ready to execute their critical section, it happens that each of them keeps waiting for the other, generating a [[Deadlock Management|deadlock]] situation. 