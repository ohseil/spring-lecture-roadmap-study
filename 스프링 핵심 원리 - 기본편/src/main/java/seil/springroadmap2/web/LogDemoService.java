package seil.springroadmap2.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seil.springroadmap2.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(final String id) {
        myLogger.log("service id = " + id);
    }
}
