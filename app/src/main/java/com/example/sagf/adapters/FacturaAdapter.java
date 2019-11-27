package com.example.sagf.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sagf.R;
import com.example.sagf.models.FacturaModel;

import java.util.ArrayList;

public class FacturaAdapter extends BaseAdapter {

    private ArrayList<FacturaModel> lista;
    private FacturaModel modelito;
    private Context context;

    public FacturaAdapter(ArrayList<FacturaModel> list, Context context) {
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
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item = view;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item = inflater.inflate(R.layout.item_usuario_activity, viewGroup, false);
        }
        TextView tvusuario = item.findViewById(R.id.tvusuario);
        modelito = lista.get(i);

        tvusuario.setText(modelito.getEtIdFactura());


        return item;
    }

}