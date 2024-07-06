Virtual Memory is a technique that allows us to separate the logical memory from the physical one.

Virtual memory is a space in the disk that simulates the central memory, when a program is executed, the entirety of it is loaded into the virtual memory, whereas only a part of it is actually loaded into physical memory, so the space of logical addresses has to be bigger than the space of physical addresses.

Virtual memory is implemented via [[Paging#Paging on request|paging]].

A problem that may present is [[Thrashing]].
