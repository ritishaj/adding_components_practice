package model;

public abstract class Component {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Panel parent;

    public Component(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() { return x;}
    public int getY() { return height;}
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public Panel getParent() { return parent; }
    public void setParent(Panel p) { this.parent = p; }
    public boolean hasParent() { return parent != null; }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public void scale(double factor) {
        width = (int) (width * factor);
        height = (int) (height * factor);
    }
}