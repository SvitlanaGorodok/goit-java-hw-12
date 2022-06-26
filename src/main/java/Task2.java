public class Task2 {
    private static int number=0;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        int n = 15;
        for (int i = 1; i <= n; i++) {
            number++;
            verification();
        }
        System.out.println(result.substring(0,result.length()-2).toString());
    }

    private static void verification() {
        Thread threadA = new Thread(() -> {
            if (number % 15 == 0) {
                result.append("fizzbuzz, ");
            }
        });
        threadA.start();
        threadA.interrupt();

        Thread threadB = new Thread(() -> {
            if (number % 3 == 0 && number % 5 != 0) {
                result.append("fizz, ");
            }
        });
        threadB.start();
        try {
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.interrupt();

        Thread threadC = new Thread(() -> {
            if (number % 5 == 0 && number % 3 != 0) {
                result.append("buzz, ");
            }
        });
        threadC.start();
        try {
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadC.interrupt();

        Thread threadD = new Thread(() -> {
            if (number % 3 != 0 && number % 5 != 0) {
                result.append(number + ", ");
            }
        });
        threadD.start();
        try {
            threadD.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadD.interrupt();

    }
}
