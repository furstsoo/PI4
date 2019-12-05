package com.example.projetointegrador.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetointegrador.R;
import com.example.projetointegrador.model.Geral;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private ArrayList<Geral> gerais;

  public FeedAdapter(ArrayList<Geral> geral) {
    this.gerais = geral;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());

    // Perform the inflation:
    View view = inflater.inflate(R.layout.recycler_view_item,parent,false);
    return new GeralViewHolder(view);

  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    Geral geral = gerais.get(position);
    GeralViewHolder geralViewHolder = (GeralViewHolder)holder;

    geralViewHolder.tTituloFeed.setText(geral.getLugar().getTitulo());
    geralViewHolder.tDescFeed.setText(geral.getLugar().getDescricao());
    //geralViewHolder.iAnuncio.setImageBitmap(geral.getFotos().get(0).getImagem());


  }

  @Override
  public int getItemCount() {
    return gerais.size();
  }

  private class GeralViewHolder extends RecyclerView.ViewHolder {

    public TextView tTituloFeed;
    public TextView tDescFeed;
    public ImageView iAnuncio;

    public GeralViewHolder(@NonNull View itemView) {

      super(itemView);
      tTituloFeed = itemView.findViewById(R.id.tTituloFeed);
      tDescFeed = itemView.findViewById(R.id.tDescFeed);
      iAnuncio = itemView.findViewById(R.id.iAnuncio);

    }
  }
}
