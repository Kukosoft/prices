package com.kairosds.prices.application.usecases;

public interface UseCase<I, O> {

	O execute(I input);

}
