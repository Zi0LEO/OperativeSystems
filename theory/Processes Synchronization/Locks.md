A Lock is a construct used to control the access to a shared variable. A Lock grants exclusive access to the process by whom is owned.
This mechanism is used implicitly in the Java's implementation of monitors.

Whenever a thread T calls a [[Monitors#Java Monitors|synchronized]] method, it acquires the lock of the object whose the method belongs to. No other thread will be able to acquire that lock until the thread T will release it.

A condition variable can be associated to a lock, the condition variable is useful because it allows a suspended thread to wake up whenever another thread notifies it that the condition it was waiting has verified.
