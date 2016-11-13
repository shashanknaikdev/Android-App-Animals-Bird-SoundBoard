package com.ssn.animalsbirds.soundboard.donate;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class MainActivity extends Activity {
	// Added for sound

	private SoundPool soundPool;
	private int soundIDbear;
	private int soundIDcat;
	private int soundIDdog;
	private int soundIDtiger;
	private int soundIDlion;
	private int soundIDelephant;
	private int soundIDhorse;
	private int soundIDpig;
	private int soundIDcrow;
	private int soundIDparrot;
	private int soundIDeagle;
	private int soundIDturkey;
	private int soundIDrooster;
	private int soundIDowl;
	private int soundIDduck;
	private int soundIDpeacock;
	// Toast t;
	boolean loaded = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		 * ImageView v1=new ImageView(this); LinearLayout.LayoutParams
		 * layoutParams1 = new LinearLayout.LayoutParams(60, 60);
		 * layoutParams1.weight=1; layoutParams1.topMargin=20;
		 * layoutParams1.bottomMargin=20;
		 * 
		 * 
		 * v1.setImageResource(R.drawable.catsil2);
		 * v1.setLayoutParams(layoutParams1); ImageView v2=new ImageView(this);
		 * LinearLayout.LayoutParams layoutParams2 = new
		 * LinearLayout.LayoutParams(60, 60); layoutParams2.weight=1;
		 * layoutParams2.topMargin=20; layoutParams2.bottomMargin=20;
		 * 
		 * v2.setImageResource(R.drawable.roostersil);
		 * v2.setLayoutParams(layoutParams2);
		 */
		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);

		tabHost.setup();

		TabSpec spec1 = tabHost.newTabSpec("Tab 1");
		spec1.setContent(R.id.tab1);
		// spec1.setIndicator("ANIMALS");
		spec1.setIndicator("", getResources().getDrawable(R.drawable.catsil2));

		TabSpec spec2 = tabHost.newTabSpec("Tab 2");
		spec2.setIndicator("", getResources()
				.getDrawable(R.drawable.roostersil));

		spec2.setContent(R.id.tab2);
		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
		/*
		 * for(int i=0;i<tabHost.getTabWidget().getChildCount();i++) { TextView
		 * tv = (TextView)
		 * tabHost.getTabWidget().getChildAt(i).findViewById(android
		 * .R.id.title); tv.setTextColor(0); }
		 */

		final GridView gridview1 = (GridView) findViewById(R.id.gridview1);
		gridview1.setAdapter(new ImageAdapter1(this));
		final GridView gridview2 = (GridView) findViewById(R.id.gridview2);
		gridview2.setAdapter(new ImageAdapter2(this));
		// Added for sound
		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
			// @Override
			public void onLoadComplete(SoundPool soundPool, int sampleId,
					int status) {
				loaded = true;
			}
		});
		soundIDbear = soundPool.load(this, R.raw.bear, 1);
		soundIDcat = soundPool.load(this, R.raw.cat, 1);
		soundIDdog = soundPool.load(this, R.raw.dog, 1);
		soundIDelephant = soundPool.load(this, R.raw.elephant, 1);
		soundIDhorse = soundPool.load(this, R.raw.horse, 1);
		soundIDlion = soundPool.load(this, R.raw.lion, 1);
		soundIDpig = soundPool.load(this, R.raw.pig, 1);
		soundIDtiger = soundPool.load(this, R.raw.tiger, 1);

		soundIDcrow = soundPool.load(this, R.raw.crow, 1);
		soundIDduck = soundPool.load(this, R.raw.duck, 1);
		soundIDeagle = soundPool.load(this, R.raw.eagle, 1);
		soundIDowl = soundPool.load(this, R.raw.owl, 1);
		soundIDparrot = soundPool.load(this, R.raw.parrot, 1);
		soundIDpeacock = soundPool.load(this, R.raw.peacock, 1);
		soundIDrooster = soundPool.load(this, R.raw.rooster, 1);
		soundIDturkey = soundPool.load(this, R.raw.turkey, 1);
		Toast.makeText(this, "Switch Tabs to select between Animals and Birds",
				Toast.LENGTH_LONG).show();

		gridview1.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				soundPool.stop(soundIDbear);
				soundPool.stop(soundIDcat);
				soundPool.stop(soundIDdog);
				soundPool.stop(soundIDelephant);
				soundPool.stop(soundIDhorse);
				soundPool.stop(soundIDlion);
				soundPool.stop(soundIDpig);
				soundPool.stop(soundIDtiger);
				soundPool.stop(soundIDcrow);
				soundPool.stop(soundIDpeacock);
				soundPool.stop(soundIDrooster);
				soundPool.stop(soundIDturkey);
				soundPool.stop(soundIDowl);
				soundPool.stop(soundIDeagle);
				soundPool.stop(soundIDparrot);
				soundPool.stop(soundIDduck);

				// int id1=(int)id;
				// Resources.getSystem().getResourceEntryName(id1);
				// ImageView img=(ImageView)gridview1.getChildAt(position);
				// Drawable draw=img.getDrawable().getCurrent();
				AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
				float actualVolume = (float) audioManager
						.getStreamVolume(AudioManager.STREAM_MUSIC);
				float maxVolume = (float) audioManager
						.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
				float volume = actualVolume / maxVolume;
				// int a=draw.hashCode();
				// String s=Resources.getSystem().getString(R.drawable.cat_1);
				// String //display_name="";
				switch (position) {
				case 0:
					// //display_name="Bear";
					if (loaded) {
						soundPool.play(soundIDbear, volume, volume, 1, 0, 1f);

					}
					break;
				case 1:
					// display_name="Cat";
					if (loaded) {
						soundPool.play(soundIDcat, volume, volume, 1, 0, 1f);

					}
					break;
				case 2:
					// display_name="Dog";
					if (loaded) {
						soundPool.play(soundIDdog, volume, volume, 1, 0, 1f);

					}
					break;
				case 3:
					// display_name="Elephant";
					if (loaded) {
						soundPool.play(soundIDelephant, volume, volume, 1, 0,
								1f);

					}
					break;
				case 4:
					// display_name="Pig";
					if (loaded) {
						soundPool.play(soundIDpig, volume, volume, 1, 0, 1f);

					}
					break;
				case 5:
					// display_name="Horse";
					if (loaded) {
						soundPool.play(soundIDhorse, volume, volume, 1, 0, 1f);

					}
					break;
				case 6:
					// display_name="Lion";
					if (loaded) {
						soundPool.play(soundIDlion, volume, volume, 1, 0, 1f);

					}
					break;
				case 7:
					// display_name="Tiger";
					if (loaded) {
						soundPool.play(soundIDtiger, volume, volume, 1, 0, 1f);

					}
					break;

				default:

					break;
				}

				/*
				 * 
				 * t=Toast.makeText(MainActivity.this, //display_name,
				 * Toast.LENGTH_SHORT); t.cancel(); //t.cancel(); t.show();
				 */

			}
		});

		gridview2.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				soundPool.stop(soundIDcrow);
				soundPool.stop(soundIDpeacock);
				soundPool.stop(soundIDrooster);
				soundPool.stop(soundIDturkey);
				soundPool.stop(soundIDowl);
				soundPool.stop(soundIDeagle);
				soundPool.stop(soundIDparrot);
				soundPool.stop(soundIDduck);
				soundPool.stop(soundIDbear);
				soundPool.stop(soundIDcat);
				soundPool.stop(soundIDdog);
				soundPool.stop(soundIDelephant);
				soundPool.stop(soundIDhorse);
				soundPool.stop(soundIDlion);
				soundPool.stop(soundIDpig);
				soundPool.stop(soundIDtiger);
				AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
				float actualVolume = (float) audioManager
						.getStreamVolume(AudioManager.STREAM_MUSIC);
				float maxVolume = (float) audioManager
						.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
				float volume = actualVolume / maxVolume;
				// display_name="";
				switch (position) {
				case 0:
					// display_name="Bald Eagle";
					if (loaded) {
						soundPool.play(soundIDeagle, volume, volume, 1, 0, 1f);

					}
					break;
				case 1:
					// display_name="Crow";
					if (loaded) {
						soundPool.play(soundIDcrow, volume, volume, 1, 0, 1f);

					}
					break;
				case 2:
					// display_name="Parrot";
					if (loaded) {
						soundPool.play(soundIDparrot, volume, volume, 1, 0, 1f);

					}
					break;
				case 3:
					// display_name="Duck";
					if (loaded) {
						soundPool.play(soundIDduck, volume, volume, 1, 0, 1f);

					}
					break;
				case 4:
					// display_name="Peacock";
					if (loaded) {
						soundPool
								.play(soundIDpeacock, volume, volume, 1, 0, 1f);

					}

					break;
				case 5:
					// display_name="Owl";
					if (loaded) {
						soundPool.play(soundIDowl, volume, volume, 1, 0, 1f);

					}
					break;
				case 6:
					// display_name="Turkey";
					if (loaded) {
						soundPool.play(soundIDturkey, volume, volume, 1, 0, 1f);

					}
					break;
				case 7:
					// display_name="Rooster";
					if (loaded) {
						soundPool
								.play(soundIDrooster, volume, volume, 1, 0, 1f);

					}
					break;

				default:

					break;
				}

				// Toast.makeText(MainActivity.this, display_name,
				// Toast.LENGTH_SHORT).show();
			}
		});

		// @Override
		/*
		 * public boolean onCreateOptionsMenu(Menu menu) {
		 * getMenuInflater().inflate(R.menu.activity_main, menu); return true; }
		 */

	}
}
