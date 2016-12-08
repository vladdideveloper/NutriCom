package com.bamsac.NutriCom.AlimentoClasificacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.bamsac.NutriCom.Alimentos.AlimentosActivity;
import com.bamsac.NutriCom.R;


/**
 * Created by Vladdi on 08/12/2016.
 */

public class AlimentoClasificacion extends AppCompatActivity
        implements AdapterView.OnItemClickListener {
    private GridView gridView;
    private AlimentoAdapter adaptador;
    public static final String EXTRA_TIPO_ALIMENTO_ID = "extra_tipo_alimento_id";
    public static final int REQUEST_UPDATE_DELETE_TIPO_ALIMENTO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimento_clasificacion);

        usarToolbar();

        gridView = (GridView) findViewById(R.id.grid);
        adaptador = new AlimentoAdapter(this);
        gridView.setAdapter(adaptador);
        gridView.setOnItemClickListener(this);
    }

    private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_alimentos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Alimento item = (Alimento) parent.getItemAtPosition(position);
        showDetailScreen(item.getIdTipo());
    }


    private void showDetailScreen(String idTipo) {
        Intent intent = new Intent(this, AlimentosActivity.class);
        intent.putExtra(AlimentoClasificacion.EXTRA_TIPO_ALIMENTO_ID, idTipo);
        startActivityForResult(intent, REQUEST_UPDATE_DELETE_TIPO_ALIMENTO);
    }

       /* Intent intent = new Intent(this, AlimentosActivity.class);
        intent.putExtra(AlimentosActivity.EXTRA_ALIMENTO_ID, item.getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this,
                            new Pair<View, String>(view.findViewById(R.id.imagen_alimento),
                                    AlimentosActivity.VIEW_NAME_HEADER_IMAGE)
                    );

            ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
        } else
            startActivity(intent);*/


}

