package com.bamsac.NutriCom.Alimentos;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bamsac.NutriCom.AlimentoDetalle.AlimentoDetalleActivity;
import com.bamsac.NutriCom.Data.AlimentosContract;
import com.bamsac.NutriCom.Data.AlimentosDbHelper;
import com.bamsac.NutriCom.R;



/**
 * Created by Vladdi on 08/12/2016.
 */

public class AlimentosFragment extends Fragment {
    public static final int REQUEST_UPDATE_DELETE_ALIMENTO = 2;
    private static final String ARG_TIPO_ALIMENTO_ID = "alimentoId";
    private AlimentosDbHelper mAlimentosDbHelper;

    private ListView mAlimentosList;
    private AlimentosCursorAdapter mAlimentosAdapter;
    private String mIdTipo;

    //private FloatingActionButton mAddButton;


    public AlimentosFragment() {
        // Required empty public constructor
    }

    public static AlimentosFragment newInstance(String idTipo) {
        AlimentosFragment fragment = new AlimentosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TIPO_ALIMENTO_ID, idTipo);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mIdTipo = getArguments().getString(ARG_TIPO_ALIMENTO_ID);
        }

        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_alimento, container, false);

        // Referencias UI
        mAlimentosList = (ListView) root.findViewById(R.id.lawyers_list);
        mAlimentosAdapter = new AlimentosCursorAdapter(getActivity(), null);
        //mAddButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        // Setup
        mAlimentosList.setAdapter(mAlimentosAdapter);

        // Eventos
        mAlimentosList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor currentItem = (Cursor) mAlimentosAdapter.getItem(i);
                String currentAlimentoId = currentItem.getString(
                        currentItem.getColumnIndex(AlimentosContract.AlimentoEntry.ID));

                showDetailScreen(currentAlimentoId);
            }
        });

        getActivity().deleteDatabase(AlimentosDbHelper.DATABASE_NAME);

        // Instancia de helper
        mAlimentosDbHelper = new AlimentosDbHelper(getActivity());
        // Carga de datos


        loadLawyers();

        return root;
    }

    private void loadLawyers() {
        new LawyersLoadTask().execute();
    }

    /*private void showSuccessfullSavedMessage() {
        Toast.makeText(getActivity(),
                "Abogado guardado correctamente", Toast.LENGTH_SHORT).show();
    }*/

    private void showDetailScreen(String lawyerId) {
        Intent intent = new Intent(getActivity(), AlimentoDetalleActivity.class);
        intent.putExtra(AlimentosActivity.EXTRA_ALIMENTO_ID, lawyerId);
        startActivityForResult(intent, REQUEST_UPDATE_DELETE_ALIMENTO);
    }

    private class LawyersLoadTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mAlimentosDbHelper.getAllLawyers(mIdTipo);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                mAlimentosAdapter.swapCursor(cursor);
            } else {
                // Mostrar empty state
            }
        }
    }

}

