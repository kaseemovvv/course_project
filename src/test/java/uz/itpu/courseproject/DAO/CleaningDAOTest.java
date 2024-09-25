package uz.itpu.courseproject.DAO;

import org.junit.jupiter.api.Test;
import uz.itpu.courseproject.DAO.criteria.CleaningCriteria;
import uz.itpu.courseproject.DAO.parameter.Parameter;
import uz.itpu.courseproject.model.Cleaning;
import uz.itpu.courseproject.model.Household;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CleaningDAOTest {
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
        Cleaning cleaning1 = new Cleaning("Samsung", "White", 100.0,"XYZ-100", true);
        Cleaning cleaning2 = new Cleaning("Philips", "Blue", 80.0,"PQR-200",false);
        Cleaning cleaning3 = new Cleaning("Dyson", "Red", 200.0,"DEF-300",true);
        Cleaning cleaning4 = new Cleaning("LG", "Green", 120.0,"GHI-400",false);
        CleaningDAO dao = new CleaningDAO();
        Cleaning[] expected = new Cleaning[]{
                cleaning1,
                cleaning2,
                cleaning3,
                cleaning4
        };

        Iterable<Cleaning> iterable = dao.find(
                new CleaningCriteria().add(ParameterExtTest.any()));

        assertNotNull(iterable);
        Cleaning[] cleanings = toArray(iterable, Cleaning[]::new);
    }

    @Test
    void shouldFindNone() {
        CleaningDAO dao = new CleaningDAO();
        Iterable<Cleaning> iterable = dao.find(
                new CleaningCriteria().add(ParameterExtTest.none()));
        assertNotNull(iterable);
        Cleaning[] cleanings = toArray(iterable, Cleaning[]::new);
        assertArrayEquals(new Cleaning[0], cleanings);
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
