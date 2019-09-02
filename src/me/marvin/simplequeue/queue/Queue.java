package me.marvin.simplequeue.queue;

import lombok.Data;

import java.util.Comparator;
import java.util.PriorityQueue;

@Data
public class Queue<T> {
    private PriorityQueue<QueueEntry<T>> entries;
    private boolean paused;
    private String id;
    private int limit;

    public Queue(String id) {
        this(id, 250);
    }

    public Queue(String id, int limit) {
        this.entries = new PriorityQueue<>(limit, Comparator.comparingInt(QueueEntry::getPriority));
        this.paused = false;
        this.id = id;
        this.limit = limit;
    }
}
