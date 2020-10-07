package ru.mail.junit;

import java.io.IOException;

public final class MyEntity {

  public void check() throws IOException {
    throw new IOException("throw IOException");
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
