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

public class ViewSembilan extends Activity {

	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.viewsembilan);
		
		
		Button next = (Button)findViewById(R.id.btnlanjut10);
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ViewSembilan.this.finish();
				Intent myIntent = new Intent(v.getContext(), ViewSepuluh.class);
				startActivityForResult(myIntent, 0);
			}
		});
		
		Button play = (Button)findViewById(R.id.bplay10);
		play.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp=new MediaPlayer();
				// go();
				mp = MediaPlayer.create(getBaseContext(), R.raw.sembilan);

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
		 Toast.makeText(ViewSembilan.this, "Selesaikan Dulu Dong Belajarnya" ,
	               Toast.LENGTH_LONG).show();
	}
}
