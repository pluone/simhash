package one.plu;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class PlaceNameParserTest {
    @Test
    public void foo() {
        Assert.assertEquals(new HashSet(Arrays.asList("北京市,昌平区")), PlaceNameParser.parse("昌平区"));
    }
}
