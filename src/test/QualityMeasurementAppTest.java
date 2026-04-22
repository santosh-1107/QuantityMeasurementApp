import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QualityMeasurementAppTest {

    @Test
    void testFeetPlusFeet() {
        var a = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(2.0, QualityMeasurementApp.LengthUnit.FEET);
        assertEquals(3.0, a.add(b).getValue(), 1e-6);
    }

    @Test
    void testInchPlusInch() {
        var a = new QualityMeasurementApp.Quantity(6.0, QualityMeasurementApp.LengthUnit.INCH);
        var b = new QualityMeasurementApp.Quantity(6.0, QualityMeasurementApp.LengthUnit.INCH);
        assertEquals(12.0, a.add(b).getValue(), 1e-6);
    }

    @Test
    void testFeetPlusInch() {
        var a = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(12.0, QualityMeasurementApp.LengthUnit.INCH);
        assertEquals(2.0, a.add(b).getValue(), 1e-6);
    }

    @Test
    void testInchPlusFeet() {
        var a = new QualityMeasurementApp.Quantity(12.0, QualityMeasurementApp.LengthUnit.INCH);
        var b = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        assertEquals(24.0, a.add(b).getValue(), 1e-6);
    }

    @Test
    void testYardPlusFeet() {
        var a = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.YARD);
        var b = new QualityMeasurementApp.Quantity(3.0, QualityMeasurementApp.LengthUnit.FEET);
        assertEquals(2.0, a.add(b).getValue(), 1e-6);
    }

    @Test
    void testCmPlusInch() {
        var a = new QualityMeasurementApp.Quantity(2.54, QualityMeasurementApp.LengthUnit.CENTIMETER);
        var b = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.INCH);
        assertEquals(5.08, a.add(b).getValue(), 1e-2);
    }

    @Test
    void testCommutativity() {
        var a = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(12.0, QualityMeasurementApp.LengthUnit.INCH);
        double r1 = a.add(b).getValue();
        double r2 = b.add(a).getValue();
        assertEquals(2.0, r1, 1e-6);
        assertEquals(24.0, r2, 1e-6);
    }

    @Test
    void testZero() {
        var a = new QualityMeasurementApp.Quantity(5.0, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(0.0, QualityMeasurementApp.LengthUnit.INCH);
        assertEquals(5.0, a.add(b).getValue(), 1e-6);
    }

    @Test
    void testNegative() {
        var a = new QualityMeasurementApp.Quantity(5.0, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(-2.0, QualityMeasurementApp.LengthUnit.FEET);
        assertEquals(3.0, a.add(b).getValue(), 1e-6);
    }

    @Test
    void testNullOperand() {
        var a = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> a.add(null));
    }

    @Test
    void testLargeValues() {
        var a = new QualityMeasurementApp.Quantity(1e6, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(1e6, QualityMeasurementApp.LengthUnit.FEET);
        assertEquals(2e6, a.add(b).getValue(), 1e-6);
    }

    @Test
    void testSmallValues() {
        var a = new QualityMeasurementApp.Quantity(0.001, QualityMeasurementApp.LengthUnit.FEET);
        var b = new QualityMeasurementApp.Quantity(0.002, QualityMeasurementApp.LengthUnit.FEET);
        assertEquals(0.003, a.add(b).getValue(), 1e-6);
    }
}