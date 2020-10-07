package ru.mail.junit;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public final class ParamTest {

  @Parameterized.Parameter
  public @NotNull MyTestParam param;

  @Parameterized.Parameters
  public static @NotNull Collection<MyTestParam> data() {
    return Arrays.asList(
        new MyTestParam(10, 20, 30),
        new MyTestParam(0, 0, 0),
        new MyTestParam(15, 15, 30),
        new MyTestParam(2, 6, 8)
    );
  }

  @Test
  public void calcerTest() {
    final var calc = new Calcer();

    Assert.assertEquals(param.expected, calc.summ(param.valueA, param.valueB));
  }


  private static final class MyTestParam {
    public final int valueA;
    public final int valueB;
    public final int expected;

    private MyTestParam(int valueA, int valueB, int expected) {
      this.valueA = valueA;
      this.valueB = valueB;
      this.expected = expected;
    }
  }
}
