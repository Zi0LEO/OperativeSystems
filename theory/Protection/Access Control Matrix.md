The model of protection, implemented via [[Protections Domain|domains]] can be viewed as a matrix, on the rows, we can find each domain, and on the columns we can find the resources.

The generic element (i, j) will be the kind of permissions that processes belonging to domain i have on the resource j.

Each object O, on creation, will be given some permissions by its creator, and will be  added as a row of the access matrix.

**List of contents**
>[!multi-column]
>- [[#Domains as objects]]
>- [[#Special operations]]
>- [[#Implementation]] 
>
>![[AccessMatrix.png]]

## Domains as objects
Some processes need the ability to switch from one domani to another to perform particular operations.
This can be easily implemented by adding the domains themselves as objects of the matrix:
![[ExtendedAccessMatrix.png]]
This new implementation allows us to define some special operations that domains can do on the matrix.

## Special operations
The special permissions we will analyze are:
 - [[#Owner]]
 - [[#Copy]]
 - [[#Control]]
 - [[#Switch]]

### Owner
>[!multi-column]
>A domain who has owner access to an object can add, remove and modify any permission
>that itself or other domains have on that object.
>
>![[OwnerPermission.png]]

### Copy
>[!multi-column]
>The copy permission is relative to a single operation than to an entire object. It is
>represented by \* after an operation, for example read\*.
>It means that a domain i can give permission to the specified operation on the object j to any other domain.
>
>![[CopyRights.png]]

### Control
It is a permission that a domain i can have on a domain j, it means that processes in domain j can modify the permissions of domain j on any object

### Switch
It is a permission that a domain i can have on domain j, it means that a process in domain i can move itself to domain j, but not viceversa, unless specified.

## Implementation
The Access Control Matrix is not implemented as an actual matrix, since many of its elements would be empty, it would be a waste of memory. There are three possible implementations that are better in terms of memory:
- [[#Objects Access List]]
- [[#Domain Permission List]]
- [[#Lock-Key Mechanism]]

### Objects Access List
Each column is a list that defines the domains that the associated object can use, for example:
For F2: "D1 = read; D4 = read,execute;"

### Domain Permission List
The dual of the object access list, each row is a list that defines the objects and the operations that the associated domain can do, for example:
For D3: "F3 = read, write; F5 = execute".

### Lock-Key Mechanism
It puts together the two mechanisms seen so far:
- Each object has a list of bit, called lock;
- Each domain has a list, called key.
A process executing in a domain can access an object only if its domain key can open the needed object's lock. 
All of this implementation is managed by the OS.