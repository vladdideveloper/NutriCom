package com.bamsac.NutriCom.Data;

/**
 * Created by Vladdi on 08/12/2016.
 */

import android.provider.BaseColumns;

/**
 * Esquema de la base de datos para alimentos
 */
public class AlimentosContract {

    public static abstract class AlimentoEntry implements BaseColumns {
        public static final String TABLE_NAME ="alimento";

        public static final String ID = "id";
        public static final String NAME = "nombre";
        public static final String GRUPO_ALIMENTO = "grupoAlimento";
        public static final String PESO = "peso";
        public static final String ENERGY = "energy";
        public static final String PROTEINAS = "proteinas";
        public static final String AVATAR_URI = "avatarUri";
        public static final String LIPIDOS = "lipidos";
        public static final String CARB = "carb";
        public static final String FIBCRUD = "fibCrud";
        public static final String FIBDIET = "fibDiet";
    }
}
