The space of [[Address Concepts#Logical and physical addresses|logical addresses]] can be non-contiguous, so the memory to allocate is used wherever it is found.
There are two schemes of memory management when talking about non-contiguous allocation:
- [[Segmentation]];
- [[Paging]];

### Segmentation with paging
MULTICS OS solved many of its problems related to the cons of these methods by putting them together.
This mixed scheme is implemented by creating each segment as a collection of pages. Each entry of the segment table will contain the base address of the pages of that segment.

