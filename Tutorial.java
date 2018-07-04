package com.example.sriven.eodersconsumer;

import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class Tutorial extends AppCompatActivity {
RelativeLayout topLevelLayout;
ViewPager viewPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tutorial);
		topLevelLayout = findViewById(R.id.top_layout);

		viewPager = (ViewPager)findViewById(R.id.view_pager);
		if (isFirstTime()) {
			topLevelLayout.setVisibility(View.INVISIBLE);
		}
	}
	private boolean isFirstTime()
	{
		SharedPreferences preferences = getPreferences(MODE_PRIVATE);
		boolean ranBefore = preferences.getBoolean("RanBefore", false);
		if (!ranBefore) {

			SharedPreferences.Editor editor = preferences.edit();
			editor.putBoolean("RanBefore", true);
			editor.apply();
			topLevelLayout.setVisibility(View.VISIBLE);
			topLevelLayout.setOnTouchListener(new View.OnTouchListener(){

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					topLevelLayout.setVisibility(View.INVISIBLE);
					return false;
				}

			});


		}
		return ranBefore;

	}
}
