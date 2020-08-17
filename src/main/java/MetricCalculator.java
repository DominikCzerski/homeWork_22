public class MetricCalculator {


    public static double meterConverter(double value, String type) {
        switch (type) {
            case "meters":
                return value;
            case "centimeters":
                return value * 100;
            case "milimeters":
                return value * 1000;
            default:
                return value;
        }
    }

    public static double centimeterConverter(double value, String type) {
        switch (type) {
            case "meters":
                return value / 100;
            case "centimeters":
                return value;
            case "milimeters":
                return value * 100;
            default:
                return value;
        }
    }

    public static double milimeterConverter(double value, String type) {
        switch (type) {
            case "meters":
                return value / 1000;
            case "centimeters":
                return value / 100;
            case "milimeters":
                return value;
            default:
                return value;
        }
    }
}
