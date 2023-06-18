package runners;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;


public class TestCreateUser {

    // Using the Relative Path
    @Test
    public Karate runTest(){
        return Karate.run("../features/users/createUser").relativeTo(getClass());
    }

    // Using the Absolute path
    @Test
    public Karate runTestUsingClasspath(){
        return Karate.run("classpath:features/users/createUser.feature");
    }
}
