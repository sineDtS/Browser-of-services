## RMI Browser

The universal service browser that we can observe is like a *specialized web browser*, except instead of HTML pages, the service browser downloads and displays interactive Java GUIs that we're calling universal services and can create anything as far as our imagination is capable of. 
And then running application and having fun.

<img src="https://image.ibb.co/mbcRJ9/Main.png" alt="Main" border="10">

### What is RMI

Remote Method Invocation (RMI) is an API which allows an object to invoke a method on an object that exists in another address space, which could be on the same machine or on a remote machine. Through RMI, object running in a JVM present on a computer (Client side) can invoke methods on an object present in another JVM (Server side). RMI creates a public remote server object that enables client and server side communications through simple method calls on the server object.

The communication between client and server is handled by using two intermediate objects: Stub object (on client side) and Skeleton object (on server side).


