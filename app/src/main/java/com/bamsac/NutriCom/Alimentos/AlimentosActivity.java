package com.bamsac.NutriCom.Alimentos;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.bamsac.NutriCom.AlimentoClasificacion.AlimentoClasificacion;
import com.bamsac.NutriCom.R;

/**
 * Created by Vladdi on 08/12/2016.
 */

public class AlimentosActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    public static final String EXTRA_ALIMENTO_ID = "extra_alimento_id";
    private String mIdTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentos);
        mIdTipo = getIntent().getStringExtra(AlimentoClasificacion.EXTRA_TIPO_ALIMENTO_ID);
        setToolbar();
        AlimentosFragment fragment = (AlimentosFragment)
                getSupportFragmentManager().findFragmentById(R.id.alimentos_cner);

        if (fragment == null) {
            fragment = AlimentosFragment.newInstance(mIdTipo);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.alimentos_cner, fragment)
                    .commit();
        }
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();

    }
}

