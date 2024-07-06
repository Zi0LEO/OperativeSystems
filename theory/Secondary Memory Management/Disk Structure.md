There are various ways to store data in a disk, and even though at the moment the most used are SSDs, many kind of disks have been necessary to come to this, and many of them are still used as a cheaper alternative to SSD. Let's analyze them:

## Magnetic Disks
Magnetic disks are still very commonly used in modern PCs as a mass storage, they are composed of a drive and a head reading from it.
The drive rotates 60-200 times per second, and they are valued by many parameters, such as:
- **Transfer rate**, the max amount of data that they can transfer to the pc per second;
- **Access time**, the time that passes from when the cpu makes a request to the disk to when the data are given to cpu.
Disks are connected via the I/O Bus, and support many kinds of bus, such as ATA, SATA, EIDE, USB and so on.

## Tape Drives
One of the first secondary memory devices, circa $10^3$ times slower than a magnetic disk, it is rarely used, but when it happens, it is just for huge quantities of data rarely needed, for example backups or data transfer between systems.

## Optical Disks
Optical disks were initially thought for recording tv programs, but then ended up to become memory devices for computers. Their functioning is based of the reflection (or not) of a laser pointed at them, with the reflection meaning 1, the missed reflection meaning 0.

# Logical Structure
Disks are handled as mono-dimensional arrays of logical blocks. This array is sequentially made in the disk sectors.
Sector 0 will be the first track of the outer-most cylinder, the number of sectors will grow proceeding with the tracks of the cylinder, to end with the inner.most cylinder, that obviously will contain way less tracks than the outer-most.