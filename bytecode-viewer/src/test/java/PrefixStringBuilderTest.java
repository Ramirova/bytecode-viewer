import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import the.bytecode.club.bytecodeviewer.decompilers.bytecode.PrefixedStringBuilder;

public class PrefixStringBuilderTest {


    @Test
    public void appendPrefixTest(){
        PrefixedStringBuilder stringBuilder = new PrefixedStringBuilder();
        stringBuilder.appendPrefix("prefix");
        Assertions.assertEquals("prefix", stringBuilder.getPrefix());
    }

    @Test
    public void trimPrefixTest(){
        PrefixedStringBuilder stringBuilder = new PrefixedStringBuilder();
        stringBuilder.appendPrefix("prefix");
        stringBuilder.trimPrefix(1);
        Assertions.assertEquals("prefi", stringBuilder.getPrefix());
    }

    @Test
    public void trimNullPrefixTest(){
        PrefixedStringBuilder stringBuilder = new PrefixedStringBuilder();
        stringBuilder.trimPrefix(1);
        Assertions.assertNull(stringBuilder.getPrefix());
    }

    @Test
    public void trimAllPrefixTest(){
        PrefixedStringBuilder stringBuilder = new PrefixedStringBuilder();
        stringBuilder.appendPrefix("prefix");
        stringBuilder.trimPrefix(100);
        Assertions.assertEquals("prefix", stringBuilder.getPrefix());
    }

    @Test
    public void toStringTest(){
        PrefixedStringBuilder stringBuilder = new PrefixedStringBuilder();
        stringBuilder.appendPrefix("prefix");
        Assertions.assertEquals("prefix", stringBuilder.toString());

    }

    @Test
    public void appendStringTest(){
        PrefixedStringBuilder stringBuilder = new PrefixedStringBuilder();
        stringBuilder.setPrefix("prefix");
        stringBuilder = stringBuilder.append("pre\n");
        Assertions.assertEquals("pre\nprefix", stringBuilder.toString());
    }

    @Test
    public void appendObjectTest(){
        PrefixedStringBuilder stringBuilder = new PrefixedStringBuilder();
        stringBuilder.setPrefix("prefix");
        stringBuilder = stringBuilder.append((Object) "pre\n");
        Assertions.assertEquals("pre\nprefix", stringBuilder.toString());
    }
}
