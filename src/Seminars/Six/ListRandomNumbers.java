package Seminars.Six;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListRandomNumbers {
    List<Integer> randomList;

    /**
     * метод возвращает список чисел указанной длины
     * @param length длина создаваемого списка
     * @return список случайных чисел от -100 до 100
     */
    public List<Integer> getRandomList(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Некорректный размер списка");
        }
        randomList = new Random().ints(length, -100, 101)
                .boxed()
                .collect(Collectors.toList());
        return randomList;
    }
}
