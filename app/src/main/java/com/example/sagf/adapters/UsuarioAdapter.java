package com.example.sagf.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sagf.R;
import com.example.sagf.models.ServicioModel;
import com.example.sagf.models.Usuarios;

import java.util.ArrayList;

public class UsuarioAdapter extends BaseAdapter {

    private ArrayList<Usuarios> list;
    private Usuarios model;
    private Context context;

    public UsuarioAdapter(ArrayList<Usuarios> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View itemcito = view;
        if (view ==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemcito = inflater.inflate(R.layout.item_usuario_activity, parent, false);
        }

        TextView tvusuario = itemcito.findViewById(R.id.tvusuario);
        model = list.get(i);

        tvusuario.setText(model.getNombre());


        return itemcito;
    }
}
