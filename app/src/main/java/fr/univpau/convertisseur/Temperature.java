package fr.univpau.convertisseur;

public class Temperature {

    public enum Units {
        CELSIUS, FAHRENHEIT, KELVIN
    }

    double valueInKelvin;

    public Temperature(double value, Temperature.Units from) {
        if (from == Units.CELSIUS) this.valueInKelvin = value + 273.15;
        if (from == Units.FAHRENHEIT) this.valueInKelvin = (value - 32) * 5 / 9 + 273.15;
        if (from == Units.KELVIN) this.valueInKelvin = value;
    }

    public double convert(Units to) {
        if (to == Units.CELSIUS) return this.valueInKelvin - 273.15;
        if (to == Units.FAHRENHEIT) return (this.valueInKelvin - 273.15) * 9 / 5 + 32;
        return this.valueInKelvin;
    }
}
