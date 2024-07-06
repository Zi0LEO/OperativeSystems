Semaphores are a tool for sinchronization that in some implementations doesn't require busy waiting. 
A semaphore S is an integer variable that can be accessed exclusively via 2 [[Atomic instructions|atomic methods]], **Wait** and **Signal**
```
wait(S){
	while(S <= 0); //do nothing
	S--;
	}

signal(S){
	S++;
}
```

We can implement a conceptual Semaphore class as follows:
```
class Semaphore{
	int value;
	LinkedList<Process> processList = new LinkedList<Process>();

	public Semaphore(int initialValue){
		this.value = initialValue;
	}
	public wait(Process process){
		this.value--;
		if (this.value < 0)
			processList.add(process);
			block(process);
		}

	public signal(){
		this.value++;
		if(this.value >= 0){
			Process p = processList.pop();
			wakeUp(p);
		}

	private block(Process process){
		//code for blocking process
	}

	private wakeUp(Process process){
		//code for waking up process
	}
}
```

Semaphores can be used to access the critical section of a program:
```
//process Pi, semaphore mutex
while true{
	mutex.wait();
	//critical section
	mutex.signal();
	//non-critical section
}
```

Semaphores were invented by [[Edsger_Dijkstra|Dijkstra]], and his implementation was S.P(), where P stands for "proberen", (test), and was the S.wait() operation, and S.V(), where V stands for "verhogen", (increment), and was the S.signal() operation.
Semaphores don't prevent the occurring neither of [[Deadlock Management|deadlock]] nor starvation.

### Binary semaphores
The semaphores we talked about so far is called counter semaphore, because its value can be any integer, positive and negative.
A binary semaphore instead is any semaphore whose value can be only 0 or 1.

### Java Semaphore class
Java allows us to use semaphores via its class `java.util.concurrent.Semaphore`.
This class implements a counter semaphore very close to the one we saw so far, with the methods S.acquire() and S.release().
The value of the semaphore is set in the constructor, and we can increment and decrement it of an arbitrary value.

### Problems examples
The introduction of semaphores allows us to solve some critical section problems:
- [[producer-consumer_problem|Producer-Consumer problem]];
- [[reader_writers_problem|Readers-Writers problem]];
- [[dining_philosophers_problem|Dining philosophers problem]]
