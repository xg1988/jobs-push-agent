package com.jobs.jobspushagent.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
@Slf4j
public class MngQueueList {
    Queue<String> queue = new LinkedList<>();

    public void addQueue(String addStr){
        queue.add(addStr);
    }

    public void pollQueue(){
        queue.poll();
    }

    public void printQueueSize(){
        log.info("queue size >> {} ", queue.size());
    }
}
