package com.keysight.es.gateway.services;

import com.keysight.es.gateway.entities.PollEntity;

import java.util.List;

public interface PollService {

    boolean submitPoll(PollEntity[] polls);

}
