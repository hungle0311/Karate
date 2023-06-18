//package features.users;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.gherkin.model.*;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.intuit.karate.Results;
//import com.intuit.karate.core.Result;
//import com.intuit.karate.core.ScenarioResult;
//import com.intuit.karate.core.Step;
//
//import java.util.stream.Stream;
//
//public class CustomerExtendReport {
//    private ExtentReports extendReports;
//    private ExtentSparkReporter extentSparkReporter;
//    private String reportDir;
//    private String reportTitle = "Karate Test Execution Report";
//    private Results testResults;
//    private ExtentTest featureNode;
//    private ExtentTest scenarioNode;
//    private String featureTitle = "";
//    private  String scenarioTitle = "";
//    public CustomerExtendReport(){
//        extendReports = new ExtentReports();
//    }
//    public CustomerExtendReport withReportDir (String reportDir){
//        this.reportDir = reportDir;
//        return this;
//    }
//
//    public  CustomerExtendReport withKarateResult(Results testResults){
//        this.testResults = testResults;
//        return this;
//    }
//
//    public  CustomerExtendReport withReportTitle(String reportTitle){
//        this.reportTitle = reportTitle;
//        return this;
//    }
//
//    public void generateExtentReport(){
////        1. Check for reportDir and testResults, if not present then throw the exception
//        if(this.reportDir != null && !this.reportDir.isEmpty() && this.testResults != null){
//            extentSparkReporter = new ExtentSparkReporter(reportDir);
//            extendReports.attachReporter(extentSparkReporter);
//            setConfig();
//            Stream<ScenarioResult> scenarioResults = getScenarioResults();
//            scenarioResults.forEach((scenarioResult) -> {
//                String featureName = getFeatureName(scenarioResult);
//                String featureDescription = getFeatureDescription(scenarioResult);
//                ExtentTest featureNode = createFeatureNode(featureName,featureDescription);
//                String scenarioTitle = getScenarioTitle(scenarioResult);
//                ExtentTest scenarioNode = createScenarioNode(featureNode,scenarioTitle);
//                scenarioResult.getStepResults().forEach((step) -> {
//                    addScenarioStep(scenarioNode,step.getStep(), step.getResult());
//                });
//            });
//            extendReports.flush();
//            return;
//        }
////        2. Using the testResults, get the list opf test scenario results
////        3. Loop over list of scenario results
////        4. Using scenario results, get the scenario object
////        5. Using scenario object, get the info about the feature file
////        6. Using the same scenario object, we will get the info about the scenario
////        7. Using the scenario result, get the list of the step result
////        8. Loop over the step result list, get the info about the scenario step and its execution status
////        9. use all the info to generate the extent reportDir
//
//    }
//
//    private Stream<ScenarioResult> getScenarioResults(){
//        return this.testResults.getScenarioResults();
//    }
//
//    private String getFeatureName(ScenarioResult scenarioResult){
//        return scenarioResult.getScenario().getFeature().getName();
//    }
//
//    private String getFeatureDescription(ScenarioResult scenarioResult){
//        return scenarioResult.getScenario().getFeature().getDescription();
//    }
//
//    private String getScenarioTitle(ScenarioResult scenarioResult){
//        return scenarioResult.getScenario().getName();
//    }
//
//    private ExtentTest createFeatureNode(String featureName, String featureDescription){
//        //If the title of feature is same, I will return same instance of extent test
//        //Else I will create a new instance and return it
//        if(this.featureTitle.equalsIgnoreCase(featureName)){
//            return featureNode;
//        }
//        this.featureTitle = featureName;
//        featureNode = extendReports.createTest(Feature.class, featureName, featureDescription);
//        return featureNode;
//    }
//
//    private ExtentTest createScenarioNode(ExtentTest featureNode,String scenarioTitle){
//        //If the title of feature is same, I will return same instance of extent test
//        //Else I will create a new instance and return it
//        if(this.scenarioTitle.equalsIgnoreCase(scenarioTitle)){
//            return scenarioNode;
//        }
//        this.scenarioTitle = scenarioTitle;
//        scenarioNode = featureNode.createNode(Scenario.class, scenarioTitle);
//        return scenarioNode;
//    }
//
//    private void addScenarioStep(ExtentTest scenarioNode, Step step, Result stepResult){
//        String type = step.getPrefix(); //Given-When-Then
//        String stepTitle = step.getText();
//        String status = stepResult.getStatus();
//        Throwable error = stepResult.getError();
//        ExtentTest stepNode;
//        switch(type){
//            case "Given":
//                stepNode = scenarioNode.createNode(Given.class,stepTitle);
//                addStatus(stepNode, status,error);
//                break;
//            case "When":
//                stepNode = scenarioNode.createNode(When.class,stepTitle);
//                addStatus(stepNode, status,error);
//                break;
//            case "Then":
//                stepNode = scenarioNode.createNode(Then.class,stepTitle);
//                addStatus(stepNode, status,error);
//                break;
//            case "And":
//                stepNode = scenarioNode.createNode(And.class,stepTitle);
//                addStatus(stepNode, status,error);
//                break;
//            default:
//                stepNode = scenarioNode.createNode(type + " " + stepTitle);
//                addStatus(stepNode, status,error);
//                break;
//        }
//    }
//
//    private void addStatus(ExtentTest stepNode, String status, Throwable error){
//        switch (status){
//            case "passed":
//                stepNode.pass("");
//                break;
//            case "failed":
//                stepNode.fail(error);
//                break;
//            default:
//                stepNode.skip("");
//                break;
//        }
//    }
//
//    private  void setConfig(){
//        extentSparkReporter.config().enableOfflineMode(true);
//        extentSparkReporter.config().setDocumentTitle(reportTitle);
//        extentSparkReporter.config().setTimelineEnabled(true);
//        extentSparkReporter.config().setTheme(Theme.DARK);
//    }
//}
