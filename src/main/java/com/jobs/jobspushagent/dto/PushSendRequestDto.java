package com.jobs.jobspushagent.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PushSendRequestDto {

    @Id @GeneratedValue
    private String pushSendRequestId;
    private String title;
    private String message;
}
