import the.bytecode.club.bytecodeviewer.decompilers.bytecode.TypeAndName;
import static org.junit.jupiter.api.Assertions.*;

class TypeAndNameTest {

    @org.junit.jupiter.api.Test
    void classTest() {
        TypeAndName typeAndNameNull = new TypeAndName();
        TypeAndName typeAndNameNotNull = new TypeAndName();
        typeAndNameNotNull.name = "Test name";

        assertNull(typeAndNameNull.name);
        assertNull(typeAndNameNull.type);
        assertEquals("Test name", typeAndNameNotNull.name);
    }
}