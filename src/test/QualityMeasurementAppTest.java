import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QualityMeasurementAppTest {

    @Test
    void testEquality_FeetToFeet_SameValue() {
        var q1 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        var q2 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_InchToInch_SameValue() {
        var q1 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.INCH);
        var q2 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.INCH);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_FeetToInch_Equivalent() {
        var q1 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        var q2 = new QualityMeasurementApp.Quantity(12.0, QualityMeasurementApp.LengthUnit.INCH);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_InchToFeet_Equivalent() {
        var q1 = new QualityMeasurementApp.Quantity(12.0, QualityMeasurementApp.LengthUnit.INCH);
        var q2 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_Feet_Different() {
        var q1 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        var q2 = new QualityMeasurementApp.Quantity(2.0, QualityMeasurementApp.LengthUnit.FEET);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_Inch_Different() {
        var q1 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.INCH);
        var q2 = new QualityMeasurementApp.Quantity(2.0, QualityMeasurementApp.LengthUnit.INCH);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_NullComparison() {
        var q1 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        assertFalse(q1.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        var q1 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        assertTrue(q1.equals(q1));
    }

    @Test
    void testEquality_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QualityMeasurementApp.Quantity(1.0, null);
        });
    }
}