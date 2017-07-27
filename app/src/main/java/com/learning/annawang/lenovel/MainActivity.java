package com.learning.annawang.lenovel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;

public class MainActivity extends Activity {

    private Button mBtnGo;
    private ListView mLvIcons;
    private IconsAdapter mIconsAdapter;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnGo = (Button) this.findViewById(R.id.btn_click);
        mLvIcons = (ListView) this.findViewById(R.id.lv_icons);
        mIconsAdapter = new IconsAdapter(this);
        mLvIcons.setAdapter(mIconsAdapter);
        final int length = GoogleMaterial.Icon.values().length;

        mBtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String icon = GoogleMaterial.Icon.values()[i++ % length].toString();
                icon = "{" + icon
                        .replace("_", "-")
                        .concat("}")
                        .concat(" " + icon);


                mIconsAdapter.add(icon);
            }
        });
    }
}
