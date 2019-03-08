package test.main.java; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import main.java.main;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

/** 
* main Tester. 
* 
* @author <Authors name> 
* @since <pre>ÈýÔÂ 8, 2019</pre> 
* @version 1.0 
*/ 
public class mainTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}
/** 
* 
* Method: getonlynum(String str) 
* 
*/ 
@Test
public void testGetonlynum() throws Exception {
//TODO: Test goes here...
    main  wordcounter = new main();
    int sum = wordcounter.getonlynum("love");
    Assert.assertEquals(1861, sum);
    sum = wordcounter.getonlynum("mine");
    Assert.assertEquals(2036, sum);
    sum = wordcounter.getonlynum("peace");
    Assert.assertEquals(1092, sum);
    sum = wordcounter.getonlynum("war");
    Assert.assertEquals(896, sum);
    sum = wordcounter.getonlynum("kill");
    Assert.assertEquals(925, sum);
    sum = wordcounter.getonlynum("killmyself");
    Assert.assertEquals(0, sum);
    sum = wordcounter.getonlynum("666666");
    Assert.assertEquals(0, sum);
    sum = wordcounter.getonlynum("good");
    Assert.assertEquals(17872, sum);
}
} 
