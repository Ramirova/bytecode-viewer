package java;

import eu.bibl.banalysis.filter.InstructionFilter;
import org.junit.jupiter.api.Test;

import static eu.bibl.banalysis.filter.InstructionFilter.ACCEPT_ALL;
import static org.junit.jupiter.api.Assertions.*;

import jdk.internal.org.objectweb.asm.tree.InsnList;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.tree.AbstractInsnNode;
import the.bytecode.club.bytecodeviewer.decompilers.bytecode.InstructionPattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InstructionPatternTest {

    @Test
    void acceptFalse() {
        int[] opcodes = new int[2];
        opcodes[0] = 1;
        opcodes[1] = 2;
        InstructionPattern instructionPattern = new InstructionPattern(opcodes);

        AbstractInsnNode node = mock(AbstractInsnNode.class);
        assertFalse(instructionPattern.accept(node));
    }

    @Test
    void acceptTrue() {
        int[] opcodes = new int[2];
        opcodes[0] = 1;
        opcodes[1] = 2;
        InstructionPattern instructionPattern = new InstructionPattern(opcodes);
        instructionPattern.filters = new InstructionFilter[1];
        instructionPattern.filters[0] = ACCEPT_ALL;
        AbstractInsnNode node = mock(AbstractInsnNode.class);
        assertTrue(instructionPattern.accept(node));
    }

    @Test
    void getLastMatch() {
        int[] opcodes = new int[2];
        opcodes[0] = 1;
        opcodes[1] = 2;
        InstructionPattern instructionPattern = new InstructionPattern(opcodes);
        assertEquals(2, instructionPattern.lastMatch.length);
    }

    @Test
    void resetMatch() {
        int[] opcodes = new int[2];
        opcodes[0] = 1;
        opcodes[1] = 2;
        InstructionPattern instructionPattern = new InstructionPattern(opcodes);
        instructionPattern.filters = new InstructionFilter[1];
        instructionPattern.filters[0] = ACCEPT_ALL;
        AbstractInsnNode node = mock(AbstractInsnNode.class);
        instructionPattern.accept(node);
        instructionPattern.resetMatch();
        assertEquals(0, instructionPattern.pointer);
        assertEquals(2, instructionPattern.lastMatch.length);
    }

    @Test
    void reset() {
        int[] opcodes = new int[2];
        opcodes[0] = 1;
        opcodes[1] = 2;
        InstructionPattern instructionPattern = new InstructionPattern(opcodes);
        instructionPattern.filters = new InstructionFilter[1];
        instructionPattern.filters[0] = ACCEPT_ALL;
        AbstractInsnNode node = mock(AbstractInsnNode.class);
        instructionPattern.accept(node);
        instructionPattern.reset();
        assertEquals(0, instructionPattern.pointer);
    }

    @Test
    void translate() {
        int[] opcodes = new int[2];
        opcodes[0] = 1;
        opcodes[1] = 2;
        InstructionPattern instructionPattern = new InstructionPattern(opcodes);
        instructionPattern.filters = new InstructionFilter[1];
        instructionPattern.filters[0] = ACCEPT_ALL;
        AbstractInsnNode node = mock(AbstractInsnNode.class);
        instructionPattern.accept(node);
        ;
        assertEquals(InstructionFilter.ACCEPT_ALL, instructionPattern.translate(node));
    }
}