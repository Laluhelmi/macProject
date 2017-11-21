<<<<<<< HEAD
package com.example.omdutz.mcafee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    private Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.tombollogin);
        register = (Button)findViewById(R.id.tombolregister);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f = new Intent(Login.this,Draw.class);
                startActivity(f);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(),Register.class);
                startActivity(a);
            }
        });
    }
}
=======
package com.example.omdutz.mcafee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.omdutz.mcafee.Interface.LoginRespon;
import com.example.omdutz.mcafee.VolleyClass.RegisterAndLoginVolley;

public class Login extends AppCompatActivity {
    private Button          login,register;
    private EditText        email,password;
    private RelativeLayout formlogin,loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.tombollogin);
        register = (Button)findViewById(R.id.tombolregister);

        email       = (EditText)findViewById(R.id.editlogin);
        password    = (EditText)findViewById(R.id.passwordlogin);
        formlogin   = (RelativeLayout)findViewById(R.id.loginform);
        loading     = (RelativeLayout)findViewById(R.id.rloading);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formlogin.setVisibility(View.INVISIBLE);
                loading  .setVisibility(View.VISIBLE);
                RegisterAndLoginVolley registerAndLoginVolley
                         = new RegisterAndLoginVolley(getApplicationContext());
                String e = email    .getText().toString();
                String p = password .getText().toString();
                registerAndLoginVolley.cekLogin(e, p, new LoginRespon() {
                    @Override
                    public void sukses() {
                        startActivity(new Intent(getApplicationContext(),Draw.class));
                        finish();
                    }
                    @Override
                    public void gagal(String pesan) {
                        formlogin.setVisibility(View.VISIBLE);
                        loading  .setVisibility(View.INVISIBLE);

                        Toast.makeText(Login.this, pesan,
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(),Register.class);
                startActivity(a);
            }
        });
    }
}
>>>>>>> e5762bda42aa311e6fc9d1dfbc9464c189f50a0c
