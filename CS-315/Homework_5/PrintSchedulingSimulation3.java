import java.util.Random;

import java.util.Scanner;

/**
 *
 * @author Cameron Stark
 */
public class PrintSchedulingSimulation3 {
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

    public static void runSimulation(Random rand, int minTimeRequired, int maxTimeRequired, int numIterations, double probOfArrival) {

        int[] priorityJobCounters = new int[3];

        MinHeap<PrintJob> printer1Queue = new MinHeap(10);
        MinHeap<PrintJob> printer2Queue = new MinHeap(10);
        init(priorityJobCounters);
        int timeLeftOnPrinter1 = 0;
        int timeLeftOnPrinter2 = 0;

        int numberServicedPrinter1 = 0;
        int numberServicedPrinter2 = 0;
        int totalServiced = 0;

        int printer1WaitTime = 0;
        int printer2WaitTime = 0;
        int totalWaitTime = 0;

        for (int numTimes = 0; numTimes < numIterations; numTimes++) {
            if (rand.nextDouble() < probOfArrival) {
                int jobPriority = getJobPriority(rand.nextDouble());
                priorityJobCounters[jobPriority - 1]++;
                int printTime = rand.nextInt(maxTimeRequired) + minTimeRequired;

                PrintJob job = new PrintJob(jobPriority, printTime);

                if (timeLeftOnPrinter1 != 0) {
                    printer2Queue.add(job);
                } else if (timeLeftOnPrinter2 != 0) {
                    printer1Queue.add(job);
                } else {
                    printer1Queue.add(job);
                }

                System.out.println("Job " + job.getJobNumber() 
                + " with priority " + jobPriority + " and print time "
                + printTime 
                + " added to queue.");
            }

            if (timeLeftOnPrinter1 != 0) {
                timeLeftOnPrinter1--;

                if (!printer1Queue.isEmpty()) {
                    printer1WaitTime++;
                }
            } else if (timeLeftOnPrinter2 != 0) {
                timeLeftOnPrinter2--;

                if (!printer2Queue.isEmpty()) {
                    printer2WaitTime++;
                }
            } else {
                if (!printer1Queue.isEmpty()) {

                    PrintJob job = printer1Queue.remove();

                    System.out.println("Job " + job.getJobNumber() 
                        + " with priority " + job.getPriority() + " and print time "
                        + job.getTimeRequired()
                        + " sent to printer 1.");
                    timeLeftOnPrinter1 = job.getTimeRequired(); 
                    numberServicedPrinter1++;  

                } else if (!printer2Queue.isEmpty()) {
                    PrintJob job = printer2Queue.remove();

                    System.out.println("Job " + job.getJobNumber() 
                        + " with priority " + job.getPriority() + " and print time "
                        + job.getTimeRequired()
                        + " sent to printer 2.");

                    timeLeftOnPrinter2 =  job.getTimeRequired();
                    numberServicedPrinter2++;
                }
            }

        }
        totalServiced = numberServicedPrinter1 + numberServicedPrinter2;
        totalWaitTime = printer1WaitTime + printer2WaitTime;
        int totalSize = printer1Queue.size() + printer2Queue.size();
        printStats(priorityJobCounters, totalServiced, totalWaitTime, totalSize);  
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
