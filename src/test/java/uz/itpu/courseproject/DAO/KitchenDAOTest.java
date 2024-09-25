package uz.itpu.courseproject.DAO;

import org.junit.jupiter.api.Test;
import uz.itpu.courseproject.DAO.criteria.KitchenCriteria;
import uz.itpu.courseproject.DAO.parameter.Parameter;
import uz.itpu.courseproject.model.ClimateControl;
import uz.itpu.courseproject.model.Household;
import uz.itpu.courseproject.model.Kitchen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class KitchenDAOTest {
    interface ParameterExtTest<A extends Household> extends Parameter<A> {
        static <A extends Household> Parameter<A> any() {
            return appliance -> true;
        }

        static <A extends Household> Parameter<A> none() {
            return appliance -> false;
        }
    }

    @Test
    void shouldFindAll() {
        Kitchen kitchen1 = new Kitchen("Whirlpool", "Stainless Steel", 200,"KIT-300", "5L", true);
        Kitchen kitchen2 = new Kitchen("Samsung", "Black", 180,"KIT-500", "10L", false);
        Kitchen kitchen3 = new Kitchen("LG", "White", 220,"KIT-70", "8L", false);
        Kitchen kitchen4 = new Kitchen("KitchenAid", "Red", 250,"KIT-900", "6L", true);
        KitchenDAO dao = new KitchenDAO();
        Kitchen[] expected = new Kitchen[]{
                kitchen1,
                kitchen2,
                kitchen3,
                kitchen4
        };
        Iterable<Kitchen> iterable = dao.find(
                new KitchenCriteria().add(ParameterExtTest.any()));
        assertNotNull(iterable);
        Kitchen[] kitchens = toArray(iterable, Kitchen[]::new);
    }

    @Test
    void shouldFindNone() {
        KitchenDAO dao = new KitchenDAO();
        Iterable<Kitchen> iterable = dao.find(
                new KitchenCriteria().add(ParameterExtTest.none()));
        assertNotNull(iterable);
        Kitchen[] kitchens = toArray(iterable, Kitchen[]::new);
        assertArrayEquals(new ClimateControl[0], kitchens);
    }

    private <A extends Household> A[] toArray(Iterable<A> iterable,
                                              IntFunction<A[]> arrayGen) {
        ArrayList<A> list = new ArrayList<>();
        iterable.forEach(list::add);
        A[] arr = list.toArray(arrayGen);
        Arrays.sort(arr, Comparator.comparing(Household::getBrand));
        return arr;
    }
}
