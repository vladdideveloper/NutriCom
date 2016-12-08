package com.bamsac.NutriCom.AlimentoDetalle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.bamsac.NutriCom.Alimentos.AlimentosActivity;
import com.bamsac.NutriCom.R;
/**
 * Created by Vladdi on 08/12/2016.
 */

public class AlimentoDetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentos_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String id = getIntent().getStringExtra(AlimentosActivity.EXTRA_ALIMENTO_ID);

        AlimentoDetalleFragment fragment = (AlimentoDetalleFragment)
                getSupportFragmentManager().findFragmentById(R.id.lawyer_detail_cner);
        if (fragment == null) {
            fragment = AlimentoDetalleFragment.newInstance(id);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.lawyer_detail_cner, fragment)
                    .commit();
        }


    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lawyer_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
