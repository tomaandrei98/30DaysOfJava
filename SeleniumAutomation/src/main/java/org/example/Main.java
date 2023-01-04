// Ex. 1
// 1. Find the number of links in the page
// 2. Print the text for all the links
// 3. Check how many links does not have the "href" attribute and mark them as "broken links"

package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //set up the environment
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        //getting the URL
        driver.get("https://demowebshop.tricentis.com/");

        //finding the anchor tags by tagName and mapping the WebElements into String by text and counting them
        List<WebElement> anchorsElements = driver.findElements(By.tagName("a"));
        List<String> anchorsText = anchorsElements.stream().map(WebElement::getText).collect(Collectors.toList());
        long numberOfAnchors = anchorsText.size();
        System.out.println("In this page, we've found " + numberOfAnchors + " anchor tags!");
        System.out.println(anchorsText);

        //closing the chrome driver
        driver.quit();
    }
}