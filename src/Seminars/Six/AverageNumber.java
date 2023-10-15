package Seminars.Six;

import java.util.List;

public class AverageNumber {
    /**
     * метод возвращает среднее арифметическое из всех чисел переданного списка
     * @param listNumber список чисел
     * @return среднее арифметическое списка чисел
     */
    public Double averageNumber(List<Integer> listNumber) {
        return listNumber.stream().mapToDouble(a -> a).average().getAsDouble();}

    /**
     * метод сравнивает два переданных числа
     * @param averageNumber1 первое число
     * @param averageNumber2 второе число
     * @return сообщение, какое из чисел больше
     */
    public String compareAverageNumbers(Double averageNumber1, Double averageNumber2) {
        return (averageNumber1.equals(averageNumber2)) ? "Средние значения равны" :
                ((averageNumber1 > averageNumber2) ? "Первый список имеет большее среднее значение" :
                        "Второй список имеет большее среднее значение");}
}