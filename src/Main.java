public class Main {
    static class RomanNumbers {
         static int convertToRomansNumbers(String x) {
            String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            int number = 0;
            for (int i = 0; i < roman.length; i++) {
                if (x.equals(roman[i])) {
                    number = i + 1;
                    break;
                }
            }
            return number;
        }

         static String convertToArabianNumbers(int x) {
            String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XI", "XIV", "XV",
                    "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV","XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                    "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV","XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV",
            "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI" , "LXVII", "LXVIII", "LXVIV", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV"
            ,"LXXVI", "LXXVII", "LXXVIII", "LXXIX" , "LXXX" ,"LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
            for (int i = 0; i < roman.length; i++) {
                if (x == i) {
                    return roman[i - 1];
                }
            }
            return "C";
        }
    }

    public static String calc(String input) {
        String[] inputArray = input.split("[+/*-]");
        if (inputArray.length > 2) {
            throw new IllegalStateException();
        }
        if (inputArray.length <= 1) {
            throw new IllegalStateException();
        }
        int firstNumber;
        int secondNumber ;
        int result ;
        if (input.contains("I") || input.contains("V") || input.contains("X")) {
            for (String s : inputArray) {
                if (s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4")
                        || s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8")
                        || s.equals("9") || s.equals("10")) {
                    throw new IllegalArgumentException();
                }
            }
            firstNumber = RomanNumbers.convertToRomansNumbers(inputArray[0]);
            secondNumber = RomanNumbers.convertToRomansNumbers(inputArray[1]);
        } else {
            firstNumber = Integer.parseInt(inputArray[0]);
            secondNumber = Integer.parseInt(inputArray[1]);
        }
        if (firstNumber > 10 || firstNumber == 0 || secondNumber > 10 || secondNumber == 0) {
            throw new IllegalArgumentException();
        }
        if (input.contains("+")) result = firstNumber + secondNumber;
        else if (input.contains("-")) result = firstNumber - secondNumber;
        else if (input.contains("*")) result = firstNumber * secondNumber;
        else result = firstNumber / secondNumber;
        if (input.contains("V") || input.contains("I") || input.contains("X")) {
            if (result < 0) {
                throw new ArithmeticException();
            }
            return RomanNumbers.convertToArabianNumbers(result);
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(calc("VI*VIII"));
    }
}