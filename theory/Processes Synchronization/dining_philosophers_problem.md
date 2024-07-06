iLet's imagine a circular table with N chairs, on each chair is sitting a philosopher, with a bowl of food in front of him, a chopstick on his right and a chopstick on his left.
The goal of each philosopher is to eat, but to do so he needs both the chopsticks, so he needs to wait for both the philosophers on his right and left to stop eating, so that he can use the chopsticks.

### Solution with semaphores
We can represent each chopstick with a semaphore, <`Semaphore[] chopsticks = new Semaphore[7];`> and each philosopher with a process.
Let's say we have 7 philosophers, the code will look like this:
```
//philosopher i
while (true) {
	chopsticks[i].wait();
	chopsticks[(i + 1) % 7].wait();
	
	//eat

	chopsticks[i].signal();
	chopsticks[(i + 1) % 7].signal();
}
```

This solution is very easy, but it comes with a big risk of [[Deadlock Management|deadlock]]. 
To solve this problem we need some other method.

### Solution with monitors
Let's introduce a monitor:
```
monitor dining_phil{
	var state[7] = {thinking, hungry, eating};
	var self[7] condition;

	init(){
		for (int i = 0; i < 7; i++)
			state[i] = thinking;
	}
}
```
In the code we have a monitor that comprehends a state an array of state variables, each keeping the state of each philosopher, and an array of conditions, called self. 
We will use each condition to synchronize the various philosophers and decide when they can eat and when they cannot.
This will be the code of each philosopher:
```
//philosopher i
while (true){
	dining_phil.pickup(i);
	//eat
	dining_phil.putdown(i);
}
```
As we see the code of each philosopher is very similar to the semaphores implementation, however, the magic will happen inside the monitor:
```
monitor dining_phil{
	// variables, conditions and init method written above

	method pickup(i){
		state[i] = hungry;
		test(i);
		if (state[i] != eating)
			self[i].wait();
		}

	method test(i){
		if(state[(i + 6) % 7] != eating && state[(i + 1) % 7] != eating && state[i] == hungry){ //the two closer philosophers are not eating and i is hungry
			state[i] = eating;
			self[i].signal();
		}
		
	}
	
	method putdown(i){
		state[i] = thinking;
		test[(i + 6) % 7]; 
		test[(i + 1) % 7]; //check if other philosophers can eat
		}
}
```