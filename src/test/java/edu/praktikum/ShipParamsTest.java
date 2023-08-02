package edu.praktikum;

import edu.praktikum.sprint6.Sail;
import edu.praktikum.sprint6.Ship;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ShipParamsTest {

    @Parameterized.Parameter
    public int power;
    @Parameterized.Parameter(1)
    public int expectedResult;

    @Mock
    Sail sail;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name = "Ship with sail power {0} should have max speed {1}")
    public static Object[][] params() {
        return new Object[][] {
                { 4, 16 },
                { 3, 12 },
        };
    }

    @Test
    public void getMaxSpeed() {
        Ship ship = new Ship(sail);

        Mockito.when(sail.getMaxPower()).thenReturn(power);

        int actualResult = ship.getMaxSpeed();

        assertEquals(expectedResult, actualResult);
    }
}
