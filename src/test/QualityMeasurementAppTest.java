import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QualityMeasurementAppTest {

    @Test
    void testTargetFeet() {
        var a = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(12.0, QualityMeasurementApp.LengthUnit.INCH);
        assertEquals(2.0, a.add(b, QualityMeasurementApp.LengthUnit.FEET).getValue(), 1e-6);
    }

    @Test
    void testTargetInch() {
        var a = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(12.0, QualityMeasurementApp.LengthUnit.INCH);
        assertEquals(24.0, a.add(b, QualityMeasurementApp.LengthUnit.INCH).getValue(), 1e-6);
    }

    @Test
    void testTargetYard() {
        var a = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(12.0, QualityMeasurementApp.LengthUnit.INCH);
        assertEquals(0.6667, a.add(b, QualityMeasurementApp.LengthUnit.YARD).getValue(), 1e-3);
    }

    @Test
    void testTargetCm() {
        var a = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.INCH);
        var b = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.INCH);
        assertEquals(5.08, a.add(b, QualityMeasurementApp.LengthUnit.CENTIMETER).getValue(), 1e-2);
    }

    @Test
    void testSameAsFirst() {
        var a = new QualityMeasurementApp.Quantity(2.0, QualityMeasurementApp.LengthUnit.YARD);
        var b = new QualityMeasurementApp.Quantity(3.0, QualityMeasurementApp.LengthUnit.FEET);
        assertEquals(3.0, a.add(b, QualityMeasurementApp.LengthUnit.YARD).getValue(), 1e-6);
    }

    @Test
    void testSameAsSecond() {
        var a = new QualityMeasurementApp.Quantity(2.0, QualityMeasurementApp.LengthUnit.YARD);
        var b = new QualityMeasurementApp.Quantity(3.0, QualityMeasurementApp.LengthUnit.FEET);
        assertEquals(9.0, a.add(b, QualityMeasurementApp.LengthUnit.FEET).getValue(), 1e-6);
    }

    @Test
    void testCommutativity() {
        var a = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(12.0, QualityMeasurementApp.LengthUnit.INCH);
        double r1 = a.add(b, QualityMeasurementApp.LengthUnit.YARD).getValue();
        double r2 = b.add(a, QualityMeasurementApp.LengthUnit.YARD).getValue();
        assertEquals(r1, r2, 1e-6);
    }

    @Test
    void testZero() {
        var a = new QualityMeasurementApp.Quantity(5.0, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(0.0, QualityMeasurementApp.LengthUnit.INCH);
        assertEquals(1.6667, a.add(b, QualityMeasurementApp.LengthUnit.YARD).getValue(), 1e-3);
    }

    @Test
    void testNegative() {
        var a = new QualityMeasurementApp.Quantity(5.0, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(-2.0, QualityMeasurementApp.LengthUnit.FEET);
        assertEquals(36.0, a.add(b, QualityMeasurementApp.LengthUnit.INCH).getValue(), 1e-6);
    }

    @Test
    void testNullTarget() {
        var a = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> a.add(b, null));
    }
}