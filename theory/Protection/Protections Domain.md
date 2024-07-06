A protection domain D includes a set of resources whose a process can access.

Each process is included into a domain.

For every process are specified <object_name, access_rights>, where the resource, and access_rights is a subset of the operations that can be made on that resource.

In some OS every process has a **minimum privilege**, that means that said process can only access the resources it needs to complete its task.

The association between objects and domains can be made both statically and dynamically.

### Domains in Unix
For example, in unix there are 2 kinds of permissions: User and Supervisor.
Let's start with a domain user-id.
When an user accesses a file, the file system makes a change of domain, in facts, every file contains a **setuid bit** that specifies if the file can make system operations or not. If the setuid bit is 1, then the user-id is modified upon accessing the file, assigning it to the same value as the file owner, to be then reset when the file is closed. 
This allows programs to operate on the system when they are allowed to.