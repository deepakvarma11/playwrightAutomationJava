package com.playwright.test;

import static org.testng.Assert.assertEquals;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {

	@Test(priority = 0)
	public void searchIphone() {
		homePage.navigateToHomePage();
		homePage.doSearch("Iphone");
		assertEquals(resultPage.getSearchHeaderText(), "Search - Iphone");
	}

	@Test(priority = 1)
	public void noOfSearchResult() {
		Assertions.assertThat(resultPage.getResultItems().size()).isEqualTo(1);
	}

	@Test(priority = 2)
	public void selectIphone() {
		resultPage.selectProduct("iPhone");
	}

}
