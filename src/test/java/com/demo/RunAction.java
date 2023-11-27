package com.demo;

import com.intuit.karate.junit5.Karate;

public class RunAction {

    @Karate.Test
    Karate testAll() {
        return Karate.run("VerifyResponseMethod").relativeTo(getClass());
    }
}
