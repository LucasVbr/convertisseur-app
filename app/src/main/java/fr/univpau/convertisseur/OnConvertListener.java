package fr.univpau.convertisseur;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class OnConvertListener implements View.OnClickListener {

    private final Spinner spinnerFrom;
    private final Spinner spinnerTo;
    private final EditText inputFrom;
    private final EditText inputTo;

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

    private double getInputValue(EditText input) {
        String inputFromText = input.getText().toString();
        if (inputFromText.isEmpty()) return 0;
        return Double.parseDouble(inputFromText);
    }

    private Temperature.Units getUnit(Spinner spinner) {
        int unitIndex = spinner.getSelectedItemPosition();
        return Temperature.Units.values()[unitIndex];
    }
}
