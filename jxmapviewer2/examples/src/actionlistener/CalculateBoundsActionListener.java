package actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lombok.Builder;
import util.BusinessUtil;

/**
 * The listener interface for receiving calculateBoundsAction events.
 * The class that is interested in processing a calculateBoundsAction
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addCalculateBoundsActionListener<code> method. When
 * the calculateBoundsAction event occurs, that object's appropriate
 * method is invoked.
 *
 * @author NaumanH
 * 
 *         Nov 29, 2018
 */
@Builder
public class CalculateBoundsActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        BusinessUtil.calculateBounds();
    }

}
