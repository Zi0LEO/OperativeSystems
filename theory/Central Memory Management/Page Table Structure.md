To manage bigger tables, three main techniques are used:
- [[#Hierarchical page tables]], usually formed by 2-3 levels of nested page tables;
- [[#Inverted page tables]], a global page table, common for every process, that stores one entry per frame;
- [[#Hashed page tables]], generally used for systems with more than 32 bits.

## Hierarchical page tables
When working with 32 bits systems, each logical address is composed of 32 bits, the first 20 will be the page index, but this means we would have 2$^{20}$ addresses, and considering a dimension of 4kb for page, this would translate to 4Mb of memory per process, this would obviously be way too expensive in terms of memory. 

>[!multi-column]
>To ovviate this problem, we split the 20 bits into two tables, so that we have 2$^{10}$ x 2$^{10}$ addresses, the outermost table will then contain 2$^{10}$ = 1024 entries, each of them will point to another table, the page of table of pages, again with 2$^{10}$ = 1024 entries. 
>The logical address, composed as `<P1, P2, offset`, will be used in all of the tables. The first table, in facts will be navigated until the element `P1`, that will work as an index, the same will happen with the second table and P2, the frame found in the second table will then be increased of `offset`, returning a physical address.
>
>![[page_table_structure.png]]

## Inverted page tables
An inverted page table, in contrast with normal page tables, will be global, every process in facts will refer to it. The number of entries of the page table will be equal to the number of frames of the physical memory. 

>[!multi-column]
>The logical address in this scheme will be `<PID, P, D>`, where PID is the process id, P is the [[Virtual Memory|virtual page]] number and D is the usual offset. The page table instead will contain a couple of variables, `<PID, P>`. 
>When the CPU generates a logical address, the MMU searches the PID, P couple in the inverted page table, the index I where it is found will be the number of frame. This, increased of D, will give us the physical address.
>
>![[Inverted_page_table.png]]


## Hashed page tables
In this scheme, the logical address is once more composed of `<P,D>`. The value P is given as an input to a hash function. This will map it into a [[Hash Map|hash map]], where [[Hashing#Collision Handling|collision handling]] will generate a [[Linked List|linked list]]. Each element of the linked list will have this structure: 
`<virtualPageNumber, physicalFrameNumber, pointerToNextElement>`.

>[!multi-column]
>Searching for an address, P will be used as input for the hash function, this will give the exact row of the hash map, then the [[Address Concepts#Memory Management Unit (MMU)|MMU]] will look for the element whose `virtualPageNumber` equals `P`, once found, the corresponding `physicalFrameNumber` will give us the number of the frame, and consequently its address, that increased of `D`, will give us the physical address we were looking for.
>
>![[hashed_page_table.png]]
