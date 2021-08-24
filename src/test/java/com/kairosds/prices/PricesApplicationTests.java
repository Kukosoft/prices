package com.kairosds.prices;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith({ RestDocumentationExtension.class, SpringExtension.class })
@SpringBootTest
class PricesApplicationTests {

	private static final String PRODUCT_ID_FIELD = "productId";
	private static final String PRICE_LIST_FIELD = "priceList";
	private static final String BRAND_ID_FIELD = "brandId";
	private static final String START_DATE_FIELD = "startDate";
	private static final String END_DATE_FIELD = "endDate";
	private static final String PRICE_FIELD = "price";
	private static final String CURR_FIELD = "curr";

	private static final String DATE_PARAM = "date";
	private static final String PRODUCT_ID_PARAM = "productId";
	private static final String BRAND_ID_PARAM = "brandId";

	private static final String EURO = "EUR";

	private MockMvc mockMvc;

	private DateTimeFormatter dateTimeFormatter;

	@BeforeEach
	public void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
		mockMvc = webAppContextSetup(webApplicationContext).apply(documentationConfiguration(restDocumentation))
				.alwaysDo(
						document("{method-name}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
				.build();
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
	}

	@Test
	public void getPriceTest1() throws Exception {
		mockMvc.perform(get("/prices/price").contentType(APPLICATION_JSON).param(DATE_PARAM, "2020-06-14T10:00")
				.param(PRODUCT_ID_PARAM, "35455").param(BRAND_ID_PARAM, "1")).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
				.andExpect(jsonPath(PRODUCT_ID_FIELD, is(35455))).andExpect(jsonPath(BRAND_ID_FIELD, is(1)))
				.andExpect(jsonPath(PRICE_LIST_FIELD, is(1)))
				.andExpect(jsonPath(START_DATE_FIELD,
						is(LocalDateTime.of(2020, 06, 14, 0, 0, 0).format(dateTimeFormatter))))
				.andExpect(jsonPath(END_DATE_FIELD,
						is(LocalDateTime.of(2020, 12, 31, 23, 59, 59).format(dateTimeFormatter))))
				.andExpect(jsonPath(PRICE_FIELD, is(35.50)))
				.andExpect(jsonPath(CURR_FIELD, is(Currency.getInstance(EURO).toString())));
	}

	@Test
	public void getPriceTest2() throws Exception {
		mockMvc.perform(get("/prices/price").contentType(APPLICATION_JSON).param(DATE_PARAM, "2020-06-14T16:00")
				.param(PRODUCT_ID_PARAM, "35455").param(BRAND_ID_PARAM, "1")).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
				.andExpect(jsonPath(PRODUCT_ID_FIELD, is(35455))).andExpect(jsonPath(BRAND_ID_FIELD, is(1)))
				.andExpect(jsonPath(PRICE_LIST_FIELD, is(2)))
				.andExpect(jsonPath(START_DATE_FIELD,
						is(LocalDateTime.of(2020, 06, 14, 15, 0, 0).format(dateTimeFormatter))))
				.andExpect(jsonPath(END_DATE_FIELD,
						is(LocalDateTime.of(2020, 06, 14, 18, 30, 00).format(dateTimeFormatter))))
				.andExpect(jsonPath(PRICE_FIELD, is(25.45)))
				.andExpect(jsonPath(CURR_FIELD, is(Currency.getInstance(EURO).toString())));
	}

	@Test
	public void getPriceTest3() throws Exception {
		mockMvc.perform(get("/prices/price").contentType(APPLICATION_JSON).param(DATE_PARAM, "2020-06-14T21:00")
				.param(PRODUCT_ID_PARAM, "35455").param(BRAND_ID_PARAM, "1")).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
				.andExpect(jsonPath(PRODUCT_ID_FIELD, is(35455))).andExpect(jsonPath(BRAND_ID_FIELD, is(1)))
				.andExpect(jsonPath(PRICE_LIST_FIELD, is(1)))
				.andExpect(jsonPath(START_DATE_FIELD,
						is(LocalDateTime.of(2020, 06, 14, 0, 0, 0).format(dateTimeFormatter))))
				.andExpect(jsonPath(END_DATE_FIELD,
						is(LocalDateTime.of(2020, 12, 31, 23, 59, 59).format(dateTimeFormatter))))
				.andExpect(jsonPath(PRICE_FIELD, is(35.50)))
				.andExpect(jsonPath(CURR_FIELD, is(Currency.getInstance(EURO).toString())));
	}

	@Test
	public void getPriceTest4() throws Exception {
		mockMvc.perform(get("/prices/price").contentType(APPLICATION_JSON).param(DATE_PARAM, "2020-06-15T10:00")
				.param(PRODUCT_ID_PARAM, "35455").param(BRAND_ID_PARAM, "1")).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
				.andExpect(jsonPath(PRODUCT_ID_FIELD, is(35455))).andExpect(jsonPath(BRAND_ID_FIELD, is(1)))
				.andExpect(jsonPath(PRICE_LIST_FIELD, is(3)))
				.andExpect(jsonPath(START_DATE_FIELD,
						is(LocalDateTime.of(2020, 06, 15, 0, 0, 0).format(dateTimeFormatter))))
				.andExpect(jsonPath(END_DATE_FIELD,
						is(LocalDateTime.of(2020, 06, 15, 11, 0, 0).format(dateTimeFormatter))))
				.andExpect(jsonPath(PRICE_FIELD, is(30.50)))
				.andExpect(jsonPath(CURR_FIELD, is(Currency.getInstance(EURO).toString())));
	}

	@Test
	public void getPriceTest5() throws Exception {
		mockMvc.perform(get("/prices/price").contentType(APPLICATION_JSON).param(DATE_PARAM, "2020-06-16T21:00")
				.param(PRODUCT_ID_PARAM, "35455").param(BRAND_ID_PARAM, "1")).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
				.andExpect(jsonPath(PRODUCT_ID_FIELD, is(35455))).andExpect(jsonPath(BRAND_ID_FIELD, is(1)))
				.andExpect(jsonPath(PRICE_LIST_FIELD, is(4)))
				.andExpect(jsonPath(START_DATE_FIELD,
						is(LocalDateTime.of(2020, 06, 15, 16, 0, 0).format(dateTimeFormatter))))
				.andExpect(jsonPath(END_DATE_FIELD,
						is(LocalDateTime.of(2020, 12, 31, 23, 59, 59).format(dateTimeFormatter))))
				.andExpect(jsonPath(PRICE_FIELD, is(38.95)))
				.andExpect(jsonPath(CURR_FIELD, is(Currency.getInstance(EURO).toString())));
	}

	@Test
	void contextLoads() {
	}

}
