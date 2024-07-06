It is implemented via an index table, that contains the pointers to each block of the secondary memory.
The table itself is contained in a block of memory.
This kind of structure allows for the direct access and removes the possibility of [[Fragmentation#External fragmentation|external fragmentation]].

A logical address will be divided into two elements Q and R, where Q will represent the index of the table that will point to the needed block, R will be the offset inside the block.

Sometimes a single block is not enough to contain the entire index table, in this case there are 3 possible solutions:
- [[Chain Scheme]];
- [[Multilevel Scheme]];
- [[Combined Scheme]].