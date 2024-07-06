Physical memory is divided into fixed-dimension blocks, called frames, whereas logical memory is divided into fixed-dimension blocks, called pages.

The [[Address Concepts#Memory Management Unit (MMU)|MMU]] keeps track of all available frames, since to execute a program that needs *n* pages we need to find *n* available frames. 

For each process it exists a page-table whose index is the number of page, and whose value is the frame, or to better say, a pointer to the start of it.

This method avoids [[Fragmentation#External fragmentation|external fragmentation]], but due to the fixed dimension blocks, may generate [[Fragmentation#Internal fragmentation|internal fragmentation]].

It's important to note that the pages are logically contiguous, whereas the frames they point to are not physically contiguous.
### Paging architecture
A [[Address Concepts#Logical and physical addresses|logical address]] in this context is composed of 2 values `<page_index, offset>`, the first value relates to the page-table.

##### [[Page Table Structure|Page table]]
Each element of this table contains:
- **Frame address**, the address where the frame starts in memory.

##### Registers
To work, this architecture needs 2 specific registers:
- **Page-table base register(PTBR)**, that points to the start of the table;
- **Page-table length register(PTLR)**, that keeps the table's length.
##### Execution
When the CPU generates a logical address, its first element `page_index` is sent to the page table, the element at index `page_index` of the table will be the address of the frame we need, to this address is then added the value of `offset`, and so the physical address is obtained.

##### Optimization
This scheme needs a double access in memory, one to access the page-table, one to access the effective memory address. This can be solved with a hardware [[Cache|cache]], called [[Associative Memory]].

### Protection
Memory protection is implemented by associating one **protection bit** to every frame. This allows to verify user permissions.
Often another bit is used, a **validity bit**.

The validity bit associated to every entry in the page table can have two values:
- **Valid** means that the associated page is in the address' space of the process, and the access is legal;
- **Invalid** means that the associated page is not in the address space of the process, so an access will throw an error.

## Shared Pages
Using paging we can easily share code in common between processes, for this to work, the common shared code must appear in the same location in the space of logical addresses for every process. This because when mapping a logical address to a physical one, for the result to be the same, thus accessing the same code, the logical address must be the same too.

## Paging on request
Paging on request is essential for the implementation of virtual memory, it basically means that a page is brought into central memory only when the OS requests it, otherwise, it will remain into mass memory. This grants:
- Less amount of central memory needed;
- More concurrent processes;
- Faster response.

When a page is needed, the CPU will generate a logical address where we can find it, then 3 things can happen:
- 1. If the relative frame is already contained into memory, everything goes smoothly;
- 2. If the address is not valid, the operation will be aborted;
- 3. If the relative frame is not contained into memory, we will have a [[Page Fault|page fault]].