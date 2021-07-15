package com.example.vikasworkbench;

import java.math.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

class Subscription {
    public Subscription() {
    }

    public Subscription(int id, int customerId, int monthlyPriceInDollars) {
        this.id = id;
        this.customerId = customerId;
        this.monthlyPriceInDollars = monthlyPriceInDollars;
    }

    public int id;
    public int customerId;
    public int monthlyPriceInDollars;
}

class User {
    public User() {
    }

    public User(int id, String name, LocalDate activatedOn, LocalDate deactivatedOn, int customerId) {
        this.id = id;
        this.name = name;
        this.activatedOn = activatedOn;
        this.deactivatedOn = deactivatedOn;
        this.customerId = customerId;
    }

    public int id;
    public String name;
    public LocalDate activatedOn;
    public LocalDate deactivatedOn;
    public int customerId;
}

class Challenge {
    public static double billFor(String month, Subscription activeSubscription, User[] users) {
        double totalBill = 0d;
        if (activeSubscription != null && users.length > 0) {
            // parse the month
            String[] tokens = month.split("-");
            LocalDate firstDayOfMonth = LocalDate.of(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), 1);
            LocalDate lastDayOfMonth = lastDayOfMonth(firstDayOfMonth);
            int totalDays = lastDayOfMonth.getDayOfMonth();
            int monthlyPriceInDollars = activeSubscription.monthlyPriceInDollars;
            double pricePerDay = Double.valueOf(monthlyPriceInDollars) / totalDays;
            int customerId = activeSubscription.customerId;
            LocalDate day = firstDayOfMonth;
            while (!day.isAfter(lastDayOfMonth)) {
                int totalActiveUsers = 0;
                for (User user : users) {
                    LocalDate activatedOn = user.activatedOn;
                    LocalDate deactivatedOn = user.deactivatedOn;
                    int userCustomerId = user.customerId;
                    if (customerId == userCustomerId) {
                        if (activatedOn.isEqual(day) || activatedOn.isBefore(day)) {
                            if (deactivatedOn == null || (deactivatedOn.isAfter(day) || deactivatedOn.isEqual(day))) {
                                totalActiveUsers++;
                            }
                        }
                    }
                }
                totalBill += pricePerDay * totalActiveUsers;
                // push to next day till end of the month
                day = nextDay(day);
            }
        }
        BigDecimal bigDecimal = new BigDecimal(Double.toString(totalBill));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    /*******
    * Helper functions *
    *******/

    /**
    Takes a LocalDate object and returns a LocalDate which is the first day
    of that month. For example:
    
    firstDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 1)
    **/
    private static LocalDate firstDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(1);
    }

    /**
    Takes a LocalDate object and returns a LocalDate which is the last day
    of that month. For example:
    
    lastDayOfMonth(LocalDate.of(2019, 2, 7)) // => LocalDate.of(2019, 2, 28)
    **/
    private static LocalDate lastDayOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }

    /**
    Takes a LocalDate object and returns a LocalDate which is the next day.
    For example:
    
    nextDay(LocalDate.of(2019, 2, 7))  // => LocalDate.of(2019, 2, 8)
    nextDay(LocalDate.of(2019, 2, 28)) // => LocalDate.of(2019, 3, 1)
    **/
    private static LocalDate nextDay(LocalDate date) {
        return date.plusDays(1);
    }
}