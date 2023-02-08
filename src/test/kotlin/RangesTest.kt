import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.Exception

internal class RangesTest
{


    @Test
    fun join_range_off_set()
    {
        var controller = Ranges();
        var r1 = Range(7, 8);
        var r2 = Range(10, 12);
      assertThrows<Exception> { controller.join_interval(r1, r2); }
    }


    @Test
    fun join_valid_interval1()
    {
        var controller = Ranges();
        var r1 = Range(7, 12);
        var r2 = Range(6, 14);
        var result = Range(7, 12);
        assertEquals(result, controller.join_interval(r1, r2));
    }

    @Test
    fun join_valid_interval2()
    {
        var controller = Ranges();
        var r1 = Range(7, 20);
        var r2 = Range(6, 14);
        var result = Range(7, 14);
        assertEquals(result, controller.join_interval(r1, r2));
    }

    @Test
    fun join_valid_interval3()
    {
        var controller = Ranges();
        var r1 = Range(-5, -2);
        var r2 = Range(-7, -3);
        var result = Range(-5, -3);
        assertEquals(result, controller.join_interval(r1, r2));
    }

    @Test
    fun join_valid_interval4()
    {
        var controller = Ranges();
        var r1 = Range(5, 2);
        var r2 = Range(3, 6);
        var result = Range(3, 5);
        assertThrows<Exception> { controller.join_interval(r1, r2); }
    }

    @Test
    fun bigger_range()
    {
        var controller = Ranges();
        var r1 = Range(1 , 10);
        var r2 = Range(2, 5);

        assertEquals(r1, controller.bigger_range(r1, r2));
    }

    @Test
    fun bigger_range2()
    {
        var controller = Ranges();
        var r1 = Range(10 , 1);
        var r2 = Range(2, 5);
        assertThrows<Exception> { controller.bigger_range(r1, r2); }
    }
    @Test
    fun bigger_range3()
    {
        var controller = Ranges();
        var r1 = Range(2 , 2);
        var r2 = Range(2, 3);
        assertEquals(r2, controller.bigger_range(r1, r2));
    }

}