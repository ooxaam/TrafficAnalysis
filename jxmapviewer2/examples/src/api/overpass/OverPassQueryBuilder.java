package api.overpass;

public class OverPassQueryBuilder {
	private static final String URL = "https://lz4.overpass-api.de/api/interpreter?data=";
	// u can try out:json as well;
	private static final String OUTPUTFORMAT = "[out:json];";
	private static final String IDEAL_FILTER_TAGS = "way[\"highway\"~\"residential|primary|tertiary|living_street|motorway|service\"]";
	private static final String RESIDENTAIL_TAG = "way[highway=residential]";
	private static final String PRIMARY_TAG = "way[highway=primary]";
	private static final String TERTIARY_TAG = "way[highway=tertiary]";
	private static final String LIVING_STREET_TAG = "way[highway=living_street]";
	private static final String MOTOWAY_TAG = "way[highway=motorway]";
	private static final String SERVICE_TAG = "way[highway=service]";
	private static final String SECONDARY_TAG = "way[highway=secondary]";
	
	private static final String POSITION = "out%20meta;";
	
	public static String query(String boundingBox) {
		return URL + OUTPUTFORMAT + RESIDENTAIL_TAG + "(" + boundingBox + ");" + POSITION;
	}
}
