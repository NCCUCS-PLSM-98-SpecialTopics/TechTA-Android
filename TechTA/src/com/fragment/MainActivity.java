package com.fragment;

import com.fragment.JWC;

import android.os.Bundle;
//import org.apache.cordova.*;

import android.app.Activity;

import android.widget.Button;

import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;  
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends  Activity {
	
	//private Button btn_send;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //super.loadUrl("file:///android_asset/www/index2.html");
        JWC.init();
		JWC.loadSettings(this);
        setContentView(R.layout.activity_main);
               	        
        Button btn1=(Button)findViewById(R.id.btn_send);
        btn1.setOnClickListener(A);    
    }
    
    public OnClickListener A = new OnClickListener(){
        @Override
        public void onClick(View v) {
           Intent nextPage = new Intent();
           nextPage.setClass(MainActivity.this, FragmentTabs.class);
           startActivity(nextPage);
           MainActivity.this.finish();
           //setContentView(R.layout.room);
        }
     };
    
    
}


