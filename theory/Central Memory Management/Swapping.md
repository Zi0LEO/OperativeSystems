A process may be temporarily brought back(swapped out) to [[Secondary Memory Management|mass memory]] and then be loaded back into central memory when it needs to execute(swapped in).

In case this swapping occurs because of the scheduler, who swaps out a lower priority process and swaps in a higher priority one, the operations take the name of **roll in** and **roll out**. 

Most of the swapping time is taken by the transfer's operation, so the needed time is directly proportional to the swapped data's dimension.