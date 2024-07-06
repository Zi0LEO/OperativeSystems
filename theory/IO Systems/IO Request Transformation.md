
While executing a user process, the CPU may be interrupted by an I/O request. In this case the needed system call routine will be invoked

>[!multi-column]
>If the request can already be satisfied the control will pass to the [[IO Kernel Subsystem]], that will transfer the needed data and generate the exit code in case of error or completion.
>
>![[IO_Requests.png]]
>
>In case the request cannot be satisfied, the process in execution will keep executing, and the request will be sent back to the device driver, this will process the request and command the respective controller to block until interrupted.
>The controller will then interrupt when the I/O operation is completed, and signal the driver. this will buffer the data if it's an input operation, and signal the [[IO Kernel Subsystem]] which I/O has completed.

Then the control will go back to the interrupted process, that will resume its execution. 