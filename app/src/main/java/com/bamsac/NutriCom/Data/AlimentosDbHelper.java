package com.bamsac.NutriCom.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bamsac.NutriCom.Data.AlimentosContract.AlimentoEntry;
/**
 * Created by Vladdi on 08/12/2016.
 */

public class AlimentosDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Alimentos.db";

    public AlimentosDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + AlimentoEntry.TABLE_NAME + " ("
                + AlimentoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + AlimentoEntry.ID + " TEXT NOT NULL,"
                + AlimentoEntry.NAME + " TEXT NOT NULL,"
                + AlimentoEntry.GRUPO_ALIMENTO + " TEXT NOT NULL,"
                + AlimentoEntry.PESO + " TEXT NOT NULL,"
                + AlimentoEntry.ENERGY + " TEXT NOT NULL,"
                + AlimentoEntry.PROTEINAS + " TEXT NOT NULL,"
                + AlimentoEntry.LIPIDOS + " TEXT NOT NULL,"
                + AlimentoEntry.CARB + " TEXT NOT NULL,"
                + AlimentoEntry.FIBCRUD + " TEXT NOT NULL,"
                + AlimentoEntry.FIBDIET + " TEXT NOT NULL,"
                + AlimentoEntry.AVATAR_URI + " TEXT,"
                + "UNIQUE (" + AlimentoEntry.ID + "))");



        // Insertar datos ficticios para prueba inicial
        mockData(db);

    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        //***************************ALMIDONES//*****************************

        mockLawyer(sqLiteDatabase, new Alimentos("Arroz Cocido 1 Porción","1","62 gr 1/2 Taza Casera","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_arroz_1pc.jpg"));

        mockLawyer(sqLiteDatabase, new Alimentos("Arroz Cocido – 4 PORC","1","","71.69 Kcal","1.56 gr", "0.14 gr","15.52 gr","0.08 gr","ND gr","A_arroz_4pc.jpg"));

        mockLawyer(sqLiteDatabase, new Alimentos("Avena en Hojuela Cocida","1","","79.90 Kcal","2.88 gr", "0.99 gr","14.97 gr","0.11 gr","ND gr","A_avenaCocida_1pc.JPG"));

        mockLawyer(sqLiteDatabase, new Alimentos("Avena en Hojuela Cruda","1","","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_avenaHojuelaCocida_1pc.jpg"));

        mockLawyer(sqLiteDatabase, new Alimentos("Camote Cocido 2 Porción","1","","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_avenaHojuelaCruda_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        /*mockLawyer(sqLiteDatabase, new Alimentos("Camote Cocido 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_camoteCocido_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Cañihua Harina 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_camoteCocido_2pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Choclo Cocido 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_canihuaCruda_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Choclo Cocido 2 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_choclo_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Maicena 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_choclo_2pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Fideo Crudo 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_fideoCrudo_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Fideo Cocido 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_fideoCocido_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Galleta de Vainilla 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_galletaVainilla_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Galleta Soda 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_galletaSoda_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Granola 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_granola_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Harina de Maíz 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_harinaMaiz_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Harina de Quinua 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_harinaQuinua_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Maíz Cancha Tostado 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_maizCanchaTostado_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Oca 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_oca_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Olluco Entero 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_olluco_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Olluco Picado 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_ollucoPicado_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Plan de Molde Blanco 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_panMoldeBlanco_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Pan Molde Integral 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_panMoldeIntegral_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Papa Amarilla 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_papaAmarilla_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Papa Blanca 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_papaBlanca_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Papa Huayro 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_arroz_1pc.jpg.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Papa Huayro 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_papaHuayro_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Papa Seca Cruda 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_papaSecaCruda_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Papa Seca Cocida 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_papaSecaCocida_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Quinua Cocida 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_arroz_1pc.jpg.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Sémola Cruda 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_semolaCruda_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Trigo Resbalado Crudo 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_arroz_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Trigo Resbalado Cocido 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_arroz_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Trigo Mote Crudo 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_trigoMoteCrudo_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Trigo Mote Cocido 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_arroz_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Yuca Cocida - 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_yucaCocida_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Harina de Trigo 1 Porción","1","71.20 Kcal","1.49 gr", "0.06 gr","15.62 gr","0.06 gr","ND gr","A_arroz_1pc.jpg"));
        //71.20	1.49	0.06	15.62	0.06	ND




        //*******************************FRUTAS//***************************

        mockLawyer(sqLiteDatabase, new Alimentos("Durazno","2","61.44 Kcal","0.576 gr", "0.096 gr","14.976 gr","0.576 gr","1.440 gr","durazno.jpg"));
                                                        //61.440	   0.576	   0.096	  14.976	  0.576	    1.440

        mockLawyer(sqLiteDatabase, new Alimentos("Chirimoya","2","61.20 Kcal","1.615 gr","0.255 gr","15.045 gr","1.275 gr","3.400 gr","F_chirimoya.jpg"));

        //61.200	1.615	0.255	15.045	1.275	3.400

        mockLawyer(sqLiteDatabase, new Alimentos("Ciruela","2", "57.40 Kcal","0.700 gr", "0.140 gr","15.050 gr", "0.350 gr","ND","ciruela.jpg"));
        //57.400	0.700	0.140	15.050	0.350	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Coco","2", "397.54 Kcal","4.726 gr", "39.059 gr","15.012 gr","3.197 gr","ND","coco.jpg"));
        //397.540	4.726	39.059	15.012	3.197	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Cocona","2", "66.83 Kcal", "1.467 gr", "1.141 gr","14.996 gr", "4.075 gr","ND","F_cocona.jpg"));
        //66.830	1.467	1.141	14.996	4.075	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Fresa","2", "88.97 Kcal", "1.519 gr", "1.736 gr","14.973 gr", "3.038 gr","4.340 gr","F_fresa.jpg"));
        //88.970	1.519	1.736	14.973	3.038	4.340

        mockLawyer(sqLiteDatabase, new Alimentos("Granadilla","2", "76.80 Kcal","2.112 gr","1.920 gr", "14.976 gr","3.360 gr","ND","granadilla.jpg"));
        //76.800	2.112	1.920	14.976	3.360	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Guanábana","2", "76.16 Kcal", "1.224 gr", "0.272 gr","14.960 gr", "1.496 gr","4.488 gr",".jpg"));
        //76.160	1.224	0.272	14.960	1.496	4.488

        mockLawyer(sqLiteDatabase, new Alimentos("Higo negro","2", "66.88 Kcal", "0.792 gr", "0.088 gr","14.960 gr", "1.496 gr","2.552 gr","higo_negro.jpg"));
        //66.880	0.792	0.088	14.960	1.496	2.552

        mockLawyer(sqLiteDatabase, new Alimentos("Higo seco","2", "74.62 Kcal", "1.476 gr", "0.082 gr","15.088 gr", "3.526 gr","4.018 gr","higos_secos.jpg"));
        //74.620	1.476	0.082	15.088	3.526	4.018

        mockLawyer(sqLiteDatabase, new Alimentos("Jugo de Naranja","2", "54.90 Kcal", "ND", "ND","15.006 gr", "0.000 gr","3.294 gr",".jpg"));
        //54.900	ND	ND	15.006	0.000	3.294

        mockLawyer(sqLiteDatabase, new Alimentos("Kiwi","2", "79.95 Kcal", "5.945 gr", "0.615 gr","14.965 gr", "0.000 gr","6.560 gr",".jpg"));
        //79.950	5.945	0.615	14.965	0.000	6.560

        mockLawyer(sqLiteDatabase, new Alimentos("Lúcuma","2", "59.40 Kcal", "0.900 gr","0.300 gr","15.00 gr", "0.780 gr","ND",".jpg"));
        //59.400	0.900	0.300	15.000	0.780	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Mandarina","2", "77.35 Kcal", "1.326 gr", "0.663 gr","15.028 gr", "1.105 gr","3.978 gr","mandarina.jpg"));
        //77.350	1.326	0.663	15.028	1.105	3.978

        mockLawyer(sqLiteDatabase, new Alimentos("Mango","2", "63.60 Kcal", "0.424 gr", "0.212 gr","14.946 gr", "1.060 gr","1.908 gr","mango.jpg"));
        //63.600	0.424	0.212	14.946	1.060	1.908

        mockLawyer(sqLiteDatabase, new Alimentos("Manzana nacional","2", "61.020 Kcal", "0.339 gr", "0.113 gr","15.029 gr", "0.904 gr","1.469 gr","F_manzana.jpg"));
        //61.020	0.339	0.113	15.029	0.904	1.469

        mockLawyer(sqLiteDatabase, new Alimentos("Jugo de Maracuyá","2", "62.980 Kcal", "0.846 gr", "0.094 gr","14.946 gr", "0.188 gr","0.188 gr",".jpg"));
        //62.980	0.846	0.094	14.946	0.188	0.188

        mockLawyer(sqLiteDatabase, new Alimentos("Melón","2", "69.000 Kcal", "1.500 gr", "0.300 gr","15.000 gr","0.600 gr","2.400 gr",".jpg"));
        //69.000	1.500	0.300	15.000	0.600	2.400

        mockLawyer(sqLiteDatabase, new Alimentos("Membrillo","2", "67.080 Kcal", "0.468 gr", "0.156 gr","14.976 gr", "2.028 gr","2.964 gr",".jpg"));
        //67.080	0.468	0.156	14.976	2.028	2.964

        mockLawyer(sqLiteDatabase, new Alimentos("Naranja","2", "78.000 Kcal", "1.170 gr", "0.390 gr","15.015 gr", "0.780 gr","4.680 gr","F_naranja.jpg"));
        //78.000	1.170	0.390	15.015	0.780	4.680

        mockLawyer(sqLiteDatabase, new Alimentos("Níspero","2", "63.920 Kcal", "0.408 gr", "0.000 gr","14.960 gr", "0.816 gr","2.312 gr",".jpg"));
        //63.920	0.408	0.000	14.960	0.816	2.312

        mockLawyer(sqLiteDatabase, new Alimentos("Papaya","2", "74.880 Kcal", "0.936 gr", "0.234 gr","14.976 gr", "1.170 gr","4.212 gr","papaya.jpg"));
        //74.880	0.936	0.234	14.976	1.170	4.212

        mockLawyer(sqLiteDatabase, new Alimentos("Pasas sin pepas","2", "60.250 Kcal", "0.600 gr", "0.100 gr","15.025 gr", "0.225 gr","0.925 gr",".jpg"));
        //60.250	0.600	0.100	15.025	0.225	0.925

        mockLawyer(sqLiteDatabase, new Alimentos("Pepino dulce","2", "55.640 Kcal", "0.642 gr", "0.000 gr","14.980 gr", "1.070 gr","ND",".jpg"));
        //55.640	0.642	0.000	14.980	1.070	ND

        mockLawyer(sqLiteDatabase, new Alimentos("Pera chilena","2", "73.010 Kcal", "0.447 gr", "0.149 gr","15.049 gr", "1.490 gr","4.619 gr",".jpg"));
        //73.010	0.447	0.149	15.049	1.490	4.619

        mockLawyer(sqLiteDatabase, new Alimentos("Piña", "68.020 Kcal","2", "0.716 gr", "0.358 gr","15.036 gr", "0.895 gr","2.506 gr","pina.jpg"));
        //68.020	0.716	0.358	15.036	0.895	2.506

        mockLawyer(sqLiteDatabase, new Alimentos("Plátano de Isla","2", "57.750 Kcal", "0.924 gr", "0.077 gr","15.015 gr", "0.385 gr","1.694 gr","platano_isla.jpg"));
        //57.750	0.924	0.077	15.015	0.385	1.694

        mockLawyer(sqLiteDatabase, new Alimentos("Plátano de Seda","2", "68.060 Kcal", "1.230 gr", "0.246 gr","15.088 gr", "0.328 gr","2.132 gr",".jpg"));
        //68.060	1.230	0.246	15.088	0.328	2.132

        mockLawyer(sqLiteDatabase, new Alimentos("Plátano Manzano","2", "64.800 Kcal", "0.792 gr", "0.144 gr","14.976 gr", "0.216 gr","1.872 gr",".jpg"));
        //64.800	0.792	0.144	14.976	0.216	1.872

        mockLawyer(sqLiteDatabase, new Alimentos("Plátano Maduro","2", "62.720 Kcal", "0.672 gr", "0.112 gr","15.120 gr", "0.168 gr","1.456 gr",".jpg"));
        //62.720	0.672	0.112	15.120	0.168	1.456

        mockLawyer(sqLiteDatabase, new Alimentos("Sandia","2", "65.520 Kcal", "1.911 gr", "0.273 gr","15.015 gr", "0.546 gr","1.092 gr","sandia.jpg"));
        //65.520	1.911	0.273	15.015	0.546	1.092

        mockLawyer(sqLiteDatabase, new Alimentos("Tuna","2", "71.920 Kcal", "0.992 gr", "0.000 gr","15.004 gr", "4.712 gr","4.092 gr","F_tuna.jpg"));
        //71.920	0.992	0.000	15.004	4.712	4.092

        mockLawyer(sqLiteDatabase, new Alimentos("Uva italia","2", "58.740 Kcal", "0.356 gr", "0.089 gr","14.952 gr","0.356 gr","0.801 gr",".jpg"));
        //58.740	0.356	0.089	14.952	0.356	0.801

        mockLawyer(sqLiteDatabase, new Alimentos("Uva negra","2", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","F_uvaNegra.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783


        //*******************************VERDURAS//***************************

        mockLawyer(sqLiteDatabase, new Alimentos("Alcachofa Entera 2 Porciones","3", "9.4 gr", "0.6 gr", "9.8 gr","gr", "gr","gr","V_alcachofa_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Apio 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Berenjena Mediana 2 Porciones","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_berenjena_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Beterraga Mediana 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_beterragaPequeñas_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Beterraga Cocida 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_beterragaCocida _1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Brócoli Cocido 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_brócoli_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Caigua Pequeña - 1 PORC","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_caiguaPequeña_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Col Blanca 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_colBlanca_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Col Morada 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_colMorada_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Coliflor 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_coliflor_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Alcachofa Corazón 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_corazónAlcachofa_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Espárragos Cocidos 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_espárragos_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Espinaca 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_espinaca_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Germinado de Alfalfa 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_germinadoAlfalfa_1.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Germinado de Frijol 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_germinadoFrejolChino_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Lechuga Largas Hojas 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_lechugaLarga_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Lechuga Larga Picada 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr",".jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Lechuga Morada Hojas 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_lechugaMorada_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Nabo Pequeño 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_naboPequeño_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Pepinillo Mediano Entero 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_pepinilloMediano_2pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Pepinillo Mediano Rodajas 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_pepinilloRodajas_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Pimiento Pequeño 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_pimientoPequeño_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Rabanitos Picados 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_rabanito_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Tomate Entero Mediando 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_tomateMediano _1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Tomate Rodajas – 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_tomateRodajas_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Tomate Picado 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_tomatePicado_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Vainitas Cocidas 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_vainitas_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Zanahoria Entera Pequeña 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_zanahoriaMediana_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Zanahoria Cocida 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_zanahoriaCocida_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Zanahoria rallada 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_zanhoriaRallada_1pc.JPG"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Zapallito Italiano Chico 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_zapallitoChico_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Zanahoria rallada 1 Porción","3", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_Espárragos - 1 PORC.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783*/


        //*******************************LACTEOS ENTEROS//***************************

        mockLawyer(sqLiteDatabase, new Alimentos("Alcachofa Entera 2 Porciones","4", "","9.4 gr", "0.6 gr", "9.8 gr","gr", "gr","gr","V_alcachofa_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Apio 1 Porción","4", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Berenjena Mediana 2 Porciones","4", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_berenjena_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        //*******************************LACTEOS SEMIDESCREMADOS//***************************

        mockLawyer(sqLiteDatabase, new Alimentos("Alcachofa Entera 2 Porciones","5", "","9.4 gr", "0.6 gr", "9.8 gr","gr", "gr","gr","V_alcachofa_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Apio 1 Porción","5", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Berenjena Mediana 2 Porciones","5", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_berenjena_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        //*******************************LACTEOS DESNATADOS//***************************

        mockLawyer(sqLiteDatabase, new Alimentos("Alcachofa Entera 2 Porciones","6", "","9.4 gr", "0.6 gr", "9.8 gr","gr", "gr","gr","V_alcachofa_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Apio 1 Porción","6","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Berenjena Mediana 2 Porciones","6","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_berenjena_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        //*******************************CARNES MAGRAS//***************************

        mockLawyer(sqLiteDatabase, new Alimentos("Alcachofa Entera 2 Porciones","7", "","9.4 gr", "0.6 gr", "9.8 gr","gr", "gr","gr","V_alcachofa_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Apio 1 Porción","7","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Berenjena Mediana 2 Porciones","7","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_berenjena_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        //*******************************CARNES SEMI MAGRAS//***************************

        mockLawyer(sqLiteDatabase, new Alimentos("Alcachofa Entera 2 Porciones","8", "","9.4 gr", "0.6 gr", "9.8 gr","gr", "gr","gr","V_alcachofa_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Apio 1 Porción","8", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Berenjena Mediana 2 Porciones","8", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_berenjena_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        //*******************************CARNES GRASAS//***************************

        mockLawyer(sqLiteDatabase, new Alimentos("Alcachofa Entera 2 Porciones","9","", "9.4 gr", "0.6 gr", "9.8 gr","gr", "gr","gr","V_alcachofa_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Apio 1 Porción","9","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Berenjena Mediana 2 Porciones","9","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_berenjena_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        //*******************************PROTEÍNAS DE ORIGEN VEGETAL//***************************

        mockLawyer(sqLiteDatabase, new Alimentos("Alcachofa Entera 2 Porciones","10","", "9.4 gr", "0.6 gr", "9.8 gr","gr", "gr","gr","V_alcachofa_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Apio 1 Porción","10","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Berenjena Mediana 2 Porciones","10","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_berenjena_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        //*******************************DULCES//***************************

        mockLawyer(sqLiteDatabase, new Alimentos("Alcachofa Entera 2 Porciones","11","", "9.4 gr", "0.6 gr", "9.8 gr","gr", "gr","gr","V_alcachofa_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Apio 1 Porción","11", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Berenjena Mediana 2 Porciones","11","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_berenjena_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        //*******************************GRASAS//***************************

        mockLawyer(sqLiteDatabase, new Alimentos("Aceite vegetal de girasol 1 Poción","12","", "9.4 gr", "0.6 gr", "9.8 gr","gr", "gr","gr","V_alcachofa_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Aceite vegetal de olivo 1 Porción","12", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Almendras","12","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_berenjena_2pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Castañas 1 Porción","12", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Mani tostado sin película 1 Porción","12", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Mantequilla 1 Porción","12", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Nueces 1 Porción","12", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Pecanas 1 Porción","12","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Ajonjoli 1 Porción","12","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Crema de leche 1 Porción","12", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Cajú o marañon 1 Porción","12","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Pistachos 1 Porción","12", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783
        mockLawyer(sqLiteDatabase, new Alimentos("Avellanas 1 Porción","12","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Palta 1 Porción","12","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Aceituna botija 1 Porción","12", "","58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Coco fresco 1 Porción","12","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783

        mockLawyer(sqLiteDatabase, new Alimentos("Pistachos 1 Porción","12","", "58.290 Kcal", "0.174 gr", "0.087 gr","14.964 gr", "0.261 gr","0.783 gr","V_apio_1pc.jpg"));
        //58.290	0.174	0.087	14.964	0.261	0.783
    }


    public long mockLawyer(SQLiteDatabase db, Alimentos alimentos) {
        return db.insert(
                AlimentoEntry.TABLE_NAME,
                null,
                alimentos.toContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }

    public long saveLawyer(Alimentos alimentos) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                AlimentoEntry.TABLE_NAME,
                null,
                alimentos.toContentValues());

    }

    public Cursor getAllLawyers(String tipoId) {
        return getReadableDatabase()
                .query(
                        AlimentoEntry.TABLE_NAME,
                        null,
                        AlimentoEntry.GRUPO_ALIMENTO + " LIKE ?",
                        new String[]{tipoId},
                        null,
                        null,
                        null,
                        null);

    }

    public Cursor getLawyerById(String lawyerId) {
        Cursor c = getReadableDatabase().query(
                AlimentoEntry.TABLE_NAME,
                null,
                AlimentoEntry.ID + " LIKE ?",
                new String[]{lawyerId},
                null,
                null,
                null,
                null);
        return c;
    }
}

