package com.learn.spring.aop.business;

import com.learn.spring.aop.annotations.TrackTime;
import com.learn.spring.aop.data.DataService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService {
    private DataService dataService;

    public BusinessService(DataService dataService) {
        this.dataService = dataService;
    }

    @TrackTime
    public int calculateMax() {
        int[] data = dataService.retrieveData();
        // throw new RuntimeException("Something went wrong");
        return Arrays.stream(data).max().orElse(-1);
    }
}
