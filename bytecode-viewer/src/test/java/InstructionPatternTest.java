import eu.bibl.banalysis.filter.InstructionFilter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.objectweb.asm.tree.AbstractInsnNode;
import the.bytecode.club.bytecodeviewer.decompilers.bytecode.InstructionPattern;
import static org.mockito.Mockito.mock;

class InstructionPatternTest {

    @Test
    void acceptFalseTest() {
        int[] opcodes = new int[2];
        opcodes[0] = 1;
        opcodes[1] = 2;
        InstructionPattern instructionPattern = new InstructionPattern(opcodes);

        AbstractInsnNode node = mock(AbstractInsnNode.class);
        assertFalse(instructionPattern.accept(node));
    }

    @Test
    void getLastMatch() {
        int[] opcodes = new int[2];
        opcodes[0] = 1;
        opcodes[1] = 2;
        InstructionPattern instructionPattern = new InstructionPattern(opcodes);
        assertEquals(2, instructionPattern.getLastMatch().length);
    }

    @Test
    void resetMatch() {
        int[] opcodes = new int[2];
        opcodes[0] = 1;
        opcodes[1] = 2;
        InstructionPattern instructionPattern = new InstructionPattern(opcodes);

        AbstractInsnNode node = mock(AbstractInsnNode.class);
        instructionPattern.accept(node);
        instructionPattern.resetMatch();
        assertEquals(2, instructionPattern.getLastMatch().length);
    }

    @Test
    void reset() {
        int[] opcodes = new int[2];
        opcodes[0] = 1;
        opcodes[1] = 2;
        InstructionPattern instructionPattern = new InstructionPattern(opcodes);

        AbstractInsnNode node = mock(AbstractInsnNode.class);
        instructionPattern.accept(node);
        instructionPattern.reset();
        assertEquals(2, instructionPattern.getLastMatch().length);
    }

    @Test
    void translate() {
        int[] opcodes = new int[2];
        opcodes[0] = 1;
        opcodes[1] = 2;
        InstructionPattern instructionPattern = new InstructionPattern(opcodes);
        AbstractInsnNode node = mock(AbstractInsnNode.class);
        instructionPattern.accept(node);
        assertEquals(InstructionFilter.ACCEPT_ALL, InstructionPattern.translate(node));
    }
}