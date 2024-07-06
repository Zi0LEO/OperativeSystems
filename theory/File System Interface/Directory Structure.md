A directory is a collection of nodes keeping the information about every file.
Both directory structure and files are stored on disk.

Each partition has its own directory structure and files, independently by how the partition are realized.
Each partition uses directory to store information about the files it keeps.

## Operations
- Search a file;
- Create a file;
- Delete a file;
- List the directory's files;
- List the directory's file properties;
- Rename a file;
- Create a directory;
- Delete a directory;
- Navigate File System.

## Logical organization
Organization's objectives are:
- **Efficiency**, needed to rapidly access a file;
- **Identification**, so that users can have 2 files with the same name, or 2 names for the same file;
- **Grouping**, needed to categorize files accordingly to their properties.
Let's analyze some solutions:

### Single-level directory
A single directory contains every file:
![[Single-levelDirectory.png]]
This solution presents identification and grouping problems

### Two-level directory
Allows to have separate directories for each user:
![[Two-levelDirectory.png]]
This solution allows for efficient research and allows different users to give the same name to different files, but it still presents grouping problems.

### Tree Structure directory

![[TreeStructureDirectory.png]]
This solution meets all the specified requirements, it in facts allows for an efficient search, using path names, it allows for different files to have the same name, and permits the grouping of files by any criteria. However, it creates some new necessities.
