import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    static long startTimer;
    static long endTimer;
    static String s;

    public static void main(String[] args) throws InterruptedException {
        String[] lettersMassive = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
        Arrays.sort(lettersMassive);
        Set<String> hashSetNumber = new HashSet<>();
        //одинаковые буквы
        for (String letter : lettersMassive) {
            for (int regNumber = 1; regNumber <= 199; regNumber++) {
                for (int j = 1; j <= 10; j++) {
                    hashSetNumber.add(String.format("%s%03d%s%s%02d", letter, j, letter, letter, regNumber));
                }
            }
        }
        //одинаковые цифры
        for (int i = 111; i <= 999; i += 111) {
            for (String letter1 : lettersMassive) {
                for (String letter2 : lettersMassive) {
                    for (String letter3 : lettersMassive) {
                        for (int regNumber = 1; regNumber <= 199; regNumber++) {
                            hashSetNumber.add(String.format("%s%03d%s%s%02d", letter1, i, letter2, letter3, regNumber));
                        }
                    }
                }
            }
        }
        List<String> arrNumber = new ArrayList<>(hashSetNumber); //Создание листа с номерами машин
        Set<String> treeSetNumber = new TreeSet<>(hashSetNumber); //Создание TreeSet с номерами

        Scanner scanner = new Scanner(System.in);


        for (; ; ) {
            System.out.println("Введите номер машины");
            s = scanner.nextLine();
            //Поиск по ArrayList
            System.out.print("Запуск поиска по ArrayList...");
            startTimer = System.nanoTime();
            if (arrNumber.contains(s)) {
                endTimer = System.nanoTime();
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Поиск завершён!");
                System.out.println("номер найден, поиск занял " + (endTimer - startTimer) + " нс");
                TimeUnit.SECONDS.sleep(2);
            } else {
                endTimer = System.nanoTime();
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Поиск завершён!");
                System.out.println("номер не найден, поиск занял " + (endTimer - startTimer) + " нс");
                TimeUnit.SECONDS.sleep(2);
            }

            Collections.sort(arrNumber);
            //Бинарный поиск по сортированному ArrayList
            System.out.print("Запуск поиска по отсортированному ArrayList бинарным способом...");
            startTimer = System.nanoTime();
            if (Collections.binarySearch(arrNumber, s) >= 0) {
                endTimer = System.nanoTime();
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Поиск завершён!");
                System.out.println("номер найден, поиск занял " + (endTimer - startTimer) + " нс");
                TimeUnit.SECONDS.sleep(2);
            } else {
                endTimer = System.nanoTime();
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Поиск завершён!");
                System.out.println("номер не найден, поиск занял " + (endTimer - startTimer) + " нс");
                TimeUnit.SECONDS.sleep(2);
            }

            //Поиск по HashSet
            System.out.print("Запуск поиска по HashSet...");
            searchSet(hashSetNumber);

            //Поиск по TreeSet
            System.out.print("Запуск поиска по TreeSet...");
            searchSet(treeSetNumber);
        }
    }

    static void searchSet(Set<String> set) throws InterruptedException {
        startTimer = System.nanoTime();
        if (set.contains(s)) {
            endTimer = System.nanoTime();
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Поиск завершён!");
            System.out.println("номер найден, поиск занял " + (endTimer - startTimer) + " нс");
            TimeUnit.SECONDS.sleep(2);
        } else {
            endTimer = System.nanoTime();
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Поиск завершён!");
            System.out.println("номер не найден, поиск занял " + (endTimer - startTimer) + " нс");
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
