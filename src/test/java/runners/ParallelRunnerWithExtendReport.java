package runners;

import com.intuit.karate.Results;
//import features.users.CustomerExtendReport;
import org.junit.jupiter.api.Test;

public class ParallelRunnerWithExtendReport {

    private  static final String CLASS_PATH = "classpath:";
    private  static final String DELIMITER = ",";

    @Test
    public void executeKarateTests (){
        String location = System.getProperty("location", "features/users");
        String tags = System.getProperty("tags", "@createUser");
        System.out.println("Location: " + location);
        System.out.println("Tags: " + tags);
        Results result = com.intuit.karate.Runner.path(String.format("classpath:%s",location))
                .outputCucumberJson(true).tags(tags)
                .parallel(5);
//        CustomerExtendReport extendReport = new CustomerExtendReport()
//                .withKarateResult(result)
//                .withReportDir(result.getReportDir())
//                .withReportTitle("Karate test extent report");
//        extendReport.generateExtentReport();
    }


}
