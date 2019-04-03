package jp.co.toyota.rest_api.domain.service;

public class CalculationService implements Calculator {

	@Override
	public int calc(int a, int b) {
		return a + b;
	}

}
