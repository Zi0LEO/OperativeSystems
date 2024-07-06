To memorize the available blocks in memory we usa a bit vector, that contains n elements, as many as the blocks in memory, in this vector, that we will call bitmap, we have:
bitmap[i] == 1 => block[i] == available;
bitmap[i] == 0 => block[i] == busy.

With big dimensions, that contain a lot of blocks, the bitmap may not be contained entirely in RAM, so we need to refactor it into a linked list of available blocks.

It's even possible to regroup the blocks to get better performance, we do this by storing the address of n available blocks in the first available block, and at the last element we store a pointer to the next block that contains available blocks.