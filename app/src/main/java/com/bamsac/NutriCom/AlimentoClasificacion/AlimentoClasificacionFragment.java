package com.bamsac.NutriCom.AlimentoClasificacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.bamsac.NutriCom.Alimentos.AlimentosActivity;
import com.bamsac.NutriCom.R;




public class AlimentoClasificacionFragment extends Fragment implements AdapterView.OnItemClickListener {

    public static final String EXTRA_TIPO_ALIMENTO_ID = "extra_tipo_alimento_id";
    public static final int REQUEST_UPDATE_DELETE_TIPO_ALIMENTO = 2;

    private GridView gridView;
    private AlimentoAdapter adaptador;
    ;

    public AlimentoClasificacionFragment() {
        // Required empty public constructor
    }
    public static AlimentoClasificacionFragment newInstance() {
        AlimentoClasificacionFragment fragment = new AlimentoClasificacionFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_alimento_clasificacion, container, false);
        gridView = (GridView) root.findViewById(R.id.grid);
        adaptador = new AlimentoAdapter(getActivity());
        gridView.setAdapter(adaptador);
        gridView.setOnItemClickListener(this);
        return root;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Alimento item = (Alimento) parent.getItemAtPosition(position);
        showDetailScreen(item.getIdTipo());
    }


    private void showDetailScreen(String idTipo) {
        Intent intent = new Intent(getActivity(), AlimentosActivity.class);
        intent.putExtra(EXTRA_TIPO_ALIMENTO_ID, idTipo);
        startActivityForResult(intent, REQUEST_UPDATE_DELETE_TIPO_ALIMENTO);
    }
}


