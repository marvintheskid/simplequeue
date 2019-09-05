# simplequeue
Egy egyszerű, független queue rendszer
## TL;DR
épp nem működik, mert balfasz vagyok

## Használat
### PriorityProvider
```java
public class DummyPriorityProvider implements QueuePriorityProvider<Dummy> {
    @Override
    public String getProviderName() {
        return "Dummy";
    }

    @Override
    public int getEntryPriority(Dummy dummy) {
        return 0;
    }
}
```

### QueueHandler
#### Constructorok:
```java
public SimpleQueueHandler(long delay, QueuePriorityProvider<T> priorityProvider, QueueConsumer<T> consumer)
public SimpleQueueHandler(long delay, QueuePriorityProvider<T> priorityProvider, QueueConsumer<T> consumer, Predicate<T> removePredicate)
```

#### Methodok:
```java
public Queue<T> createQueue(String id)
public Queue<T> createQueue(String id, int limit)
public Tuple<QueueEntry<T>, QueueResponse> queueEntry(String queue, T tEntry)
public Tuple<QueueEntry<T>, QueueResponse> queueEntry(Queue<T> queue, T tEntry)
public boolean unQueueEntry(T tEntry)
```

#### Használat:
```java
public class Main {
    private SimpleQueueHandler<Dummy> queueHandler;
    
    public void createQueue() {
        queueHandler = new SimpleQueueHandler(250, new DummyPriorityProvider<>(), (dummy, queue, handler) -> {
            //Consumer, hogy mire használja fel az entryt
        },
        (dummy) -> {
            //Predicate, hogy mikor removeolja az entryt
        });
    }
    
    public void test() {
        queueHandler.createQueue("queuename");
        queueHandler.queueEntry("queuename", new Dummy());
    }
}
```

## Licensz
Copyright (c) 2019 marvintheskid (Kovács Márton)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
