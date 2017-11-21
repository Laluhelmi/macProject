<<<<<<< HEAD
    package com.example.omdutz.mcafee;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.omdutz.mcafee.VolleyClass.RegisterAndLoginVolley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

    public class Register2 extends AppCompatActivity implements TextWatcher{
    private Button  verifikasi;
    private EditText email,password,repassword;
    private RelativeLayout relativeLayout;
    public static Register2 register2Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        define();
        verifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
                relativeLayout.setVisibility(View.VISIBLE);
                verifikasi.setVisibility(View.INVISIBLE);
            }
        });
    }
    public void validate(){
        RelativeLayout relativeLayout = ((RelativeLayout)findViewById(R.id.relateive));
        if(cekEmail(email.getText().toString()) == false){
            Snackbar.make(relativeLayout,
                    "Format Email Tidak Valid",Snackbar.LENGTH_SHORT).show();
         }else if(password.getText().toString().length() < 6){
            Snackbar.make(((RelativeLayout)findViewById(R.id.relateive)),
                    "Password Minimal 6 Karakter",Snackbar.LENGTH_SHORT).show();
        }

        else if(!password .getText().toString().equals(
                repassword.getText().toString()
        )){
            Snackbar.make(((RelativeLayout)findViewById(R.id.relateive)),
                    "Password Tidak Sama",Snackbar.LENGTH_SHORT).show();
        }else{
            kirimRegistrasi();
        }
    }

    public void kirimRegistrasi(){
        Map<String,String> dataRegistrasi = new HashMap<>();
        dataRegistrasi.put("no_ktp"         ,Register.ktp.getText().toString());
        dataRegistrasi.put("nama_user"      ,Register.nama.getText().toString());
        dataRegistrasi.put("telp"           ,Register.telp.getText().toString());
        dataRegistrasi.put("email"          ,email.getText().toString());
        dataRegistrasi.put("password"       ,password.getText().toString());
        dataRegistrasi.put("id_toko"        ,Register.idtokoDipilih);
        dataRegistrasi.put("re_password"    ,repassword.getText().toString());
        RegisterAndLoginVolley registerAndLoginVolley = new RegisterAndLoginVolley(this);
        registerAndLoginVolley.register(dataRegistrasi);
    }

    public boolean cekEmail(String email){
        return Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(email).matches();
    }
    public void define(){
        verifikasi = (Button)findViewById(R.id.tombolverifikasi);
        verifikasi.setEnabled(false);
        password   = (EditText)findViewById(R.id.password);
        repassword = (EditText)findViewById(R.id.ulangpassword);
        email      = (EditText)findViewById(R.id.email);
        relativeLayout = (RelativeLayout)findViewById(R.id.relativeloading);
        email.addTextChangedListener(this);
        repassword.addTextChangedListener(this);
        password.addTextChangedListener(this);
        register2Activity = Register2.this;

    }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(!email.getText().toString().isEmpty()
                    && !verifikasi.getText().toString().isEmpty()
                    && !repassword.getText().toString().isEmpty()){
                verifikasi.setEnabled(true);
            }else{
                verifikasi.setEnabled(false);
            }

        }
        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
=======
    package com.example.omdutz.mcafee;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.omdutz.mcafee.VolleyClass.RegisterAndLoginVolley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

    public class Register2 extends AppCompatActivity implements TextWatcher{
    private Button  verifikasi;
    private EditText email,password,repassword;
    private RelativeLayout relativeLayout;
    public static Register2 register2Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        define();
        verifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
                relativeLayout.setVisibility(View.VISIBLE);
                verifikasi.setVisibility(View.INVISIBLE);
            }
        });
    }
    public void validate(){
        RelativeLayout relativeLayout = ((RelativeLayout)findViewById(R.id.relateive));
        if(cekEmail(email.getText().toString()) == false){
            Snackbar.make(relativeLayout,
                    "Format Email Tidak Valid",Snackbar.LENGTH_SHORT).show();
         }else if(password.getText().toString().length() < 6){
            Snackbar.make(((RelativeLayout)findViewById(R.id.relateive)),
                    "Password Minimal 6 Karakter",Snackbar.LENGTH_SHORT).show();
        }

        else if(!password .getText().toString().equals(
                repassword.getText().toString()
        )){
            Snackbar.make(((RelativeLayout)findViewById(R.id.relateive)),
                    "Password Tidak Sama",Snackbar.LENGTH_SHORT).show();
        }else{
            kirimRegistrasi();
        }
    }

    public void kirimRegistrasi(){
        Map<String,String> dataRegistrasi = new HashMap<>();
        dataRegistrasi.put("no_ktp"         ,Register.ktp.getText().toString());
        dataRegistrasi.put("nama_user"      ,Register.nama.getText().toString());
        dataRegistrasi.put("telp"           ,Register.telp.getText().toString());
        dataRegistrasi.put("email"          ,email.getText().toString());
        dataRegistrasi.put("password"       ,password.getText().toString());
        dataRegistrasi.put("id_toko"        ,Register.idtokoDipilih);
        dataRegistrasi.put("re_password"    ,repassword.getText().toString());
        RegisterAndLoginVolley registerAndLoginVolley = new RegisterAndLoginVolley(this);
        registerAndLoginVolley.register(dataRegistrasi);
    }

    public boolean cekEmail(String email){
        return Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(email).matches();
    }
    public void define(){
        verifikasi = (Button)findViewById(R.id.tombolverifikasi);
        verifikasi.setEnabled(false);
        password   = (EditText)findViewById(R.id.password);
        repassword = (EditText)findViewById(R.id.ulangpassword);
        email      = (EditText)findViewById(R.id.email);
        relativeLayout = (RelativeLayout)findViewById(R.id.relativeloading);
        email.addTextChangedListener(this);
        repassword.addTextChangedListener(this);
        password.addTextChangedListener(this);
        register2Activity = Register2.this;

    }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(!email.getText().toString().isEmpty()
                    && !verifikasi.getText().toString().isEmpty()
                    && !repassword.getText().toString().isEmpty()){
                verifikasi.setEnabled(true);
            }else{
                verifikasi.setEnabled(false);
            }

        }
        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
>>>>>>> e5762bda42aa311e6fc9d1dfbc9464c189f50a0c
