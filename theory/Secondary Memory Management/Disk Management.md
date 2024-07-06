To use the disk as a [[File Concept|file]] storage, the OS needs to implement its structures on it.
For this to happen it's important that the OS sees the disk through an interface that hides the real nature of the implementation of the disk.
The disk is so divided in different partitions and successively is logically formatted to create the [[File System Interface|file system]].
The bootstrap program, loaded in rom will be responsible for loading the OS in the selected partition.
