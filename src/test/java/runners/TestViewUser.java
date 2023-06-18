package runners;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;


public class TestViewUser {

    @Test
    public Karate runTest(){
        return Karate.run("../features/users/viewUser").relativeTo(getClass());
    }
}
