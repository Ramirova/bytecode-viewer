import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import the.bytecode.club.bytecodeviewer.BytecodeViewer;
import the.bytecode.club.bytecodeviewer.decompilers.bytecode.MethodNodeDecompiler;
import the.bytecode.club.bytecodeviewer.decompilers.bytecode.PrefixedStringBuilder;

import java.io.File;
import java.io.IOException;

import static org.mockito.Mockito.mock;

public class MethodNodeDecompilerTest {


    @Test
    //Depends on gui, that is not instantiated
    public void decompileTest() throws IOException {
        File source = new File("../bytecode-viewer/bytecode-viewer/src/test/resources/TestSourceCorrect.class");
        ClassReader classReader = new ClassReader(FileUtils.readFileToByteArray(source));
        ClassNode classNode = new ClassNode();
        classReader.accept(classNode, ClassReader.SKIP_DEBUG);
        MethodNode methodNode = classNode.methods.get(0);
        PrefixedStringBuilder stringBuilder = MethodNodeDecompiler.decompile(new PrefixedStringBuilder(), methodNode, classNode);
        Assertions.assertNotNull(stringBuilder.toString());
    }
}
