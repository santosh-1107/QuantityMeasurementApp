import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QualityMeasurementAppTest {

    @Test
    void testFeet_SameValue() {
        assertTrue(QualityMeasurementApp.compareFeet(1.0, 1.0));
    }

    @Test
    void testFeet_DifferentValue() {
        assertFalse(QualityMeasurementApp.compareFeet(1.0, 2.0));
    }

    @Test
    void testFeet_NullComparison() {
        QualityMeasurementApp.Feet f = new QualityMeasurementApp.Feet(1.0);
        assertFalse(f.equals(null));
    }

    @Test
    void testFeet_NonNumericInput() {
        QualityMeasurementApp.Feet f = new QualityMeasurementApp.Feet(1.0);
        assertFalse(f.equals("abc"));
    }

    @Test
    void testFeet_SameReference() {
        QualityMeasurementApp.Feet f = new QualityMeasurementApp.Feet(1.0);
        assertTrue(f.equals(f));
    }

    @Test
    void testInch_SameValue() {
        assertTrue(QualityMeasurementApp.compareInch(1.0, 1.0));
    }

    @Test
    void testInch_DifferentValue() {
        assertFalse(QualityMeasurementApp.compareInch(1.0, 2.0));
    }

    @Test
    void testInch_NullComparison() {
        QualityMeasurementApp.Inch i = new QualityMeasurementApp.Inch(1.0);
        assertFalse(i.equals(null));
    }

    @Test
    void testInch_NonNumericInput() {
        QualityMeasurementApp.Inch i = new QualityMeasurementApp.Inch(1.0);
        assertFalse(i.equals("abc"));
    }

    @Test
    void testInch_SameReference() {
        QualityMeasurementApp.Inch i = new QualityMeasurementApp.Inch(1.0);
        assertTrue(i.equals(i));
    }
}