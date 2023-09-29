package com.jobs.jobspushagent.service;

import com.jobs.jobspushagent.dto.PushSendRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
@Slf4j
public class MngQueueDtoList {
    Queue<PushSendRequestDto> queue = new LinkedList<>();

    public void addQueue(PushSendRequestDto dto){
        queue.add(dto);
        log.info("queue size >> {} ", queue.size());
    }

    public PushSendRequestDto pollQueue(){
        return queue.poll();
    }

    public int queueSize(){
        return queue.size();
    }
}
