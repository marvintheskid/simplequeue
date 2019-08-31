package me.marvin.simplequeue.queue;

import lombok.Getter;
import me.marvin.simplequeue.provider.QueuePriorityProvider;

@Getter
public class QueueEntry<T> {
    private T entry;
    private String id;
    private int priority;

    public QueueEntry(String id, T entry, QueuePriorityProvider<T> priorityProvider) {
        this(id, entry, priorityProvider.getEntryPriority(entry));
    }

    public QueueEntry(String id, T entry, int priority) {
        this.id = id;
        this.entry = entry;
        this.priority = priority;
    }
}
