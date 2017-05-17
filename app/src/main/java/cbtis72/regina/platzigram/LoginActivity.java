package cbtis72.regina.platzigram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cbtis72.regina.platzigram.view.ContainerActivity;
import cbtis72.regina.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goCreateAccount(View view){
        //en donde estoy y a donde quiero ir
        Intent intent=new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void goContainer(View view){
        Intent intent=new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }
}
