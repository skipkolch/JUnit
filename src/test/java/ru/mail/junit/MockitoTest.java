package ru.mail.junit;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public final class MockitoTest {

  @Mock
  private @NotNull DataService service;

  @Spy
  private @NotNull Calcer serviceSpy = new Calcer();


  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
    
    service = Mockito.mock(DataService.class);
    Mockito.when(service.getData()).thenReturn(Collections.singletonList("One"));
  }


  @Test
  public void mockTest() {
    DataService dataService = Mockito.mock(DataService.class);
    Mockito.when(dataService.getData()).thenReturn(Collections.singletonList("One"));
    Mockito.when(dataService.getDataById(Mockito.anyInt())).thenAnswer(invocation -> {
      ///...
      dataService.getData();
      return "Hello";
    });


    dataService.getData();
    dataService.getDataById(1);
    Mockito.verify(dataService, Mockito.times(2)).getData();
  }

  @Test
  public void testMockList() {
    var mockList = Mockito.mock(ArrayList.class);
    //по умолчанию вызовы методов у mock-объектов ничего не будут делать
    mockList.add("test");

    assertEquals(0, mockList.size());
    assertNull(mockList.get(0));
  }


  @Test
  public void testSaveData() {
    DataService dataService = Mockito.mock(DataService.class);
    Mockito.doAnswer(invocation -> getSumm()).when(dataService).saveData(Mockito.anyList());


    dataService.saveData(Arrays.asList(1, 2, 34, 4));
  }

  private int getSumm() {
    return new Calcer().summ(1, 2);
  }


}
