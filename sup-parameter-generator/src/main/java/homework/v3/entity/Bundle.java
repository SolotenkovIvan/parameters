package homework.v3.entity;

import java.io.*;
import java.util.List;

public class Bundle implements Externalizable {
    
    public static final long SerialVersionUID = 1L;
    
    private List<Path> path;
    private List<String> values;

    public List<Path> getPath() {
        return path;
    }
    public void setPath(List<Path> path) {
        this.path = path;
    }

    public List<String> getValues() {
        return values;
    }
    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Пишем поле с именем " + this.getPath() + " и значением " + this.getValues());
        out.writeObject(this.getPath());
        out.writeObject(this.getValues());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setPath(( List<Path>)in.readObject());
        this.setValues((List<String>)in.readObject());

    }
}
