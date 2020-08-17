public class WeightCalculator {

    public static double kilogramsConverter(double value, String type) {
        switch (type) {
            case "kilograms":
                return value;
            case "grams":
                return value * 1000;
            case "miligrams":
                return value * 1_000_000;
            default:
                return value;
        }
    }

    public static double gramsConverter(double value, String type) {
        switch (type) {
            case "kilograms":
                return value / 1000;
            case "grams":
                return value;
            case "miligrams":
                return value * 1000;
            default:
                return value;
        }
    }

    public static double miligramsConverter(double value, String type) {
        switch (type) {
            case "kilograms":
                return value / 1_000_000;
            case "grams":
                return value / 1000;
            case "miligrams":
                return value;
            default:
                return value;
        }
    }
}
