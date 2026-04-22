public class QualityMeasurementApp {

    public static class QuantityWeight {
        private final double value;
        private final WeightUnit unit;

        public QuantityWeight(double value, WeightUnit unit) {
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

        public QuantityWeight convertTo(WeightUnit target) {
            if (target == null) throw new IllegalArgumentException();
            double base = this.toBase();
            double result = target.convertFromBase(base);
            return new QuantityWeight(result, target);
        }

        public QuantityWeight add(QuantityWeight other) {
            if (other == null) throw new IllegalArgumentException();
            double sum = this.toBase() + other.toBase();
            double result = unit.convertFromBase(sum);
            return new QuantityWeight(result, unit);
        }

        public QuantityWeight add(QuantityWeight other, WeightUnit target) {
            if (other == null || target == null) throw new IllegalArgumentException();
            double sum = this.toBase() + other.toBase();
            double result = target.convertFromBase(sum);
            return new QuantityWeight(result, target);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            QuantityWeight q = (QuantityWeight) obj;
            return Math.abs(this.toBase() - q.toBase()) < 1e-3;
        }
    }
}