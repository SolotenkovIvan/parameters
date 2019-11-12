package homework.v3.entity;

import java.io.*;

/**
 * Например, ADMIN/USER/SUPER_VISOR & etc
 * */
public class Role implements Externalizable {
    
    public static final long SerialVersionUID = 1L;
    
    private String role;

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
