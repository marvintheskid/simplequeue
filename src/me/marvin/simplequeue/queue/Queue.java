package me.marvin.simplequeue.queue;

import lombok.Getter;

import java.util.Comparator;
import java.util.PriorityQueue;

@Getter
public class Queue<T> {
    private PriorityQueue<QueueEntry<T>> players;
    private boolean paused;
    private String id;
    private int limit;

    public Queue(String id) {
        this(id, 250);
    }

    public Queue(String id, int limit) {
        this.players = new PriorityQueue<>(limit, Comparator.comparingInt(QueueEntry::getPriority));
        this.paused = false;
        this.id = id;
        this.limit = limit;
    }
}
