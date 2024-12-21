package com.example.app2;
import static com.example.app2.R.id.savebtn;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    Switch sound, vibration, led, showBanners, showContent, showOnLockScreen;
    Button save;
    private SharedPreferences preferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("NotificationData", MODE_PRIVATE);

        sound = findViewById(R.id.sound);
        vibration = findViewById(R.id.vibration);
        led = findViewById(R.id.led);
        showBanners = findViewById(R.id.banners);
        showContent = findViewById(R.id.content);
        showOnLockScreen = findViewById(R.id.lockscreen);
        save = findViewById(savebtn);

        loadSavedPreferences();

        save.setOnClickListener(v -> {
            BottomSheetDialog bottomsheetDialog = new BottomSheetDialog(MainActivity.this);
            Button closeBottomSheet, saveToUserPrefBtn;
            View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
                    R.layout.bottom_sheet_layout,null);
            bottomsheetDialog.setContentView(bottomSheetView);
            closeBottomSheet = bottomSheetView.findViewById(R.id.btn_closeSheet);
            closeBottomSheet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bottomsheetDialog.dismiss();
                }
            });
            saveToUserPrefBtn = bottomSheetView.findViewById(R.id.saveToUserPref);
            saveToUserPrefBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    savePreferences();
                    bottomsheetDialog.dismiss();
                }
            });
            bottomsheetDialog.show();
        });
    }

    private void savePreferences() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("sound", sound.isChecked());
        editor.putBoolean("vibration", vibration.isChecked());
        editor.putBoolean("led", led.isChecked());
        editor.putBoolean("banners", showBanners.isChecked());
        editor.putBoolean("content", showContent.isChecked());
        editor.putBoolean("lockscreen", showOnLockScreen.isChecked());
        editor.apply();
    }

    private void loadSavedPreferences() {
        sound.setChecked(preferences.getBoolean("sound", false));
        vibration.setChecked(preferences.getBoolean("vibration", false));
        led.setChecked(preferences.getBoolean("led", false));
        showBanners.setChecked(preferences.getBoolean("banners", false));
        showContent.setChecked(preferences.getBoolean("content", false));
        showOnLockScreen.setChecked(preferences.getBoolean("lockscreen", false));
    }
}