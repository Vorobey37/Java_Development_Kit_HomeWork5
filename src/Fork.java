public class Fork {
    private int number;
    private boolean isTaken;

    public Fork(int number) {
        this.number = number;
        this.isTaken = false;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Вилку №" + number;
    }

}
