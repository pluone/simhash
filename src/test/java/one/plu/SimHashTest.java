package one.plu;

import org.junit.Assert;
import org.junit.Test;

public class SimHashTest {
   @Test
   public void foo() {
       String s1 = "the cat sat on the mat";
       String s2 = "the cat sat on a mat";
       String s3 = "we all scream for ice cream";

       String s1_simHash = SimHash.calcSimHash(s1);
       String s2_simHash = SimHash.calcSimHash(s2);
       String s3_simHash = SimHash.calcSimHash(s3);


       Assert.assertEquals(4,SimHash.hammingDistance(s1_simHash, s2_simHash));
       Assert.assertEquals(16,SimHash.hammingDistance(s1_simHash, s3_simHash));
       Assert.assertEquals(12,SimHash.hammingDistance(s2_simHash, s3_simHash));
   }


}
