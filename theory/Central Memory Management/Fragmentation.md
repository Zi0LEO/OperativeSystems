Fragmentation is a problem faced by systems based on [[Contiguous Allocation]] of central memory. It can be **external** or **internal**.

### External fragmentation
>[!multi-column]
>External fragmentation occurs when there is enough total space in memory to contain a routine, but that space is, as the title, fragmented, it means that it is divided in more smaller holes none of which is big enough to contain the routine.
>
>![[External_fragmentation.jpg]]

### Internal fragmentation
>[!multi-column]
>Internal fragmentation occurs when the allocated memory is bigger than the requested one, in this case, the allocated memory inside the partition is actually unused, increasing processes increases the amount of unused memory.
>
>![[Internal_fragmentation.png]]

### Solutions
A possible solution of external fragmentation is compaction.
>[!help]
>Compaction is a technique that consists in moving the allocated memory blocks as close as possible to one another.
>

This solution is only possible if relocation is [[Address Concepts#Address binding|dynamic at run time]].