Thrashing is a problem that generates when too many processes are present in central memory.
To keep the CPU constantly busy, it's very important to keep more processes in central memory, so that when a process is blocked for any reason, another will be ready to be executed, this is implemented with [[Paging]], because of this technique, the whole process is present in virtual memory, but not in the physical one.
When too many processes are present in memory, the occurrence of [[Page Fault|page faults]] is huge, and every page fault has to be handles by the OS, but as we know, page fault handling requires access in mass memory, that is really slow.

>[!multi-column]
>During the page fault handling, cpu idles, waiting for the replacement of the needed pages, but since we can imagine that in physical memory only 1 page per process is actually present, virtually each context switch will need one or more page faults handling, producing a thrashing situation.
>
>![[Pasted image 20240613084202.png]]

