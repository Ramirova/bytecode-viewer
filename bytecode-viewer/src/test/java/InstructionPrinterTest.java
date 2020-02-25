import org.junit.jupiter.api.Test;
import org.objectweb.asm.tree.*;
import the.bytecode.club.bytecodeviewer.decompilers.bytecode.InstructionPrinter;
import the.bytecode.club.bytecodeviewer.decompilers.bytecode.TypeAndName;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InstructionPrinterTest {

    @Test
    void createPrint() {
        MethodNode methodNode = new MethodNode();
        InsnList insnList = new InsnList();
        AbstractInsnNode abstractInsnNode = new InsnNode(5);
        insnList.insert(abstractInsnNode);
        methodNode.instructions = insnList;
        TypeAndName[] typeAndName = new TypeAndName[1];
        TypeAndName typeAndNameExample  = new TypeAndName();
        typeAndNameExample.name = "Test";
        typeAndName[0] = typeAndNameExample;

        InstructionPrinter instructionPrinter = new InstructionPrinter(methodNode, typeAndName);
        ArrayList<String> print = instructionPrinter.createPrint();

        ArrayList<String> expectedResult = new  ArrayList<String>();
        expectedResult.add("    iconst_2");
        assertEquals(expectedResult, print);
    }

    @Test
    void saveTo() {
        MethodNode methodNode = new MethodNode();
        InsnList insnList = new InsnList();
        AbstractInsnNode abstractInsnNode = new InsnNode(5);
        insnList.insert(abstractInsnNode);
        methodNode.instructions = insnList;
        TypeAndName[] typeAndName = new TypeAndName[1];
        TypeAndName typeAndNameExample  = new TypeAndName();
        typeAndNameExample.name = "Test";
        typeAndName[0] = typeAndNameExample;

        File file = new File("temp.txt");

        InstructionPrinter instructionPrinter = new InstructionPrinter(methodNode, typeAndName);
        InstructionPrinter.saveTo(file, instructionPrinter);

        String result = "";
        try (BufferedReader br = Files.newBufferedReader(Paths.get("temp.txt"))) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        assertEquals("    iconst_2", result);
    }
}