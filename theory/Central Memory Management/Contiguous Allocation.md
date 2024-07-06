# Central Memory
Central memory is usually divided in two partitions:
- Operative System partition;
- User Processes partition.
This is not always the case, let's analyze pros and cons of each solution.
### Single partition allocation
In this case a relocation register is used protect user processes from each other and to protect OS processes from user processes. 

Two registers are extremely important:
- Relocation register, which contains the smallest available [[Address Concepts#Logical and physical addresses|physical address]], usually located after the OS;
- Limit register, which contains the maximum interval of [[Address Concepts#Logical and physical addresses|logical addresses]], this means that every logical address has to be smaller than the limit register.

### Multiple partition allocation
When a process is put into central memory, it needs a hole big enough to contain it.

> [!help]
> A hole is an available block of memory

It is OS's responsibility to keep track of allocated and free partitions.

To find and allocate a hole to a program, there are various algorithms:
- **first-fit** allocates to the process the first hole big enough to contain it.
- **best-fit** allocates to the process the smallest hole big enough to contain it.
- **worst-fit** allocates to the process the biggest possible hole.
Obviously, the best performances are provided by first and best fit.

### Problems
Even though contiguous allocation seems the best possible solution, it generates one of the worst problems of today's computers: [[Fragmentation]].

# Secondary Memory
Each file occupies a contiguous collection of blocks on the disk, to access each file we need to know the number the block and the offset of the file. This system allows direct access, but wastes a lot of space because of [[Fragmentation]]. Moreover, there may be some cases where files cannot ask for more space because the next blocks are already full.

The logical address will be split into Q and R, where Q + starting address will be the block to access, R will be the offset inside the block.
### Extents
Some OS use a modified type of contiguous memory allocation, in facts, when a file needs more memory, but cannot expand, another contiguous space, called extent and pointed by the File Control Block, is added.