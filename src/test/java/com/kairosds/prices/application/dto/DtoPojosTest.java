package com.kairosds.prices.application.dto;

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

public class DtoPojosTest {

	private static final String DOMAIN_PACKAGE = "com.kairosds.prices.application.dto";

	@Test
	void domainPojosTest() {
		final Validator validator = ValidatorBuilder.create().with(new GetterMustExistRule())
				.with(new SetterMustExistRule()).with(new SetterTester()).with(new GetterTester()).build();

		validator.validate(DOMAIN_PACKAGE, new FilterPackageInfo());
		EqualsVerifier.simple().forPackage(DOMAIN_PACKAGE).verify();
		ToStringVerifier.forPackage(DOMAIN_PACKAGE, false).verify();
	}

}
