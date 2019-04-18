# PreferenceFragment2
lab4:设置
# 代码：
```
MainActivity.java
package com.example.preferencefragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends Activity implements View.OnClickListener{
    private Intent it=new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                it.setClass(MainActivity.this, SettingFragment.class);
                startActivity(it);
                break;
        }
    }
}

SettingFragment.java
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



```
activity_main.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/btn1"
        android:layout_width="152dp"
        android:layout_height="80dp"
        android:onClick="onClick"
        android:text="设置" />
</LinearLayout>

preferences.xml
<?xml version="1.0" encoding="utf-8"?>
<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <PreferenceCategory
        android:key="Inline_settings"
        android:title="In-line preferences">
        <CheckBoxPreference
            android:key="checkbox_preference"
            android:title="CheckBox Preference"
            android:summary="This is a checkbox"
            android:defaultValue="true" />
    </PreferenceCategory>

    <PreferenceCategory
        android:key="Dialog_settings"
        android:title="Dialog-based preferences">
        <EditTextPreference
            android:key="edittext_preference"
            android:summary="An example that use an edit text dialog"
            android:title="Edit text preference"
            android:dialogTitle="Enter your favorite animal"/>
        <ListPreference
            android:key="listpreference_preference"
            android:title="List preference"
            android:dialogTitle="choose one"
            android:entries="@array/entries_list_preference"
            android:entryValues="@array/entryValues_list_preference"
            android:summary="An example that uses a list dialog"
            />
    </PreferenceCategory>

    <PreferenceCategory
        android:key="Launch_settings"
        android:title="Launch preferences">
        <PreferenceScreen
            android:key="screen_preference"
            android:title="Screen preference"
            android:summary="Shows another screen of preferences">
            <CheckBoxPreference
                android:key="next_screen_checkbox_preference"
                android:title="Toggle preference"
                android:summary="Preference that is on the next screen but the same hierarchy" />
        </PreferenceScreen>
        <PreferenceScreen
            android:key="intent_preference"
            android:title="Intent preference"
            android:summary="Launches an Activity from an Intent">
            <intent
                android:action="android.intent.action.VIEW"
                android:data="http://www.baidu.com" />
        </PreferenceScreen>
    </PreferenceCategory>

    <PreferenceCategory
        android:key="Attributes_settings"
        android:title="Preference attributes">
        <CheckBoxPreference
            android:key="parent_checkbox_preference"
            android:title="Parent checkbox preference"
            android:summary="this is visually a parent" />
        <CheckBoxPreference
            android:dependency="parent_checkbox_preference"
            android:key="child_checkbox_preference"
            android:title="Child checkbox preference"
            android:layout="?android:attr/preferenceLayoutChild"
            android:summary="this is visually a child" />
    </PreferenceCategory>

</PreferenceScreen>
