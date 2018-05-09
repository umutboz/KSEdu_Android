package com.kocsistem.edu.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kocsistem.edu.R;
import com.kocsistem.edu.adapter.FilmListAdapter;
import com.kocsistem.edu.model.FilmModel;
import com.kocsistem.edu.view.MainActivity;
import com.kocsistem.networking.KSNetworkingFactory;
import com.kocsistem.networking.listener.KSNetworkResponseListener;
import com.kocsistem.networking.model.ErrorModel;
import com.kocsistem.networking.model.ResultModel;

import java.util.List;

/**
 * Created by umutboz on 09,May,2018
 */
public class FragmentA extends MainFragment {

    String FILMS_URL = "https://ott.mvp.tivibu.com.tr/iap-dataapi/public/vod/offerings?language=tr-TR&serviceIds=SVODFILM&ebcs=MOBIL&categoryId=%2FSecizle%2FFilm%2FKomedi";

    List<FilmModel> filmList;
    RecyclerView recyclerView;
    public FragmentA()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragmenta_layout,container ,false);
        recyclerView = view.findViewById(R.id.main_film_list_recyclerView);
loadData();
        return view;
    }

    @Override
    public String getTitle() {
         return "ONE";
    }


    void loadData()
    {
        KSNetworkingFactory
                .create()
                .get(FILMS_URL, new KSNetworkResponseListener<List<FilmModel>, String>() {
                    @Override
                    public void onSuccess(ResultModel<List<FilmModel>> result) {
                        List<FilmModel> models = result.getModel();
                        FilmListAdapter filmListAdapter= new FilmListAdapter(getActivity(),models);
                        recyclerView.setAdapter(filmListAdapter);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        filmListAdapter.notifyDataSetChanged();
                    }
                    @Override
                    public void onError(ErrorModel<String> error) {
                    }
                });
    }


}
