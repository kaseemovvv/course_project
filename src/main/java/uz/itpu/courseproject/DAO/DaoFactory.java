package uz.itpu.courseproject.DAO;

import uz.itpu.courseproject.model.Cleaning;
import uz.itpu.courseproject.model.ClimateControl;
import uz.itpu.courseproject.model.Household;
import uz.itpu.courseproject.model.Kitchen;

public enum DaoFactory {
    INSTANCE;

    @SuppressWarnings("unchecked")
    public <A extends Household> HouseholdDAO<A> getApplianceDAO(Class<A> applianceType) {
        if (Cleaning.class.equals(applianceType)) {
            return (HouseholdDAO<A>) new CleaningDAO();
        }
        if (ClimateControl.class.equals(applianceType)) {
            return (HouseholdDAO<A>) new ClimateControlDAO();
        }
        if (Kitchen.class.equals(applianceType)) {
            return (HouseholdDAO<A>) new KitchenDAO();
        }
        return null;
    }
}
