package api.overpass;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;

public enum Type {
    WAY;

    @JsonValue
    public String toValue() {
        switch (this) {
            case WAY :
                return "way";
        }
        return null;
    }

    @JsonCreator
    public static Type forValue(String value) throws IOException {
        if (value.equals("way"))
            return WAY;
        throw new IOException("Cannot deserialize Type");
    }
}
