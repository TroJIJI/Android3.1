package com.example.android31.ui.characters_list;

import android.telecom.TelecomManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android31.R;
import com.example.android31.data.models.Character;
import com.example.android31.databinding.ListCharactersBinding;

import java.util.ArrayList;
import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolder> {
private List<Character> list =new ArrayList<>();


    @NonNull
    @Override
    public CharactersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(ListCharactersBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));

    }

    public void setList(List<Character> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull CharactersAdapter.ViewHolder holder, int position) {
holder.onBind(list.get(position));
    }



    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,status;
        private ImageView imageView;
        private ListCharactersBinding binding;
        public ViewHolder(@NonNull  ListCharactersBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;

        }

        public void onBind(Character models) {
            binding.tvName.setText(models.getName());
            binding.tvStatus.setText(models.getStatus());
            Glide.with(binding.getRoot()).load(models.getImage()).centerCrop().into(binding.imgCharacters);

        }
    }
}
