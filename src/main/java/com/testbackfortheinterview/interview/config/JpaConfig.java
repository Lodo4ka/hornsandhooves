package com.testbackfortheinterview.interview.config;

import com.testbackfortheinterview.interview.InterviewApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@Configuration
@EntityScan(basePackageClasses = {
        InterviewApplication.class,
        Jsr310JpaConverters.class
})

public class JpaConfig {
}
