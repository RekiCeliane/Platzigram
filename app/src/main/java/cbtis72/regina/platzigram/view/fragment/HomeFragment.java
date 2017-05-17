package cbtis72.regina.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cbtis72.regina.platzigram.R;
import cbtis72.regina.platzigram.adapter.PictureAdapterRecyclerView;
import cbtis72.regina.platzigram.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        //propiedades de nuestro toolbar
        showToolbar(getResources().getString(R.string.tab_home),false,view);
        RecyclerView picturesRecycler=(RecyclerView)view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView=
                new PictureAdapterRecyclerView(buildPictures(),R.layout.cardview_picture, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    //ArrayList de picture, tomando como parametros lo de model
    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures=new ArrayList<>();
        pictures.add(new Picture("https://s-media-cache-ak0.pinimg.com/originals/4f/5b/70/4f5b709efb5ac4d6405c1f7f16991ad6.png","Kim Woo Bin", "4 días", "3 Me gusta"));
        pictures.add(new Picture("http://bigbangupdates.com/wp-content/uploads/2015/10/CQ108LXWsAAoz_l.jpg","Choi Seung", "3 días", "10 Me gusta"));
        pictures.add(new Picture("http://www.allkpop.com/upload/2017/03/af_org/got7-mark_1488759416_af_org.jpg","Mark Tuan", "2 días", "9 Me gusta"));
        return pictures;
    }

    //como poner toolbar en un fragment
    public void showToolbar(String tittle, boolean upButton, View view){
        //Para que el toolbar tenga soporte para versiones anteriores
        Toolbar toolbar=(Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        //Agregarle titulo
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
        //Para agregarle un boton de regreso
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

}
