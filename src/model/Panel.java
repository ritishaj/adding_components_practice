package model;

import java.util.ArrayList;
import java.util.List;

public class Panel extends Component {
    private List<Component> children;

    public Panel(int x, int y, int width, int height) {
        super(x, y, width, height);
        children = new ArrayList<>();
    }

    public boolean contains(Component c) {
        return children.contains(c);
    }

    public void add(Component c) {
        if (!(children.contains(c))) {
            if (c.hasParent()) {
                removeChildFromParent(c);
            }
            children.add(c);
            c.setParent(this);
        }
    }

    //EFFECTS: scales width and height by factor, truncates the result to an integer
    public void scale(double factor) {
        width = (int) (width * factor);
        height = (int) (height * factor);
        for (Component c : children) {
            c.scale(factor);
        }
    }

    public void removeChildFromParent(Component c) {
        if (c.hasParent()) {
            Panel oldParent = c.getParent();
            oldParent.children.remove(c);
        }
    }
}