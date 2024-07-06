I/O usage is one of the factors that influence performance the most. The reasons are obvious if we think about it:
- Large number of context switch to handle the interrupts;
- CPU time to execute drivers;
- Data transfer;
- Data traffic.

To get better performance, we can optimize the mentioned factors, for example we can:
- Reduce the data copying;
- Reduce the number of context switch;
- Use the [[IO Hardware#Direct Memory Access(DMA)|DMA]];
- Balance the load between CPU, Memory, bus and I/O system.