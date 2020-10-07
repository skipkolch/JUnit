package ru.mail.junit;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public interface DataService {
  void saveData(@NotNull List<Integer> dataToSave);

  @NotNull String getDataById(int id);

  @NotNull List<String> getData();

  final class Dummy implements DataService {
    public static final @NotNull DataService instance = new Dummy();

    @Override
    public void saveData(@NotNull List<Integer> dataToSave) {
    }

    @Override
    public @NotNull String getDataById(int id) {
      return "";
    }

    @Override
    public @NotNull List<String> getData() {
      return Collections.emptyList();
    }
  }
}
