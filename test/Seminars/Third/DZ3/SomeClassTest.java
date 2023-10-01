package Seminars.Third.DZ3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class SomeClassTest {
    SomeClass someClass;

    @BeforeEach
    void setUp(){
        someClass = new SomeClass();
    }

    /**
     * Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет, является ли
     * переданное число четным или нечетным:
     */
    @Test
    void testEvenNumber(){
        assertThat(someClass.evenOddNumber(10)).isTrue();
    }

    @Test
    void testOddNumber(){
        assertThat(someClass.evenOddNumber(11)).isFalse();
    }

    /**
     * Разработайте и протестируйте метод numberInInterval,
     * который проверяет, попадает ли переданное число в интервал (25;100).
     */
    @ParameterizedTest
    @ValueSource(ints = {25, 60, 100})
    void testNumberInInterval(int i){
        assertThat(someClass.numberInInterval(i)).isTrue();
    }

    @Test
    void testLessInterval(){
        assertThat(someClass.numberInInterval(0)).isFalse();
    }

    @Test
    void testMoreInterval(){
        assertThat(someClass.numberInInterval(101)).isFalse();
    }
}