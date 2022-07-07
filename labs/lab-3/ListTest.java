import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class ListTest {

    
    // Empty List
    // This is the starting point.  This tests to that a newly created list
    // contains no data.
    //
    @Test
    public void emptyList() {
        LinkedList.List<Integer> list  = new LinkedList.List<Integer>();
        
        assertNotNull(list);
        assertNull(LinkedList.next(list));
        assertNull(LinkedList.advance(list, 1));
        assertNull(LinkedList.at(list, 1));
        assertNull(LinkedList.item(list));
        assertEquals(0, LinkedList.length(list));
        assertEquals(true, LinkedList.empty(list));
    }


    // Append
    // This tests verifies that the append function adds items to the end of the
    // list.  It does test a number of functions as a side effect. 
    @Test
    public void append() {
       
        LinkedList.List<Integer> list  = new LinkedList.List<Integer>();

        for(int i = 0; i < 6; ++i)  {
            LinkedList.append(list, i);
        }
        
        assertNotNull(list);
        assertNotNull(LinkedList.next(list));
        assertNotNull(LinkedList.advance(list, 1));

        for(int i = 0; i < 6; ++i)  {
            assertEquals(i, LinkedList.at(list, i));
        }


        LinkedList.List<Integer> rest = list;
        int i = 0;
        while(!LinkedList.empty(rest)) {
            assertEquals(i, LinkedList.item(rest));
            rest = LinkedList.next(rest);
            ++i;
        }
    }

    // Prepend
    // Like append, above, this functions ensures that prepend adds data to the
    // front of the list and it also tests a number of list functions in
    // the process. 
    @Test
    public void prepend() {
        LinkedList.List<Integer> list  = new LinkedList.List<Integer>();

        for(int i = 0; i < 6; ++i)  {
            LinkedList.prepend(list, 5 - i);
        }
        
        assertNotNull(list);
        assertNotNull(LinkedList.next(list));
        assertNotNull(LinkedList.advance(list, 1));

        for(int i = 0; i < 6; ++i)  {
            assertEquals(i, LinkedList.at(list, i));
        }


        LinkedList.List<Integer> rest = list;
        int i = 0;
        while(!LinkedList.empty(rest)) {
            assertEquals(i, LinkedList.item(rest));
            rest = LinkedList.next(rest);
            ++i;
        }
    }

    // Empty
    // This tests that the empty predicate is working
    @Test
    public void empty() {
        LinkedList.List<Integer> list  = new LinkedList.List<Integer>();

        assertNotNull(list);
        assertTrue(LinkedList.empty(list));
        LinkedList.append(list, 1);
        assertFalse(LinkedList.empty(list));
    }

    // Remove
    // This tests that remove will remove data from the front of the list.
    @Test
    public void remove() {
        LinkedList.List<Integer> list  = new LinkedList.List<Integer>();

        assertNotNull(list);
        assertTrue(LinkedList.empty(list));
        LinkedList.append(list, 1);
        assertFalse(LinkedList.empty(list));
        LinkedList.append(list, 2);
        assertEquals(1, LinkedList.item(list));
        LinkedList.remove(list);
        assertEquals(2, LinkedList.item(list));
        LinkedList.remove(list);
        assertTrue(LinkedList.empty(list));
    }

    // Advance
    // The test ensures that the advance function returns the correct sub-list.
    @Test
    public void advance() {
        
        LinkedList.List<Integer> list  = new LinkedList.List<Integer>();

        for(int i = 0; i < 6; ++i)  {
            LinkedList.append(list, i);
        }
        
        assertNotNull(list);
        assertNotNull(LinkedList.next(list));
        assertNotNull(LinkedList.advance(list, 1));

        for(int i = 0; i < 6; ++i)  {
            assertEquals(i, LinkedList.at(list, i));
        }


        LinkedList.List<Integer> rest = list;
        for(int i = 0; i < 6; ++i) {
            assertEquals(i, LinkedList.item(LinkedList.advance(list, i)));
        }
        assertNull(LinkedList.item(LinkedList.advance(list, 6)));
    }

    // Length
    // Check to ensure that the length function returns the length of the list. 
    @Test
    public void length() {
        
        LinkedList.List<Integer> list  = new LinkedList.List<Integer>();

        for(int i = 0; i < 6; ++i)  {
            assertEquals(i, LinkedList.length(list));
            LinkedList.append(list, i);
        }
        assertEquals(6, LinkedList.length(list));
    }
}
