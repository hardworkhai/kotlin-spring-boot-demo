package com.example.demo.job

import com.example.demo.config.ServiceInit
import org.quartz.Job
import org.quartz.JobExecutionContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TestJob : Job {
    private val log : Logger = LoggerFactory.getLogger(ServiceInit::class.java)
    override fun execute(context: JobExecutionContext?) {
        log.debug("I am back.")
    }
}