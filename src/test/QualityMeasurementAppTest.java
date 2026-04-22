import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QualityMeasurementAppTest {

    @Test
    void testYard_Same() {
        var q1 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.YARD);
        var q2 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.YARD);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testYard_Different() {
        var q1 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.YARD);
        var q2 = new QualityMeasurementApp.Quantity(2.0, QualityMeasurementApp.LengthUnit.YARD);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testYardToFeet() {
        var q1 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.YARD);
        var q2 = new QualityMeasurementApp.Quantity(3.0, QualityMeasurementApp.LengthUnit.FEET);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testFeetToYard() {
        var q1 = new QualityMeasurementApp.Quantity(3.0, QualityMeasurementApp.LengthUnit.FEET);
        var q2 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.YARD);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testYardToInch() {
        var q1 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.YARD);
        var q2 = new QualityMeasurementApp.Quantity(36.0, QualityMeasurementApp.LengthUnit.INCH);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testCmToInch() {
        var q1 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.CENTIMETER);
        var q2 = new QualityMeasurementApp.Quantity(0.393701, QualityMeasurementApp.LengthUnit.INCH);
        assertTrue(q1.equals(q2));
    }

    @Test
    void testCmToFeet_NotEqual() {
        var q1 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.CENTIMETER);
        var q2 = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.FEET);
        assertFalse(q1.equals(q2));
    }

    @Test
    void testTransitive() {
        var a = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.YARD);
        var b = new QualityMeasurementApp.Quantity(3.0, QualityMeasurementApp.LengthUnit.FEET);
        var c = new QualityMeasurementApp.Quantity(36.0, QualityMeasurementApp.LengthUnit.INCH);
        assertTrue(a.equals(b) && b.equals(c) && a.equals(c));
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QualityMeasurementApp.Quantity(1.0, null);
        });
    }

    @Test
    void testSameReference() {
        var q = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.YARD);
        assertTrue(q.equals(q));
    }

    @Test
    void testNullComparison() {
        var q = new QualityMeasurementApp.Quantity(1.0, QualityMeasurementApp.LengthUnit.YARD);
        assertFalse(q.equals(null));
    }

    @Test
    void testComplexAllUnits() {
        var a = new QualityMeasurementApp.Quantity(2.0, QualityMeasurementApp.LengthUnit.YARD);
        var b = new QualityMeasurementApp.Quantity(6.0, QualityMeasurementApp.LengthUnit.FEET);
        var c = new QualityMeasurementApp.Quantity(72.0, QualityMeasurementApp.LengthUnit.INCH);
        assertTrue(a.equals(b) && b.equals(c) && a.equals(c));
    }
}