package ru.mail.junit;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public final class HamcrestTest {


  @Test
  public void equalsTest() {
    String str = "Hello";

    assertThat(str, anyOf(containsString("w"), endsWith("lo")));
  }

  @Test
  public void checkTest() {
    int x = 7;
    assertThat(x, allOf(greaterThanOrEqualTo(7), not(equalTo(6)), lessThanOrEqualTo(10)));
  }

  @Test
  public void collectionTest() {
    var list = Arrays.asList(1,2,3,4,5);
    var map = Collections.emptyMap();
    assertThat(list, is(not(empty())));
    assertThat(list, everyItem(greaterThan(0)));
    assertThat(list, hasItem(5));
    assertThat(list, contains(1, 2, 3, 4, 5));
//    assertThat(map, hasEntry());
//    assertThat(map, hasKey());
//    assertThat(map, hasValue());
  }

}
