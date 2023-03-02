package JavaGuide.concurrent.myThreadPool;

/**
 * @autor wwl
 * @date 2023/1/30-20:45
 * 拒绝策略
 */
@FunctionalInterface
interface RejectPolicy<T> {
    void reject(BlockingQueue<T> queue, T task);
}