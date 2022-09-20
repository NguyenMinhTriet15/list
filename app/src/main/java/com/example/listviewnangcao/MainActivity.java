package com.example.listviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int vitri = -1;
    ListView lvclb;
    ArrayList<Club> arrayclub;
    Adapter clubadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        clubadapter = new Adapter(this, R.layout.dong, arrayclub);
        lvclb.setAdapter(clubadapter);
        lvclb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showInfo();
            }
        });
        lvclb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    showdialog();
                vitri = i;
                    return true;

            }
        });
    }

    private void showdialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_main3);
        dialog.show();
        Button btnkhong = (Button) dialog.findViewById(R.id.button);
        Button btnco = (Button) dialog.findViewById(R.id.button2);
        btnco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayclub.remove(vitri);
                clubadapter.notifyDataSetChanged();

            }
        });
    }

    private void Anhxa() {
        lvclb = (ListView) findViewById(R.id.lvclub);
        arrayclub = new ArrayList<>();
        arrayclub.add(new Club("Real Madrid","Coach: Carlo Ancelotti", R.drawable.real));
        arrayclub.add(new Club("Manchester United", "Coach: Erik ten Hag", R.drawable.mu));
        arrayclub.add(new Club("Manchester City","Coach: Pep Guardiola", R.drawable.mc));
        arrayclub.add(new Club("Paris Saint German", "Coach: Mauricio Pochettino", R.drawable.psg));
    }
    private void showInfo() {
        Intent it = new Intent(this, MainActivity2.class);
        startActivity(it);
    }
}