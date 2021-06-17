package org.apache.dubbo.demo;

public interface CallbackService {
    void addListener(String key, CallbackListener listener);
}
