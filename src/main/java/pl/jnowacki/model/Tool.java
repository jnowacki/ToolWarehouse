package pl.jnowacki.model;

import java.io.Serializable;

public class Tool implements Serializable {

    private int id;
    private String name;
    private ToolType type;
    private boolean available;

    public Tool() {
    }

    public Tool(int id, String name, ToolType type, boolean available) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ToolType getType() {
        return type;
    }

    public void setType(ToolType type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
