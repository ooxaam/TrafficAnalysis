package actionlistener;

import domain.Screen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import lombok.Builder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import util.Constant;

/**
 * The listener interface for receiving fetchLocationAction events.
 * The class that is interested in processing a fetchLocationAction
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addFetchLocationActionListener<code> method. When
 * the fetchLocationAction event occurs, that object's appropriate
 * method is invoked.
 *
 * @author NaumanH
 * 
 *         Nov 29, 2018
 */
@Builder
public class FetchLocationActionListener implements ActionListener {

    private Screen screen;

    @Override
    public void actionPerformed(ActionEvent e) {

        screen.setAddressLocation(fetchLocation());
    }

    private String fetchLocation() {
        
        screen.getTooltip().setTipText(screen.getLocationText().getText());
        StringBuilder url = new StringBuilder();
        url.append(Constant.FETCH_LOCATION_URL);
        url.append(screen.getLocationText().getText());
        url.append("&format=");
        url.append(Constant.FORMAT_XML);
        System.out.println(url.toString());
        HttpGet request = new HttpGet(url.toString());
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpResponse response = client.execute(request);
            System.out.println(response.toString());
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, Constant.CHAR_SET_UTF_8);
            System.out.println(responseString);
            return responseString;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
