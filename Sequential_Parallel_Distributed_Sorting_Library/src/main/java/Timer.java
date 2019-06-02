public class Timer {
    private Runnable strategy;

    public Runnable getStrategy() {
        return strategy;
    }

    public void setStrategy(Runnable strategy) {
        this.strategy = strategy;
    }

    public long testStrategy() {
        long startTime = System.nanoTime();
        strategy.run();
        long endTime = System.nanoTime();

        return endTime - startTime;
    }
}
