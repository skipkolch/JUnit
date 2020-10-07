package ru.mail.junit;

import org.jetbrains.annotations.NotNull;
import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.*;
import org.junit.runner.Description;

import java.io.IOException;

public final class RulesTest {

//  @Rule
//  public static @NotNull ExternalResource testRule = new ExternalResource() {
//    @Override
//    protected void before() throws Throwable {
//      super.before();
//    }
//
//    @Override
//    protected void after() {
//      super.after();
//    }
//  };
//
//  @Rule
//  public @NotNull TestWatcher watcher = new TestWatcher() {
//    @Override
//    protected void succeeded(Description description) {
//      super.succeeded(description);
//    }
//
//    @Override
//    protected void failed(Throwable e, Description description) {
//      super.failed(e, description);
//    }
//
//    @Override
//    protected void skipped(AssumptionViolatedException e, Description description) {
//      super.skipped(e, description);
//    }
//
//    @Override
//    protected void starting(Description description) {
//      super.starting(description);
//    }
//
//    @Override
//    protected void finished(Description description) {
//      super.finished(description);
//    }
//  };
//
//  @Rule
//  public @NotNull TemporaryFolder folder = new TemporaryFolder();

  @Rule
  public @NotNull ExpectedException exception = ExpectedException.none();

  @Rule
  public @NotNull Timeout timeout = Timeout.millis(1000);

//  @Test
//  public void test_1() {
//    System.out.println("@Test - tes_1");
//  }


  @Test(expected = IOException.class, timeout = 1000)
  public void expectedExceptionTest() throws IOException {

    throw new IOException("throw IOException");
  }

//  @Test
//  public void test_2() {
//    System.out.println("@Test - test_2");
//  }
}
