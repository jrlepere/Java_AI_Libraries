import java.util.LinkedList;
import java.util.List;

import csp.Domain;

/**
 * The Domain for the Coloring Australia problem
 * @author JLepere2
 * @date 02/10/2018
 */
public class CADomain implements Domain<Color> {

	public CADomain() {
		colors = new LinkedList<>();
		colors.add(Color.RED);
		colors.add(Color.BLUE);
		colors.add(Color.GREEN);
	}
	
	public List<Color> getValues() {
		return colors;
	}
	
	private List<Color> colors;

}
