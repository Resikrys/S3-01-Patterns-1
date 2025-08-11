package s3_01_command.vehicle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testCarStartReturnsCorrectMessage {

    @Test
    void start() {
        Car car = new Car("TestCar");
        assertEquals("TestCar Car: Engine started. Vroom vroom!", car.start());
    }
}