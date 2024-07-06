Since there is a huge variety of I/O hardware, it's obvious that there will be a lot of ways to manage these.
Some common concepts we will see a lot are:
- Ports
- Bus
- Controller
Moreover, The I/O devices can be used in two ways:
- Via /O Instructions and registers;
- Mapping the I/O device in memory.
## Polling
The interaction between CPU and a controller happens in a [[producer-consumer_problem|producer-consumer]] model. The device state is in facts checked via 3 bits:
- command-ready;
- busy;
- error.
Cyclically the CPU puts itself in a busy-waiting, keeping to check if the busy bit goes to 0.

## Interrupt
Another way for the controller and the CPU to interact is by the interrupt. 
The CPU in facts keeps an available request line to receive interrupt signals from the I/O devices. When this interrupt is received, the CPU invokes the needed interruption handling routine, and this routine will decide what to do next.
Sometimes the interrupts can be masked, to avoid the CPU to break a particular job.
The interrupt vector is needed to invoke the correct interrupt handler for every received interrupt.

### Direct Memory Access(DMA)
The DMA is a processor whose job is to handle the needed controls during data transfer, it's particularly useful as it frees the CPU of these low-impact controls, allowing it to work on more important jobs. The interaction between the DMA controller and a device controller is called handshaking, and when it happens it means that the controls have succeeded, and the transfer can proceed.