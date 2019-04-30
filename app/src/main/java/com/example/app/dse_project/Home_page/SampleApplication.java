package com.example.app.dse_project.Home_page;

import android.app.Application;

import com.parse.Parse;

public class SampleApplication extends Application {
    @Override
    public void onCreate() {
      //  super.onCreate();
        Parse.initialize(this, "HloReNgHsJCLGTV6dkRB0YVsS56m0NXvQCUsZswZ","EqbrHG27T5xm6KnfbEtpMiea1ny4g1NCjjvfaRYi");
    }
}