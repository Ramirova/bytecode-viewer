import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import the.bytecode.club.bytecodeviewer.compilers.JavaCompiler;

import java.io.File;
import java.io.IOException;

public class JavaCompilerTest {

    @Test
    public void compileCorrectFile() throws IOException {
        JavaCompiler compiler = new JavaCompiler();
        File source = new File(getClass().getResource("/TestSourceCorrect.java").getFile());
        byte[] compiledBytes = compiler.compile(FileUtils.readFileToString(source), source.getName());

        File compiledSource = new File("/TestSourceCorrect.class");
        byte[] expectedBytes = compiler.compile(FileUtils.readFileToString(compiledSource), compiledSource.getName());

        Assertions.assertArrayEquals(expectedBytes, compiledBytes);

    }

    @Test
    public void compileFileWithError(){

    }
}
