/**
 * This is JUnit that tests the lower method in StringHandling class.
 * This contains 80 testcases.
 * 
 * Please don't run this file.
 * You can add your own test cases to this file by just copy and 
 * paste the last three lines of the code (TestCase6).
 * 
 * @author Deepak Kumar
 * @author Vipul
 */

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import java.util.*;

public class TestJUnit {
  @Test
  public void testCase1() {
    Team[] teams = {new Team("England",4,2,3), new Team("India",5,2,4),new Team("Australia",6,2,3), new Team("SouthAfrica",5,3,4), new Team("Bangladesh",3,4,2), new Team("Zimbabwe",3,4,6), new Team("Ireland",3,4,1)};
    Team[] res = {new Team("Australia",6,2,3), new Team("India",5,2,4), new Team("SouthAfrica",5,3,4),new Team("England",4,2,3), new Team("Zimbabwe",3,4,6), new Team("Bangladesh",3,4,2), new Team("Ireland",3,4,1) };
    Solution s = new Solution();
    Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.sort(teams)));
  }
  @Test
  public void testCase2(){
    Team[] teams = {new Team("SouthAfrica",5,3,4), new Team("Bangladesh",3,2,2), new Team("Zimbabwe",5,3,6), new Team("Ireland",3,4,1)};
    Team[] res = {new Team("Zimbabwe",5,3,6), new Team("SouthAfrica",5,3,4), new Team("Bangladesh",3,2,2), new Team("Ireland",3,4,1)};
    Solution s = new Solution();
    Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.sort(teams)));
  }
  @Test
  public void testCase3(){
    Team[] teams = {new Team("England",4,2,3), new Team("India",2,2,4),new Team("Australia",6,2,3), new Team("SouthAfrica",5,3,4), new Team("Bangladesh",3,4,2), new Team("Zimbabwe",6,4,6), new Team("Ireland",4,4,1)};
    Team[] res = {new Team("Australia",6,2,3), new Team("Zimbabwe",6,4,6), new Team("SouthAfrica",5,3,4),new Team("England",4,2,3), new Team("Ireland",4,4,1), new Team("Bangladesh",3,4,2), new Team("India",2,2,4)  };
    Solution s = new Solution();
    Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.sort(teams)));
  }
  @Test
  public void testCase4(){
    Team[] teams = {new Team("England",0,2,3), new Team("India",0,2,4),new Team("Australia",6,2,3), new Team("SouthAfrica",5,3,4), new Team("Bangladesh",13,4,2), new Team("Zimbabwe",13,4,6), new Team("Ireland",6,4,1)};
    Team[] res = {new Team("Zimbabwe",13,4,6), new Team("Bangladesh",13,4,2), new Team("Australia",6,2,3), new Team("Ireland",6,4,1), new Team("SouthAfrica",5,3,4), new Team("India",0,2,4), new Team("England",0,2,3)  };
    Solution s = new Solution();
    Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.sort(teams)));
  }

  @Test
  public void testCase5(){
    Team[] teams = {new Team("England",0,2,3)};
    Team[] res = {new Team("England",0,2,3)};
    Solution s = new Solution();
    Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.sort(teams)));
  }

  @Test
  public void testCase6(){
    Team[] teams = {new Team("England",10,14,1), new Team("India",10,14,2),new Team("Australia",10,14,3), new Team("SouthAfrica",10,14,4), new Team("Bangladesh",10,14,5), new Team("Zimbabwe",10,14,6), new Team("Ireland",10,14,7)};
    Team[] res = {new Team("Ireland",10,14,7),new Team("Zimbabwe",10,14,6), new Team("Bangladesh",10,14,5), new Team("SouthAfrica",10,14,4), new Team("Australia",10,14,3), new Team("India",10,14,2), new Team("England",0,2,3)};
    Solution s = new Solution();
    Assert.assertEquals(Arrays.toString(res), Arrays.toString(s.sort(teams)));
  }

}

