package com.keysight.es.gateway;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class StorageProperties {

    @Value("${app.questionFile}")
    private String questionFile;

}
