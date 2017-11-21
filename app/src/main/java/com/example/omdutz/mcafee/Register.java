package com.example.omdutz.mcafee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.example.omdutz.mcafee.Pojo.Validasi;
import com.example.omdutz.mcafee.VolleyClass.RegisterAndLoginVolley;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        TextWatcher{
    public static Register registerActivity;
    private Button  tombol2;
    public static   EditText nama,ktp,telp;
    public static   String   idtokoDipilih;
    private Spinner toko;
    private RelativeLayout relativeLayout;
    //buat object volley untuk kirim request
    RegisterAndLoginVolley registerAndLoginVolley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tombol2 = (Button)findViewById(R.id.tombolnext);
        tombol2.setEnabled(false);
        tombol2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
        registerAndLoginVolley = new RegisterAndLoginVolley(this);
        widgetDeclaration();
        setTokoData();
        registerActivity = Register.this;
    }
    public void validate(){
        Validasi validasi = new Validasi(getApplicationContext());
        validasi.setRule(nama,"nama");
        validasi.setRule(ktp ,"ktp");
        validasi.setRule(telp,"telp");
        if(validasi.run() == true){
            Intent c = new Intent(getApplicationContext(), Register2.class);
            startActivity(c);
        }
    }

    public void widgetDeclaration(){
        relativeLayout = (RelativeLayout) findViewById(R.id.rRegister);
        toko           = (Spinner )    findViewById(R.id.layout7);
        nama           = (EditText)    findViewById(R.id.nama);
        ktp            = (EditText)    findViewById(R.id.KTP);
        telp           = (EditText)    findViewById(R.id.HP);
        nama.addTextChangedListener(this);
        ktp .addTextChangedListener(this);
        telp.addTextChangedListener(this);
    }

    public void setTokoData(){
        registerAndLoginVolley.setListNamaToko(toko);
        toko.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        idtokoDipilih = registerAndLoginVolley.getListIdtoko().get(i);
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(!nama.getText().toString().isEmpty()
                && !telp.getText().toString().isEmpty()
                && !ktp.getText().toString().isEmpty()){
            tombol2.setEnabled(true);
        }else{
            tombol2.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
