package com.jobs.jobspushagent.repository;

import com.jobs.jobspushagent.dto.PushSendRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PushSendListRepository extends JpaRepository<PushSendRequestDto, String> {

}
