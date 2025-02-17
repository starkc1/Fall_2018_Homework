import java.util.Random;

import java.util.Scanner;

/**
 *
 * @author Cameron Stark
 */
public class PrintSchedulingSimulation2 {
    public static void main(String[] args) {
        double avgNumUnitsPerJobArrival;
        int minTimeRequired;
        int maxTimeRequired;
        int numIterations = 1;

        Scanner scanner = new Scanner(System.in);
        while (numIterations != 0) {
            Random rand = new Random(System.currentTimeMillis());
            System.out.println("Enter the Average Number of Units Per Job Arrival");
            avgNumUnitsPerJobArrival = scanner.nextDouble();
            if (avgNumUnitsPerJobArrival < 0) {
                while (avgNumUnitsPerJobArrival < 0) {
                    System.out.println("The Average Number of Units Per Job Arrival must be greater then 0");
                    avgNumUnitsPerJobArrival = scanner.nextDouble();
                }
            }

            System.out.println("Enter the Min Time Required");
            minTimeRequired = scanner.nextInt();
            if (minTimeRequired < 0) {
                while (minTimeRequired < 0) {
                    System.out.println("The Min Time Required must be greater then 0");
                    minTimeRequired = scanner.nextInt();
                }
            }

            System.out.println("Enter the Max Time Required");
            maxTimeRequired = scanner.nextInt();
            if (maxTimeRequired < 0) {
                while (maxTimeRequired < 0) {
                    System.out.println("The Max Time Required must be greater than 0");
                    maxTimeRequired = scanner.nextInt();
                }
            }

            while (minTimeRequired > maxTimeRequired) {
                System.out.println("The Min Time Required must be less then The Max Time Required");
                minTimeRequired = scanner.nextInt();
            }

            while (maxTimeRequired < minTimeRequired) {
                System.out.println("The Max Time Required must be greater then The Min Time Required");
                maxTimeRequired = scanner.nextInt();
            }

            System.out.println("Enter the Number of Iterations");
            numIterations = scanner.nextInt();

            double probOfArrivalInOneUnit = (1.0 / avgNumUnitsPerJobArrival) * Math.exp(-1.0 / avgNumUnitsPerJobArrival);
            System.out.println("Probability of arrival in one unit of time: " + probOfArrivalInOneUnit);

            runSimulation(rand, minTimeRequired, maxTimeRequired, numIterations, probOfArrivalInOneUnit);
        }
        System.out.println("Program Ended");
        scanner.close();

        // double avgNumUnitsPerJobArrival = 3;
        // int minTimeRequired = 3;
        // int maxTimeRequired = 8;
        // int numIterations = 30;
    }// end main

    public static void runSimulation(Random rand, int minTimeRequired, int maxTimeRequired, int numIterations,
            double probOfArrival) {
        // keeps track of the number of jobs of the specified priority
        int[] priorityJobCounters = new int[3];
        MinHeap<PrintJob> printQ = new MinHeap(10);
        init(priorityJobCounters); // set all elements in the array to 0
        int timeLeftOnPrinter = 0; // this is basically the printer
        // this keeps track of the number of jobs that actually get to the printer
        int numberServiced = 0;
        // this keeps track of the total time spent on the printer by all jobs
        // that made it to the printer.
        int totalWaitTime = 0;
        for (int numTimes = 0; numTimes < numIterations; numTimes++) {
            if (rand.nextDouble() < probOfArrival) // check to see if a job should arrive
            {
                // Create the necessary info for that job.
                int jobPriority = getJobPriority(rand.nextDouble());
                priorityJobCounters[jobPriority - 1]++;
                int printTime = rand.nextInt(maxTimeRequired) + minTimeRequired;
                // Create the job with that info.
                PrintJob job = new PrintJob(jobPriority, printTime);
                // Immediately add the job to the queue.
                printQ.add(job);
                System.out.println("Job " + job.getJobNumber() + " with priority " + jobPriority + " and print time "
                        + printTime + " added to queue.");
            }
            // Check to see if printer is occupied
            if (timeLeftOnPrinter != 0) {
                // If it is, decrement the time left for the current job
                timeLeftOnPrinter--;
                // Check to see if anyone is waiting
                if (!printQ.isEmpty())
                    totalWaitTime++;
            } else // printer is free
            {
                // Check to see if any job is waiting so that it can be sent to the printer
                if (!printQ.isEmpty()) {
                    PrintJob job = printQ.remove();
                    System.out.println("Job " + job.getJobNumber() + " with priority " + job.getPriority()
                            + " and print time " + job.getTimeRequired() + " sent to printer.");
                    timeLeftOnPrinter = job.getTimeRequired(); // reset print clock
                    numberServiced++; // count the number of jobs sent to the printer
                }
            }
        }

        // display statistics about the simulation
        printStats(priorityJobCounters, numberServiced, totalWaitTime, printQ.size());
    }

    public static void init(int[] numPriorJobs) {
        // Initializes the integer array to all zeros.
        for (int i = 0; i < numPriorJobs.length; i++) {
            numPriorJobs[i] = 0;
        }
    }

    public static int getJobPriority(double r) {
        // Returns 1, 2, or 3 depending on their expected frequency.
        if (r < 0.15) // These jobs occur 15% of the time
            return 1;
        else if (r < 0.5) // These jobs occur 35% of the time
            return 2;
        else // These jobs occur 50% of the time
            return 3;
    }

    public static void printStats(int[] priorityJobCounters, int numServiced, int totWaitTime, int numJobsStillOnQ) {
        // Prints some stats about the simulation. The variables are self-documenting.
        int totalJobs = 0;
        for (int i = 0; i < priorityJobCounters.length; i++) {
            totalJobs += priorityJobCounters[i];
            System.out.println("Number of priority " + (i + 1) + " jobs: " + priorityJobCounters[i]);
        }

        System.out.println("Total jobs: " + totalJobs);
        System.out.println("Number of jobs serviced: " + numServiced);
        System.out.println("Number of jobs still on queue: " + numJobsStillOnQ);
        System.out.printf("Average wait time: %.1f\n", ((double) totWaitTime / numServiced));
    }
}// end class
