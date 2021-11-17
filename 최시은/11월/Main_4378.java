import java.util.*;

public class Main_4378 {
    public static void main(String[] args) {
        String[] FirstLine = {"`","1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "="};
        String[] SecondLine = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"};
        String[] ThirdLine = {"A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "\'"};
        String[] LastLine = {"Z", "X", "C", "V", "B", "N", "M", ",", ".", "/"};

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split("");
            String result = "";

            for (String word : input) {
                boolean hasWord = false;

                if (word.equals(" ")) {
                    hasWord = true;
                    result += " ";
                }

                for (int i = 0; i < FirstLine.length; i++) {
                    if (hasWord == true) break;
                    else if (word.equals(FirstLine[i])) {
                        hasWord = true;
                        result += FirstLine[i - 1];
                        break;
                    }
                }

                for (int i = 0; i < SecondLine.length; i++) {
                    if (hasWord == true) break;
                    else if (word.equals(SecondLine[i])) {
                        hasWord = true;
                        result += SecondLine[i - 1];
                        break;
                    }
                }

                for (int i = 0; i < ThirdLine.length; i++) {
                    if (hasWord == true) break;
                    else if (word.equals(ThirdLine[i])) {
                        hasWord = true;
                        result += ThirdLine[i - 1];
                        break;
                    }
                }

                for (int i = 0; i < LastLine.length; i++) {
                    if (hasWord == true) break;
                    else if (word.equals(LastLine[i])) {
                        hasWord = true;
                        result += LastLine[i - 1];
                        break;
                    }
                }

            }

            System.out.println(result);
        }
    }
}
