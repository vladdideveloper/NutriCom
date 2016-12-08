package com.bamsac.NutriCom.AlimentoDetalle;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.CollapsingToolbarLayout;
import com.bumptech.glide.Glide;

import com.bamsac.NutriCom.Alimentos.AlimentosFragment;
import com.bamsac.NutriCom.Data.Alimentos;
import com.bamsac.NutriCom.Data.AlimentosDbHelper;
import com.bamsac.NutriCom.R;

/**
 * Created by Vladdi on 08/12/2016.
 */

public class AlimentoDetalleFragment extends Fragment {
    private static final String ARG_LAWYER_ID = "lawyerId";

    private String mLawyerId;

    private CollapsingToolbarLayout mCollapsingView;
    private ImageView mAvatar;
    private TextView mProteinas;
    private TextView mPeso;
    private TextView mEnergy;
    private TextView mLipidos;
    private TextView mCarb;
    private TextView mFibCrud;
    private TextView mFibDiet;

    private AlimentosDbHelper mAlimentosDbHelper;


    public AlimentoDetalleFragment() {
        // Required empty public constructor
    }

    public static AlimentoDetalleFragment newInstance(String lawyerId) {
        AlimentoDetalleFragment fragment = new AlimentoDetalleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_LAWYER_ID, lawyerId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mLawyerId = getArguments().getString(ARG_LAWYER_ID);
        }

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_alimento_detalle, container, false);
        mCollapsingView = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_layout);
        mAvatar = (ImageView) getActivity().findViewById(R.id.iv_avatar);
        mPeso = (TextView) root.findViewById(R.id.tv_peso);
        mProteinas = (TextView) root.findViewById(R.id.tv_proteinas);
        mEnergy = (TextView) root.findViewById(R.id.tv_energy);
        mLipidos = (TextView) root.findViewById(R.id.tv_lipidos);
        mCarb = (TextView) root.findViewById(R.id.tv_carb);
        mFibCrud = (TextView) root.findViewById(R.id.tv_fibCrud);
        mFibDiet = (TextView) root.findViewById(R.id.tv_fibDiet);

        mAlimentosDbHelper = new AlimentosDbHelper(getActivity());

        loadLawyer();

        return root;
    }

    private void loadLawyer() {
        new GetLawyerByIdTask().execute();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == AlimentosFragment.REQUEST_UPDATE_DELETE_ALIMENTO) {
            if (resultCode == Activity.RESULT_OK) {
                getActivity().setResult(Activity.RESULT_OK);
                getActivity().finish();
            }
        }
    }

    private void showLawyer(Alimentos alimentos) {
        mCollapsingView.setTitle(alimentos.getName());
        Glide.with(this)
                .load(Uri.parse("file:///android_asset/" + alimentos.getAvatarUri()))
                .centerCrop()
                .into(mAvatar);
        mPeso.setText(alimentos.getPeso());
        mProteinas.setText(alimentos.getProteinas());
        mEnergy.setText(alimentos.getEnergy());
        mLipidos.setText(alimentos.getLipidos());
        mCarb.setText(alimentos.getCarb());
        mFibCrud.setText(alimentos.getFibCrud());
        mFibDiet.setText(alimentos.getFibDiet());
    }

    /*private void showLawyersScreen(boolean requery) {
        if (!requery) {
            showDeleteError();
        }
        getActivity().setResult(requery ? Activity.RESULT_OK : Activity.RESULT_CANCELED);
        getActivity().finish();
    }*/

    private void showLoadError() {
        Toast.makeText(getActivity(),
                "Error al cargar información", Toast.LENGTH_SHORT).show();
    }

    /*private void showDeleteError() {
        Toast.makeText(getActivity(),
                "Error al eliminar abogado", Toast.LENGTH_SHORT).show();
    }*/

    private class GetLawyerByIdTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mAlimentosDbHelper.getLawyerById(mLawyerId);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.moveToLast()) {
                showLawyer(new Alimentos(cursor));
            } else {
                showLoadError();
            }
        }

    }

}
