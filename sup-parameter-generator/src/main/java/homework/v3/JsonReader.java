package homework.v3;

import homework.v3.entity.JsonFileClass;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    public JsonFileClass read(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        final JsonFileClass jsonFileClass = mapper.readValue(new File(url), JsonFileClass.class);
        return jsonFileClass;
    }
}
