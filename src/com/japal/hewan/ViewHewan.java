package com.japal.hewan;

import com.japal.maribelajarbahasainggris.MainActivity;
import com.japal.maribelajarbahasainggris.R;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;


public class ViewHewan extends Activity implements OnItemClickListener{
	
	
	public static final String[] items={"Dogs","Chickens","Pigs","Rhinos","Ducks","Bears","Crocodiles","Birds","Sheep","Elephants",
						"Giraffes","Goats","Kangaroo","Bats","Rabbits","Deer","Cats","Hippos","Bee","Tiger",
						"Peacocks","Monkeys","Owls","Pandas","Penguins","Cows","Lions","Mice","Squirrels","Zebra"};
	
	private int[] imageID={R.drawable.anjing,R.drawable.ayam,R.drawable.babi,R.drawable.badak,R.drawable.bebek,
				  R.drawable.beruang,R.drawable.buaya,R.drawable.burung,R.drawable.domba,R.drawable.gajah,R.drawable.jerapah,
				  R.drawable.kambing,R.drawable.kangguru,R.drawable.kelelawar,R.drawable.kelinci,R.drawable.kijang,R.drawable.kucing,
				  R.drawable.kudanil,R.drawable.lebah,R.drawable.macan,R.drawable.merak,R.drawable.monyet,R.drawable.owl,
				  R.drawable.panda,R.drawable.penguin,R.drawable.sapi,R.drawable.singa,R.drawable.tikus,R.drawable.tupai,R.drawable.zebra};
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.viewhewan);
		
		Button home = (Button)findViewById(R.id.home);
		home.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ViewHewan.this.finish();
				Intent i = new Intent(v.getContext(), MainActivity.class);
				startActivityForResult(i, 0);
			}
		});
		
		
		GridView g = (GridView)findViewById(R.id.gridhewan);
		g.setAdapter(new IconAdapter());
		
		g.setOnItemClickListener(this);
	}
	
	private class IconAdapter extends ArrayAdapter<String>{
		
		public IconAdapter(){
			super(ViewHewan.this,R.layout.rowgridhewan, items);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			View row= convertView;
			
			if(row==null){
				LayoutInflater inflater = getLayoutInflater();
				row = inflater.inflate(R.layout.rowgridhewan, parent, false);
			}
			
			ImageView gambarHewan = (ImageView)row.findViewById(R.id.gambarhewan);
			TextView textHewan = (TextView)row.findViewById(R.id.texthewan);
			
			gambarHewan.setScaleType(ScaleType.FIT_XY);
			
			textHewan.setText(items[position]);
			gambarHewan.setImageResource(imageID[position]);
		
			return row;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int p, long arg3) {
		// TODO Auto-generated method stub
		 Toast.makeText(ViewHewan.this, items[p] ,
	               Toast.LENGTH_SHORT).show();
	}
	
	public void onBackPressed(){
		Toast.makeText(ViewHewan.this, "Maaf Tidak Bisa." ,
	               Toast.LENGTH_SHORT).show();
	}
}
