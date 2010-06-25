package org.tridroid.camdroid;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

	private Camera camera;

	public CameraPreview(Context context, AttributeSet attrs) {
		super(context, attrs);
		initHolder();
	}

	private void initHolder() {
		SurfaceHolder holder = getHolder();
		holder.addCallback(this);
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		initCamera(holder);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		camera.startPreview();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		uninitCamera();
	}

	private void initCamera(SurfaceHolder holder) {
		camera = Camera.open();
		try {
			camera.setPreviewDisplay(holder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void uninitCamera() {
		camera.stopPreview();
		camera.release();
		camera = null;
	}

	public void pause() {
		if (camera != null)
			camera.stopPreview();
	}

	public void resume() {
		if (camera != null)
			camera.startPreview();
	}



}
