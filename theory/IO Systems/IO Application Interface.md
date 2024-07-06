I/O System calls offer an uniform interface to interact with different devices.
Thanks to device-drivers, in facts, it is possible to interact with each device at the same way, hiding the differences between them.
Devices can vary in many aspects:
- [[#Characters or blocks]];
- Sequential or direct access;
- Shared or dedicated;
- With different speeds;
- For reading, writing or both.

## Characters or blocks
Blocks devices are for example disks:
- They offer operations of reading and writing,
- Can access to ile system,
- Can access each mapped file in memory.

Characters devices are for example keyboards or serial ports:
- Offer both get and put methods,
- Can offer more structured operations.

