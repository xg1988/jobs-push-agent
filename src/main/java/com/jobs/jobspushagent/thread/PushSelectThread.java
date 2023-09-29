package com.jobs.jobspushagent.thread;


import com.jobs.jobspushagent.dto.PushSendRequestDto;
import com.jobs.jobspushagent.service.MngQueueDtoList;
import com.jobs.jobspushagent.service.MngQueueList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

@Component
@Slf4j
public class PushSelectThread extends Thread{
    MngQueueList mngQueueList;

    MngQueueDtoList mngQueueDtoList;

    public PushSelectThread(MngQueueList mngQueueList, MngQueueDtoList mngQueueDtoList){
        this.mngQueueList = mngQueueList;
        this.mngQueueDtoList = mngQueueDtoList;
    }

    @Override
    public void run() {
        //super.run();
        try{
            while (true){
                String name = Thread.currentThread().getName();
                mngQueueList.addQueue("test");

                for(int i =0 ; i< 1000; i++){
                    PushSendRequestDto pushSendRequestDto = PushSendRequestDto.builder().pushSendRequestId(UUID.randomUUID().toString())
                            .title("타이틀")
                            .message("메시지" + i).build();
                    mngQueueDtoList.addQueue(pushSendRequestDto);
                }

                log.info("PushSendThread run [{}].. {}",name, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
                Thread.sleep(10000);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
