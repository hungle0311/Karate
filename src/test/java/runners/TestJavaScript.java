package runners;

import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;


public class TestJavaScript {

    @Test
    public Karate runTest(){
        return Karate.run("javaScript").relativeTo(getClass());
    }
}
