package org.example;


import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void firstMethod(){
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://www.google.com/");
        Assertions.assertThat("a").isEqualTo("a");
        RestAssured.baseURI = "https://pokeapi.co/api/v2/pokemon/25";
    }

}
