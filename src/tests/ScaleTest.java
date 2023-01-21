package tests;

import model.Button;
import model.Label;
import model.Panel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScaleTest {
    private Panel outer;
    private Panel inner;
    private Label lbl;
    private Button btn;

    @BeforeEach
    void runBefore() {
        outer = new Panel(0, 0, 16, 9);
        inner = new Panel(2, 1, 7, 6);
        lbl = new Label(4, 1, 4, 3);
        btn = new Button(1, 1, 1, 5);
    }

    @Test
    void testOneLevel() {
        outer.add(inner);
        outer.scale(2.0);
        assertEquals((int) (16 * 2.0), outer.getWidth());
        assertEquals((int) (9 * 2.0), outer.getHeight());
        assertEquals((int) (7 * 2), inner.getWidth());
        assertEquals((int) (6 * 2), inner.getHeight());
    }

    @Test
    void testMultipleScaleOps() {
        outer.add(inner);
        outer.scale(2.0);
        outer.scale(0.5);
        assertEquals((int) (16 * 2.0 * 0.5), outer.getWidth());
        assertEquals((int) (9 * 2.0 * 0.5), outer.getHeight());
        assertEquals((int) (7 * 2 * 0.5), inner.getWidth());
        assertEquals((int) (6 * 2 * 0.5), inner.getHeight());
    }

    @Test
    void testTwoLevelsMultipleSiblingsMultipleScaleOps() {
        outer.add(inner);
        inner.add(lbl);
        inner.add(btn);

        outer.scale(3.0);
        assertEquals((int) (4 * 3.0), lbl.getWidth());
        assertEquals((int) (3 * 3.0), lbl.getHeight());
        assertEquals((int) (1 * 3.0), btn.getWidth());
        assertEquals((int) (5 * 3.0), btn.getHeight());

        outer.scale(0.33);
        assertEquals((int) (4 * 3.0 * 0.33), lbl.getWidth());
        assertEquals((int) (3 * 3.0 * 0.33), lbl.getHeight());
        assertEquals((int) (1 * 3.0 * 0.33), btn.getWidth());
        assertEquals((int) (5 * 3.0 * 0.33), btn.getHeight());
    }
}