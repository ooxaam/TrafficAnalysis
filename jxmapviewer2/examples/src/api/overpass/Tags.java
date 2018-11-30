package api.overpass;

public class Tags {
    private String surface;
    
    private String highway;

    private String name;

    private String oneway;
    
    private String maxspeed;
    
    public String getHighway() {
        return highway;
    }

    public void setHighway(String highway) {
        this.highway = highway;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getOneway() {
        return oneway;
    }

    public void setOneway(String oneway) {
        this.oneway = oneway;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getMaxspeed() {
        return maxspeed;
    }

    public void setMaxspeed(String maxspeed) {
        this.maxspeed = maxspeed;
    }

    @Override
    public String toString() {
        return "Tags [surface=" + surface + ", highway=" + highway + ", name=" + name + ", oneway=" + oneway
                + ", maxspeed=" + maxspeed + "]";
    }
}
