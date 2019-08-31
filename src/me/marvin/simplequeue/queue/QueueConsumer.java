package me.marvin.simplequeue.queue;

import me.marvin.simplequeue.provider.QueuePriorityProvider;

@FunctionalInterface
public interface QueueConsumer<T> {
    void accept(T t, Queue<T> q, QueuePriorityProvider<T> p);

    default QueueConsumer<T> andThen(QueueConsumer<T> after) {
        return (T t, Queue<T> q, QueuePriorityProvider<T> p) -> {
            accept(t, q, p);
            after.accept(t, q, p);
        };
    }
}
