## RMI Browser

The universal service browser that we can observe is like a *specialized web browser*, except instead of HTML pages, the service browser downloads and displays interactive Java GUIs that we're calling universal services and can create anything as far as our imagination is capable of. 
And then running application and having fun.

<img src="https://image.ibb.co/mbcRJ9/Main.png" alt="Main" border="10">

### What is RMI

[Remote Method Invocation (RMI)](https://docs.oracle.com/javase/9/docs/api/java/rmi/package-summary.html) is an API which allows an object to invoke a method on an object that exists in another address space, which could be on the same machine or on a remote machine. Through RMI, object running in a JVM present on a computer (Client side) can invoke methods on an object present in another JVM (Server side). RMI creates a public remote server object that enables client and server side communications through simple method calls on the server object.

The communication between client and server is handled by using two intermediate objects: *Stub object* (on client side) and *Skeleton object* (on server side).

## Platform-specific notes

If you want develop Java applications, then you should [download](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html) and install the [Java Development Kit (JDK)](https://docs.oracle.com/javase/10/) for your platform. The JDK includes the JRE, so you do not have to download both separately. But if you want only run Java programs but not develop them, you may download and install the [Java Runtime Environment (JRE)](http://www.oracle.com/technetwork/java/javase/downloads/jre10-downloads-4417026.html) for your platform.

**JDK** and **JRE** can be installed on the following platforms:

* **Oracle Solaris** 

* **Microsoft Windows** 

* **Linux**

* **macOS** 

### Getting Started

Before you run, you must have the [Java Virtual Machine (JVM)](https://en.wikipedia.org/wiki/Java_virtual_machine) installed.

#### First we need to start the server (remote service), for what:

* Generate the stubs (client helper) and skeletons (server helper) using `rmic` - these are the client and server *"helpers"*. You don't have to create these classes or ever look at the source code that generates them. It's all handled automatically when you run the `rmic` tool (that ships with your JDK) in terminal.

**Note** that `rmic` should run with `.class` file, not with `.java`, but without `.class` extension like you’ll see below:                         
```cs
$ rmic com.company.ServiceServerImpl
Warning: generation and use of skeletons and static stubs for JRMP
is deprecated. Skeletons are unnecessary, and static stubs have
been superseded by dynamically generated stubs. Users are
encouraged to migrate away from using rmic to generate skeletons and static
stubs. See the documentation for java.rmi.server.UnicastRemoteObject.`
```    
In my case `com.company` is the name of the package.

* Start the RMI registry in terminal. The `rmiregistry` is like the white pages of a phone book. 
It's where the user goes to get the proxy (the client stub/helper object). 
The `rmiregistry` should work in the background.
```cs
$ rmiregistry

``` 

* Open next one terminal and start the remote service (ServiceServerImpl.java). 
The remote service should work in the background.

#### And now we'll start the client (ServiceBrowser.java) and having fun.

## How can I extend this application?

We have 3 services (mini-applications) in `InterfacesForRMIBrowser.java`, which are called *DiceService*, *MiniMusicService* and *DayOfTheWeekService* respectively.

Each one has its own class.

But we also have interface `Service`. This is the key to everything. This very simple interface has just one method, `getGuiPanel()`. 
Every service that gets shipped over to the client must implement this interface. This is what makes the whole thing **UNIVERSAL**.

I created these classes, and you may do the same and extend the application. Just implement the interface `Service` and this new service will be included in the application.

Good luck and happy coding!


