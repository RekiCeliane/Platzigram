package cbtis72.regina.platzigram.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import cbtis72.regina.platzigram.R;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //Llamar al Toolbar, agregar titulo, el boolean es para decir si se vera o no el buttonBack
        showToolbar(getResources().getString(R.string.toolbar_tittle_createaccount),true);
    }

    public void showToolbar(String tittle, boolean upButton){
        //Para que el toolbar tenga soporte para versiones anteriores
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Agregarle titulo
        getSupportActionBar().setTitle(tittle);
        //Para agregarle un boton de regreso
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
