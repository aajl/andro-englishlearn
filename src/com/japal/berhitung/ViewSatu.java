package com.japal.berhitung;

import java.io.IOException;

import com.japal.maribelajarbahasainggris.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class ViewSatu extends Activity{
	
	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.viewsatu);
		
		
		Button next = (Button)findViewById(R.id.btnlanjut2);
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ViewSatu.this.finish();
				Intent myIntent = new Intent(v.getContext(), ViewDua.class);
				startActivityForResult(myIntent, 0);
			}
		});
		
		Button play = (Button)findViewById(R.id.bplay2);
		play.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp=new MediaPlayer();
				// go();
				mp = MediaPlayer.create(getBaseContext(), R.raw.satu);

				try {
					mp.prepare();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				mp.start();

			}
		});
		
	}
	
	public void onBackPressed(){
		 Toast.makeText(ViewSatu.this, "Selesaikan Dulu Dong Belajarnya" ,
	               Toast.LENGTH_LONG).show();
	}
		
		
	}

