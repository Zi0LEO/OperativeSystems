Each file is managed by a series of blocks organized as a linked list, each block will contain in facts as the first word a pointer to the next bock, and then the info on the file. 
This kind of allocation is fairly easy to maintain, since each File Control Block will need just the pointer to the first block, there is no [[Fragmentation]], and allows for the growth of file size. The down-side is that, because of its implementation, there cannot be a direct access, but only sequential, so the time to access a specific data will depend by the dimension of the file and the position of the data inside the file.

The logical address will be divided into Q and R, where Q is the element of the linked list to access(the block), R + 1 will be the offset in the block.

### File Allocation Table
Some OS, like MS-DOS, use a FAT, a table who contains as many entries as the number of blocks in memory, each entry contains the index of the next block.