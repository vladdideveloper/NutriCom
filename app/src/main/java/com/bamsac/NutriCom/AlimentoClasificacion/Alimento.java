package com.bamsac.NutriCom.AlimentoClasificacion;

import com.bamsac.NutriCom.R;

/**
 * Created by Vladdi on 08/12/2016.
 */

public class Alimento {
    private String nombre;
    private String idTipo;
    private int idDrawable;


    public Alimento(String nombre,String idTipo, int idDrawable) {
        this.nombre = nombre;
        this.idTipo = idTipo;
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public int getIdDrawable() {
        return idDrawable;
    }


    public int getId() {
        return nombre.hashCode();
    }

    public static Alimento[] ITEMS = {
            new Alimento("Almidones","1", R.drawable.almidones),
            new Alimento("Frutas","2", R.drawable.frutas),
            new Alimento("Verduras","3", R.drawable.verduras),
            new Alimento("Lácteos Enteros","4", R.drawable.lacteosenteros),
            new Alimento("Lácteos Semidescremados","5", R.drawable.lacteossemidescremados),
            new Alimento("Lácteos Desnatados","6", R.drawable.lacteosdesnatados),
            new Alimento("Carnes Magras","7", R.drawable.carnesmagras),
            new Alimento("Carnes Semi Magras","8", R.drawable.carnessemimagras),
            new Alimento("Carnes Grasas","9", R.drawable.verduras),
            new Alimento("Proteínas  de origen vegetal","10", R.drawable.proteinasvegetal),
            new Alimento("Dulces","11", R.drawable.dulces),
            new Alimento("Grasas","12", R.drawable.grasas),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Alimento
     */
    public static Alimento getItem(int id) {
        for (Alimento item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}