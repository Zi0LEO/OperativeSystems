In this algorithm, designed for N processes, every process is identified by an integer (*P*1, *P*2, ... , *P*n).
Before executing its [[Processes Synchronization#Critical section|critical section]], every process receives a non-descending "booking" number, just like in a bakery.
The number received can be equal, but never inferior to the number received by the previous process.
Once the process has received its number, the process allowed to execute its critical section is the one with the smallest booking number, in case of equal booking numbers, the process identified with the smallest integer executes first.

```
//Process Pi
while(true){

	choosing[i] = true;
	number[i] = max(number[0], number[1], ... , number[n-1]) + 1;
	choosing[i] = false;
	
		for (j = 0; j < n; j++){
		
		while(choosing[j]); //wait if some process is choosing a number
		
		while((number[j] != 0) && ((number[j], j) < (number[i], i))); wait
		
		}
		//critical section
		number[i] = 0;
		//non-critical section
}
```
