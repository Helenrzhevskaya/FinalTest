package lesson4_JInit;

public class Functions {
    public static boolean isPrime(Integer number) {
        //проверка на простые числа:
        if (number <= 1) return false;
        for (int i = 2; i < number - 1; i++) {
            if (number % i == 0) return false; //провека, если число делится без остатка - то число не простое
        }
        return true;

    }

    public static boolean isPalindrome(String word) {
        if (word.length() < 2) return true;

        if (word.charAt(0) != word.charAt(word.length() - 1)) { //если символ находящийся на первой поизиции не равняется символу который находится на посл.месте в этом слов, то возвр фолс
            return false;
        }

        return isPalindrome(word.substring(1, word.length() -1)); //рекурсия. обрезать слово, с первого символа до предпоследнего

    }
}
