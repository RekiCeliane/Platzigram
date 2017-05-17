package cbtis72.regina.platzigram.view;

import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.View;

import cbtis72.regina.platzigram.R;

public class PictureDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);

        //iniciando toolbar
        showToolbar("", true);

        //transicion...validacion
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setEnterTransition(new Fade());
        }
    }

    public void showToolbar(String tittle, boolean upButton){
        //Para que el toolbar tenga soporte para versiones anteriores
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Agregarle titulo
        getSupportActionBar().setTitle(tittle);
        //Para agregarle un boton de regreso, para esto es necesario agregar a donde se quiere regresar
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);

    }
}
