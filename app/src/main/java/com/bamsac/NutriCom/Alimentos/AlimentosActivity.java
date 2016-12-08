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
        switch (mIdTipo){
            case  "1":
                setTitle("Almidón");
                break;
            case  "2":
                setTitle("Frutas");
                break;
            case  "3":
                setTitle("Verduras");
                break;
            case  "4":
                setTitle("Lacteos enteros");
                break;
            case  "5":
                setTitle("Lacteos semidescremados");
                break;
            case  "6":
                setTitle("Lacteos desnatados");
                break;
            case  "7":
                setTitle("Carnes magras");
                break;
            case  "8":
                setTitle("Carnes semi magras");
                break;
            case  "9":
                setTitle("Carnes grasas");
                break;
            case  "10":
                setTitle("Proteínas de origen vegetal");
                break;
            case  "11":
                setTitle("Dulces");
                break;
            case  "12":
                setTitle("Grasas");
                break;
            default:
                setTitle("Fracaso");
                break;
        }

        /*if (mIdTipo == "4"){
            setTitle("Arroz");
        }else {
            setTitle("Otro");
        }*/



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

