package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Successfully Finished " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed but within success percentage " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("First test Started " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Last test Finished " + context.getName());
        System.out.println("Success Tests " + context.getPassedTests());
        System.out.println("Failed Tests " + context.getFailedTests());
    }
}