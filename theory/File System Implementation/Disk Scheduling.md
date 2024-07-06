The OS is responsible for the disk management, access time and larger band width are the objectives.
The access time can be divided in:
- **Seeking time**, the time needed to the head to move to the desired cylinder;
- **Rotational time**, the time needed to the disk to position the needed track under the head.
As usual, many algorithms can be used to to schedule the access requests, let's take a string of sectors to access, and let's make examples for all the most interesting scheduling algorithms, the sector sequence will be:
98, 183, 37, 122, 14, 124, 65, 67. The head will begin at position 53.
## Scheduling FCFS
With this kind of scheduling, the order in which the sectors are visited is exactly the one in the sequence, the total movements will be (98 - 53) + (183 - 98) +(98 - 37) + ... + (67 - 65), for a total of 640 cylinders of movement.
## Scheduling SSTF
This scheduling selects the smallest possible seek time from the current position, it is a kind of SJF, and because of this it can produce starvation, even more for the most extreme cylinders. In our example the visited sequence would be: 53, 65, 67, 37, 14, 98, 122, 124, 183.
The total movement will be 236 cylinders.
## Scheduling SCAN
The head in this case will navigate to an extreme of the disk, serving all the requests it meets, and then navigate to the other, serving all the requests it meets on its way.
In out case the sequence will be: 53, 37, 14, 0, 65, 67, 98, 122, 124, 183, for a total movement of 236 cylinders.
## Scheduling C-SCAN
A variant of the SCAN algorithm that treats the disk as a circular array, it only goes forward, serving all the requests it meets, once it reaches the inner-most cylinder, it goes back to 0, without serving anyone, and starts again from there. In our case the sequence would be: 53, 65, 67, 98, 122, 124, 183, 199, 0, 14, 37, for a total movement of 183 cylinders, excluding the movement needed to bring the head from 199 to 0, that is not counted.
## Scheduling C-LOOK
Variant of C-SCAN that does not move until the end nor beginning of the disk, but just until the most extreme requests. In our case: 53, 65, 67, 98, 122, 124, 183, 14, 37, for a total movement of 153 cylinders. 