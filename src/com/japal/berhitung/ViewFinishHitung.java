package com.japal.berhitung;

import com.japal.maribelajarbahasainggris.MainActivity;
import com.japal.maribelajarbahasainggris.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class ViewFinishHitung extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.viewfinishhitung);
		
		Button menu = (Button)findViewById(R.id.btnmenu);
		menu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ViewFinishHitung.this.finish();
				Intent i = new Intent(v.getContext(), MainActivity.class);
				startActivityForResult(i, 0);
				
			}
		});
		 
	}
	
	public void onBackPressed(){
		 Toast.makeText(ViewFinishHitung.this, "Mulai Dari Awal Aja Yaa..." ,
	               Toast.LENGTH_LONG).show();
	}
}
