package com.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import person.MyCalculator;
import person.MyCalculatorImpl;

@RunWith(MockitoJUnitRunner.class)
public class CalcTest {

    @InjectMocks
    MyCalculatorImpl impl;

    @Test
    public void testCalc() {
        try (MockedStatic<MyCalculator> utilities = Mockito.mockStatic(MyCalculator.class)) {
            utilities.when(() -> MyCalculator.add(2, 6))
                    .thenReturn(22);

            Assert.assertEquals(impl.add(2, 6), 22);
        }
    }

}
