package com.example.sagf.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sagf.R;
import com.example.sagf.models.ActivoModel;

import java.io.Serializable;
import java.util.ArrayList;

public class ActivoAdapter extends BaseAdapter {

    private ArrayList<ActivoModel> lista;
    private ActivoModel modelo;
    private Context context;

    public ActivoAdapter(ArrayList<ActivoModel> list, Context context){
        this.lista = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View itemc = view;
        if (itemc ==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemc = inflater.inflate(R.layout.item_activo_activity, parent, false);
        }

        TextView tvactivo = itemc.findViewById(R.id.tvactivo);
        modelo = lista.get(i);

        tvactivo.setText(modelo.getEtSerial());


        return itemc;
    }
}
