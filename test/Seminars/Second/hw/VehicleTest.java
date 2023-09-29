package Seminars.Second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleTest {
    Motorcycle motorcycle;
    Car car;

    @BeforeEach
    void PrepareData(){
        motorcycle = new Motorcycle("HONDA", "CB 1100", 2020);
        car = new Car("NISSAN", "Primera P12", 2010);
    }

    /**
     * Проверить, что экземпляр объекта Car также является экземпляром транспортного средства
     * (используя оператор instanceof).
     */
    @Test
    void testCar(){
        assertThat(car instanceof Vehicle).isEqualTo(true);
    }

    /**
     * Проверить, что объект Car создается с 4-мя колесами.
     */
    @Test
    void testCarWheels(){
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    /**
     * Проверить, что объект Motorcycle создается с 2-мя колесами.
     */
    @Test
    void testMotorcycleWheels(){
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    /**
     * Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    void testSpeedCar() {
        car.testDrive();

        assertThat(car.getSpeed()).isEqualTo(60);
    }

    /**
     *  Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения
     *  (используя метод testDrive()).
     */
    @Test
    void testSpeedMotorcycle() {
        motorcycle.testDrive();

        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    /**
     *  Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
     * машина останавливается (speed = 0).
     */
    @Test
    void testParkingCar(){
        car.testDrive();
        car.park();

        assertThat(car.getSpeed()).isEqualTo(0);
    }

     /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
     * мотоцикл останавливается (speed = 0).
     */
     @Test
     void testParkingMotorcycle(){
         motorcycle.testDrive();
         motorcycle.park();

         assertThat(motorcycle.getSpeed()).isEqualTo(0);
     }
}