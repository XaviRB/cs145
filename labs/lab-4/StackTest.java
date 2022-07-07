import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import my.Stack;

public class StackTest {

    // Empty Stack
    //
    @Test
    public void emptyStack() {

        Stack<Integer> q = new Stack<Integer>();

        assertNotNull(q);
        assertTrue(q.empty());
        assertNull(q.peek());
        assertNull(q.remove());
    }

    // Simple Stack
    //
    @Test
    public void simpleStack() {

        Stack<Integer> q = new Stack<Integer>();

        assertNotNull(q);
        assertTrue(q.empty());

        q.add(0);
        assertFalse(q.empty());

        assertEquals(q.remove(), 0);

        assertTrue(q.empty());
    }

    // Order Stack
    //
    @Test
    public void orderStack() {

        Stack<Integer> q = new Stack<Integer>();

        assertNotNull(q);
        assertTrue(q.empty());

        for(int i = 0; i < 10; ++i) {
            q.add(i);
        }

        for(int i = 0; i < 10; ++i) {
            assertFalse(q.empty());
            assertEquals(q.remove(), 9-i);
        }

        assertTrue(q.empty());
    }

    // Peek Stack
    //
    @Test
    public void peekStack() {

        Stack<Integer> q = new Stack<Integer>();

        assertNotNull(q);

        for(int i = 0; i < 10; ++i) {
            q.add(i);
        }

        for(int i = 0; i < 10; ++i) {
            assertEquals(q.peek(), 9-i);
            q.remove();
        }
    }
}
