Overlay technique is used when the address space of a process exceeds the available RAM, in such cases, only the most used data and instructions are loaded into memory.
Whenever different parts of the program are needed, an algorithm determines which data and instructions are the least used and [[Swapping|swaps them out]] with the needed data.

This solution is very useful on machines with limited hardware, that does not allow for better solutions, but its implementation is very complex
