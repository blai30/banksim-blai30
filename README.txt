CSc 220        Assignment 3. Due: TBD
==============================================================================

1. Introduction 

We want to write a program to simulate a bank with multiple tellers. The goal 
of this simulation is to collect statistical information of the bank’s 
customers and tellers. A bank service area consists of several tellers and a 
customer waiting line (or queue). In each time unit, at most one new customer 
arrives at the waiting line. If the customer waiting line is too long, the 
customer leaves without completing transaction; otherwise, the customer gets 
into the waiting line. If all tellers are busy, customers in the waiting lines 
must wait to for a teller. If a teller is free and customers are waiting, the 
first customer in the waiting line advances to the teller’s counter and begins 
transaction.  When a customer is done, the customer departs and the teller 
becomes free. We will run the simulation through many units of time. At the 
end of each time unit, your program should print out a "snap-shot" of queues, 
customers and tellers. At the end of the program, your program should print 
out statistics and conclude simulation.


2. Assumptions and Requirements

2.1. Assumptions

- At most one customer arrives per time unit
- All numbers are positive integer numbers (>=0), except average values 
  should be displayed to two decimal places
- No time lost in between events:
  a customer arriving and entering waiting line
  a customer arriving and leaving without banking
  a customer completing transaction and departing
  a customer leaving the waiting line, advancing to a teller and 
             beginning transaction 

2.2. The limits of simulations parameters

- Maximum number of tellers     10
- Maximum simulation length     10000
- Maximum transaction time      500
- Maximum customer queue limit  50
- Probability of a new customer 1% - 100%


2.3. Input parameters and customer (random/file) data 

- The following data are read at the beginning of the simulation:

  int numTellers;         // number of Tellers.
  int simulationTime;     // time to run simulation
  int customerQLimit;     // customer queue limit
  int chancesOfArrival;   // probability of a new Customer ( 1 - 100)
  int maxTransactionTime; // maximum transaction time per customer
  int dataSource;         // data source: from file or random


- Sample input layout :

  $ java PJ3.BankSimulator

        ***  Get Simulation Parameters  ***


  Enter simulation time (positive integer)       : 10  
  Enter the number of tellers                    : 3
  Enter chances (0% < & <= 100%) of new customer : 75
  Enter maximum transaction time of customers    : 5
  Enter customer queue limit                     : 2
  Enter 0/1 to get data from Random/file         : 1         <- see datails below
  Enter filename                                 : DataFile  <- for input 1 above



- In each time unit of simulation, your program will need two positive integers 
  numbers to compute boolean anyNewArrival & int transactionTime. A user should
  have two options to specify the source of those numbers (input 1 or 0):

  For user input 1, numbers are read from a file. A filename should be provided 
  at the beginning of simulation. Each line in a datafile should contain two 
  positive numbers (> 0). A datafile should contain sufficient data for
  simulationTime. In each time unit, anyNewArrival & transactionTime are 
  computed in getCustomerData() as follows :

         read data1 and data2 from the file;
         anyNewArrival = (((data1%100)+1)<= chancesOfArrival);
         transactionTime = (data2%maxTransactionTime)+1;
 

  For user input 0, numbers are generated by method nextInt() in a Random 
  object, dataRandom, which should be constructed at the beginning of 
  simulation. In each time unit, anyNewArrival & transactionTime are computed
  in getCustomerData() as follows :

        anyNewArrival = ((dataRandom.nextInt(100)+1) <= chancesOfArrival);
        transactionTime = dataRandom.nextInt(maxTransactionTime)+1;


2.4. Input/Output information 

- At the end of each time unit, you program should print out "snap-shot" of
  simulation. At the end of simulation, you program need to print out end
  of simulation report

- Sample run is provided at the end of Readme file.


2.5 Data structures and simulation algorithm

- I have defined package PJ3 with the Customer, Teller and ServiceArea classes. 
  You need to implement their methods. I also provide an outline of a 
  simulation program BankSimulator.java. 


3. Compile and run program

- You need to download PJ3 zip file (with sample datafie) from ilearn.

