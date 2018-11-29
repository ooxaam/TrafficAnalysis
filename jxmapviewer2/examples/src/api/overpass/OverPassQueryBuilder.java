package api.overpass;

public class OverPassQueryBuilder {
	private static final String url = "https://lz4.overpass-api.de/api/interpreter?data=";
	// u can try out:json as well;
	private static final String outputFormat = "[out:xml];";
	private static final String filterTags = "way[\"highway\"~\"residential|primary|tertiary|living_street|motorway|service\"]";
	private static final String position = "out%20meta;";
	
	public static String query(String boundingBox) {
		return url + outputFormat + filterTags + "(" + boundingBox + ");" + position;
	}
}
