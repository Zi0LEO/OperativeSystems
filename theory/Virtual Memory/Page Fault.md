Each entry in the [[Paging#Page Table Structure Page table|page table]] contains a validity bit, this bit equals 1 if the selected page is associated with a frame of the central memory, 0 if the frame is contained only in mass memory.
Initially obviously every validity bit is set to 0.
During address mapping, when a logical address points to a page whose validity bit is 0, a **page fault** is generated.

## Procedure
Once a page fault is generated, the OS needs to handle the exception:
- 1. The OS checks an internal page-table of the process, if the reference is correct, then it's necessary to swap in the page.
- 2. An available frame is found in memory;
- 3. The page is loaded into the frame;
- 4. The validity bit of the page is set to 1 and the page-table is refreshed;
- 5. The execution is resumed.

## No available frame
What happens if no available frame is found in memory?
The OS will need to swap out the least used memory page. This can look easy, but the objective is to reduce the possibility of another page fault, because it is incredibly slow to swap in a frame. So the algorithm will need to keep this in count.

### Page replacement
When a page needs to be swapped in, but there are no available frames, page replacement can be used to swap out a victim page. The process is the following:
- 1. The requested page is found on disk;
- 2. Look for an available frame, if not found, as in our case, select a victim frame to be swapped out;
- 3. Write the selected frame on disk, if it has been modified (dirty bit), and swap in the needed page;
- 4. Read the requested page on the modified frame, and resume operations.
The choice of the victim frame is made by the [[Page Replacement Algorithms|page replacement algorithm]]
