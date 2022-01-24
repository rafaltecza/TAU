public class MockitoApartmentService {

    private MockitoApartmentSubService mockitoApartmentSubService;

    public MockitoApartmentService(MockitoApartmentSubService mockitoApartmentSubService) {
        this.mockitoApartmentSubService = mockitoApartmentSubService;
    }

    public MockitoApartmentModel ExecuteApartmentModel(boolean canExecute) {
        return canExecute ? mockitoApartmentSubService.GetApartmentInfo() : null;
    }
}
