package util;

import static api.overpass.OverPassQueryBuilder.query;
import static java.lang.String.valueOf;
import static java.util.Arrays.stream;

import api.overpass.ElementsV2;
import api.overpass.OverPassResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactory;

/**
 * The Class BusinessUtil.
 *
 * @author NaumanH
 * 
 * Nov 29, 2018
 */
public class BusinessUtil {
    
    /**
     * Gets the bounds as a set of two <code>GeoPosition</code> objects.
     * @param mapViewer The map viewer.
     * @return Returns the set of two <code>GeoPosition</code> objects that represent the north west and south east
     * corners of the map.
     */
    public static Set<GeoPosition> getMapGeoBounds(JXMapViewer mapViewer)
    {
        Set<GeoPosition> set = new HashSet<GeoPosition>();
        TileFactory tileFactory = mapViewer.getTileFactory();
        int zoom = mapViewer.getZoom();
        Rectangle2D bounds = mapViewer.getViewportBounds();
        Point2D pt = new Point2D.Double(bounds.getX(), bounds.getY());
        set.add(tileFactory.pixelToGeo(pt, zoom));
        pt = new Point2D.Double(bounds.getX() + bounds.getWidth(), bounds.getY() + bounds.getHeight());
        set.add(tileFactory.pixelToGeo(pt, zoom));
        return set;
    }
    
    public static void calculateBoundingBox(Set<GeoPosition> bound) {
        String bbox = geoPositionToBbox(bound);
        final String query = query(bbox);
        System.out.println(query);
        HttpGet request = new HttpGet(query);
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpResponse response = client.execute(request);
            System.out.println(response.toString());

            ObjectMapper objectMapper = new ObjectMapper();
            OverPassResponse jsonToPojo = objectMapper.readValue(response.getEntity().getContent(), OverPassResponse.class);

            //System.out.println(jsonToPojo.toString());
            writeToFile(jsonToPojo);

            fetchWayRelations(jsonToPojo, 5618281558L);
            //readWriteSample(jsonToPojo);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

	private static ElementsV2 fetchWayRelations(OverPassResponse jsonToPojo, long wayId) {
		return stream(jsonToPojo.getElements()).filter(o -> o.getID() == wayId).findFirst().orElse(null);
	}

	public static void readWriteSample(OverPassResponse jsonToPojo)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        FileOutputStream f = new FileOutputStream(new File("D://myObjects.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        o.writeObject(jsonToPojo);

        o.close();
        f.close();

        FileInputStream fi = new FileInputStream(new File("D://myObjects.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        OverPassResponse pr1 = (OverPassResponse) oi.readObject();

        System.out.println(pr1.toString());

        oi.close();
        fi.close();
    }
    
    private static void writeToFile(OverPassResponse jsonToPojo) throws IOException {
        try (FileWriter file = new FileWriter("D://file1.osm")) {
            file.write(jsonToPojo.toString());
            System.out.println("Successfully Copied JSON Object to File...");
        }
    }

    private static String geoPositionToBbox(Set<GeoPosition> bound) {
        Object[] gps = bound.toArray();
        GeoPosition gp1 = (GeoPosition) gps[0];
        GeoPosition gp2 = (GeoPosition) gps[1];
        String minLat;
        String minLon;
        String maxLat;
        String maxLon;

        if (gp2.getLatitude() > gp1.getLatitude()) {
            minLat = valueOf(gp1.getLatitude());
            maxLat = valueOf(gp2.getLatitude());
        }
        else {
            minLat = valueOf(gp2.getLatitude());
            maxLat = valueOf(gp1.getLatitude());
        }

        if (gp2.getLongitude() > gp1.getLongitude()) {
            minLon = valueOf(gp1.getLongitude());
            maxLon = valueOf(gp2.getLongitude());
        }
        else {
            minLon = valueOf(gp2.getLongitude());
            maxLon = valueOf(gp1.getLongitude());
        }

        return minLat + "," + minLon + "," + maxLat + "," + maxLon;
    }

    public static void calculateBounds() {
        HttpGet request = new HttpGet(Constant.CALCULATE_BOUNDS_URL);
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpResponse response = client.execute(request);
            System.out.println(response.toString());
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, Constant.CHAR_SET_UTF_8);
            System.out.println(responseString);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static String calculateLattitude(String responseString) {
        String l = responseString.substring(responseString.indexOf("lat="));
        return l.substring(l.indexOf("'") + 1, l.indexOf("lon=") - 2);
    }

    public static String calculateLongitude(String responseString) {
        String l = responseString.substring(responseString.indexOf("lon='") + 5);
        return l.split("'")[0];
    }
}
