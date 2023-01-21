package tests;

import model.Button;
import model.Panel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// NOTE: this class is not complete.  The tests
// presented here test only one aspect of the Panel class
public class PanelTest {
    private Panel panelA;
    private Panel panelB;
    private Button button;

    @BeforeEach
    void runBefore() {
        panelA = new Panel(0, 0, 200, 350);
        panelB = new Panel(0, 375, 200, 100);
        button = new Button(0, 0, 50, 10);
    }

    @Test
    void testAddComponent() {
        panelA.add(button);
        assertTrue(panelA.contains(button));
    }

    @Test
    void testAddComponentAlreadyAdded() {
        panelA.add(button);
        panelB.add(button);
        assertFalse(panelA.contains(button));
        assertTrue(panelB.contains(button));
    }
}