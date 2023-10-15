package Seminars.Six;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MainTest {
    ListRandomNumbers listRandomNumbers;
    AverageNumber averageNumber;

    @BeforeEach
    void setUp() {
        averageNumber = new AverageNumber();
        listRandomNumbers = new ListRandomNumbers();
    }

    @Test
    void test_averageNumber(){
        assertThat(averageNumber.averageNumber(Arrays.asList(1, 2, 3, 4))).isEqualTo(2.5);
        assertThat(averageNumber.averageNumber(Arrays.asList(-1, 0, 1, 4))).isEqualTo(1);
    }

    @Test
    void test_compareAverageNumbers(){
        assertThat(averageNumber.compareAverageNumbers(1.0, -2.0)).isEqualTo("Первый список имеет большее среднее значение");
        assertThat(averageNumber.compareAverageNumbers(-1.0, 2.0)).isEqualTo("Второй список имеет большее среднее значение");
        assertThat(averageNumber.compareAverageNumbers(1.0, 1.0)).isEqualTo("Средние значения равны");
    }

    @Test
    void test_listRandomNumbersException(){
        assertThatThrownBy(() -> listRandomNumbers.getRandomList(0))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Некорректный размер списка");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 6})
    void test_listRandomNumbers(int i){
        assertEquals(listRandomNumbers.getRandomList(i).size(), i);
    }

    @Test
    void integrationTestModel(){
        ListRandomNumbers listRandomNumbersMock = mock(ListRandomNumbers.class);
        when(listRandomNumbersMock.getRandomList(anyInt())).thenReturn(Arrays.asList(5, 7, 8, 10));

        Double expectedAverageNumber = (5+7+8+10)/4.0;
        Double aclualAverageNumber = averageNumber.averageNumber(listRandomNumbersMock.getRandomList(anyInt()));

        assertEquals(expectedAverageNumber, aclualAverageNumber);
    }

    @Test
    void test_randomLenghtInModel() {
        int expectedrandomLenght = main.randomLenght();

        assertTrue(expectedrandomLenght>=2 && expectedrandomLenght<21);
    }

}