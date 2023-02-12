# Define the terms (any five)
   a) Jdbc
   b) Socket
   c) Java Bean
   d) RMI
   e) HTTP
   f) Session
   g) Cookie
   h) URL
# a) JDBC
   In initial days of database technologies the various vendor has been developed various of database like oracle has been developed oracle & microsoft has developed msql-server also there are so much database are available in the market.
   If anybody (programmer) want to deal with database they must have knowledge about database which they are using. 
 
   Jdbc is kind of specification develop by the Sun Microsystems store the data permanently. There are two approaches to store the data permanently through the file & database but in file we can't provide enough security to unauthorized the users.
 
   In order to deal any database to represent the data permanently, we must have to use the driver. Driver is s software which is act like middleware between database & other programming application. A driver has specific for each database.
   They are four type of drivers.
        1) JDBC-ODBC bridge driver.
        2) Native & Partial java Driver
        3) Network Protocol Driver 
        4) Thin Driver 

# b) Socket
   A socket is an endpoint for communication between two machines. This class implements client sockets (also called just "sockets")The actual work of the socket is performed by an instance of the SocketImpl class. An application, by changing the socket factory that creates the socket implementation, can configure itself to create sockets appropriate to the local firewall.
   Socket and ServerSocket classes are used for connection-oriented socket programming and DatagramSocket and DatagramPacket classes are used for connection-less socket programming. 

# c) Java Bean
   JavaBeans is a technology developed by Sun Microsystems and released in 1996, as part of JDK 1.1.
   The 'beans' of JavaBeans are classes that encapsulate one or more objects into a single standardized object (the bean). This standardization allows the beans to be handled in a more generic fashion, allowing easier code reuse and introspection. This in turn allows the beans to be treated as software components, and to be manipulated visually by editors and IDEs without needing any initial configuration, or to know any internal implementation details.

   As part of the standardization, all beans must be serializable, have a zero-argument constructor, and allow access to properties using getter and setter methods.
   # Advantages
       1. The properties, events, and methods of a bean can be exposed to another application.
       2. A bean may register to receive events from other objects and can generate events that are sent to those other objects
       3. Auxiliary software can be provided to help configure a bean
       4. The configuration settings of a bean can be saved to persistent storage and restored.

  # Disadvantages
       1. A class with a zero-argument constructor is subject to being instantiated in an invalid state. 
           If such a class is instantiated manually by a developer (rather than automatically by some kind of framework), 
           the developer might not realize that the class has been improperly instantiated. 
           The compiler cannot detect such a problem, and even if it is documented, there is no guarantee that the developer will see the documentatio

       2. JavaBeans are inherently mutable and so lack the advantages offered by immutable objects

       3. Having to create getters for every property and setters for many, most, or all of them can lead to an immense quantity of boilerplate code
  



   



   