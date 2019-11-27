package com.example.sagf.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sagf.R;
import com.example.sagf.models.ActivoModel;
import com.example.sagf.models.ServicioModel;


import java.util.ArrayList;

public class ServicioAdapter extends BaseAdapter {

    private ArrayList<ServicioModel> list;
    private ServicioModel model;
    private Context context;

    public ServicioAdapter(ArrayList<ServicioModel> list, Context context){
        this.list = list;
        this.context = context;
    }


    @Override
    public int getCount() {
        return list.size() ;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View item= view;
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item = inflater.inflate(R.layout.item_usuario_activity,parent, false);
        }

        TextView tvcuenta = item.findViewById(R.id.tvusuario);
        model = list.get(i);
        tvcuenta.setText(model.getEtAservicio());
        return item;
    }
}
