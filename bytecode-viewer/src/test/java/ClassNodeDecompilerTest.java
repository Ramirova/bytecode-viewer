import org.objectweb.asm.tree.ClassNode;

import the.bytecode.club.bytecodeviewer.decompilers.bytecode.ClassNodeDecompiler;
import static org.junit.jupiter.api.Assertions.*;

class ClassNodeDecompilerTest {

    @org.junit.jupiter.api.Test
    void decompileClassNode() {
        ClassNodeDecompiler decompiler = new ClassNodeDecompiler();
        ClassNode classNode = new ClassNode(458752);
        classNode.name = "Test";
        byte[] b = hexStringToByteArray("e04fd020ea3a6910a2d808002b30309d");

        String s = decompiler.decompileClassNode(classNode, b);
        assertEquals("class Test {\n" + "     <ClassVersion=0>\n" + "}", s);
   }

    @org.junit.jupiter.api.Test
    void getAccessString() {
        String s = ClassNodeDecompiler.getAccessString(100);
        assertEquals("protected class", s);
    }

    @org.junit.jupiter.api.Test
    void decompileToZip() {
        ClassNodeDecompiler decompiler = new ClassNodeDecompiler();

        decompiler.decompileToZip("123", "zipName");
        assertFalse(new ClassNodeDecompiler().equals(decompiler));
    }

    private byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}