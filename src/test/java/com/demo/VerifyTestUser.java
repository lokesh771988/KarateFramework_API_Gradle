package com.demo;

import com.intuit.karate.junit5.Karate;

public class VerifyTestUser {

    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }
}
