package com.keysight.es.gateway.restcontroller;

import com.keysight.es.gateway.restcontrollers.PollRestController;
import com.keysight.es.gateway.restcontrollers.QuestionRestController;
import com.keysight.es.gateway.services.PollService;
import com.keysight.es.gateway.services.QuestionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class QuestionRestControllerTests {

    @Mock
    QuestionService questionService;

    @InjectMocks
    QuestionRestController questionRestController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(questionRestController)
                .build();
    }
    @Test
    public void givenNoArgumentsWhenGgetQuestionsThenServiceIsInvoked()
    {

    }


}
