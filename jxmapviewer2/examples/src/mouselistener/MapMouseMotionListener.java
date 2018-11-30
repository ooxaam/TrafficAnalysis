package mouselistener;

import domain.Screen;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import javax.annotation.Generated;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.JXMapViewer;

/**
 * The listener interface for receiving mapMouseMotion events.
 * The class that is interested in processing a mapMouseMotion
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addMapMouseMotionListener<code> method. When
 * the mapMouseMotion event occurs, that object's appropriate
 * method is invoked.
 *
 * @author NaumanH
 * 
 *         Nov 29, 2018
 */
public class MapMouseMotionListener implements MouseMotionListener {

    private JXMapKit jXMapKit;
    private Screen screen;

	@Generated("SparkTools")
	private MapMouseMotionListener(Builder builder) {
		this.jXMapKit = builder.jXMapKit;
		this.screen = builder.screen;
	}

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        JXMapViewer map = jXMapKit.getMainMap();

        // convert to world bitmap
        Point2D worldPos = map.getTileFactory().geoToPixel(screen.getGp(), map.getZoom());

        // convert to screen
        Rectangle rect = map.getViewportBounds();
        int sx = (int) worldPos.getX() - rect.x;
        int sy = (int) worldPos.getY() - rect.y;
        Point screenPos = new Point(sx, sy);
        // System.out.println(screenPos.toString());
        // check if near the mouse
        if (screenPos.distance(e.getPoint()) < 20) {
            screenPos.x -= screen.getTooltip().getWidth() / 2;

            screen.getTooltip().setLocation(screenPos);
            screen.getTooltip().setVisible(true);
        } else {
            screen.getTooltip().setVisible(false);
        }

    }

	/**
	 * Creates builder to build {@link MapMouseMotionListener}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link MapMouseMotionListener}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private JXMapKit jXMapKit;
		private Screen screen;

		private Builder() {
		}

		public Builder jXMapKit(JXMapKit jXMapKit) {
			this.jXMapKit = jXMapKit;
			return this;
		}

		public Builder screen(Screen screen) {
			this.screen = screen;
			return this;
		}

		public MapMouseMotionListener build() {
			return new MapMouseMotionListener(this);
		}
	}

}
