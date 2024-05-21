package com.onscreensync.offline.player;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.fragment.app.FragmentActivity;

import com.onscreensync.offline.player.services.LocalStorageService;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends FragmentActivity {
    private LocalStorageService storageService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.storageService = new LocalStorageService(this);

        Handler handler = new Handler();
        final Runnable r = () -> startRun();
        handler.postDelayed(r, 3000);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
        System.exit(0);
    }

    private void startRun() {
        Intent intent = new Intent(this, ContentActivity.class);
        // Start the new activity
        startActivity(intent);
        finish(); // Close the current activity
    }
}