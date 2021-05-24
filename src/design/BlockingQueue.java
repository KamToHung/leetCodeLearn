package design;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 设计阻塞队列
 */
public class BlockingQueue {

    private int[] queue;

    private int takeIndex;

    private int putIndex;

    private int size;

    private int count;

    ReentrantLock lock = new ReentrantLock();

    Condition empty = lock.newCondition();

    Condition full = lock.newCondition();

    public BlockingQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.takeIndex = 0;
        this.putIndex = 0;
    }

    public int take() {
        // 取出
        lock.lock();
        try {
            while (count == 0) {
                empty.await();
            }
            int value = dequeue();
            full.signal();
            return value;
        } catch (Exception e) {
            // TODO
        } finally {
            lock.unlock();
        }
        return 0;
    }

    public void put(int value) {
        // 插入
        lock.lock();
        try {
            while (count == size) {
                full.await();
            }
            enqueue(value);
            empty.signal();
        } catch (Exception e) {
            // TODO
        } finally {
            lock.unlock();
        }
    }

    public void enqueue(int value) {
        queue[putIndex] = value;
        putIndex++;
        // 如果满了则返回第一位
        if (size == putIndex) {
            putIndex = 0;
        }
        // 处理入队列
        count++;
    }

    public int dequeue() {
        int value = queue[takeIndex];
        takeIndex++;
        if (size == takeIndex) {
            takeIndex = 0;
        }
        // 处理出队列
        count--;
        return value;
    }
}

