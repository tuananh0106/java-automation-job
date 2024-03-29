package com.example.job_learn_1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Demo1 {
    public static void main(String[] args) throws SchedulerException {
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerName", "group1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("jobName", "group1").build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);

    }
}
