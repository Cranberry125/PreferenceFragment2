package com.example.preferencefragment;
import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SettingFragment extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new Fragement()).commit();
    }
    public static class Fragement extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }




}
