package com.henkef.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.henkef.recyclerview.R;
import com.henkef.recyclerview.model.Filme;

import java.util.List;

//obs: o recycler view não vai exibir no celular todos os itens da lista, ele só vai exibir o numero de itens que definimos, e quando for baixado a tela então o
//recycler view vai mostrando o proximo item na tela. Após exibir os icones que aparece na tela ele vai utilizar o metodo onBindViewHolder para criar as novas views.

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override  //obs: o onCreateViewHolder apenas cria o item, ele não imprime a visualização
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override  //obs: o onBindViewHolder imprime a visualização na tela
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filme filme = listaFilmes.get( position);
        holder.titulo.setText( filme.getTituloFilme() );
        holder.genero.setText( filme.getGenero() );
        holder.ano.setText( filme.getAno() );

    }

    @Override  //obs: imprime a quantidade de itens que será exibido na tela, se for 1 será imprimido 1 item, se for 5 será exibido 5 itens
    public int getItemCount() {
        return listaFilmes.size();  //esse metodo irá descobrir o tamanho da minha lista
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }

}
