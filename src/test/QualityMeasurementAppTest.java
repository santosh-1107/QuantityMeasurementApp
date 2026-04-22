import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QualityMeasurementAppTest {

    @Test
    void testFeetToInch() {
        assertEquals(12.0, QualityMeasurementApp.convert(1.0,
                QualityMeasurementApp.LengthUnit.FEET,
                QualityMeasurementApp.LengthUnit.INCH), 1e-6);
    }

    @Test
    void testInchToFeet() {
        assertEquals(2.0, QualityMeasurementApp.convert(24.0,
                QualityMeasurementApp.LengthUnit.INCH,
                QualityMeasurementApp.LengthUnit.FEET), 1e-6);
    }

    @Test
    void testYardToInch() {
        assertEquals(36.0, QualityMeasurementApp.convert(1.0,
                QualityMeasurementApp.LengthUnit.YARD,
                QualityMeasurementApp.LengthUnit.INCH), 1e-6);
    }

    @Test
    void testInchToYard() {
        assertEquals(2.0, QualityMeasurementApp.convert(72.0,
                QualityMeasurementApp.LengthUnit.INCH,
                QualityMeasurementApp.LengthUnit.YARD), 1e-6);
    }

    @Test
    void testCmToInch() {
        assertEquals(1.0, QualityMeasurementApp.convert(2.54,
                QualityMeasurementApp.LengthUnit.CENTIMETER,
                QualityMeasurementApp.LengthUnit.INCH), 1e-6);
    }

    @Test
    void testFeetToYard() {
        assertEquals(2.0, QualityMeasurementApp.convert(6.0,
                QualityMeasurementApp.LengthUnit.FEET,
                QualityMeasurementApp.LengthUnit.YARD), 1e-6);
    }

    @Test
    void testRoundTrip() {
        double v = 5.0;
        double result = QualityMeasurementApp.convert(
                QualityMeasurementApp.convert(v,
                        QualityMeasurementApp.LengthUnit.FEET,
                        QualityMeasurementApp.LengthUnit.INCH),
                QualityMeasurementApp.LengthUnit.INCH,
                QualityMeasurementApp.LengthUnit.FEET);
        assertEquals(v, result, 1e-6);
    }

    @Test
    void testZero() {
        assertEquals(0.0, QualityMeasurementApp.convert(0.0,
                QualityMeasurementApp.LengthUnit.FEET,
                QualityMeasurementApp.LengthUnit.INCH), 1e-6);
    }

    @Test
    void testNegative() {
        assertEquals(-12.0, QualityMeasurementApp.convert(-1.0,
                QualityMeasurementApp.LengthUnit.FEET,
                QualityMeasurementApp.LengthUnit.INCH), 1e-6);
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            QualityMeasurementApp.convert(1.0, null,
                    QualityMeasurementApp.LengthUnit.FEET);
        });
    }

    @Test
    void testNaN() {
        assertThrows(IllegalArgumentException.class, () -> {
            QualityMeasurementApp.convert(Double.NaN,
                    QualityMeasurementApp.LengthUnit.FEET,
                    QualityMeasurementApp.LengthUnit.INCH);
        });
    }
}