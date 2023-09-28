package com.jobs.jobspushagent.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class PushSendRequestDto {

    @Id @GeneratedValue
    private String pushSendRequestId;
    private String title;
    private String message;

}
