package softdrive.com.nyrestaurants.Controladores;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import softdrive.com.nyrestaurants.Controladores.AdapterRest;
import softdrive.com.nyrestaurants.Controladores.HolderRest;
import softdrive.com.nyrestaurants.Modelos.Restaurante;
import softdrive.com.nyrestaurants.R;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private RecyclerView rvRest;

    private AdapterRest adapter;
    private List<Restaurante> restaurantes=new ArrayList<>();

    private FirebaseDatabase database;
    private DatabaseReference ref;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    //--------------setup del recyclerView--------------------------//

        rvRest=(RecyclerView)findViewById(R.id.RvRestaurants);
        //-------------Instancia base de datos firebase-------------------
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("restaurants");

        adapter=new AdapterRest(restaurantes, this);


        LinearLayoutManager l= new LinearLayoutManager(this);
        rvRest.setLayoutManager(l);
        rvRest.setAdapter(adapter);

        //-------------------Recibe los datos de firebase------------------//

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Restaurante r=dataSnapshot.getValue(Restaurante.class);
                adapter.add(r);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

//--------------Insertando menu en el ActionBar------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search,  menu);
        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
//-------------------metodo del query--------------------------
    @Override
    public boolean onQueryTextChange(String newText) {

        newText =newText.toLowerCase();
        ArrayList<Restaurante>newList=new ArrayList<>();

        for(Restaurante restaurante:restaurantes){
            String name=restaurante.getName().toLowerCase();
            if(name.contains(newText)){
                newList.add(restaurante);

            }

        }


            adapter.setFilter(newList);

        return true;
    }
}
