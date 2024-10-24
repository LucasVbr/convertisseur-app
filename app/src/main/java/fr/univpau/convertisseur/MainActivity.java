/*
 * ConvertisseurMainActivity.java, 24/10/2024
 * UPPA M2 TI 2024-2025
 * MIT License (MIT)
 */

package fr.univpau.convertisseur;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Main activity of the application.
 *
 * @author LucasVbr
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.convertisseur_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final Button convertButton = findViewById(R.id.btn_convert);
        convertButton.setOnClickListener(new OnConvertListener(
                findViewById(R.id.spinner_from),
                findViewById(R.id.spinner_to),
                findViewById(R.id.input_from),
                findViewById(R.id.input_to)
        ));
    }
}