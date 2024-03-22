package org.example;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void firstMethod(){
        Assertions.assertThat("a").isEqualTo("a");
    }

}
