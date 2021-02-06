package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.seleniumeasy.enums.Colors.*;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test " + result.getName() + " STARTED");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test " + result.getName() + TEXT_GREEN.getColor() + " PASSED" + TEXT_RESET.getColor());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test " + result.getName() + TEXT_RED.getColor() + " FAILED" + TEXT_RESET.getColor());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test " + result.getName() + TEXT_YELLOW.getColor() + " SKIPPED" + TEXT_RESET.getColor());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test " + result.getName() + " FAILED but within SUCCESS percentage");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(TEXT_BLUE.getColor() + "STARTED" + TEXT_RESET.getColor() + " testing " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(TEXT_PURPLE.getColor() + "FINISHED" + TEXT_RESET.getColor() + " testing " + context.getName());
    }
}