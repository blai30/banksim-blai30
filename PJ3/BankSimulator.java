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
        System.out.println("Enter simulation time (positive integer)\t:");
        this.simulationTime = input.nextInt();
        System.out.println("Enter the number of tellers\t:");
        this.numTellers = input.nextInt();
        System.out.println("Enter chances (0% < & <= 100%) of new customer\t:");
        this.chancesOfArrival = input.nextInt();
        System.out.println("Enter maximum transaction time of customers\t:");
        this.maxTransactionTime = input.nextInt();
        System.out.println("Enter customer queue limit\t:");
        this.customerQLimit = input.nextInt();
        System.out.println("Enter 0/1 to get data from Random/file\t:");
        this.dataSource = input.nextInt();
        if(this.dataSource == 1) {
            System.out.println("Enter filename\t:");
            
        }
    }

    // Refer to step 1 in doSimulation()
    private void getCustomerData() {
        // get next customer data : from file or random number generator
        // set anyNewArrival and transactionTime
        // see Readme file for more info
        // add statements
    }

    private void doSimulation() {
        // add statements

        // Initialize ServiceArea
        // Time driver simulation loop
        for (int currentTime = 0; currentTime < simulationTime; currentTime++) {

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
    }

    // *** main method to run simulation ****
    public static void main(String[] args) {
        BankSimulator runBankSimulator = new BankSimulator();
        runBankSimulator.setupParameters();
        runBankSimulator.doSimulation();
        runBankSimulator.printStatistics();
    }

}
