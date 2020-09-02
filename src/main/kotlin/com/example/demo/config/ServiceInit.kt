package com.example.demo.config

import com.example.demo.job.TestJob
import org.quartz.CronScheduleBuilder.cronSchedule
import org.quartz.JobBuilder
import org.quartz.JobKey
import org.quartz.Trigger
import org.quartz.TriggerBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.scheduling.quartz.SchedulerFactoryBean
import org.springframework.stereotype.Component


@Component
class ServiceInit  @Autowired constructor(val schedulerFactoryBean: SchedulerFactoryBean) : CommandLineRunner {

    private val log : Logger = LoggerFactory.getLogger(ServiceInit::class.java)

    @Value("\${quartz-cron}")
    private val cron: String? = null


    @Throws(Exception::class)
    override fun run(vararg arg0: String) {
        log.debug("init something")
        val scheduler = schedulerFactoryBean.scheduler
        log.debug("start update source job")

        /*获取当前任务标识*/
        val jobKey = JobKey.jobKey("update", "source")
        val trigger: Trigger = TriggerBuilder.newTrigger().withIdentity(jobKey.name, jobKey.group).withSchedule(cronSchedule(cron)).build()
        scheduler.pauseJob(jobKey)
        scheduler.unscheduleJob(trigger.getKey())
        scheduler.deleteJob(jobKey)

        /*获取任务详情*/
        val jobDetail = JobBuilder.newJob(TestJob::class.java).withIdentity(jobKey).withDescription("执行更新数据源表任务")
                .storeDurably().build()
        scheduler.scheduleJob(jobDetail, trigger)
    }


}