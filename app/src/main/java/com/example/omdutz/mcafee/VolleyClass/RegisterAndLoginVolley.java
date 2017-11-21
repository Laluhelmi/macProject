package com.example.omdutz.mcafee.VolleyClass;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.omdutz.mcafee.ClientPackage.Http;
<<<<<<< HEAD
import com.example.omdutz.mcafee.Pojo.RegisterPojo;
=======
import com.example.omdutz.mcafee.Interface.LoginRespon;
>>>>>>> e5762bda42aa311e6fc9d1dfbc9464c189f50a0c
import com.example.omdutz.mcafee.Register;
import com.example.omdutz.mcafee.Register2;
import com.example.omdutz.mcafee.RegisterSukses;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by L on 16/11/17.
 */

public class RegisterAndLoginVolley {
    private Context      context;
    private RequestQueue requestQueue;
    private List<String> listIdToko;

    public RegisterAndLoginVolley(Context context){
        this.context       = context;
        this.requestQueue  = Volley.newRequestQueue(this.context);
    }

    public void setListNamaToko(final Spinner spinner){
                           listIdToko = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(
                Http.url + "toko", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    List<String> listToko   = new ArrayList<>();
                    JSONArray jsonArray = new JSONArray(response);
                    for(int i = 0;i < jsonArray.length();i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        listToko    .add(object.getString("nama_toko"));
                        listIdToko  .add(object.getString("id_toko"   ));
                    }
                    ArrayAdapter<String> adapter  = new ArrayAdapter<String>(context,
                            android.support.design.R.layout.support_simple_spinner_dropdown_item,
                            listToko);
                    adapter.setDropDownViewResource(
                            android.support.design.R.layout.support_simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);

                }catch (Exception e){
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        },onVolleyError());
        stringRequest.setRetryPolicy(this.requstTimeOut());
        this.requestQueue.add(stringRequest);
    }
    public List<String> getListIdtoko(){
        return listIdToko;
    }
    public void register(final Map<String,String> data){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Http.url + "user/index_pojo", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("registrasi",response);

                Register.registerActivity   .finish();
                Register2.register2Activity .finish();;

                context.startActivity(new Intent(context, RegisterSukses.class));
            }
        }, onVolleyError()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return data;
            }
        };
        stringRequest.setRetryPolicy(this.requstTimeOut());
        this.requestQueue.add(stringRequest);
    }

<<<<<<< HEAD
    public void cekLogin(final String email, final String password){
         StringRequest stringRequest = new StringRequest(Request.Method.POST, Http.url + "",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

=======
    public void cekLogin(final String email, final String password, final LoginRespon respon){
         StringRequest stringRequest = new StringRequest(Request.Method.POST, Http.url + "login",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try{
                        JSONObject object = new JSONObject(response);
                        if(object.getString("status").equals("succes ")){
                            respon.sukses();
                        }else{
                            String pesan = object.getString("message");
                            respon.gagal(pesan);
                        }

                    }catch (Exception e){
                        Log.d("Error",e.getMessage());
                    }
>>>>>>> e5762bda42aa311e6fc9d1dfbc9464c189f50a0c
                }
            },onVolleyError()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
            Map<String,String> data = new HashMap<>();
            data.put("email"        ,email);
            data.put("password"     ,password);
            return data;
            }
         };
        stringRequest.setRetryPolicy(this.requstTimeOut());
        this.requestQueue.add(stringRequest);
    }

    public DefaultRetryPolicy requstTimeOut(){
         return new DefaultRetryPolicy(5000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }
    public Response.ErrorListener onVolleyError(){
          return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(error instanceof TimeoutError){
                    Toast.makeText(context, "Periksa Jaringan Internet Anda", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
=======
                }else{
                    Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
>>>>>>> e5762bda42aa311e6fc9d1dfbc9464c189f50a0c
                }
            }
        };
    }
}
