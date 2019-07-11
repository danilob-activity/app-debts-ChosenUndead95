package com.example.danilo.appdebts;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class InsertDebts extends AppCompatActivity {
    EditText mEdtextDataPay;
    final Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_debts);
        getSupportActionBar().setDisplayHomeAsUpEnabled( true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled( true);//Ativar o botão
        getSupportActionBar().setTitle( R.string.titleInsert);

        mEdtextDataPay= (EditText) findViewById(R.id.editTextDate);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            //    updateLabel();
            }

        };

        mEdtextDataPay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(InsertDebts.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }
    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mEdtextDataPay.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu. menu_add_debts,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão na ToolBar
        switch (item.getItemId()) {
            case android.R.id. home: //ID do seu botão (gerado automaticamente pelo android, usando comoestá, deve funcionar
                startActivity( new Intent(this, MainWindow. class)); //O efeito ao ser pressionado do botão(no caso abre a activity)
                finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }
}
