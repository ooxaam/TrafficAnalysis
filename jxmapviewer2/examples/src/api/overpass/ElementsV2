package api.overpass;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public class ElementsV2 implements Serializable{
    private static final long serialVersionUID = -3463581484276587211L;

    private Type type;
    private long id;
    private String timestamp;
    private long version;
    private long changeset;
    private String user;
    private long uid;
    private long[] nodes;
    private Map<String, String> tags;

    @JsonProperty("type")
    public Type getType() {
        return type;
    }
    @JsonProperty("type")
    public void setType(Type value) {
        this.type = value;
    }

    @JsonProperty("id")
    public long getID() {
        return id;
    }
    @JsonProperty("id")
    public void setID(long value) {
        this.id = value;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }
    @JsonProperty("timestamp")
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

    @JsonProperty("version")
    public long getVersion() {
        return version;
    }
    @JsonProperty("version")
    public void setVersion(long value) {
        this.version = value;
    }

    @JsonProperty("changeset")
    public long getChangeset() {
        return changeset;
    }
    @JsonProperty("changeset")
    public void setChangeset(long value) {
        this.changeset = value;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }
    @JsonProperty("user")
    public void setUser(String value) {
        this.user = value;
    }

    @JsonProperty("uid")
    public long getUid() {
        return uid;
    }
    @JsonProperty("uid")
    public void setUid(long value) {
        this.uid = value;
    }

    @JsonProperty("nodes")
    public long[] getNodes() {
        return nodes;
    }
    @JsonProperty("nodes")
    public void setNodes(long[] value) {
        this.nodes = value;
    }

    @JsonProperty("tags")
    public Map<String, String> getTags() {
        return tags;
    }
    @JsonProperty("tags")
    public void setTags(Map<String, String> value) {
        this.tags = value;
    }
    @Override
    public String toString() {
        return "ElementsV2 [type=" + type + ", id=" + id + ", timestamp=" + timestamp + ", version=" + version
                + ", changeset=" + changeset + ", user=" + user + ", uid=" + uid + ", nodes=" + Arrays.toString(nodes)
                + ", tags=" + tags + "]";
    }
    
}
