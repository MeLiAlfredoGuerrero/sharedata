package com.example.sharedata.services.impl;

import static com.example.sharedata.contants.Constants.CONTROLLER_KEY;
import static com.example.sharedata.contants.Constants.SERVICE_DATA;
import static com.example.sharedata.contants.Constants.SERVICE_KEY;

import com.example.sharedata.services.ExampleService;
import com.example.sharedata.singleton.DataHolder;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Override
    public String threadContext() {
        ThreadContext.put(SERVICE_KEY, SERVICE_DATA);
        System.out.println(ThreadContext.get(CONTROLLER_KEY));
        return "Thread Context Impl";
    }

    @Override
    public String SingletonDataHolder() {
        System.out.println(DataHolder.getInstance().get(CONTROLLER_KEY));
        DataHolder.getInstance().put(SERVICE_KEY, SERVICE_DATA);
        return "singleton";
    }

    @Override
    public String example() {
        return "example";
    }
}
