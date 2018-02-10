import java.util.LinkedList;
import java.util.List;

import csp.Domain;

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
