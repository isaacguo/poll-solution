package com.keysight.es.gateway.restcontrollers;

import com.keysight.es.gateway.entities.PollEntity;
import com.keysight.es.gateway.services.PollService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poll")
@Data
@AllArgsConstructor
public class PollRestController {

    private final PollService pollService;

    @PostMapping("/submit")
    public boolean submitPoll(@RequestBody PollEntity[] polls)
    {
        return this.pollService.submitPoll(polls);
    }


}
