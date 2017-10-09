package one.plu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimHashTest {
    SimHash simHash;

    @Test
    public void foo() {
        String s1 = "the cat sat on the mat";
        String s2 = "the cat sat on a mat";
        String s3 = "we all scream for ice cream";
        int hd1 = simHash.hammingDistance(simHash.simhash32(s1), simHash.simhash32(s2));
        int hd2 = simHash.hammingDistance(simHash.simhash32(s2), simHash.simhash32(s3));
        int hd3 = simHash.hammingDistance(simHash.simhash32(s1), simHash.simhash32(s3));
        System.out.println(hd1);
        System.out.println(hd2);
        System.out.println(hd3);

//       Assert.assertTrue();
    }

    @Test
    public void bar() {
        String s1 = "我爱你中国";
        String s2 = "我真的爱你中国";
        String s3 = "中国是世界上最强大的国家之一";

        int hd1 = simHash.hammingDistance(simHash.simhash32(s1), simHash.simhash32(s2));
        int hd2 = simHash.hammingDistance(simHash.simhash32(s2), simHash.simhash32(s3));
        int hd3 = simHash.hammingDistance(simHash.simhash32(s1), simHash.simhash32(s3));
        System.out.println(hd1);
        System.out.println(hd2);
        System.out.println(hd3);
    }


    @Test
    public void bar64() {
        String s1 = "我爱你中国";
        String s2 = "我真的爱你中国";
        String s3 = "中国是世界上最强大的国家之一";

        int hd1 = simHash.hammingDistance(simHash.simhash64(s1), simHash.simhash64(s2));
        int hd2 = simHash.hammingDistance(simHash.simhash64(s2), simHash.simhash64(s3));
        int hd3 = simHash.hammingDistance(simHash.simhash64(s1), simHash.simhash64(s3));
        System.out.println(hd1);
        System.out.println(hd2);
        System.out.println(hd3);
    }


    @Test
    public void test() {
        int hammingDistance = simHash.hammingDistance(simHash.simhash32("2648"), simHash.simhash32("2650"));
        System.out.println(hammingDistance);
    }

    @Test
    public void test_hamming_distance() {
        assertEquals(4, simHash.hammingDistance(0xFF, 0x55));
    }

    @Before
    public void init() {
        simHash = new SimHash();
    }

    @Test
    public void foobar() {

    }


}
