package util;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
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
    
    public static void calculateBoundingBox() {
        HttpGet request =
                new HttpGet(Constant.BOUNDING_BOX_URL_1);
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
