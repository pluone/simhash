package one.plu;

import org.ansj.splitWord.analysis.ToAnalysis;
import org.junit.Assert;
import org.junit.Test;

public class AnsgSegTest {
    @Test
    public void test() {
        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        System.out.println(ToAnalysis.parse(str));

        String expectedResult = "欢迎/v,使用/v,ansj/en,_,seg/en,,,(,ansj/en,中文/nz,分词/n,),在/p,这里/r,如果/c,你/r,遇到/v,什么/r,问题/n,都/d,可以/v,联系/v,我/r,./m,我/r,一定/d,尽我所能/l,./m,帮助/v,大家/r,./m,ansj/en,_,seg/en,更快/d,,,更/d,准/a,,,更/d,自由/a,!";
        Assert.assertEquals(expectedResult, new SimHash().wordSeg(ToAnalysis.parse(str).getTerms()));
    }
}