- Compile programs (you are in directory containing Readme file):

  javac PJ3/*.java

- Run programs (you are in directory containing Readme file):

  // Run simulation
  java PJ3.BankSimulator

4. Due Date 

- 11:55 of Wednesday 4/26/2017
- To submit your project, you need to zip all source files (*.java) and
  upload it to ilearn.


=====================================================================================
SAMPLE RUN
=====================================================================================

=> Java PJ3.Customer
Customer Info:customerID=1:transactionTime=5:arrivalTime=18:finishTime=28

=> java PJ3.Teller
tellerID=5:startFreeTime=0:endFreeTime=0:startBusyTime=0:endBusyTime=0:totalFreeTime=0:totalBusyTime=0:totalCustomer=0>>customer:null

tellerID=5:startFreeTime=0:endFreeTime=20:startBusyTime=20:endBusyTime=25:totalFreeTime=20:totalBusyTime=0:totalCustomer=1>>customer:customerID=1:transactionTime=5:arrivalTime=15:finishTime=25

tellerID=5:startFreeTime=25:endFreeTime=20:startBusyTime=20:endBusyTime=25:totalFreeTime=20:totalBusyTime=5:totalCustomer=1>>customer:customerID=1:transactionTime=5:arrivalTime=15:finishTime=25



                Teller ID                : 5
                Total free time          : 20
                Total busy time          : 5
                Total # of customers     : 1
                Average transaction time : 5.00

=> java PJ3.ServiceArea
[customerID=1:transactionTime=18:arrivalTime=10:finishTime=0, customerID=2:transactionTime=33:arrivalTime=11:finishTime=0, customerID=3:transactionTime=21:arrivalTime=12:finishTime=0, customerID=4:transactionTime=37:arrivalTime=13:finishTime=0]
===============================================
Remove customer:customerID=1:transactionTime=18:arrivalTime=10:finishTime=0
Remove customer:customerID=2:transactionTime=33:arrivalTime=11:finishTime=0
Remove customer:customerID=3:transactionTime=21:arrivalTime=12:finishTime=0
Remove customer:customerID=4:transactionTime=37:arrivalTime=13:finishTime=0
===============================================
freeTellerQ:[tellerID=1:startFreeTime=0:endFreeTime=0:startBusyTime=0:endBusyTime=0:totalFreeTime=0:totalBusyTime=0:totalCustomer=0>>customer:null, tellerID=2:startFreeTime=0:endFreeTime=0:startBusyTime=0:endBusyTime=0:totalFreeTime=0:totalBusyTime=0:totalCustomer=0>>customer:null, tellerID=3:startFreeTime=0:endFreeTime=0:startBusyTime=0:endBusyTime=0:totalFreeTime=0:totalBusyTime=0:totalCustomer=0>>customer:null, tellerID=4:startFreeTime=0:endFreeTime=0:startBusyTime=0:endBusyTime=0:totalFreeTime=0:totalBusyTime=0:totalCustomer=0>>customer:null]
===============================================
Remove free teller:tellerID=1:startFreeTime=0:endFreeTime=0:startBusyTime=0:endBusyTime=0:totalFreeTime=0:totalBusyTime=0:totalCustomer=0>>customer:null
Remove free teller:tellerID=2:startFreeTime=0:endFreeTime=0:startBusyTime=0:endBusyTime=0:totalFreeTime=0:totalBusyTime=0:totalCustomer=0>>customer:null
Remove free teller:tellerID=3:startFreeTime=0:endFreeTime=0:startBusyTime=0:endBusyTime=0:totalFreeTime=0:totalBusyTime=0:totalCustomer=0>>customer:null
Remove free teller:tellerID=4:startFreeTime=0:endFreeTime=0:startBusyTime=0:endBusyTime=0:totalFreeTime=0:totalBusyTime=0:totalCustomer=0>>customer:null
===============================================
freeTellerQ:[]
busyTellerQ:[]
===============================================
Assign customers to free tellers
===============================================
Insert tellers to busyTellerQ
busyTellerQ:[tellerID=1:startFreeTime=0:endFreeTime=13:startBusyTime=13:endBusyTime=31:totalFreeTime=13:totalBusyTime=0:totalCustomer=1>>customer:customerID=1:transactionTime=18:arrivalTime=10:finishTime=31, tellerID=2:startFreeTime=0:endFreeTime=13:startBusyTime=13:endBusyTime=46:totalFreeTime=13:totalBusyTime=0:totalCustomer=1>>customer:customerID=2:transactionTime=33:arrivalTime=11:finishTime=46, tellerID=3:startFreeTime=0:endFreeTime=13:startBusyTime=13:endBusyTime=34:totalFreeTime=13:totalBusyTime=0:totalCustomer=1>>customer:customerID=3:transactionTime=21:arrivalTime=12:finishTime=34, tellerID=4:startFreeTime=0:endFreeTime=13:startBusyTime=13:endBusyTime=50:totalFreeTime=13:totalBusyTime=0:totalCustomer=1>>customer:customerID=4:transactionTime=37:arrivalTime=13:finishTime=50]
===============================================
Remove busy teller:tellerID=1:startFreeTime=31:endFreeTime=13:startBusyTime=13:endBusyTime=31:totalFreeTime=13:totalBusyTime=18:totalCustomer=1>>customer:customerID=1:transactionTime=18:arrivalTime=10:finishTime=31
Remove busy teller:tellerID=3:startFreeTime=34:endFreeTime=13:startBusyTime=13:endBusyTime=34:totalFreeTime=13:totalBusyTime=21:totalCustomer=1>>customer:customerID=3:transactionTime=21:arrivalTime=12:finishTime=34
Remove busy teller:tellerID=2:startFreeTime=46:endFreeTime=13:startBusyTime=13:endBusyTime=46:totalFreeTime=13:totalBusyTime=33:totalCustomer=1>>customer:customerID=2:transactionTime=33:arrivalTime=11:finishTime=46
Remove busy teller:tellerID=4:startFreeTime=50:endFreeTime=13:startBusyTime=13:endBusyTime=50:totalFreeTime=13:totalBusyTime=37:totalCustomer=1>>customer:customerID=4:transactionTime=37:arrivalTime=13:finishTime=50

=> java PJ3.BankSimulator


        ***  Get Simulation Parameters  ***


Enter simulation time (positive integer)       : 10
Enter the number of tellers                    : 3
Enter chances (0% < & <= 100%) of new customer : 75
Enter maximum transaction time of customers    : 5
Enter customer queue limit                     : 2
Enter 0/1 to get data from Random/file         : 1
Enter filename                                 : DataFile


        ***  Start Simulation  ***


Teller #1 to #3 are ready...


---------------------------------------------
Time : 0
        customer #1 arrives with transaction time 5 units
        customer #1 wait in the customer queue
        customer #1 gets a teller
        teller #1 starts serving customer #1 for 5 units
---------------------------------------------
Time : 1
        customer #2 arrives with transaction time 2 units
        customer #2 wait in the customer queue
        customer #2 gets a teller
        teller #2 starts serving customer #2 for 2 units
---------------------------------------------
Time : 2
        customer #3 arrives with transaction time 5 units
        customer #3 wait in the customer queue
        customer #3 gets a teller
        teller #3 starts serving customer #3 for 5 units
---------------------------------------------
Time : 3
        No new customer!
        customer #2 is done
        teller  #2 is free
---------------------------------------------
Time : 4
        customer #4 arrives with transaction time 3 units
        customer #4 wait in the customer queue
        customer #4 gets a teller
        teller #2 starts serving customer #4 for 3 units
---------------------------------------------
Time : 5
        No new customer!
        customer #1 is done
        teller  #1 is free
---------------------------------------------
Time : 6
        customer #5 arrives with transaction time 3 units
        customer #5 wait in the customer queue
        customer #5 gets a teller
        teller #1 starts serving customer #5 for 3 units
---------------------------------------------
Time : 7
        customer #6 arrives with transaction time 5 units
        customer #6 wait in the customer queue
        customer #4 is done
        teller  #2 is free
        customer #3 is done
        teller  #3 is free
        customer #6 gets a teller
        teller #2 starts serving customer #6 for 5 units
---------------------------------------------
Time : 8
        No new customer!
---------------------------------------------
Time : 9
        No new customer!
        customer #5 is done
        teller  #1 is free


============================================


End of simulation report

        # total arrival customers  : 6
        # customers gone-away      : 0
        # customers served         : 6

        *** Current Tellers Info. ***


        # waiting customers : 0
        # busy tellers      : 1
        # free tellers      : 2

        Total waiting time         : 0
        Average waiting time       : 0.00


        Busy Tellers Info. :


                Teller ID                : 2
                Total free time          : 2
                Total busy time          : 8
                Total # of customers     : 3
                Average transaction time : 2.67



        Free Tellers Info. :


                Teller ID                : 3
                Total free time          : 5
                Total busy time          : 5
                Total # of customers     : 1
                Average transaction time : 5.00


                Teller ID                : 1
                Total free time          : 2
                Total busy time          : 8
                Total # of customers     : 2
                Average transaction time : 4.00


