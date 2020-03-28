package com.geekforgeeks.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Job {
    String jobName;
    int deadline;
    int profit;

    Job(String jobName, int deadline, int profit) {
        this.jobName = jobName;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobName='" + jobName + '\'' +
                ", deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }
}


public class JobSelection {

    public static int jobSelection(List<Job> jobList) {
        int value = 0;
        String[] arr = new String[jobList.size()];

        Collections.sort(jobList, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit - o1.profit;
            }
        });


        for (Job job : jobList) {
            for (int i = (job.deadline - 1); i >= 0; i--) {
                if (arr[i] == null) {
                    arr[i] = new String(job.jobName);
                    value += job.profit;
                    break;
                }
            }
        }


        jobList.forEach(x -> System.out.println(x));

        return value;
    }


    public static void main(String args[]) {

        List<Job> jobList = new ArrayList<>();
        jobList.add(new Job("job0", 4, 50));
        jobList.add(new Job("job1", 1, 5));
        jobList.add(new Job("job2", 1, 20));
        jobList.add(new Job("job3", 5, 10));
        jobList.add(new Job("job4", 5, 80));

        System.out.println(jobSelection(jobList));
    }
}
