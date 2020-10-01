package designpattern.structural.decorator;

import java.math.BigDecimal;

public class CheeseBurst extends Pizza {

	public CheeseBurst() {
		this.description = "Cheese Burst Pizza";
	}
	
	@Override
	public BigDecimal getCost() {
		return new BigDecimal(20.0);
	}

}
