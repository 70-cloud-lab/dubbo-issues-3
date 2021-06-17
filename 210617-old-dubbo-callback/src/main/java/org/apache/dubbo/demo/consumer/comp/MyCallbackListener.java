package org.apache.dubbo.demo.consumer.comp;

import org.apache.dubbo.demo.CallbackListener;

import java.io.Serializable;

public class MyCallbackListener implements CallbackListener, Serializable {
    @Override
    public void onChanged(String msg) {
        System.out.println("callback: " + msg);
    }
}
