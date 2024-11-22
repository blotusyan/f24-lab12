package edu.cmu.Weather;

public class Weather {
    private WeatherService weatherService;

    // Enum to represent supported length scales
    public enum LengthScale {
        INCHES,
        MILLIMETERS
    }

    private LengthScale lengthScale = LengthScale.MILLIMETERS;

    /**
     * Sets the length scale for rainfall.
     *
     * @param scale the desired length scale (INCHES or MILLIMETERS).
     */
    public void setLengthScale(LengthScale scale) {
        if (scale == null) {
            throw new IllegalArgumentException("Scale cannot be null");
        }
        this.lengthScale = scale;
    }

    /**
     * Retrieves the rainfall measurement over the last 24 hours from the weather service in the preferred scale.
     *
     * @return the rainfall amount in the preferred scale (INCHES or MILLIMETERS).
     */
    public double getRainfall() {
        double wsRainfall = weatherService.getRainfall(); // Assume this returns rainfall in millimeters

        switch (lengthScale) {
            case INCHES:
                return wsRainfall / 25.4; // Convert millimeters to inches
            case MILLIMETERS:
                return wsRainfall;
            default:
                throw new IllegalStateException("Unexpected length scale: " + lengthScale);
        }
    }
}
