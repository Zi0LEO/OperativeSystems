Be V a collection of nodes and E a collection of edges:
- V is composed of 2 sub-collections:
	- A collection of processes P;
	- A collection of resources R.
- E is composed either of edges

 >[!multi-column]
>![[graph_allocation.jpg]]
>As we can see, there is no cycle in the above graph, this grants us that no deadlock will happen.
>
>![[graph_allocation_deadlock.jpg]]
>This graph contains a cycle {R2, P2, R3, P3}, and deadlock happens.
>
>![[graph_allocation_cycle.jpg]]
>This graph contains a cycle {R2, P1, R1, P3}, but no deadlock happens.

So, are cycles and deadlock related?
Yes, they are, the rules are the following:
- If the graph contains no cycles, no deadlock can happen;
- If the graph contains a cycle, and the resources in that cycle have more instances, deadlock may happen;
- If the graph contains a cycle, and the resources in that cycle have just one instance, deadlock will happen.

## Stages of resource allocation
The graph of resource allocation can be used when there is just one instance of each resource. In this case, we can define 4 states:
>[!multi-column]
>![[claim-edge.png]] 
>This edge, named **claim edge** means that process Pi may request in future an instance of the resource Rj.
>
>![[request-edge.png]]
>When the process actually asks for the resource, the edge becomes a **request edge**.
>
>![[assignation-edge.png]]
>The edge changes again when the resource is effectively acquired by the process, becoming an **assignation edge**

For this to work obviously, every process must claim all the resources it may need in future when it is started.

## How to prevent deadlock
Let's suppose process Pi requests a resource Rj, the request can be satisfied only if turning the request edge Pi - Rj into an assignation edge Rj - Pi won't create a cycle in the graph.
Let's see an example:

>[!multi-column]
>![[graph-allGood.jpg]]
>In this graph apparently everything is fine, there are no cycles, so there can be no deadlock, but what would happen if P2 asked to acquire R2?
>
>![[graph-ohNo.jpg]]
>Here, R2 has been acquired by P2, and as we see, the edge became an assignation edge, changing direction and forming a cycle, now there could be a deadlock, and the system is not in a [[Deadlock Management#Safe state|safe state]].

The system has to watch out for these kind of situations, where apparently safe states can bring to risk of deadlock.