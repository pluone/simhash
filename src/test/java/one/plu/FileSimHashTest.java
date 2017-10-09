package one.plu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class FileSimHashTest {
    FileSimHash fileSimHash;
    @Before
    public void init() {
        fileSimHash = new FileSimHash();
    }
    @Test
    public void foo() throws IOException {
        List<Long> foo = fileSimHash.getFileLinesSimHashList();
        Assert.assertEquals(null, foo);
    }

    @Test
    public void getMapTest() throws IOException {
        Map map = fileSimHash.getMap();
        Assert.assertEquals(9, map.size());
        Assert.assertEquals(null, map);
    }
    @Test
    public void getSortedMapTest() throws IOException {
        Map map = fileSimHash.getSortedMap();
        Assert.assertEquals(9, map.size());
        Assert.assertEquals(null, map);
    }

    @Test
    public void bar() throws IOException {
        List<Long> hammingDistance = fileSimHash.getHammingDistance((SortedMap) fileSimHash.getSortedMap());
        Assert.assertEquals(null, hammingDistance);
    }
}
