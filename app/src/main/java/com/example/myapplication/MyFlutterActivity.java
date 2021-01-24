package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.RenderMode;

import android.os.Bundle;
import android.view.View;

public class MyFlutterActivity extends FragmentActivity {
    private static final String TAG_FLUTTER_FRAGMENT = "TAG_FLUTTER_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_flutter);
        showFragment();
    }

    public void showFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FlutterFragment flutterFragment = null;

        if (flutterFragment == null) {
            //添加指定的view
            flutterFragment = FlutterFragment.withNewEngine()
                    .dartEntrypoint("main")//需要在main方法外再添加新的入口
                    .renderMode(RenderMode.texture).build();

            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, flutterFragment, TAG_FLUTTER_FRAGMENT)
                    .commitAllowingStateLoss();
        }

        FlutterActivity
                .withNewEngine()
                .initialRoute("one_page")
                .build(this);
    }
}