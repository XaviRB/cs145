import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import my.Queue;

public class QueueTest {
    // Empty Stack
    //
    @Test
    public void emptyQueue() {

        Queue<Integer> q = new Queue<Integer>();
        assertNotNull(q);
        assertTrue(q.empty());
        assertNull(q.peek());
        assertNull(q.remove());
    }
    // Simple Stack
    //
    @Test
    public void simpleQueue() {
        Queue<Integer> q = new Queue<Integer>();
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
    public void orderQueue() {
        Queue<Integer> q = new Queue<Integer>();
        assertNotNull(q);
        assertTrue(q.empty());
        for(int i = 0; i < 10; ++i) {
            q.add(i);
        }
        for(int i = 0; i < 10; ++i) {
            assertFalse(q.empty());
            assertEquals(q.remove(), i);
        }
        assertTrue(q.empty());
    }
    // Peek Stack
    //
    @Test
    public void peekQueue() {
        Queue<Integer> q = new Queue<Integer>();
        assertNotNull(q);
        for(int i = 0; i < 10; ++i) {
            q.add(i);
        }
        for(int i = 0; i < 10; ++i) {
            assertEquals(q.peek(), i);
            q.remove();
        }
    }
}
