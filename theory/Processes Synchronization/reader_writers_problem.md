The Readers-Writers problem is a critical section problem, that can be solved with semaphores. Let's go through it.
There are two kinds of processes, readers processes, that can access and read the data, and writers processes, that can access and modify the data.
Because of their permissions, it's obvious that many readers can read concurrently, but only one writer can write at once.
Let's analyze the variables we need:
- "wrt" [[Semaphores|semaphore]], to handle the [[Processes Synchronization#Critical section|mutual exclusion]] between writers,
- "readerCount" int, to keep track of how many readers are reading,
- "mutex" [[Semaphores|semaphore]], to safely access the "readerCount" variable.

The code will look something like:

>[!multi-column]
>```
>//Writer
>while(true){
>	wait(wrt);
>	
>	write()
>	
>	signal(wrt);            
>}
>```
>
>```
>//Reader
>while(true){
>	wait(mutex);
>	readerCount++;
>	if(readerCount == 1){
>		signal(wrt);               
>	}
>	signal(mutex);
>	
>	read();
>	
>	wait(mutex);
>	readerCount--;
>	if(readerCount == 0){
>		signal(wrt);
>	}
>	signal(mutex);
>}
>```

The first and last reader need to regulate the access to data with the writers too, so that when someone is reading, no one can write and vice versa.