package uz.itpu.courseproject.DAO;

import org.junit.jupiter.api.Test;
import uz.itpu.courseproject.DAO.criteria.ClimateControlCriteria;
import uz.itpu.courseproject.DAO.parameter.Parameter;
import uz.itpu.courseproject.model.ClimateControl;
import uz.itpu.courseproject.model.Household;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClimateDAOTest {
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
        ClimateControl climateControl1 = new ClimateControl("LG", "Black", 150,"ABC-200", true);
        ClimateControl climateControl2 = new ClimateControl("Honeywell", "White", 120,"DEF-400", false);
        ClimateControl climateControl3 = new ClimateControl("Samsung", "Silver", 180,"GHI-600", true);
        ClimateControl climateControl4 = new ClimateControl("Dyson", "Gray", 200,"JKL-800", false);
        ClimateControlDAO dao = new ClimateControlDAO();
        ClimateControl[] expected = new ClimateControl[]{
                climateControl1,
                climateControl2,
                climateControl3,
                climateControl4
        };
        Iterable<ClimateControl> iterable = dao.find(
                new ClimateControlCriteria().add(ParameterExtTest.any()));
        assertNotNull(iterable);
        ClimateControl[] climateControls = toArray(iterable, ClimateControl[]::new);
    }

    @Test
    void shouldFindNone() {
        ClimateControlDAO dao = new ClimateControlDAO();
        Iterable<ClimateControl> iterable = dao.find(
                new ClimateControlCriteria().add(ParameterExtTest.none()));
        assertNotNull(iterable);
        ClimateControl[] climateControls = toArray(iterable, ClimateControl[]::new);
        assertArrayEquals(new ClimateControl[0], climateControls);
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
