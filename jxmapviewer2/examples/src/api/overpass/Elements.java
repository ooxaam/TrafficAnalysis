package api.overpass;

import java.util.Arrays;

public class Elements {
    private Tags tags;

    private String uid;

    private String timestamp;

    private String id;

    private String[] nodes;

    private String type;

    private String user;

    private String changeset;

    private String version;

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getNodes() {
        return nodes;
    }

    public void setNodes(String[] nodes) {
        this.nodes = nodes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getChangeset() {
        return changeset;
    }

    public void setChangeset(String changeset) {
        this.changeset = changeset;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Elements [tags=" + tags + ", uid=" + uid + ", timestamp=" + timestamp + ", id=" + id + ", nodes="
                + Arrays.toString(nodes) + ", type=" + type + ", user=" + user + ", changeset=" + changeset
                + ", version=" + version + "]";
    }
}
