import java.util.ArrayList;

public class Table extends Thread{

    private ArrayList<Fork> forks;
    private ArrayList<Philosopher> philosophers;

    public Table(){
        this.forks = createForkList();
        this.philosophers = createPhilosopherList();
    }

    @Override
    public void run() {
        for (Philosopher element : philosophers) {
            element.start();
        }
    }

    private ArrayList<Philosopher> createPhilosopherList(){
        ArrayList<Philosopher> philosophers = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            Philosopher philosopher = new Philosopher((i + 1), forks);
            philosophers.add(philosopher);
        }
        return philosophers;
    }
    private ArrayList<Fork> createForkList(){
        ArrayList<Fork> forks = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            Fork fork = new Fork(i + 1);
            forks.add(fork);
        }
        return forks;
    }
}
