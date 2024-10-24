/*
 * OnConvertListener.java, 24/10/2024
 * UPPA M2 TI 2024-2025
 * MIT License (MIT)
 */


package fr.univpau.convertisseur;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Listener for the convert button.
 *
 * @author LucasVbr
 */
public class OnConvertListener implements View.OnClickListener {

    /** The spinner for the unit to convert from. */
    private final Spinner spinnerFrom;

    /** The spinner for the unit to convert to. */
    private final Spinner spinnerTo;

    /** The input field for the value to convert. */
    private final EditText inputFrom;

    /** The input field for the result of the conversion. */
    private final EditText inputTo;

    /**
     * Create a new listener for the convert button.
     * @param spinnerFrom The spinner for the unit to convert from.
     * @param spinnerTo The spinner for the unit to convert to.
     * @param inputFrom The input field for the value to convert.
     * @param inputTo The input field for the result of the conversion.
     */
    public OnConvertListener(Spinner spinnerFrom, Spinner spinnerTo, EditText inputFrom, EditText inputTo) {
        this.spinnerFrom = spinnerFrom;
        this.spinnerTo = spinnerTo;
        this.inputFrom = inputFrom;
        this.inputTo = inputTo;
    }

    @Override
    public void onClick(View view) {
        final double inputValue = getInputValue(this.inputFrom);
        final Temperature.Units fromUnit = getUnit(this.spinnerFrom);
        final Temperature.Units toUnit = getUnit(this.spinnerTo);

        Temperature temperature = new Temperature(inputValue, fromUnit);

        try {
            double result = temperature.convert(toUnit);
            this.inputTo.setText(String.format("%.2f", result));
        } catch (IllegalArgumentException e) {
            Log.e("OnConvertListener", "Invalid conversion", e);
        }
    }

    /**
     * Get the value from an input field.
     * @param input The input field.
     * @return The value from the input field as a double.
     */
    private double getInputValue(EditText input) {
        String inputFromText = input.getText().toString();
        if (inputFromText.isEmpty()) return 0;
        return Double.parseDouble(inputFromText);
    }

    /**
     * Get the unit from a spinner.
     * @param spinner The spinner.
     * @return The unit from the spinner.
     */
    private Temperature.Units getUnit(Spinner spinner) {
        int unitIndex = spinner.getSelectedItemPosition();
        return Temperature.Units.values()[unitIndex];
    }
}
