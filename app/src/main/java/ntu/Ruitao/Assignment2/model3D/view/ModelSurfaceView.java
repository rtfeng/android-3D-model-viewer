package ntu.Ruitao.Assignment2.model3D.view;

import ntu.Ruitao.Assignment2.model3D.controller.TouchController;

import android.content.Context;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * This is the actual opengl view. From here we can detect touch gestures for example
 * 
 * @author Ruitao
 *
 */
public class ModelSurfaceView extends GLSurfaceView {

	private ModelActivity parent;
	private ModelRenderer mRenderer;
	private TouchController touchHandler;

	public ModelSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);

		// parent component
		this.parent = (ModelActivity) context;

		// Create an OpenGL ES 2.0 context.
		setEGLContextClientVersion(2);

		// This is the actual renderer of the 3D space
		mRenderer = new ModelRenderer(this);
		setRenderer(mRenderer);

		// Render the view only when there is a change in the drawing data
		// TODO: enable this again
		// setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

		touchHandler = new TouchController(this, mRenderer);

		getHolder().setFormat(PixelFormat.RGBA_8888);
		getHolder().setFormat(PixelFormat.TRANSLUCENT);
//		setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
		setZOrderMediaOverlay(true);
//		setBackgroundColor(Color.parseColor("#E57373"));
	}

	public ModelSurfaceView(ModelActivity parent) {
		super(parent);

		// parent component
		this.parent = parent;

		// Create an OpenGL ES 2.0 context.
		setEGLContextClientVersion(2);

		// This is the actual renderer of the 3D space
		mRenderer = new ModelRenderer(this);
		setRenderer(mRenderer);

		// Render the view only when there is a change in the drawing data
		// TODO: enable this again
		// setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

		touchHandler = new TouchController(this, mRenderer);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return touchHandler.onTouchEvent(event);
	}

	public ModelActivity getModelActivity() {
		return parent;
	}

}