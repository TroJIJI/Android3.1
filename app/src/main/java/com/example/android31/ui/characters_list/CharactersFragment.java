package com.example.android31.ui.characters_list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android31.App;
import com.example.android31.R;
import com.example.android31.data.models.MainResponse;
import com.example.android31.databinding.FragmentCharactersBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CharactersFragment extends Fragment {


    private FragmentCharactersBinding binding;
    private RecyclerView recyclerView;
    private CharactersAdapter adapter;


    public CharactersFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter=new CharactersAdapter();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharactersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.fragmentRecycler.setAdapter(adapter);
        App.service.fetchCharacters().enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.isSuccessful() && response.body()!=null){
                    adapter.setList(response.body().getResults());
                    Log.d("TAG", "onResponse: success");
                }else {
                    Log.e("TAG","onResponse: "+ response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                Log.e("TAG","onResponse: "+ t.getLocalizedMessage());

            }
        });
    }
}