package com.examples.java.factorymethod;

public class GetPlanFactory {
	public Plan getPlan(String planTyp) {
		if (planTyp.equalsIgnoreCase("DOMESTIC")) {
			return new DomesticPlan();
		}
		if (planTyp.equalsIgnoreCase("COMMERCIAL")) {
			return new CommercialPlan();
		}
		if (planTyp.equalsIgnoreCase("INSTITUTIONAL")) {
			return new InstitutionalPlan();
		}
		return null;
	}
}
