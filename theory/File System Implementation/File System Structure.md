The file system is located in [[Secondary Memory Management|secondary memory]], and it is organized with a blocks structure, with different levels, from the highest to the lowest level we can find:
- **Applications**, scripts and commands;
- **Logical file system**, where the whole file system is seen as a single structure, here the security checks take place;
- **File organization module**, checks the physical blocks allocation and their mapping to logical ones, is responsible for the translation of addresses;
- **Basic File System**, interacts with drivers to access the physical blocks of a storage device;
- **I/O control**, devices drivers
- **Devices**, the physical devices, like disks, SSD etc...

### File Control Block
Each file is mapped to a FCB, this contains the relevant data of said file, like permissions, pointers to it, dimensions, owner etc..
In Unix system this is called inode (index node).

### Virtual File Systems
Some OS, like Unix, implement a virtual file system, this allows to manage different types of memories, for example both local and remote, with the same API, with an object oriented logic.