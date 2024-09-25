package uz.itpu.courseproject.DAO;

import org.junit.jupiter.api.Test;
import uz.itpu.courseproject.model.Cleaning;
import uz.itpu.courseproject.model.ClimateControl;
import uz.itpu.courseproject.model.Household;
import uz.itpu.courseproject.model.Kitchen;

import static org.junit.jupiter.api.Assertions.*;

class DAOFactoryTest {

    @Test
    void shouldReturnNullWhenUnknownClassIsPassed() {
        // Define a dummy household class for testing unknown types
        class DummyHousehold extends Household {}
        // Attempt to get the DAO for the dummy household class
        HouseholdDAO<DummyHousehold> dao = DaoFactory.INSTANCE.getApplianceDAO(DummyHousehold.class);
        // Assert that the DAO is null
        assertNull(dao);
    }
    @Test
    void shouldReturnCleaningDao() {
        // Attempt to get the DAO for the Cleaning class
        HouseholdDAO<Cleaning> dao = DaoFactory.INSTANCE.getApplianceDAO(Cleaning.class);
        // Assert that the DAO is not null and is an instance of CleaningDAO
        assertNotNull(dao);
        assertTrue(dao instanceof CleaningDAO);
    }

    @Test
    void shouldReturnClimateControlDao() {
        // Attempt to get the DAO for the ClimateControl class
        HouseholdDAO<ClimateControl> dao = DaoFactory.INSTANCE.getApplianceDAO(ClimateControl.class);
        // Assert that the DAO is not null and is an instance of ClimateControlDAO
        assertNotNull(dao);
        assertTrue(dao instanceof ClimateControlDAO);
    }

    @Test
    void shouldReturnKitchenDao() {
        // Attempt to get the DAO for the Kitchen class
        HouseholdDAO<Kitchen> dao = DaoFactory.INSTANCE.getApplianceDAO(Kitchen.class);
        assertNotNull(dao);
        assertTrue(dao instanceof KitchenDAO);
    }
}
