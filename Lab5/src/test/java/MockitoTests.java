import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;

public class MockitoTests {

    /**
     * Test nr 1
     * Testowanie mockowania
     */
    @Test
    public void testApartmentSubServiceMocking() {
        MockitoApartmentModel apartmentModel = new MockitoApartmentModel("Apartament nad morzem", "Pomorska 22",800000);
        MockitoApartmentSubService apartmentSubService = mock(MockitoApartmentSubService.class);
        MockitoApartmentService apartmentService = new MockitoApartmentService(apartmentSubService);
        when(apartmentSubService.GetApartmentInfo()).thenReturn(apartmentModel);
        MockitoApartmentModel runningModel = apartmentService.ExecuteApartmentModel(true);
        verify(apartmentSubService).GetApartmentInfo();
        Assertions.assertEquals(apartmentModel, runningModel);
    }

    /**
     * Test nr 2
     * Testowanie typu apartamentu
     */
    @Test
    public void testTypeMocking() {
        MockitoApartmentSubService apartmentSubService = mock(MockitoApartmentSubService.class);
        given(apartmentSubService.GetTypeOfApartment()).willReturn("Flat");
        String defaultType = apartmentSubService.GetTypeOfApartment();
        Assertions.assertEquals("Flat", defaultType);
    }

    /**
     * Test nr 3
     * Testowanie ilości pokoji
     */
    @Test
    public void testRoomsMocking() {
        MockitoApartmentSubService apartmentSubService = mock(MockitoApartmentSubService.class);
        given(apartmentSubService.GetAmountOfRooms()).willReturn(2);
        int defaultType = apartmentSubService.GetAmountOfRooms();
        Assertions.assertEquals(2, defaultType);
    }


    /**
     * Test nr 4
     * Testowanie wartości not null
     */
    @Test
    public void testNotNullReturn() {
        MockitoApartmentModel apartmentModel = new MockitoApartmentModel("Apartament na Chmielnej", "Chmielna 10",2200000);
        MockitoApartmentSubService apartmentSubService = mock(MockitoApartmentSubService.class);
        MockitoApartmentService apartmentService = new MockitoApartmentService(apartmentSubService);
        when(apartmentSubService.GetApartmentInfo()).thenReturn(apartmentModel);
        MockitoApartmentModel runningModel = apartmentService.ExecuteApartmentModel(true);
        Assertions.assertNotNull(runningModel);
    }

    /**
     * Test nr 5
     * Testowanie wartości null
     */
    @Test
    public void testNullReturn() {
        MockitoApartmentModel apartmentModel = new MockitoApartmentModel("Apartament w górach", "Księska 55",1200000);
        MockitoApartmentSubService apartmentSubService = mock(MockitoApartmentSubService.class);
        MockitoApartmentService apartmentService = new MockitoApartmentService(apartmentSubService);
        when(apartmentSubService.GetApartmentInfo()).thenReturn(apartmentModel);
        MockitoApartmentModel runningModel = apartmentService.ExecuteApartmentModel(false);
        verify(apartmentSubService, never()).GetApartmentInfo();
        Assertions.assertNull(runningModel);
    }

    /**
     * Test nr 6
     * Testowanie exception
     */
    @Test
    void TestExceptionMocking() {
        MockitoApartmentService service = mock(MockitoApartmentService.class);
        when(service.ExecuteApartmentModel(anyBoolean())).thenThrow(new RuntimeException());
        Assertions.assertThrows(RuntimeException.class, () -> service.ExecuteApartmentModel(true));
    }


    /**
     * Test nr 7
     * Testowanie exception przy pobieraniu wartości ilości pokoji
     */
    @Test
    void TestExceptionAmountRoomsMocking() {
        MockitoApartmentSubService carService = mock(MockitoApartmentSubService.class);
        when(carService.GetAmountOfRooms()).thenThrow(new NullPointerException());
        Assertions.assertThrows(NullPointerException.class, carService::GetAmountOfRooms);
    }


}
