package firstcome_event.application;

import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class SchedulingQueue {

    private final Queue<Long> queue = new ConcurrentLinkedQueue<>();

    public void add(final long memberId) {
        queue.add(memberId);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public Long peek() {
        return queue.peek();
    }

    public void poll() {
        queue.poll();
    }

    public int size() {
        return queue.size();
    }
}
