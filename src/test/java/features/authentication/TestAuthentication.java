package features.authentication;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;


public class TestAuthentication {
    @Test
    public Karate runTest(){
        return Karate.run("authentication").relativeTo(getClass());
    }
}
