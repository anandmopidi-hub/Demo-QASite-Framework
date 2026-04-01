package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String reportPath = System.getProperty("user.dir") + "/reports/" + timestamp + "/ExtentReport.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            // UI Customization
            spark.config().setDocumentTitle("Automation Test Report");
            spark.config().setReportName("DemoQA UI Automation");
            spark.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
            spark.config().setTimelineEnabled(true);

            extent = new ExtentReports();
            extent.attachReporter(spark);

            // System Info (VERY IMPORTANT)
            extent.setSystemInfo("Tester", "Anand");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Build", "1.0.0");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }

        return extent;
    }
}

