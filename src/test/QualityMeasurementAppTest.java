import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QualityMeasurementAppTest {

    @Test
    void testKgToKg() {
        var a = new QualityMeasurementApp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var b = new QualityMeasurementApp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertTrue(a.equals(b));
    }

    @Test
    void testKgToGram() {
        var a = new QualityMeasurementApp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var b = new QualityMeasurementApp.QuantityWeight(1000.0, WeightUnit.GRAM);
        assertTrue(a.equals(b));
    }

    @Test
    void testKgToPound() {
        var a = new QualityMeasurementApp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var b = new QualityMeasurementApp.QuantityWeight(2.20462, WeightUnit.POUND);
        assertTrue(a.equals(b));
    }

    @Test
    void testConvert() {
        var a = new QualityMeasurementApp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        assertEquals(1000.0, a.convertTo(WeightUnit.GRAM).getValue(), 1e-6);
    }

    @Test
    void testAddSameUnit() {
        var a = new QualityMeasurementApp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var b = new QualityMeasurementApp.QuantityWeight(2.0, WeightUnit.KILOGRAM);
        assertEquals(3.0, a.add(b).getValue(), 1e-6);
    }

    @Test
    void testAddDifferentUnit() {
        var a = new QualityMeasurementApp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var b = new QualityMeasurementApp.QuantityWeight(1000.0, WeightUnit.GRAM);
        assertEquals(2.0, a.add(b).getValue(), 1e-6);
    }

    @Test
    void testAddTargetUnit() {
        var a = new QualityMeasurementApp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var b = new QualityMeasurementApp.QuantityWeight(1000.0, WeightUnit.GRAM);
        assertEquals(2000.0, a.add(b, WeightUnit.GRAM).getValue(), 1e-6);
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QualityMeasurementApp.QuantityWeight(1.0, null);
        });
    }

    @Test
    void testNegative() {
        var a = new QualityMeasurementApp.QuantityWeight(5.0, WeightUnit.KILOGRAM);
        var b = new QualityMeasurementApp.QuantityWeight(-2.0, WeightUnit.KILOGRAM);
        assertEquals(3.0, a.add(b).getValue(), 1e-6);
    }
}