package com.knightboost.lancetx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProxyThread extends Thread {

    public ProxyThread() {
        this.collectInfo();
    }

    public ProxyThread(@Nullable Runnable target) {
        super(target);
        this.collectInfo();
    }

    public ProxyThread(@NonNull String name) {
        super(name);
        this.collectInfo();
    }

    public void collectInfo() {
        System.out.println("ProxyThread created:" + Thread.currentThread().getName());
        System.out.println("当前线程的大概数量:" + Thread.activeCount());
        System.out.println("当前线程的堆栈:" + Thread.getAllStackTraces());

    }
}
