package com.ow.tracer.common.base;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * @auther: Easy
 * @date: 18-12-26 01:49
 * @description:
 */


public interface BaseJob extends Job{
    public void execute(JobExecutionContext context) throws JobExecutionException;
}
