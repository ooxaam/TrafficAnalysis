package api.overpass;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tags {
    private String placement;
    private String lit;
    private String ref;
    private String surface;
    private String highway;
    private String bdouble;
    private String name;
    private String oneway;
    private String maxspeed;
    private String int_ref;
    private String lanes;
    private String smoothness;
    private String cycleway;
    private String sidewalk;
    private String destination;
    private String oldRef;
    private String destinationDistanceLanes;
    private String destinationLanes;
    private String destinationRefLanes;
    private String destinationRef;
    private String destinationSymbol;
    private String turnLanes;
    private String osmarenderNameDirection;
    private String overtaking;
    private String sourceMaxspeed;
    private String hgv;
    private String zoneTraffic;
    private String hazard;
    private String noteName;
    private String placementStart;
    private String regName;
    private String foot;
    private String footway;
    private String horse;
    private String tracktype;
    private String bicycle;
    private String cyclewayBoth;
    private String sourceDestination;
    
    @JsonProperty("source:destination")
    public String getSourceDestination() { return sourceDestination; }
    @JsonProperty("source:destination")
    public void setSourceDestination(String value) { this.sourceDestination = value; }
    
    @JsonProperty("cycleway:both")
    public String getCyclewayBoth() { return cyclewayBoth; }
    @JsonProperty("cycleway:both")
    public void setCyclewayBoth(String value) { this.cyclewayBoth = value; }
    
    @JsonProperty("bicycle")
    public String getBicycle() { return bicycle; }
    @JsonProperty("bicycle")
    public void setBicycle(String value) { this.bicycle = value; }
    
    @JsonProperty("horse")
    public String getHorse() { return horse; }
    @JsonProperty("horse")
    public void setHorse(String value) { this.horse = value; }
    
    @JsonProperty("tracktype")
    public String getTracktype() { return tracktype; }
    @JsonProperty("tracktype")
    public void setTracktype(String value) { this.tracktype = value; }
    
    @JsonProperty("foot")
    public String getFoot() {
        return foot;
    }

    @JsonProperty("foot")
    public void setFoot(String value) {
        this.foot = value;
    }

    @JsonProperty("footway")
    public String getFootway() {
        return footway;
    }
    
    @JsonProperty("footway")
    public void setFootway(String value) {
        this.footway = value;
    }
    
    @JsonProperty("note:name")
    public String getNoteName() {
        return noteName;
    }
    
    @JsonProperty("note:name")
    public void setNoteName(String value) {
        this.noteName = value;
    }

    @JsonProperty("placement:start")
    public String getPlacementStart() {
        return placementStart;
    }
    
    @JsonProperty("placement:start")
    public void setPlacementStart(String value) {
        this.placementStart = value;
    }

    @JsonProperty("reg_name")
    public String getRegName() {
        return regName;
    }
    
    @JsonProperty("reg_name")
    public void setRegName(String value) {
        this.regName = value;
    }
    
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

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getLit() {
        return lit;
    }

    public void setLit(String lit) {
        this.lit = lit;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getBdouble() {
        return bdouble;
    }

    public void setBdouble(String bdouble) {
        this.bdouble = bdouble;
    }

    public String getInt_ref() {
        return int_ref;
    }

    public void setInt_ref(String int_ref) {
        this.int_ref = int_ref;
    }

    public String getLanes() {
        return lanes;
    }

    public void setLanes(String lanes) {
        this.lanes = lanes;
    }

    public String getSmoothness() {
        return smoothness;
    }

    public void setSmoothness(String smoothness) {
        this.smoothness = smoothness;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCycleway() {
        return cycleway;
    }

    public void setCycleway(String cycleway) {
        this.cycleway = cycleway;
    }

    public String getSidewalk() {
        return sidewalk;
    }

    public void setSidewalk(String sidewalk) {
        this.sidewalk = sidewalk;
    }

    @JsonProperty("destination:distance:lanes")
    public String getDestinationDistanceLanes() {
        return destinationDistanceLanes;
    }
    
    @JsonProperty("destination:distance:lanes")
    public void setDestinationDistanceLanes(String value) {
        this.destinationDistanceLanes = value;
    }

    @JsonProperty("destination:lanes")
    public String getDestinationLanes() {
        return destinationLanes;
    }
    
    @JsonProperty("destination:lanes")
    public void setDestinationLanes(String value) {
        this.destinationLanes = value;
    }

    @JsonProperty("destination:ref")
    public String getDestinationRef() {
        return destinationRef;
    }
    
    @JsonProperty("destination:ref")
    public void setDestinationRef(String value) {
        this.destinationRef = value;
    }
    
    @JsonProperty("turn:lanes")
    public String getTurnLanes() {
        return turnLanes;
    }
    
    @JsonProperty("turn:lanes")
    public void setTurnLanes(String value) {
        this.turnLanes = value;
    }
    
    @JsonProperty("destination:ref:lanes")
    public String getDestinationRefLanes() {
        return destinationRefLanes;
    }
    
    @JsonProperty("destination:ref:lanes")
    public void setDestinationRefLanes(String value) {
        this.destinationRefLanes = value;
    }
    
    @JsonProperty("destination:symbol")
    public String getDestinationSymbol() {
        return destinationSymbol;
    }
    
    @JsonProperty("destination:symbol")
    public void setDestinationSymbol(String value) {
        this.destinationSymbol = value;
    }
    
    @JsonProperty("old_ref")
    public String getOldRef() {
        return oldRef;
    }

    @JsonProperty("old_ref")
    public void setOldRef(String oldRef) {
        this.oldRef = oldRef;
    }

    @JsonProperty("osmarender:nameDirection")
    public String getOsmarenderNameDirection() {
        return osmarenderNameDirection;
    }
    
    @JsonProperty("osmarender:nameDirection")
    public void setOsmarenderNameDirection(String value) {
        this.osmarenderNameDirection = value;
    }
    
    @JsonProperty("overtaking")
    public String getOvertaking() {
        return overtaking;
    }
    
    @JsonProperty("overtaking")
    public void setOvertaking(String value) {
        this.overtaking = value;
    }
    
    @JsonProperty("source:maxspeed")
    public String getSourceMaxspeed() {
        return sourceMaxspeed;
    }
    
    @JsonProperty("source:maxspeed")
    public void setSourceMaxspeed(String value) {
        this.sourceMaxspeed = value;
    }
    
    @JsonProperty("hgv")
    public String getHgv() {
        return hgv;
    }

    @JsonProperty("hgv")
    public void setHgv(String value) {
        this.hgv = value;
    }

    @JsonProperty("zone:traffic")
    public String getZoneTraffic() {
        return zoneTraffic;
    }

    @JsonProperty("zone:traffic")
    public void setZoneTraffic(String value) {
        this.zoneTraffic = value;
    }
    
    @JsonProperty("hazard")
    public String getHazard() {
        return hazard;
    }

    @JsonProperty("hazard")
    public void setHazard(String value) {
        this.hazard = value;
    }

    @Override
    public String toString() {
        return "Tags [placement=" + placement + ", lit=" + lit + ", ref=" + ref + ", surface=" + surface + ", highway="
                + highway + ", bdouble=" + bdouble + ", name=" + name + ", oneway=" + oneway + ", maxspeed=" + maxspeed
                + ", int_ref=" + int_ref + ", lanes=" + lanes + ", smoothness=" + smoothness + ", cycleway=" + cycleway
                + ", sidewalk=" + sidewalk + ", destination=" + destination + ", destinationDistanceLanes="
                + destinationDistanceLanes + ", destinationLanes=" + destinationLanes + ", destinationRefLanes="
                + destinationRefLanes + ", destinationRef=" + destinationRef + ", destinationSymbol="
                + destinationSymbol + ", turnLanes=" + turnLanes + "]";
    }
}
