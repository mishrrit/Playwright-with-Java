/*
 * package listeners;
 * 
 * import com.aventstack.extentreports.ExtentReports; import
 * com.aventstack.extentreports.ExtentTest; import
 * com.aventstack.extentreports.Status; import
 * com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 * 
 * public class ExtentReportListener implements ITestListener {
 * 
 * private static ExtentReports extent = new ExtentReports(); private static
 * ExtentTest test;
 * 
 * @Override public void onStart(ITestContext context) { String reportPath =
 * "./build/reports/ExtentReport.html"; ExtentHtmlReporter htmlReporter = new
 * ExtentHtmlReporter(reportPath); extent.attachReporter(htmlReporter); }
 * 
 * @Override public void onTestStart(ITestResult result) { String testName =
 * result.getMethod().getMethodName(); test = extent.createTest(testName); }
 * 
 * @Override public void onTestSuccess(ITestResult result) {
 * test.log(Status.PASS, "Test passed"); }
 * 
 * @Override public void onTestFailure(ITestResult result) {
 * test.log(Status.FAIL, "Test failed"); test.log(Status.FAIL,
 * result.getThrowable()); }
 * 
 * @Override public void onTestSkipped(ITestResult result) {
 * test.log(Status.SKIP, "Test skipped"); }
 * 
 * @Override public void onFinish(ITestContext context) { extent.flush(); }
 * 
 * }
 */