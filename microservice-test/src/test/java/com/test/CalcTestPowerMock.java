package com.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import person.MyCalculator;
import person.MyCalculatorImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest({MyCalculator.class})
@PowerMockIgnore("jdk.internal.reflect.*")
public class CalcTestPowerMock {

    @InjectMocks
    MyCalculatorImpl impl;

    @Test
    public void test() {
        PowerMockito.mockStatic(MyCalculator.class);
        PowerMockito.when(MyCalculator.add(Mockito.anyInt(), Mockito.anyInt())).thenReturn(10);

        Assert.assertEquals(impl.add(2,3),11);
    }

}
