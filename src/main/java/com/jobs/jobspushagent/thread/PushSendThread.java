package com.jobs.jobspushagent.thread;


import com.jobs.jobspushagent.service.MngQueueDtoList;
import com.jobs.jobspushagent.service.MngQueueList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class PushSendThread extends Thread{
    MngQueueList mngQueueList;

    MngQueueDtoList mngQueueDtoList;

    public PushSendThread(MngQueueList mngQueueList, MngQueueDtoList mngQueueDtoList){
        this.mngQueueList = mngQueueList;
        this.mngQueueDtoList = mngQueueDtoList;
    }

    @Override
    public void run() {
        //super.run();

        try{
            while (true){
                String name = Thread.currentThread().getName();
                log.info("PushSendThread run [{}].. {}",name, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

                mngQueueList.pollQueue();

                log.info("mngQueueDtoList.printQueueSize() >> {}", mngQueueDtoList.queueSize());
                log.info("pushSendRequestDto >> {}", mngQueueDtoList.pollQueue() );

                Thread.sleep(10);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
