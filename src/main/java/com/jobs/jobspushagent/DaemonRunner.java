package com.jobs.jobspushagent;

import com.jobs.jobspushagent.service.MngQueueDtoList;
import com.jobs.jobspushagent.service.MngQueueList;
import com.jobs.jobspushagent.thread.PushSelectThread;
import com.jobs.jobspushagent.thread.PushSendThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DaemonRunner implements CommandLineRunner {

    MngQueueList mngQueueList;
    MngQueueDtoList mngQueueDtoList;
    DaemonRunner(MngQueueList mngQueueList, MngQueueDtoList mngQueueDtoList){
        this.mngQueueList = mngQueueList;
        this.mngQueueDtoList = mngQueueDtoList;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("DaemonRunner start >> {}", Thread.currentThread().getName());

        for (int i = 0; i< 1; i++){
            PushSelectThread pushSelectThread = new PushSelectThread(mngQueueList, mngQueueDtoList);
            pushSelectThread.start();
        }

        for (int i = 0; i< 1; i++){
            PushSendThread pushSendThread = new PushSendThread(mngQueueList, mngQueueDtoList);
            pushSendThread.start();
        }

    }
}
