RAID Structures are a set of techniques based on a collection of disks where the OS operates concurrently. This set of disk is treated as a secondary memory, and allows for redundancy, that allows for a more stable and reliable memory storage.
 A RAID Structure can be organized in 7 different levels:
 - Level 0, each disk contains different data, max performance, minimum reliability, i a disk fails, all the storage becomes useless;
 - Level 1, each disk contains an exact copy of itself into another disk, this system is more reliable since in case of failure of a disk, data can still be retrieved from the other, but needs double the storage.
 - Level 2, every 2 disks there is a parity disk, in fact, every disk is separated at bit level, and the parity disk contains the result of the XOR between the bits of the other 2 disks, if one disk fails, data can be calculated by doing the XOR between the safe disk and the parity disk. This scheme allows for a reliable system with less costs than level 1.

There are other 4 levels, but I did not understand them.