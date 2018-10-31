package me.xiba.demo.module_c.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import me.xiba.demo.module_c.R;
import me.xiba.demo.module_c.entity.ModuleCDaggerEntity;

/**
 * @Author:liukun
 * @Date: 2018-10-31 14:52
 * @Description:
 */
public class ModuleCActivity extends AppCompatActivity {

    @Inject
    ModuleCDaggerEntity entity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_c_activity);

        TextView textView = findViewById(R.id.text);

        if (entity != null) {
            textView.setText(entity.getName());
        }

        Log.e("DaggerDemo", "entity.getName()=" + entity.getName());
    }
}
