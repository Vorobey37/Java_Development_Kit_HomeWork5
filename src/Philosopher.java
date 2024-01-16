import java.util.ArrayList;

public class Philosopher extends Thread {

    private ArrayList<Fork> forks;
    private int number;
    private int count;

    public Philosopher(int number, ArrayList<Fork> forks) {
        this.number = number;
        this.forks = forks;
        this.count = 0;
    }

    @Override
    public void run() {
        try {
            while(count < 3){
                eat();
            }
            System.out.println(this + " наелся");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void eat() throws InterruptedException {

        if (!getLeft().isTaken() && !getRight().isTaken()){
            getLeft().setTaken(true);
            getRight().setTaken(true);
            System.out.println(this + " взял " + getLeft() + " и " + getRight() + " и начал есть");
            sleep(3000);
            System.out.println(this + " закончил есть и положил " + getLeft() + " и " + getRight());
            getLeft().setTaken(false);
            getRight().setTaken(false);
            count++;
            think();
        } else {
            System.out.println(this + " не нашел подходящую вилку");
            think();
        }

    }
    private void think() throws InterruptedException {
        System.out.println(this + " размышляет");
        sleep(3000);
    }

    private synchronized Fork getLeft(){
        if (number == 1){
            return forks.get(4);
        } else {
            return forks.get(number - 2);
        }
    }

    private synchronized Fork getRight(){
        return forks.get(number - 1);
    }

    @Override
    public String toString() {
        return "Филосов №" + number;
    }
}
