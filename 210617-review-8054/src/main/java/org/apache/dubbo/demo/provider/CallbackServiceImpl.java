package org.apache.dubbo.demo.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.demo.CallbackListener;
import org.apache.dubbo.demo.CallbackService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@DubboService
public class CallbackServiceImpl implements CallbackService {

    private final Map<String, CallbackListener> listeners = new ConcurrentHashMap<>();

    private Thread t;

    public CallbackServiceImpl() {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);

                        listeners.forEach((k, v) -> {
                            try {
                                v.onChanged(getChangeMessage(k));
                            } catch (Throwable t) {
                                listeners.remove(k);
                            }
                        });
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private String getChangeMessage(String k) {
        return "Changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @Override
    public void addListener(String key, CallbackListener listener) {
        System.out.println("GOT LISTENER");
        listeners.put(key, listener);
        listener.onChanged(getChangeMessage(key));
    }
}
