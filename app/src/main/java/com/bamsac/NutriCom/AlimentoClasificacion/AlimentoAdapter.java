package com.bamsac.NutriCom.AlimentoClasificacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bamsac.NutriCom.R;
import com.bumptech.glide.Glide;


/**
 * Created by Vladdi on 08/12/2016.
 */

public class AlimentoAdapter extends BaseAdapter {
    private Context context;

    public AlimentoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Alimento.ITEMS.length;
    }

    @Override
    public Alimento getItem(int position) {
        return Alimento.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item_clasificacion_alimento, viewGroup, false);
        }

        ImageView imagenCoche = (ImageView) view.findViewById(R.id.imagen_grupo_alimento);
        TextView nombreCoche = (TextView) view.findViewById(R.id.nombre_grupo_alimento);

        final Alimento item = getItem(position);
        Glide.with(imagenCoche.getContext())
                .load(item.getIdDrawable())
                .into(imagenCoche);

        nombreCoche.setText(item.getNombre());

        return view;
    }

}

