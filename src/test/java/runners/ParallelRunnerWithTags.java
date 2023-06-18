package runners;

import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParallelRunnerWithTags {

    private  static final String CLASS_PATH = "classpath:";
    private  static final String DELIMITER = ",";

    @Test
    public void executeKarateTests (){
        System.out.println(getLocations());
        System.out.println(getTags());
        Runner.path(getLocations()).tags(getTags()).parallel(5);
//        Runner.path("classpath:features/createCustomer").tags("@createCustomer").parallel(5);
//        Runner.path("classpath:features/createCustomer").tags("~@ignore").parallel(5);

    }

    private List<String> getTag(){
        String tag = System.getProperty("tags","@authentication");
        List<String> tags =Arrays.asList(tag);
        return tags;
    }

    private List<String> getTags(){
        String tag = System.getProperty("tags","@authentication");
        List<String> tags = Collections.emptyList();
        if(tag.contains(DELIMITER)){
            String tagArray[] = tag.split(DELIMITER);
            tags = Arrays.asList(tagArray);
            return  tags;
        }
        tags = Arrays.asList(tag);
        return tags;
    }

    private List<String> getLocation(){
        String location = System.getProperty("location", "features");
        List<String> locations =Arrays.asList(CLASS_PATH + location);
        return locations;
    }

    private List<String> getLocations(){
        String location = System.getProperty("location", "features");
        List<String> locations = Collections.emptyList();
        if(location.contains(DELIMITER)){
            String locationArray[] = location.split(DELIMITER);
            locations = Arrays.asList(locationArray);
            locations.replaceAll((entry) -> {
                return CLASS_PATH + entry;
            });
            return locations;
        }
        locations = Arrays.asList(CLASS_PATH + location);
        return locations;
    }
}
