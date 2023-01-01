package com.learn.spring.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService {
    public int[] retrieveData() {
        return new int[] {10, 20, 30, 40, 50, 60};
    }
}
