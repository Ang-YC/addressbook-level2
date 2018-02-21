package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void isAnyNull() throws Exception {
        Object array = new Integer[1];

        // Empty
        assertNoneNull();

        // Single null
        assertAnyNull((Object) null);

        // Single none null
        assertNoneNull("a");
        assertNoneNull(1);
        assertNoneNull(array);

        // Some null
        assertAnyNull(null, null);
        assertAnyNull(null, 1);
        assertAnyNull(1, null);
        assertAnyNull("a", 1, null, 2);

        // None null
        assertNoneNull("a", 1);
        assertNoneNull("a", array);
        assertNoneNull("a", "a", "a");
    }

    private void assertAnyNull(Object... items) {
        assertTrue(Utils.isAnyNull(items));
    }

    private void assertNoneNull(Object... items) {
        assertFalse(Utils.isAnyNull(items));
    }


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
