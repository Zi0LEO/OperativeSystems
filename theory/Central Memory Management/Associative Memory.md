An associative memory is a kind of [[Cache|cache]] specifically used in [[Paging|paging]], it supports parallel search and allows to implement a buffer that contains part of the [[Paging#Page table|page table]].

When trying to access some data, there are 2 possibilities:
- The data can be found in a register of the associative memory, then the frame number is directly obtained and can be used to calculate the physical address;
- The data cannot be found in the registers of the associative memory, then the frame number will be taken from the page table, with an access to the memory.

Since this kind of memory is a cache, reducing the possibility of a cache miss will have an enormous impact on the effective access time.