package actionlistener;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.GeoPosition;
import util.BusinessUtil;
import javax.annotation.Generated;

/**
 * The listener interface for receiving boundingBoxAction events.
 * The class that is interested in processing a boundingBoxAction
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addBoundingBoxActionListener<code> method. When
 * the boundingBoxAction event occurs, that object's appropriate
 * method is invoked.
 *
 * @author NaumanH
 * 
 *         Nov 29, 2018
 */
public class BoundingBoxActionListener implements ActionListener {

    private JXMapKit jXMapKit;

	@Generated("SparkTools")
	private BoundingBoxActionListener(Builder builder) {
		this.jXMapKit = builder.jXMapKit;
	}

    @Override
    public void actionPerformed(ActionEvent e) {

    	JXMapViewer map = jXMapKit.getMainMap();
        Rectangle loc = map.getViewportBounds();
        System.out.println("Viewer Bounds " + loc.toString());
        //Rectangle bounds = map.getBounds();
        //System.out.println("Map Bounds: " + bounds);
        Set<GeoPosition> bound = BusinessUtil.getMapGeoBounds(map);
        System.out.println(bound.toString());
        BusinessUtil.calculateBoundingBox(bound);
    }

	/**
	 * Creates builder to build {@link BoundingBoxActionListener}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link BoundingBoxActionListener}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private JXMapKit jXMapKit;

		private Builder() {
		}

		public Builder jXMapKit(JXMapKit jXMapKit) {
			this.jXMapKit = jXMapKit;
			return this;
		}

		public BoundingBoxActionListener build() {
			return new BoundingBoxActionListener(this);
		}
	}
    
}
