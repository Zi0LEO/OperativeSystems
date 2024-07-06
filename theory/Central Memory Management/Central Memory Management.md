The central memory, or main memory, contains data withdrew from [[Secondary Memory Management|mass memory]] that are waiting to be executed by the CPU, it is usually implemented via a RAM(Random Access Memory). Its management depends largely by what the hardware makes available to the OS.
To be executed, every program needs to be contained, at least partially in central memory.
Programs on disk need to be transferred to central memory via an input queue, that can be defined as a collection of processes on disk that are waiting to be transferred on central memory.
Some useful concepts before going on:
- [[Address Concepts]]
- [[Dynamic Loading and Binding]]
- [[Overlay]]
- [[Swapping]]

## Memory allocation
The principal argument we need to face when we talk about central memory management is the allocation of it, since it is vital for the optimization and maximization of its usage.
There are two main philosophies:
- [[Contiguous Allocation]];
- [[Non-contiguous Allocation]].
