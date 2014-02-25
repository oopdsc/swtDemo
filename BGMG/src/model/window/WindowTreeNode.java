package model.window;

import java.util.List;

public abstract class WindowTreeNode {

	public abstract String getName();
    public abstract void setChildren(List<WindowTreeNode> Children);
    public abstract List<WindowTreeNode> getChildren();
    
}
