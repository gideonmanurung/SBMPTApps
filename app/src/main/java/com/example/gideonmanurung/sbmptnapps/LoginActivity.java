package com.example.gideonmanurung.sbmptnapps;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gideonmanurung.sbmptnapps.model.ModelUser;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button btnLogin;
    private Button btnRegister;
    private Context myContext;
    private boolean isRegistered = false;
    private boolean isLogin = false;
    private Realm realm;
    CallbackManager callBackManager;
    LoginButton login_button;
    TextView textStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);


//        initializeController();
//        loginWithFB();
        realm = Realm.getDefaultInstance();
        myContext = getApplicationContext();
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnLogin);





        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RealmResults<ModelUser> allUser = realm.where(ModelUser.class).findAll();
                for(ModelUser u : allUser){
                    if(u.getUsername().matches(username.getText().toString())){
                        if(u.getPassword().matches(password.getText().toString())){
                            Intent mainIntent = new Intent(myContext, MainActivity.class);
                            startActivity(mainIntent);
                            isRegistered = true;
                            isLogin = true;
                        }
                        isRegistered = true;
                    }
                }
                if(!isLogin){
                    //Toast.makeText(myContext,"Username/Password is not match", Toast.LENGTH_SHORT).show();
                }
                if(!isLogin&&!isRegistered){
                    //Toast.makeText(myContext, "Username is not registered", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(myContext, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
    }

//    private void initializeController() {
//        callBackManager = CallbackManager.Factory.create();
//        textStatus = (TextView) findViewById(R.id.txtStatus);
//        login_button = (LoginButton) findViewById(R.id.login_button);
//
//
//    }
//    private void loginWithFB(){
//        LoginManager.getInstance().registerCallback(callBackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                textStatus.setText("Login Berhasil"+loginResult.getAccessToken());
//            }
//
//            @Override
//            public void onCancel() {
//                textStatus.setText("Login Canceled");
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//                textStatus.setText("Login Error"+error.getMessage());
//            }
//        });
//    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        callBackManager.onActivityResult(requestCode, resultCode, data);
//    }
}
