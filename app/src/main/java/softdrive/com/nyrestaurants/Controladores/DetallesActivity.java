package softdrive.com.nyrestaurants.Controladores;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import softdrive.com.nyrestaurants.R;

public class DetallesActivity extends AppCompatActivity  {




    private TextView nombre;
    private TextView telefono;
    private TextView direccion;
    private TextView Area;
    private TextView codigo_postal;

    private TextView ciudad;
    private CircleImageView foto;
    String lati, lngi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);



        //------------instanciacion---------------------//
        nombre=(TextView)findViewById(R.id.name1);
        telefono=(TextView)findViewById(R.id.telefono1);
        direccion=(TextView)findViewById(R.id.direccion1);
        Area=(TextView)findViewById(R.id.area1);
        ciudad=(TextView)findViewById(R.id.city1);
        codigo_postal=(TextView)findViewById(R.id.postal1);

        foto=(CircleImageView)findViewById(R.id.imgRest1);







        //---------------Obtencion de datos del intent--------------------//


        Bundle bundle=getIntent().getExtras();

        String name= bundle.getString("name");
        String phone= bundle.getString("phone");
        String address=bundle.getString("address");
        String area=bundle.getString("area");
        String city=bundle.getString("city");
        String imgURL=bundle.getString("img");
        String postal_code=bundle.getString("postal");





         lati=bundle.getString("lat");
         lngi=bundle.getString("lng");

        double lat=Double.parseDouble(lati);
        double lng=Double.parseDouble(lngi);

    //---------------------set de informacion---------------------//
        nombre.setText(name);
        telefono.setText(phone);
        direccion.setText(address);
        Area.setText(area);
        codigo_postal.setText(postal_code);
        ciudad.setText(city);

        Glide.with(DetallesActivity.this).load(imgURL).into(foto);

        //------------------Intent del ubicacion--------------------//

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetallesActivity.this, MapsActivity.class);
                intent.putExtra("lat", lati);
                intent.putExtra("lng", lngi);
                startActivity(intent);
            }
        });
    }

}
