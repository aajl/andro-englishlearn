package com.japal.maribelajarbahasainggris;

import com.japal.berhitung.ViewNol;
import com.japal.hewan.ViewHewan;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {

	Dialog popup;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		Button hitung = (Button)findViewById(R.id.btnberhitung);
		hitung.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				MainActivity.this.finish();
				Intent myIntent = new Intent(view.getContext(), ViewNol.class);
				startActivityForResult(myIntent, 0);
			}
		});
		
			Button hewan = (Button)findViewById(R.id.btnhewan);
		hewan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MainActivity.this.finish();
				Intent myIntent = new Intent(v.getContext(), ViewHewan.class);
				startActivityForResult(myIntent, 0);
			}
		});
		
		
		Button latihan = (Button)findViewById(R.id.btnlatihan);
		latihan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popup();
			}
		});
		
		Button keluar = (Button)findViewById(R.id.btnkeluar);
		keluar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				exit();	
			}
		});
		
		
	}
	
	
	private void exit(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		  builder.setMessage("Yakin Akan Keluar?")
		  .setCancelable(false)//tidak bisa tekan tombol back
		  //jika pilih yess
		  .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		   public void onClick(DialogInterface dialog, int id) {
		    finish();
		   }
		  })
		  //jika pilih no
		  .setNegativeButton("No", new DialogInterface.OnClickListener() {
		   public void onClick(DialogInterface dialog, int id) {
		    dialog.cancel();
		   }
		  }).show();
	}
	
	public void onBackPressed(){
		exit();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void popup(){
		popup  = new Dialog(MainActivity.this,android.R.style.Theme_Translucent);
		popup.requestWindowFeature(Window.FEATURE_NO_TITLE); 
		popup.setCancelable(true);
		popup.setContentView(R.layout.popuptentang);
	Button btnclose = (Button)popup.findViewById(R.id.btnclose);
	btnclose.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			popup.dismiss();	
		}
	});
	popup.show();
	}



}
