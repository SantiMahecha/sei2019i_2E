package com.example.traductor.business_logic.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.traductor.R;

public class TranslatorAdapter extends RecyclerView.Adapter<TranslatorAdapter.TranslatorAdapterViewHolder>{
    private String[] text;
    private final TranslatorAdapterOnClickHandler mClickHandler;

    public interface TranslatorAdapterOnClickHandler{
        void onClick(String translateForParagraph);
    }

    public TranslatorAdapter(TranslatorAdapterOnClickHandler clickHandler){
        mClickHandler = clickHandler;
    }

    @NonNull
    @Override
    public TranslatorAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutForListItem = R.layout.translation_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutForListItem,viewGroup,false);
        return new TranslatorAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TranslatorAdapterViewHolder translatorAdapterViewHolder, int i) {
        translatorAdapterViewHolder.mParagraphTv.setText(text[i]);
    }

    @Override
    public int getItemCount() {
        if(text == null) return 0;
        return text.length;
    }

    public void setTextData(String[] newText){
        text = newText;
        notifyDataSetChanged();
    }

    //ViewHolder de las traducciones
    class TranslatorAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mParagraphTv;

        public TranslatorAdapterViewHolder(View view){
            super(view);
            mParagraphTv = (TextView) view.findViewById(R.id.tv_translated_paragraph);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            String translateForParagraph = text[adapterPosition];
            mClickHandler.onClick(translateForParagraph);
        }
    }


}
