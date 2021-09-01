package com.kairosds.prices.application;

import org.junit.jupiter.api.Test;

import com.jparams.verifier.tostring.ToStringVerifier;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ApplicationPojosTest {

	private static final String INPUT_PACKAGE = "com.kairosds.prices.application.input";

	private static final String DTO_PACKAGE = "com.kairosds.prices.application.dto";

	@Test
	void inputPojosTest() {
		final Validator validator = ValidatorBuilder.create().with(new GetterMustExistRule())
				.with(new SetterMustExistRule()).with(new SetterTester()).with(new GetterTester()).build();

		validator.validate(INPUT_PACKAGE, new FilterPackageInfo());
		EqualsVerifier.simple().forPackage(INPUT_PACKAGE).verify();
		ToStringVerifier.forPackage(INPUT_PACKAGE, false).verify();
	}

	@Test
	void dtoPojosTest() {
		final Validator validator = ValidatorBuilder.create().with(new GetterMustExistRule())
				.with(new SetterMustExistRule()).with(new SetterTester()).with(new GetterTester()).build();

		validator.validate(DTO_PACKAGE, new FilterPackageInfo());
		EqualsVerifier.simple().forPackage(DTO_PACKAGE).verify();
		ToStringVerifier.forPackage(DTO_PACKAGE, false).verify();
	}

}
