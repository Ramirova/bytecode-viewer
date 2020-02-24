import org.junit.jupiter.api.Assertions;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;
import jd.core.model.instruction.bytecode.instruction.Instruction;
import org.junit.jupiter.api.Test;
import the.bytecode.club.bytecodeviewer.decompilers.bytecode.InstructionPattern;
import the.bytecode.club.bytecodeviewer.decompilers.bytecode.InstructionSearcher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class instructionSearcher {

    @Test
    public void getSizeTest(){
        InstructionSearcher searcher = new InstructionSearcher(mock(InsnList.class),mock(InstructionPattern.class));
        Assertions.assertEquals(0, searcher.size());
    }

    @Test
    public void successSearchTest(){
        InstructionPattern pattern = mock(InstructionPattern.class);
        when(pattern.accept(any())).thenReturn(true);

        InsnList list = mock(InsnList.class);
        when(list.toArray()).thenReturn(new AbstractInsnNode[]{mock(AbstractInsnNode.class)});
        InstructionSearcher searcher = new InstructionSearcher(list,pattern);
        Assertions.assertTrue(searcher.search());
    }

    @Test
    public void failSearchTest(){
        InstructionPattern pattern = mock(InstructionPattern.class);
        when(pattern.accept(any())).thenReturn(false);

        InsnList list = mock(InsnList.class);
        when(list.toArray()).thenReturn(new AbstractInsnNode[]{mock(AbstractInsnNode.class)});
        InstructionSearcher searcher = new InstructionSearcher(list, pattern);
        Assertions.assertFalse(searcher.search());
    }
}
