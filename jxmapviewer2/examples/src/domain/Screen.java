package domain;

import actionlistener.BoundingBoxActionListener;
import actionlistener.CalculateBoundsActionListener;
import actionlistener.FetchLocationActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JToolTip;
import javax.swing.border.EmptyBorder;
import lombok.Getter;
import mouselistener.MapMouseMotionListener;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import util.BusinessUtil;
import util.Constant;

/**
 * The Class Screen.
 *
 * @author NaumanH
 * 
 *         Nov 15, 2018
 */
@Getter
public class Screen {

    private String lattitude = "31.5655908";
    private String longitude = "74.3141453";

    private JXMapKit jXMapKit;
    private JTextField locationText;
    private JButton searchButton;
    private JButton boundsButton;
    private JButton boundingBox;
    private JToolBar sideBar;
    private JPanel panel;
    private GeoPosition gp;
    private JToolTip tooltip;

    public Screen() {
        jXMapKit = prepareJXMapKit();
        locationText = new JTextField(Constant.LOCATION, 20);
        locationText.setPreferredSize(new Dimension(100, 25));
        locationText.setBorder(new EmptyBorder(3, 0, 3, 0));

        searchButton = new JButton(Constant.SEARCH_LOCATION);
        searchButton.setBorder(new EmptyBorder(3, 0, 3, 0));

        boundsButton = new JButton(Constant.CALCULATE_BOUNDS);
        boundsButton.setBorder(new EmptyBorder(3, 0, 3, 0));

        boundingBox = new JButton(Constant.BOUNDING_BOX);
        boundingBox.setBorder(new EmptyBorder(3, 0, 3, 0));

        sideBar = populateSideBar();
        sideBar.add(boundingBox);

        panel = new JPanel();
        panel.add(sideBar);

        // Display the viewer in a JFrame
        displayViewerInFrame(jXMapKit, panel);
        addListeners();
        jXMapKit.setAddressLocation(new GeoPosition(Float.valueOf(lattitude), Float.valueOf(longitude)));
    }

    private void addListeners() {
        searchButton.addActionListener(FetchLocationActionListener.builder().screen(this).build());
        boundsButton.addActionListener(CalculateBoundsActionListener.builder().build());
        boundingBox.addActionListener(BoundingBoxActionListener.builder().jXMapKit(jXMapKit).build());
    }

    private JXMapKit prepareJXMapKit() {
        final JXMapKit jXMapKit = new JXMapKit();
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        jXMapKit.setTileFactory(tileFactory);

        // location of Java
        gp = new GeoPosition(Float.valueOf(lattitude), Float.valueOf(longitude));

        tooltip = new JToolTip();
        tooltip.setTipText(Constant.DEFAULT_TOOL_TEXT);
        tooltip.setComponent(jXMapKit.getMainMap());
        jXMapKit.getMainMap().add(tooltip);

        jXMapKit.setZoom(11);
        jXMapKit.setAddressLocation(gp);

        jXMapKit.getMainMap()
                .addMouseMotionListener(MapMouseMotionListener.builder().jXMapKit(jXMapKit).screen(this).build());

        return jXMapKit;
    }

    private JToolBar populateSideBar() {
        JToolBar sideBar = new JToolBar(JToolBar.VERTICAL);
        sideBar.setFloatable(false);
        sideBar.setMargin(new Insets(10, 5, 5, 5));
        sideBar.add(locationText);
        sideBar.add(searchButton);
        sideBar.add(boundsButton);
        return sideBar;
    }

    private void displayViewerInFrame(final JXMapKit jXMapKit, JPanel panel) {
        JFrame frame = new JFrame(Constant.TRAFFIC_ANALYSIS_SIMULATION);
        frame.getContentPane().add(panel, BorderLayout.WEST);
        frame.getContentPane().add(jXMapKit, BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setAddressLocation(String responseString) {
        lattitude = BusinessUtil.calculateLattitude(responseString);
        longitude = BusinessUtil.calculateLongitude(responseString);
        gp = new GeoPosition(Float.valueOf(lattitude), Float.valueOf(longitude));
        jXMapKit.setAddressLocation(gp);
    }

}
// https://www.overpass-api.de/api/interpreter?data=[out:json];node[highway=primary](50.7,7.1,50.8,7.25);out%20meta;
// https://wiki.openstreetmap.org/wiki/Overpass_API/Overpass_API_by_Example
// https://github.com/zsoltk/overpasser
// https://wiki.openstreetmap.org/wiki/Java_Access_Example
// https://blog-en.openalfa.com/how-to-query-openstreetmap-using-the-overpass-api
