package id.ac.umn.alvinoctavianus_42583_tugas1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.SpannableStringBuilderKt;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mathcollection.*;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);
    }

    private void updatetext(String inputangka){
        String angkalama = display.getText().toString();
        int cursorpos = display.getSelectionStart();
        String angkakiri = angkalama.substring(0, cursorpos);
        String angkakanan = angkalama.substring(cursorpos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(inputangka);
            display.setSelection(cursorpos + 1);
        }
        else {
            display.setText(String.format("%s%s%s", angkakiri, inputangka, angkakanan));
            display.setSelection(cursorpos + 1);
        }

    }
    public void btnnol(View view){
        updatetext("0");
    }

    public void btnsatu(View view){
        updatetext("1");
    }

    public void btnndua(View view){
        updatetext("2");
    }

    public void btntiga(View view){
        updatetext("3");
    }

    public void btnempat(View view){
        updatetext("4");
    }

    public void btnlima(View view){
        updatetext("5");
    }

    public void btnenam(View view){
        updatetext("6");
    }

    public void btntujuh(View view){
        updatetext("7");
    }

    public void btndelapan(View view){
        updatetext("8");
    }

    public void btnsembilan(View view){
        updatetext("9");
    }

    public void btnce(View view){
        int cursorpos = display.getSelectionStart();
        int textleng = display.getText().length();

        if (cursorpos != 0 && textleng != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorpos - 1, cursorpos, "");
            display.setText(selection);
            display.setSelection(cursorpos - 1);
        }
    }

    public void btnc(View view){
        display.setText("");
    }

    public void btnback(View view){
        int cursorpos = display.getSelectionStart();
        int pnjgtext = display.getText().length();

        if (cursorpos != 0 && pnjgtext != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorpos - 1, cursorpos, "");
            display.setText(selection);
            display.setSelection(cursorpos - 1);
        }
    }

    public void btnbagi(View view){
        updatetext("/");
    }

    public void btnkali(View view){
        updatetext("x");
    }

    public void btnkurang(View view){
        updatetext("-");
    }

    public void btntambah(View view){
        updatetext("+");
    }

    public void btnsamadengan(View view){
        String perhitungan = display.getText().toString();
        perhitungan = perhitungan.replaceAll("x", "*");

        Expression hitung = new Expression(perhitungan);
        String hasil = String.valueOf(hitung.calculate());
        display.setText(hasil);
        display.setSelection(hasil.length());
    }

    public void btnkoma(View view){
        updatetext(".");
    }

    public void btnplusminus(View view){
        updatetext("-");
    }
}