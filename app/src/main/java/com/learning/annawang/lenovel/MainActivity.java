package com.learning.annawang.lenovel;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.octicons_typeface_library.Octicons;

public class MainActivity extends Activity {

    private static final String KEY_PER = "KEY_PRE";
    private static final String KEY_CUR = "KEY_CUR";

    private Button mBtnGmd, mBtnCmd, mBtnOct;
    private ListView mLvIcons;
    private IconsAdapter mIconsAdapter;
    private int i;

    private SharedPreferences mPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnGmd = (Button) this.findViewById(R.id.btn_gmd);
        mBtnCmd = (Button) this.findViewById(R.id.btn_cmd);
        mBtnOct = (Button) this.findViewById(R.id.btn_oct);

        mLvIcons = (ListView) this.findViewById(R.id.lv_icons);
        mIconsAdapter = new IconsAdapter(this);
        mLvIcons.setAdapter(mIconsAdapter);

        mBtnGmd.setOnClickListener(mOnclickListener);
        mBtnCmd.setOnClickListener(mOnclickListener);
        mBtnOct.setOnClickListener(mOnclickListener);

        mPreference = PreferenceManager.getDefaultSharedPreferences(this);
    }

    private View.OnClickListener mOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String pre = mPreference.getString(KEY_PER, "");
            if (!((Button) v).getText().toString().equalsIgnoreCase(pre)) {
                mIconsAdapter.invalid();
                i = 0;
            }
            mPreference.edit().putString(KEY_PER, ((Button) v).getText().toString()).apply();
            String icon = "";
            switch (v.getId()) {
                case R.id.btn_gmd: {
                    int length = GoogleMaterial.Icon.values().length;
                    icon = GoogleMaterial.Icon.values()[i++ % length].toString();
                    break;
                }
                case R.id.btn_cmd: {
                    int length = CommunityMaterial.Icon.values().length;
                    icon = CommunityMaterial.Icon.values()[i++ % length].toString();
                    break;
                }

                case R.id.btn_oct: {
                    int length = Octicons.Icon.values().length;
                    icon = Octicons.Icon.values()[i++ % length].toString();
                    break;
                }

                default:
                    break;
            }

            icon = "{" + icon
                    .replace("_", "-")
                    .concat("}")
                    .concat(" " + icon);
            mIconsAdapter.add(icon);
        }
    };
}
