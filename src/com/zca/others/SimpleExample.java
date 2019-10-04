/* 
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */
 
package com.zca.others;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * This Example will demonstrate how to start and shutdown the Quartz scheduler and how to schedule a job to run in
 * Quartz.
 * 
 * @author Bill Kratzer
 */
public class SimpleExample {

  public void run() throws Exception {

    // 1.创建Scheduler的工厂
    SchedulerFactory sf = new StdSchedulerFactory();
    // 2.从工厂中获取调度器
    Scheduler sched = sf.getScheduler();
    // 时间
    Date runTime = evenSecondDateAfterNow();
    // 3.创建JobDatail
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
    // 4.触发器
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
    // 5.注册任务
    sched.scheduleJob(job, trigger);
    // 启动
    sched.start();
    // wait long enough so that the scheduler as an opportunity to
    // run the job!
    try {
      // wait 65 seconds to show job
      Thread.sleep(5L * 1000L);
      // executing...
    } catch (Exception e) {
      //
    }





    // shut down the scheduler
    sched.shutdown(true);
  }

  public static void main(String[] args) throws Exception {

    SimpleExample example = new SimpleExample();
    example.run();

  }

}
