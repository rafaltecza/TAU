public class Counter {

    public int add(int x, int y) {
        return x + y;
    }

    public int sub(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public void validate(int x, int y) {
        if (x == 0 || y == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {}

}
