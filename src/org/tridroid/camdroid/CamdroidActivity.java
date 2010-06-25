package org.tridroid.camdroid;

import android.app.Activity;
import android.os.Bundle;

public class CamdroidActivity extends Activity {
    private CameraPreview cameraPreview;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setupViews();
    }

	@Override
	protected void onPause() {
		super.onPause();
		cameraPreview.pause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		cameraPreview.resume();
	}
	
	private void setupViews() {
		cameraPreview = (CameraPreview) findViewById(R.id.camera_preview);
	}

}