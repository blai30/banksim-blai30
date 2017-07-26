package PJ3;

import java.util.*;
import java.io.*;

// You may add new functions or data in this class 
// You may modify any functions or data members here
// You must use Customer, Teller and ServiceArea classes
// to implement Bank simulator
class BankSimulator {

    // input parameters
    private int numTellers, customerQLimit;
    private int simulationTime, dataSource;
    private int chancesOfArrival, maxTransactionTime;

    // statistical data
    private int numGoaway, numServed, totalWaitingTime;

    // internal data
    private int customerIDCounter;   // customer ID counter
    private ServiceArea servicearea; // service area object
    private Scanner dataFile;	   // get customer data from file
    private Random dataRandom;	   // get customer data using random function

    // most recent customer arrival info, see getCustomerData()
    private boolean anyNewArrival;
    private int transactionTime;

    // initialize data fields
    private BankSimulator() {
        // add statements
        this.numTellers = 0;
        this.customerQLimit = 0;
        this.simulationTime = 0;
        this.dataSource = 0;
        this.chancesOfArrival = 0;
        this.maxTransactionTime = 0;
        this.numGoaway = 0;
        this.numServed = 0;
        this.totalWaitingTime = 0;
        this.customerIDCounter = 0;
    }

    private void setupParameters() {
        // read input parameters
        // setup dataFile or dataRandom
        // add statements
        Scanner input = new Scanner(System.in);
        System.out.println("\n\t***  Get Simulation Parameters  ***\n\n");
        
        // Simulation time
        do {
            System.out.print("Enter simulation time (positive integer)\t: ");
            if (input.hasNextInt()) {
                this.simulationTime = input.nextInt();
            } else {
                input.next();
            }
        } while (this.simulationTime > 10000 || this.simulationTime <= 0);
        
        // Number of tellers
        do {
            System.out.print("Enter the number of tellers\t\t\t: ");
            if (input.hasNextInt()) {
                this.numTellers = input.nextInt();
            } else {
                input.next();
            }
        } while (this.numTellers > 10 || this.numTellers <= 0);
        
        // Chances of new customer
        do {
            System.out.print("Enter chances (0% < & <= 100%) of new customer\t: ");
            if (input.hasNextInt()) {
                this.chancesOfArrival = input.nextInt();
            } else {
                input.next();
            }
        } while (this.chancesOfArrival > 100 || this.chancesOfArrival <= 0);
        
        // Maximum transaction time of customer
        do {
            System.out.print("Enter maximum transaction time of customers\t: ");
            if (input.hasNextInt()) {
                this.maxTransactionTime = input.nextInt();
            } else {
                input.next();
            }
        } while (this.maxTransactionTime > 500 || this.maxTransactionTime <= 0);
        
        // Customer queue limit
        do {
            System.out.print("Enter customer queue limit\t\t\t: ");
            if (input.hasNextInt()) {
                this.customerQLimit = input.nextInt();
            } else {
                input.next();
            }
        } while (this.customerQLimit > 50 || this.customerQLimit <= 0);
        
        // Data from Random or file
        do {
            System.out.print("Enter 0/1 to get data from Random/file\t\t: ");
            if (input.hasNextInt()) {
                this.dataSource = input.nextInt();
            } else {
                input.next();
            }
        } while (this.dataSource != 0 && this.dataSource != 1);
        
        // Set up data source for Random or file
        if (this.dataSource == 1) {
            System.out.print("Enter filename\t\t\t\t\t: ");
            try {
                dataFile = new Scanner(new File(input.next()));
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Using Random data.");
            }
        }
        input.close();
        this.dataRandom = new Random();
    }

    // Refer to step 1 in doSimulation()
    private void getCustomerData() {
        // get next customer data : from file or random number generator
        // set anyNewArrival and transactionTime
        // see Readme file for more info
        // add statements
        if (this.dataSource == 0) {
            // Using Random
            this.anyNewArrival = (this.dataRandom.nextInt(100) + 1) <= this.chancesOfArrival;
            this.transactionTime = this.dataRandom.nextInt(maxTransactionTime) + 1;
        } else if (this.dataSource == 1) {
            // Using file
            this.anyNewArrival = ((this.dataFile.nextInt() % 100) + 1) <= this.chancesOfArrival;
            this.transactionTime = (this.dataFile.nextInt() % maxTransactionTime) + 1;
        }
    }
    
    private void doSimulation() {
        // add statements
        System.out.println("\n\n\t***  Start Simulation  ***\n\n");
        // Initialize ServiceArea
        this.servicearea = new ServiceArea(this.numTellers, this.customerQLimit);
        
        // Print tellers that are ready beginning simulation
        System.out.print("Teller #1");
        if (this.numTellers > 1) {
            System.out.print(" to #" + this.numTellers + " are");
        } else {
            System.out.print(" is");
        }
        System.out.println(" ready...\n\n");
        
        // Time driver simulation loop
        for (int currentTime = 0; currentTime < simulationTime; currentTime++) {
            System.out.println("---------------------------------------------");
            System.out.println("Time : " + currentTime);
            // Step 1: any new customer enters the bank?
            getCustomerData();
            
            if (anyNewArrival) {
                // Step 1.1: setup customer data
                
                // Step 1.2: check customer waiting queue too long?
                //           if it is too long, update numGoaway
                //           else enter customer queue
            } else {
                System.out.println("\tNo new customer!");
            }

            // Step 2: free busy tellers that are done at currentTime, add to free cashierQ
            // Step 3: get free tellers to serve waiting customers at currentTime
        } // end simulation loop

        // clean-up - close scanner
    }

    private void printStatistics() {
        // add statements into this method!
        // print out simulation results
        // see the given example in project statement
        // you need to display all free and busy gas pumps

        // need to free up all customers in queue to get extra waiting time.
        // need to free up all tellers in free/busy queues to get extra free & busy time.
        System.out.println("\n\n============================================\n\n");
        System.out.println("End of simulation report\n");
        System.out.println("\t# total arrival customers  : " + this.customerIDCounter);
        System.out.println("\t# customers gone-away      : " + this.numGoaway);
        System.out.println("\t# customers served         : " + this.numServed);
        
        System.out.println("\n\t*** Current Tellers Info. ***\n\n");
        this.servicearea.printStatistics();
        
        System.out.println("\n\tTotal waiting time\t: " + this.totalWaitingTime);
        System.out.printf("\tAverage waiting time\t: %.2f\n",
                (double) this.totalWaitingTime / servicearea.numWaitingCustomers());
        
        System.out.println("\n\nBusy Tellers Info. :\n\n");
        while (!servicearea.emptyBusyTellerQ()) {
            Teller teller = servicearea.removeBusyTellerQ();
        }
        System.out.println("\n\nFree Tellers Info. :\n\n");
    }

    // *** main method to run simulation ****
    public static void main(String[] args) {
        BankSimulator runBankSimulator = new BankSimulator();
        runBankSimulator.setupParameters();
        runBankSimulator.doSimulation();
        runBankSimulator.printStatistics();
    }

}
