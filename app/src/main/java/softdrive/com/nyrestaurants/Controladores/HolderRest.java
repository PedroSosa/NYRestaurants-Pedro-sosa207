package softdrive.com.nyrestaurants.Controladores;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import softdrive.com.nyrestaurants.R;

/**
 * Created by the-b on 30/10/2017.
 */

public class HolderRest extends RecyclerView.ViewHolder {




    private TextView nombre;
    private TextView price;
    private TextView direccion;
    private CircleImageView foto;


    public HolderRest(View itemView) {
        super(itemView);



        nombre=(TextView)itemView.findViewById(R.id.name);
        price=(TextView)itemView.findViewById(R.id.price);
        direccion=(TextView)itemView.findViewById(R.id.address);
        foto=(CircleImageView)itemView.findViewById(R.id.imgRest);




    }



    public TextView getNombre() {
        return nombre;
    }

    public void setNombre(TextView nombre) {
        this.nombre = nombre;
    }

    public TextView getPrice() {
        return price;
    }

    public void setPrice(TextView price) {
        this.price = price;
    }

    public TextView getDireccion() {
        return direccion;
    }

    public void setDireccion(TextView direccion) {
        this.direccion = direccion;
    }

    public CircleImageView getFoto() {
        return foto;
    }

    public void setFoto(CircleImageView foto) {
        this.foto = foto;
    }



}
