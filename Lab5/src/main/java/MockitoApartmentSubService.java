public interface MockitoApartmentSubService {

    public MockitoApartmentModel GetApartmentInfo();

    default String GetTypeOfApartment() {
        return "Flat";
    }

    default int GetAmountOfRooms() {
        return 2;
    }

}
