/*
 * Temperature.java, 24/10/2024
 * UPPA M2 TI 2024-2025
 * MIT License (MIT)
 */

package fr.univpau.convertisseur;

/**
 * Class representing a temperature value.
 *
 * @author LucasVbr
 */
public class Temperature {

    /** Enumeration of the units for temperature. */
    public enum Units {
        CELSIUS, FAHRENHEIT, KELVIN, RANKINE, REAUMUR
    }

    /** The value of the temperature in Kelvin. */
    double valueInKelvin;

    /**
     * Create a new temperature value.
     *
     * @param value The value of the temperature.
     * @param from  The unit of the temperature value.
     */
    public Temperature(double value, Temperature.Units from) {
        if (from == Units.CELSIUS) this.valueInKelvin = value + 273.15;
        if (from == Units.FAHRENHEIT) this.valueInKelvin = (value - 32) * 5 / 9 + 273.15;
        if (from == Units.KELVIN) this.valueInKelvin = value;
        if (from == Units.RANKINE) this.valueInKelvin = (value - 491.67) * 5 / 9;
        if (from == Units.REAUMUR) this.valueInKelvin = value * 5 / 4 + 273.15;
    }

    /**
     * Convert the temperature to the given unit.
     *
     * @param to The unit to convert to.
     * @return The value of the temperature in the given unit.
     */
    public double convert(Units to) {
        if (to == Units.CELSIUS) return this.valueInKelvin - 273.15;
        if (to == Units.FAHRENHEIT) return (this.valueInKelvin - 273.15) * 9 / 5 + 32;
        if (to == Units.RANKINE) return (this.valueInKelvin) * 9 / 5;
        if (to == Units.REAUMUR) return (this.valueInKelvin - 273.15) * 4 / 5;

        return this.valueInKelvin;
    }
}
