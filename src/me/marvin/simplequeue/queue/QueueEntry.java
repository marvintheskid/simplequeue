package me.marvin.simplequeue.queue;

import lombok.Getter;
import me.marvin.simplequeue.provider.QueuePriorityProvider;

@Getter
public class QueueEntry<T> {
    private T entry;
    private String queueId;
    private int priority;

    public QueueEntry(String queueId, T entry, QueuePriorityProvider<T> priorityProvider) {
        this(queueId, entry, priorityProvider.getEntryPriority(entry));
    }

    public QueueEntry(String queueId, T entry, int priority) {
        this.queueId = queueId;
        this.entry = entry;
        this.priority = priority;
    }
}
