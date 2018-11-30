package actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.annotation.Generated;
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
public class CalculateBoundsActionListener implements ActionListener {

    @Generated("SparkTools")
	private CalculateBoundsActionListener(Builder builder) {
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        BusinessUtil.calculateBounds();
    }

	/**
	 * Creates builder to build {@link CalculateBoundsActionListener}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link CalculateBoundsActionListener}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private Builder() {
		}

		public CalculateBoundsActionListener build() {
			return new CalculateBoundsActionListener(this);
		}
	}

}
