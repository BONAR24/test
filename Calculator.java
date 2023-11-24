import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String finish = calc(str);
        System.out.println(finish);
    }

    static boolean operatorCheck(String input) { //метод проверки оператора строки
        if (input.equals("+") || input.equals("-") || input.equals("/") || input.equals("*")) {
            return true;
        } else {
            return false;
        }
    }

    static String arab(String input1, String inputOp, String input2) { //метот для выполнения операций с арабскими числами
        int number1 = Integer.parseInt(input1);
        int number2 = Integer.parseInt(input2);
        int sum = 0;
        if (inputOp.equals("+")) {
            sum = number1 + number2;
        } else if (inputOp.equals("-")) {
            sum = number1 - number2;
        } else if (inputOp.equals("/")) {
            sum = number1 / number2;
        } else if (inputOp.equals("*")) {
            sum = number1 * number2;
        }
        String sumStr = String.valueOf(sum);
        return sumStr;
    }

    static String rome(String input1, String inputOp, String input2) {  //метот для выполнения операций с римскими числами
        String numberStr1;
        String numberStr2;
        String check = "";
        String sumRome;
        int number1 = 0;
        int number2 = 0;
        String[] arabStr2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] romeStr2 = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        for (int i = 0; i < arabStr2.length; i++) {
            if (input1.equals(romeStr2[i + 1])) {
                number1 = Integer.parseInt(arabStr2[i]);
                break;
            }
        }
        for (int i = 0; i < arabStr2.length; i++) {
            if (input2.equals(romeStr2[i + 1])) {
                number2 = Integer.parseInt(arabStr2[i]);
                break;
            }
        }
        int sum = 0;
        if (inputOp.equals("+")) {
            sum = number1 + number2;
        } else if (inputOp.equals("-")) {
            sum = number1 - number2;
        } else if (inputOp.equals("/")) {
            sum = number1 / number2;
        } else if (inputOp.equals("*")) {
            sum = number1 * number2;
        }
        if (sum <= 0) {
            check = "ошибка : в римской системе нет отрицательных чисел или результат операции привел к нулю";
        } else {
            for (int i = 0; i < romeStr2.length; i++) {
                if (sum == i + 1) {
                    check = romeStr2[i + 1];
                    break;
                }
            }
        }
        return check;
    }

    public static String calc(String input) {
        String[] arrayStr = input.split(" "); //массив отделенных сылочных символов
        if (arrayStr.length < 3) {
            return "ошибка : строка не является математической операцией или проверьте наличие пробелов";
        } else if (arrayStr.length > 3) {
            return "ошибка : формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *) или найдены лишние пробелы";
        }
        String[] arrayStrNumber = new String[2];
        arrayStrNumber[0] = arrayStr[0];
        arrayStrNumber[1] = arrayStr[2];  //выше реализован массив только с числами(без оператора) ввиде сторк
        boolean op = operatorCheck(arrayStr[1]); //вызов метода проверки оператора
        if (op == false) {
            return "ошибка : неверная арифмитическая операция";
        }
        int arabCheck = 0;
        int romeCheck = 0;
        String[] arabStr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] romeStr = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        //ниже цикл проверки арабских чисел
        for (int i = 0; i < arrayStrNumber.length; i++) {
            for (int j = 0; j < arabStr.length; j++) {
                if (arrayStrNumber[i].equals(arabStr[j])) {
                    arabCheck += 1;//фиксация проверки вида системы исчисления
                    break;
                }
            }
        }
        //ниже цикл проверки риских цифр
        for (int i = 0; i < arrayStrNumber.length; i++) {
            for (int j = 0; j < romeStr.length; j++) {
                if (arrayStrNumber[i].equals(romeStr[j])) {
                    romeCheck += 1;  //фиксация проверки вида системы исчисления
                    break;
                }
            }
        }
        if (arabCheck == 2) {
            String a = arab(arrayStr[0], arrayStr[1], arrayStr[2]);
            return a;
        } else if (romeCheck == 2) {
            String b = rome(arrayStr[0], arrayStr[1], arrayStr[2]);
            return b;
        } else if (arabCheck == 1 && romeCheck == 1) {
            return "ошибка : у операндов разные системы исчисления ";
        }
        return "ошибка : введен неверный диапазон или неизвестные калькулятору операнды";
    }
}

