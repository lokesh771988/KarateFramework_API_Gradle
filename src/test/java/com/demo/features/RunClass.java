package com.demo.features;

import com.intuit.karate.junit5.Karate;

public class RunClass {
    @Karate.Test
    Karate testAll() {
        return Karate.run("ExcelFileValuesDisplay").relativeTo(getClass());
    }
}
