package it.unibs.pajc;

import java.util.HashMap;
import java.util.Stack;

public class CalcModel {
	private HashMap<String, OperatoreBinario> operators = new HashMap<>();
	
	public CalcModel() {
		operators.put("+", (x, y) -> x + y);
		operators.put("-", (x, y) -> x - y);
		operators.put("*", (x, y) -> x * y);
		operators.put("/", (x, y) -> x / y);
	}

	public String listOperators() {
		return null; // deve restituire una stringa contenente gli operatori gestiti
	}
	
	// --------------------------------------------
	// Stack notazione polacca inversa
	// --------------------------------------------	
	private class CompEl {
		final Double value;
		final OperatoreBinario operator;
		final String operatorSymbol;
		
		CompEl(Double value) {
			this.value = value;
			this.operator = null;
			this.operatorSymbol = null;
		}
		
		CompEl(OperatoreBinario operator, String operatorSymbol) {
			this.value = null;
			this.operator = operator;
			this.operatorSymbol = operatorSymbol;
		}
		
		boolean isOperator() { return operator != null; }
		
		boolean isOperand() { return value != null; }
		
		public String toString() {
			return isOperand() ? Double.toString(value) : operatorSymbol;
		}	
	}
	
	
	private Stack<CompEl> compStack = new Stack<>();
	
	public void pushOperator(String operatorSymbol) {
		OperatoreBinario op = operators.get(operatorSymbol);
		if(op == null)
			return;
		compStack.add(new CompEl(op, operatorSymbol));
		
		
		CompEl c = new CompEl(op, operatorSymbol);
	}
	
	public void pushOperand(Double value) {
		compStack.add(new CompEl(value));
	}
	
	public String dump() {
		return compStack.toString();
	}
	
	
}
