package com.simplemobiletools.filemanager.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;

import com.simplemobiletools.filemanager.Config;
import com.simplemobiletools.filemanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {
    @BindView(R.id.settings_show_hidden) SwitchCompat mShowHiddenSwitch;

    private static Config mConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mConfig = Config.newInstance(getApplicationContext());
        ButterKnife.bind(this);

        setupShowHidden();
    }

    private void setupShowHidden() {
        mShowHiddenSwitch.setChecked(mConfig.getShowHidden());
    }

    @OnClick(R.id.settings_show_hidden_holder)
    public void handleShowHidden() {
        mShowHiddenSwitch.setChecked(!mShowHiddenSwitch.isChecked());
        mConfig.setShowHidden(mShowHiddenSwitch.isChecked());
    }
}
