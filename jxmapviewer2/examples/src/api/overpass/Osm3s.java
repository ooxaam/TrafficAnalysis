package api.overpass;

import java.io.Serializable;

public class Osm3s implements Serializable{
    private static final long serialVersionUID = 8618992541808233422L;

    private String copyright;

    private String timestamp_osm_base;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getTimestamp_osm_base() {
        return timestamp_osm_base;
    }

    public void setTimestamp_osm_base(String timestamp_osm_base) {
        this.timestamp_osm_base = timestamp_osm_base;
    }

    @Override
    public String toString() {
        return "Osm3s [copyright=" + copyright + ", timestamp_osm_base=" + timestamp_osm_base + "]";
    }
}
