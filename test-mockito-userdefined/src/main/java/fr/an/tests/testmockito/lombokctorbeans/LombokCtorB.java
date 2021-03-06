package fr.an.tests.testmockito.lombokctorbeans;

import javax.inject.Inject;

import fr.an.tests.testmockito.C;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_={@Inject})
public class LombokCtorB {
	
	private final C c;
	
	public String foo(String x) {
		return "B.foo(" + c.foo(x) + ")";
	}
	
}