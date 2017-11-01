package softdrive.com.nyrestaurants.Controladores;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import softdrive.com.nyrestaurants.Modelos.Restaurante;
import softdrive.com.nyrestaurants.R;

/**
 * Created by the-b on 30/10/2017.
 */

public class AdapterRest extends RecyclerView.Adapter<HolderRest> {

    private List<Restaurante>restaurantes=new ArrayList<>();
    private Context c;
    private View.OnClickListener listener;

    public AdapterRest(List<Restaurante> restaurantes, Context c) {
        this.restaurantes = restaurantes;
        this.c = c;
    }

    public void add(Restaurante r){
        restaurantes.add(r);
        notifyItemInserted(restaurantes.size());
    }

    //----------------inflado de la vista del recyclerView--------------------------//

    @Override
    public HolderRest onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.row_recycler, parent, false);
        v.setOnClickListener(listener);
        return new HolderRest(v);
    }

    //-------------------seteo de datos de las vistas-------------------------------//

    @Override
    public void onBindViewHolder(HolderRest holder, final int position) {
        holder.getNombre().setText(restaurantes.get(position).getName());

        holder.getPrice().setText("Rango de precio: "+String.valueOf(restaurantes.get(position).getPrice()));
        holder.getDireccion().setText(restaurantes.get(position).getAddress());

        Glide.with(c).load(restaurantes.get(position).getImage_url()).into(holder.getFoto());


        //-----------Datos de detalle en cada view------------------------------//

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(c, DetallesActivity.class);
                String lat=String.valueOf(restaurantes.get(position).getLat());
                String lng=String.valueOf(restaurantes.get(position).getLng());
                intent.putExtra("name", restaurantes.get(position).getName());
                intent.putExtra("phone", restaurantes.get(position).getPhone());
                intent.putExtra("address", restaurantes.get(position).getAddress());
                intent.putExtra("area", restaurantes.get(position).getArea());
                intent.putExtra("city", restaurantes.get(position).getCity());
                intent.putExtra("postal", restaurantes.get(position).getPostal_code());
                intent.putExtra("img", restaurantes.get(position).getImage_url());
                intent.putExtra("lat", lat);
                intent.putExtra("lng", lng);
                c.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return restaurantes.size();
    }


   /* public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }


    }*/

   //-------------- seteo del filtro -----------------------------//

    public void setFilter(ArrayList<Restaurante> newList){
        restaurantes= new ArrayList<>();
        restaurantes.addAll(newList);
        notifyDataSetChanged();
    }
}
