package com.wiley.wat.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByCssSelector;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vefimov on 23.08.2016.
 */
public class WASBy extends By {

    /**
     * Finds elements via the driver's underlying W3 Selector engine using data-selenium-id attribute.
     *
     * @param seleniumId String value of data-selenium-id attribute
     * @return a WASBy which locates elements by CSS using seleniumId.
     */
    public static WASBy seleniumId(final String seleniumId) {
        if (seleniumId == null) {
            throw new IllegalArgumentException(
                    "Cannot find elements when the selector is null");
        }

        return new BySeleniumId(Equality.EQUALS, seleniumId);

    }

    public static WASBy seleniumIdContains(final String seleniumId) {
        if (seleniumId == null) {
            throw new IllegalArgumentException(
                    "Cannot find elements when the selector is null");
        }

        return new BySeleniumId(Equality.CONTAINS, seleniumId);
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return null;
    }

    private enum Equality {
        EQUALS, CONTAINS
    }

    public static class BySeleniumId extends WASBy implements Serializable {

        private String selector;

        BySeleniumId(Equality equality, String seleniumId) {
            switch (equality) {
                case EQUALS:
                    this.selector = "[data-selenium-id='" + seleniumId + "']";
                    break;
                case CONTAINS:
                    this.selector = "[data-selenium-id*='" + seleniumId + "']";
                    break;
            }
        }

        @Override
        public WebElement findElement(SearchContext context) {
            if (context instanceof FindsByCssSelector) {
                return ((FindsByCssSelector) context).findElementByCssSelector(selector);
            }

            throw new WebDriverException("Driver does not support finding an element by selector: " + selector);
        }

        @Override
        public List<WebElement> findElements(SearchContext context) {
            if (context instanceof FindsByCssSelector) {
                return ((FindsByCssSelector) context).findElementsByCssSelector(selector);
            }

            throw new WebDriverException("Driver does not support finding elements by selector: " + selector);
        }

        @Override
        public String toString() {
            return "WASBy.cssSelector: " + selector;
        }
    }
}
