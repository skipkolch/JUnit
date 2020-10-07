package ru.mail.junit;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public final class MainTest {

  @Test(expected = IOException.class)
  public void firstTest() throws IOException {
    new MyEntity().check();
  }


  @Test
  public void summTest() {
    int a = 10;
    int b = 20;
    int expected = 30;

    int actual = new Calcer().summ(a, b);

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void equalsArray() {
    int a[] = {1,2,3,4,5};
    int b[] = {1,2,3,4,5};

    Assert.assertArrayEquals(a, b);
  }
}
