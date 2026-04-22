public class QualityMeasurementApp {

    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CENTIMETER(0.393701 / 12.0);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double toFeet(double value) {
            return value * factor;
        }
    }

    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null || !Double.isFinite(value)) throw new IllegalArgumentException();
            this.value = value;
            this.unit = unit;
        }

        public Quantity convertTo(LengthUnit target) {
            if (target == null) throw new IllegalArgumentException();
            double feet = unit.toFeet(value);
            double converted = feet / target.toFeet(1.0);
            return new Quantity(converted, target);
        }

        private double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quantity q = (Quantity) obj;
            return Double.compare(this.toFeet(), q.toFeet()) == 0;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (source == null || target == null || !Double.isFinite(value)) throw new IllegalArgumentException();
        double feet = source.toFeet(value);
        return feet / target.toFeet(1.0);
    }

    public static void main(String[] args) {
        System.out.println(convert(1.0, LengthUnit.FEET, LengthUnit.INCH));
        System.out.println(convert(3.0, LengthUnit.YARD, LengthUnit.FEET));
    }
}