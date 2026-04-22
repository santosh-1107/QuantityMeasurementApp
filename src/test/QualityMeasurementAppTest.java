import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QualityMeasurementAppTest {

    @Test
    void testFeetToInchConversion() {
        var q = new QualityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        assertEquals(12.0, q.convertTo(LengthUnit.INCH).getValue(), 1e-6);
    }

    @Test
    void testEquality() {
        var a = new QualityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(12.0, LengthUnit.INCH);
        assertTrue(a.equals(b));
    }

    @Test
    void testAdditionDefaultUnit() {
        var a = new QualityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(12.0, LengthUnit.INCH);
        assertEquals(2.0, a.add(b).getValue(), 1e-6);
    }

    @Test
    void testAdditionWithTargetUnit() {
        var a = new QualityMeasurementApp.Quantity(1.0, LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(12.0, LengthUnit.INCH);
        assertEquals(0.6667, a.add(b, LengthUnit.YARD).getValue(), 1e-3);
    }

    @Test
    void testCmToInch() {
        var q = new QualityMeasurementApp.Quantity(2.54, LengthUnit.CENTIMETER);
        assertEquals(1.0, q.convertTo(LengthUnit.INCH).getValue(), 1e-6);
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QualityMeasurementApp.Quantity(1.0, null);
        });
    }

    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QualityMeasurementApp.Quantity(Double.NaN, LengthUnit.FEET);
        });
    }
}