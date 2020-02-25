import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.FieldNode;
import the.bytecode.club.bytecodeviewer.decompilers.bytecode.FieldNodeDecompiler;
import the.bytecode.club.bytecodeviewer.decompilers.bytecode.PrefixedStringBuilder;

import static org.mockito.Mockito.mock;


public class FieldNodeDecompilerTest {

    @Test
    public void decompileNonNullValueTest(){
        PrefixedStringBuilder builder = new PrefixedStringBuilder();
        FieldNode node = mock(FieldNode.class);
        node.value = "String";
        node.access = Opcodes.ACC_PUBLIC;
        node.name = "name";
        node.desc = Type.getDescriptor(String.class);

        String actualResult = FieldNodeDecompiler.decompile(builder, node).toString();
        Assertions.assertEquals("public java.lang.String name = \"String\";", actualResult);
    }

    @Test
    public void decompileNullValueTest(){
        PrefixedStringBuilder builder = new PrefixedStringBuilder();
        FieldNode node = mock(FieldNode.class);
        node.value = null;
        node.access = Opcodes.ACC_PUBLIC;
        node.name = "name";
        node.desc = Type.getDescriptor(String.class);

        String actualResult = FieldNodeDecompiler.decompile(builder, node).toString();
        Assertions.assertEquals("public java.lang.String name;", actualResult);
    }
}
