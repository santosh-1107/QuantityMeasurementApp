import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QualityMeasurementAppTest {

    @Test
    void testEquality_SameValue() {
        QualityMeasurementApp.Feet f1 = new QualityMeasurementApp.Feet(1.0);
        QualityMeasurementApp.Feet f2 = new QualityMeasurementApp.Feet(1.0);
        assertTrue(f1.equals(f2));
    }

    @Test
    void testEquality_DifferentValue() {
        QualityMeasurementApp.Feet f1 = new QualityMeasurementApp.Feet(1.0);
        QualityMeasurementApp.Feet f2 = new QualityMeasurementApp.Feet(2.0);
        assertFalse(f1.equals(f2));
    }

    @Test
    void testEquality_NullComparison() {
        QualityMeasurementApp.Feet f1 = new QualityMeasurementApp.Feet(1.0);
        assertFalse(f1.equals(null));
    }

    @Test
    void testEquality_NonNumericInput() {
        QualityMeasurementApp.Feet f1 = new QualityMeasurementApp.Feet(1.0);
        assertFalse(f1.equals("abc"));
    }

    @Test
    void testEquality_SameReference() {
        QualityMeasurementApp.Feet f1 = new QualityMeasurementApp.Feet(1.0);
        assertTrue(f1.equals(f1));
    }
}