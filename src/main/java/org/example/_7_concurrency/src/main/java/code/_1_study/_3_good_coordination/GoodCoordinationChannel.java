package org.example._7_concurrency.src.main.java.code._1_study._3_good_coordination;

import lombok.SneakyThrows;

public class GoodCoordinationChannel implements IChannel {
    private String message;
    private boolean isChannelEmpty = true;

    @SneakyThrows
    public synchronized String take() {
        if (isChannelEmpty) {
            this.wait();
        }
        isChannelEmpty = true;
        notifyAll();
        return message;
    }


    @SneakyThrows
    public synchronized void put(String message) {
        if (!isChannelEmpty) {
            this.wait();
        }
        this.message = message;
        isChannelEmpty = false;
        notifyAll();
    }
}