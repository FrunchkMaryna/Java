package java0;

public class Variant17 {
    
    /**
     * Array17
     * 
     * Дано масив A розміру N. Вивести його елементи в наступному порядку: 
     * A1, A2, AN, AN-1, A3, A4, AN-2, AN-3, … .
     * 
     * @param array is the input array
     * @return reordered array
     */
    public double[] arrayTask(double[] array) {
        int i = 0;
        int j = array.length - 1;
        double[] result = new double[array.length];
        int index = 0;
        
        while (i <= j) {
            if (i <= j) {
                result[index++] = array[i++];
            }
            if (i <= j) {
                result[index++] = array[j--];
            }
        }
        return result;
    }

    /**
     * Integer17
     * 
     * Дано ціле число більше 999. Використовуючи одну операцію поділу націло і 
     * одну операцію взяття залишку від поділу, знайти цифру, відповідну розряду сотень.
     * 
     * @param k is an integer number
     * @return the hundreds digit
     */
    public int integerNumbersTask(int k) {
        return (k / 100) % 10;
    }

    /**
     * Boolean17
     * 
     * Дано ціле позитивне число. Перевірити істинність висловлювання: 
     * «Це число є непарним тризначним».
     * 
     * @param number1 is the input number
     * @return true if the number is odd and three-digit
     */
    public boolean booleanTask(int number1) {
        return number1 >= 100 && number1 < 1000 && number1 % 2 != 0;
    }
    
    /**
     * Case17
     * 
     * Дано ціле число в діапазоні 10, 40, що визначає кількість навчальних завдань 
     * по деякій темі. Вивести рядок-опис зазначеної кількості завдань, 
     * забезпечивши правильне узгодження числа зі словами «навчальне завдання».
     * 
     * @param number is the integer in range 10-40
     * @return description of the task number
     */
    public String caseTask(int number) {
        if (number < 10 || number > 40) {
            return "Number is out of range";
        }

        String[] ones = {"", "одне", "два", "три", "чотири", "п'ять", "шість", "сім", "вісім", "дев'ять"};
        String[] teens = {"десять", "одинадцять", "дванадцять", "тринадцять", "чотирнадцять", "п'ятнадцять", "шістнадцять", "сімнадцять", "вісімнадцять", "дев'ятнадцять"};
        String[] tens = {"", "", "двадцять", "тридцять", "сорок"};

        if (number < 20) {
            return teens[number - 10] + " навчальних завдань";
        } else {
            int tenPart = number / 10;
            int onePart = number % 10;
            String result = tens[tenPart];
            if (onePart != 0) {
                result += " " + ones[onePart];
            }
            result += " навчальних завдань";
            return result;
        }
    }

    /**
     * For17
     * 
     * Дано речовинне число A і ціле число N (> 0). Використовується один цикл, 
     * щоб знайти суму 1 + A + A^2 + A^3 + … + A^N.
     * 
     * @param n is the number of terms
     * @param A is the base number
     * @return sum of the series
     */
    public double forTask(int n, double A) {
        double sum = 0;
        double power = 1;
        
        for (int i = 0; i <= n; i++) {
            sum += power;
            power *= A;
        }
        
        return sum;
    }

    /**
     * If17
     * 
     * Дано три змінні речовинного типу: A, B, C. Якщо їх значення впорядковані 
     * по зростанню або зменшенню, подвоїти їх; в іншому випадку замінити значення 
     * кожної змінної на протилежне.
     * 
     * @param A is the first variable
     * @param B is the second variable
     * @param C is the third variable
     * @return new values of A, B, C
     */
    public double[] ifTask(double A, double B, double C) {
        if ((A < B && B < C) || (A > B && B > C)) {
            return new double[] {A * 2, B * 2, C * 2};
        } else {
            return new double[] {-A, -B, -C};
        }
    }

    /**
     * Matrix17
     * 
     * Дана матриця розміру M x N і ціле число K (1 ≤ K ≤ M). Знайти суму і добуток 
     * елементів K-го рядка даної матриці.
     * 
     * @param array is the input matrix
     * @param k is the row index (1-based)
     * @return an array where the first element is the sum and the second is the product
     */
    public int[] matrixTask(int[][] array, int k) {
        int sum = 0;
        int product = 1;
        
        for (int element : array[k - 1]) {
            sum += element;
            product *= element;
        }
        
        return new int[] {sum, product};
    }

    /**
     * While17
     * 
     * Дано ціле число NN (> 0). Використовуючи операції поділу націло і взяття залишку від поділу, 
     * вивести всі його цифри, починаючи з правої (розряду одиниць).
     * 
     * @param number is the input number
     */
    public void whileTask(int number) {
        while (number > 0) {
            System.out.print(number % 10 + " ");
            number /= 10;
        }
    }

    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }

}
