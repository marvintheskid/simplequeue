package me.marvin.simplequeue.queue;

import lombok.Data;

import java.util.LinkedList;

@Data
public class Queue<T> {
    //TODO Jobb megoldást erre
    private LinkedList<QueueEntry<T>> entries;
    private boolean paused;
    private String id;
    private int limit;

    public Queue(String id) {
        this(id, 250);
    }

    public Queue(String id, int limit) {
        this.entries = new LinkedList<>();
        this.paused = false;
        this.id = id;
        this.limit = limit;
    }
}
