package com.example.aplikasikalkulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> resultsAdapter;

    TextView Text_Hasil;
    EditText Number1, Number2;
    RadioButton RadioButton_Tambah, RadioButton_Kurang, RadioButton_Kali, RadioButton_Bagi;
    Button Button_Hitung;
    CheckBox CheckBox_Hasil;
    ListView ListView_Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> resultsAdapter;

        resultsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        ListView_Hasil = findViewById(R.id.ListView_Hasil);
        ListView_Hasil.setAdapter(resultsAdapter);
    }

    public void tombolHitung(View v) {
        Number1 = (EditText) findViewById(R.id.Number1);
        Number2 = (EditText) findViewById(R.id.Number2);

        int number1 = Integer.parseInt(Number1.getText().toString());
        int number2 = Integer.parseInt(Number2.getText().toString());

        RadioButton_Tambah = (RadioButton) findViewById(R.id.RadioButton_Tambah);
        RadioButton_Kurang = (RadioButton) findViewById(R.id.RadioButton_Kurang);
        RadioButton_Kali = (RadioButton) findViewById(R.id.RadioButton_Kali);
        RadioButton_Bagi = (RadioButton) findViewById(R.id.RadioButton_Bagi);

        int result = 0;

        if (RadioButton_Tambah.isChecked()) {
            result = number1 + number2;
        } else if (RadioButton_Kurang.isChecked()) {
            result = number1 - number2;
        } else if (RadioButton_Kali.isChecked()) {
            result = number1 * number2;
        } else if (RadioButton_Bagi.isChecked()) {
            result = number1 / number2;
        }

        Text_Hasil = (TextView) findViewById(R.id.Text_Hasil);
        Text_Hasil.setText("Hasil = " + number1 + "&" + number2 + " = " + result);

        CheckBox_Hasil = (CheckBox) findViewById(R.id.CheckBox_Hasil);

        if (CheckBox_Hasil.isChecked()) {
            resultsAdapter.add("Hasil = " + number1 + "&" + number2 + " = " + result);
        }
    }
}