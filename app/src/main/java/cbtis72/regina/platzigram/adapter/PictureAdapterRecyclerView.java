package cbtis72.regina.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cbtis72.regina.platzigram.R;
import cbtis72.regina.platzigram.model.Picture;
import cbtis72.regina.platzigram.view.PictureDetailActivity;

/**
 * Created by USUARIO on 01/05/2017.
 */

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{

    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //se esta inflando el layout a view
        View view= LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);

        return new PictureViewHolder(view);
    }

    //aqui tenemos acceso a cada view
    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        //paso de datos de cada objeto
        //<user-permission android:name="android.permission.INTERNET"/>

        //se recorre la lista y se van llenando las tarjetas
        Picture picture=pictures.get(position);
        //se cacha de un objeto (picture) un elemento
        holder.usernameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);

        //metodo para onClick en la imagen
        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, PictureDetailActivity.class);

                //transicion
                //Comprobando la version que lo soporte
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode=new Explode();
                    //duracion en milisegundos
                    explode.setDuration(1000);
                    //salida de la transicion
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent,
                            ActivityOptionsCompat.makeSceneTransitionAnimation
                                    (activity, view,activity.getString(R.string.transitionname_picture)).toBundle());
                }else{
                    activity.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        //conteo de elementos
        return pictures.size();
    }

    //donde se creara lo que ira en el recycler, un card a la vez
    public class PictureViewHolder  extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumberCard;

        public PictureViewHolder(View itemView) {
            super(itemView);

            //instanciar
            pictureCard=(ImageView)itemView.findViewById(R.id.pictureCard);
            usernameCard=(TextView) itemView.findViewById(R.id.userNameCard);
            timeCard=(TextView) itemView.findViewById(R.id.timeCard);
            likeNumberCard=(TextView) itemView.findViewById(R.id.likeNumberCard);
        }
    }
}
