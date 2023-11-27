package com.demo.features;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.sorting.SortingMethod;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@KarateOptions(tags = { "~@ignore" })
public class SuiteRun {

    @Test
    void testParallel() {
        String karateOutputPath = "target/surefire-reports";
        Results results = Runner.parallel(getClass(), 6, karateOutputPath);
        generateReport(karateOutputPath);
        assertTrue(results.getFailCount() == 0, results.getErrorMessages());
        //assertNull(results.getFailureReason());
    }

    private void generateReport(String karateOutputPath) {

        File reportOutputDirectory = new File(karateOutputPath);
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] { "json" }, true);
        List<String> jsonPaths = new ArrayList<String>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));

        String projectName = "WPPGen1Pie";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        // points to the demo trends which is not used for other tests
        configuration.setTrendsStatsFile(new File("target/demo-trends.json"));

        // TODO: Add these respective values
        /*
         * configuration.setBuildNumber("101");
         * configuration.addClassifications("Branch", "release/1.0");
         * configuration.addClassifications("Environment", "E2E");
         */

        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, configuration);
        reportBuilder.generateReports();
    }
}
