package com.example.vikasworkbench;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.AssertionErrors;

import java.time.LocalDate;

public class BillForTests {
    /* test fixtures */

    Subscription newPlan = new Subscription(1, 1, 4);

    User[] noUsers = new User[0];

    User[] constantUsers = {
            new User(1, "Employee #1", LocalDate.of(2018, 11, 4), null, 1),
            new User(2, "Employee #2", LocalDate.of(2018, 12, 4), null, 1)
    };

    User[] userSignedUp = {
            new User(1, "Employee #1", LocalDate.of(2018, 11, 4), null, 1),
            new User(2, "Employee #2", LocalDate.of(2018, 12, 4), null, 1),
            new User(3, "Employee #3", LocalDate.of(2019, 01, 10), null, 1),
    };

    /* end test fixtures */

//    @Test
//    public void worksWhenTheCustomerHasNoActiveUsersDuringTheMonth() {
//        AssertionErrors.assertEquals(0, Challenge.billFor("2019-01", newPlan, noUsers), 0.01);
//    }
//
//    @Test
//    public void worksWhenEverythingStaysTheSameForAMonth() {
//        AssertionErrors.assertEquals(8, Challenge.billFor("2019-01", newPlan, constantUsers), 0.01);
//    }
//
//    @Test
//    public void worksWhenAUserIsActivatedDuringTheMonth() {
//        AssertionErrors.assertEquals(10.84, Challenge.billFor("2019-01", newPlan, userSignedUp), 0.01);
//    }
}