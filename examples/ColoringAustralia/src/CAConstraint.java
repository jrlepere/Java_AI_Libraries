import csp.EqualVariablesConstraint;

/**
 * A Constraint for the ColoringAustralia problem
 * @author JLepere2
 * @date 02/10/2018
 */
public class CAConstraint extends EqualVariablesConstraint<CAVariable, CADomain, Color>{

	public CAConstraint(CAVariable var1, CAVariable var2) {
		super(var1, var2);
	}

}
