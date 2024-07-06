The access to files via file system can be done in 2 ways:
- Sequential access: 
	- read next
	- write next
	- reset
- Direct access: where n is the relative block number
	- read n
	- write n
	- position to n

The reset operation in sequential access allows to go back to the start of the file, whereas the position of n operation in direct access allows to go to the specified block n.
