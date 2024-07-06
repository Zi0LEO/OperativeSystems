Segmentation is a scheme of memory management that corresponds to the view of memory that the use has, a program is in facts a collection of segments, where each segment can be:
- main program;
- routine;
- object;
- global/local variables;
- stack;
and so on.

### Segmentation architecture
A [[Address Concepts#Logical and physical addresses|logical address]] in the context of segmentation is composed of 2 values:
`<segment_number, offset>`, the first value, the segment number, relates to the segment-table.
##### Segment table
Each element of this table contains:
- Base, the address where the segment starts in memory;
- Limit, the length of each segment
##### Registers
To work, this architecture needs 2 specific registers:
- **Segment-table base register(STBR)**, that keeps track of the physical address where the segment-table is;
- **Segment-table length register(STLR)**, that keeps track of the number of segments in the table.

##### Execution
When the CPU generates a logical address, its first element `segment_number` is sent to the segment-table, located at the address pointed by STBR. Once the segment is found, its `limit` parameter is confronted with `offset`, the second element of the logical address. If acceptable, `offset` is then increased of `base` and so the physical address is obtained.

