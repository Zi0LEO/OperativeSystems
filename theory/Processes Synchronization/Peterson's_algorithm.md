This algorithm basically puts together both of Dijkstra's ones to find a working solution that solves previous problems

```
//Process Pi
while(true){
	flag[i] = true;
	turn = j;
	while(flag[j] && turn == j); // do nothing
	
	//critical section
	flag[i] = false
	//non-critical section
	
	}
```
 This solution works, but just with 2 processes