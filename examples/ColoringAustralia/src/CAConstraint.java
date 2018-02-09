import csp.EqualVariablesConstraint;

public class CAConstraint extends EqualVariablesConstraint<CAVariable, CADomain, Color>{

	public CAConstraint(CAVariable var1, CAVariable var2) {
		super(var1, var2);
	}

}
