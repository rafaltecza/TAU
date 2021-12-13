import com.alibaba.fastjson.annotation.JSONField;

public class Model {

    @JSONField(name = "Name")
    private String name;

    @JSONField(name = "Val")
    private int value;

    @JSONField(name = "Type")
    private boolean type;

    public Model(String name, int value, boolean type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
