package actionlistener;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lombok.Builder;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.JXMapViewer;
import util.BusinessUtil;

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
@Builder
public class BoundingBoxActionListener implements ActionListener {

    private JXMapKit jXMapKit;

    @Override
    public void actionPerformed(ActionEvent e) {

        JXMapViewer map = jXMapKit.getMainMap();
        Rectangle loc = map.getViewportBounds();
        System.out.println("Viewer Bounds " + loc.toString());
        Rectangle bounds = map.getBounds();
        System.out.println("Map Bounds: " + bounds);
        System.out.println(BusinessUtil.getMapGeoBounds(map).toString());
        BusinessUtil.calculateBoundingBox();

    }

}
