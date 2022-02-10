import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] letter = {"A","B","E","K","M","H","O","P","C","T","Y","X"};
        Arrays.sort(letter);
        Set<String> arrNumberSame = new HashSet<>();
        Set<String> arrNumberLettersSame = new HashSet<>();
        //одинаковые буквы
        for(String a123: letter) {
            for(int reg = 1; reg <= 199; reg++) {
                for(int j = 1; j <= 10; j ++) {
                    arrNumberLettersSame.add(String.format("%s%03d%s%s%02d",a123,j,a123,a123,reg));
                }
            }
        }
        //одинаковые цифры
        for(int i = 111; i <= 999; i += 111) {
            for (String a1 : letter) {
                for (String a2 : letter) {
                    for (String a3 : letter) {
                        for (int reg = 1; reg <= 199; reg++) {
                            arrNumberSame.add(String.format("%s%03d%s%s%02d", a1, i, a2, a3, reg));
                        }
                    }
                }
            }
        }
        System.out.println("Колличество номеров с одинаковыми буквами");
        System.out.println(arrNumberLettersSame.size());
        System.out.println("Колличество номеров с одинаковыми цифрами");
        System.out.println(arrNumberSame.size());
        Set<String > allNumbers = new HashSet<>(){{
           addAll(arrNumberLettersSame);
           addAll(arrNumberSame);
        }};
        System.out.println("Вместе");
        System.out.println(allNumbers.size());
//        ArrayList<String> arrNum = new ArrayList<>(arrNumberSame);
    }
}
