package com.jobs.jobspushagent.thread;


import com.jobs.jobspushagent.service.MngQueueList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class PushSendThread extends Thread{
    MngQueueList mngQueueList;

    public PushSendThread(MngQueueList mngQueueList){
        this.mngQueueList = mngQueueList;
    }

    @Override
    public void run() {
        //super.run();

        try{
            while (true){
                String name = Thread.currentThread().getName();
                log.info("PushSendThread run [{}].. {}",name, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

                mngQueueList.pollQueue();
                Thread.sleep(1000);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
