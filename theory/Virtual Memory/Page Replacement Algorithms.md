The algorithm's objective is to minimize the occurrence of page fault, so this will be the criterion on which the algorithms will be evaluated.

Let's keep in mind the obvious the more frames we can utilize, the less page fault we will encounter.

Let's take as an example a sequence of access in memory: "1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5"


## Optimal Algorithm
This algorithm simply swaps out the page that will not be used for the longest time, for the sequence in our example, with a 4 frame memory, it will generate 6 page faults. 
The problem with this algorithm is that we cannot know which data will be needed next, so we cannot know which one will not be used for the longest time, so this algorithm is useful just as a comparison to other, applicable algorithms.

## First-In First-Out
Classic, easiest used algorithm to implement page replacement is the FIFO algorithm, where the first page that was swapped in memory will be the first one to be swapped out.

In this algorithm we encounter the **Belady's Anomaly**: 
With the same conditions, in facts, a memory with 3 frames will generate less page faults than a memory with 4 frames.

## Least Recently Used
It swaps out the page that has not been used for the longest time.
It can be implemented with a counter or with a stack:
#### Counter implementation
Each page entry has a counter, whenever the page is referenced, the value of the clock is copied into the counter, when a swap out is needed, the victim frame will be the one corresponding to the lowest clock value of the page table.
#### Stack implementation
A stack is kept where the most recently used page is put on top, by simply removing it from the stack and putting it back in whenever it is referenced, doing so, the least recently used page will always be on the bottom, so no research is needed, whenever a swap out is needed, the page removed will be the one at the bottom of the stack.

## Second Chance
Since the LRU algorithm needs hardware support, sometimes its implementation is not possible, so an alternative is the approssimated LRU, also called Second Chace algorithm.
Every page has a reference bit, initially set to 0, when the page is referenced, the bit is set to 1. When the algorithm will search for a page to swap out, it will check its reference bit, if it is set to to 0, the page will be swapped out, if it is set to 1, the page will be given a "second chance", by keeping it in memory but setting the reference bit to 0, and swapping out the next page, in a circular queue.
This algorithm does not know the order of usage of pages, so does not require any additional hardware.

## Counting algorithms
The least used are the counter algorithms, where each page keeps a counter of how many times it has been referenced, it can work by replacing the **least frequently used** pages or the **most frequently used** pages.
