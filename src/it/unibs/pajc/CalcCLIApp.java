package it.unibs.pajc;

public class CalcCLIApp {

	public static void main(String[] args) {
		CalcModel model = new CalcModel();

		model.pushOperand(5.);
		model.pushOperand(2.);
		model.pushOperator("+");

		System.out.println(model.dump());
		System.out.println(model.eval());

	}

}
