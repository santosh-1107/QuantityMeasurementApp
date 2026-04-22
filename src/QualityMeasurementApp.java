public class QualityMeasurementApp {

    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null || !Double.isFinite(value)) throw new IllegalArgumentException();
            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        private double toBase() {
            return unit.convertToBase(value);
        }

        public Quantity convertTo(LengthUnit target) {
            if (target == null) throw new IllegalArgumentException();
            double base = this.toBase();
            double result = target.convertFromBase(base);
            return new Quantity(result, target);
        }

        public Quantity add(Quantity other) {
            if (other == null) throw new IllegalArgumentException();
            double sumBase = this.toBase() + other.toBase();
            double result = unit.convertFromBase(sumBase);
            return new Quantity(result, unit);
        }

        public Quantity add(Quantity other, LengthUnit target) {
            if (other == null || target == null) throw new IllegalArgumentException();
            double sumBase = this.toBase() + other.toBase();
            double result = target.convertFromBase(sumBase);
            return new Quantity(result, target);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Quantity q = (Quantity) obj;
            return Double.compare(this.toBase(), q.toBase()) == 0;
        }
    }

    public static void main(String[] args) {
        Quantity a = new Quantity(1.0, LengthUnit.FEET);
        Quantity b = new Quantity(12.0, LengthUnit.INCH);
        System.out.println(a.convertTo(LengthUnit.INCH).getValue());
    }
}