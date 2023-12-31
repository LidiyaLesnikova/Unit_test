package Seminars.DZ1;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    public static double squareRootExtraction(double number) {
        if (number == 0) {
            throw new ArithmeticException("It is not possible to extract the root from 0");
        }
        if (number < 0) {
            throw new ArithmeticException("It is impossible to extract the root from negative numbers");
        }

        double t;
        double squareRoot = number / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        }
        while ((t - squareRoot) != 0);
        return squareRoot;

        // или просто return Math.sqrt(number);
    }

    /**
     * @param purchaseAmount сумма покупки
     * @param discountAmount размер скидки
     * @return возвращает сумму покупки с учетом скидки
     */
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        if (discountAmount>100) {
            try {
                throw new ArithmeticException("Скидка больше 100% не возможна, будет предоставлена 100%");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                return 0;
            }
        } else if (discountAmount<0) {
            try {
                throw new ArithmeticException("Отрицательная скидка не возможна, предоставлена не будет");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                return purchaseAmount;
            }
        }
       return purchaseAmount - purchaseAmount*discountAmount/100;
    }

    public static int pow(int value, int powValue) {
        int rezult = 1;
        for (int i = 1; i <= powValue; i++) {
            if (i==0) return 1;
            rezult = rezult * value;
        }
        return rezult;
    }
}