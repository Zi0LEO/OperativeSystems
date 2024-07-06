The kernel offers a collection of services to better manage I/O requests.

### Scheduling
Some I/O requests are scheduled via the devices queue, in some cases OS use fair politics.

### Buffering
Buffering is extremely important since it allows devices with different memory or speed to interact with each other. Let's take for example a keyboard and a disk, the difference of speed between them is huge, so much that a direct interaction between them would be really difficult without buffering.
