import Container.IntContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Тесты для класса IntContainer.
 */
public class IntContainerTest {
    IntContainer container = new IntContainer();

    @BeforeEach
    void begin() {
        container.add(1);
        container.add(2);
        container.add(3);
    }

    @Test
    void addAndGet() {
        assertEquals(1, container.get(0));
        assertEquals(2, container.get(1));
        assertEquals(3, container.get(2));
    }

    @Test
    void remove() {
        assertEquals(2, container.remove(1));
        assertEquals(1, container.get(0));
        assertEquals(3, container.get(1));
        assertEquals(2, container.size());
    }

    @Test
    void size() {
        assertEquals(3, container.size());
        container.add(1);
        assertEquals(4, container.size());
    }

    @Test
    void resize() {
        for (int i = 0; i < 8; i++)
            container.add(i);
        assertEquals(11, container.size());
        assertEquals(6, container.get(9));
        assertEquals(7, container.get(10));
    }

    @Test
    void getOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(13));
    }

    @Test
    void removeOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(13));
    }
}
