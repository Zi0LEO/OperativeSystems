The creator/owner of a file needs to be able to check which operations are available on the file, and who can make them. There are  in facts various types of access, but the most important are:
- Write;
- Read;
- Execute.

To handle these permissions, users are divided in three categories:
- Owner;
- Group;
- Public.
The owner access is usually the one with most, if not all, permissions, the group is a set of users that can be granted a specific set of permissions, users can be added and removed from the group by a manager, usually the one with owner access, that can even handle the set of granted permissions. At last, the public access is the one granted to everyone else.

Each file contains permission for the 3 types of access, one bit per permission per access, for a total of 9 bits:
- 3 bits: read, write, execute, for owner access;
- 3 bits: read, write, execute, for group access;
- 3 bits: read, write, execute, for public access.
If the bit is 0, it means the permission is not granted, if the bit is 1, the permission is granted.
