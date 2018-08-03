package vda.irestore.com.vda_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dermandar.dmd_lib.CallbackInterfaceShooter;
import com.dermandar.dmd_lib.DMD_Capture;
import com.dermandar.dmd_lib.DMD_Capture.FinishShootingEnum;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import vda.irestore.com.vda_android.Global.Utils;

public class ShooterActivity extends Activity {
	public static int imageNumber = 1;

	public  static File panoImageURL1;
	public  static File panoThumbImageURL1;
	public  static String panoImageName1;

	private Handler mHandler;
	File thumbPanoFilePath_one,panoFilePath_one;


	private RelativeLayout mRelativeLayoutRoot;
	private ViewGroup mViewGroupCamera;
	private DMD_Capture mDMDCapture;

	private Display mDisplay;
	private DisplayMetrics mDisplayMetrics;
	SharedPreferences sharedPref;
	SharedPreferences.Editor editor;

	private ImageViewBordered mImageViewCameraCaptureEffect;
	private Bitmap mBitmapCameraCaptureEffect;
	private AlphaAnimation mAlphaAnimationCameraCaptureEffect;
	private AnimationSet mAnimationSetCameraCaptureEffect;
	private View mViewPreviewCaptureEffect;

	private TextView mTextViewInstruction;

	private SimpleDateFormat mSimpleDateFormat;

	private String mPanoramaName, mEquiPath;
	private boolean mIsCapturing, mIsStitching;
	private int mNumberTakenImages;

	private int mCurrentInstructionMessageID = -1;
	private int lAngle = 0;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sharedPref = getSharedPreferences(getString(
				R.string.preference_file_key), Context.MODE_PRIVATE);

		//getting screen resolution
		mDisplay = getWindowManager().getDefaultDisplay();
		mDisplayMetrics = new DisplayMetrics();
		mDisplay.getMetrics(mDisplayMetrics);

		mHandler = new Handler();

		//File name formatter
		mSimpleDateFormat = new SimpleDateFormat("yyMMdd_HHmmss");

		mRelativeLayoutRoot = new RelativeLayout(this);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		mRelativeLayoutRoot.setLayoutParams(layoutParams);

		mDMDCapture = new DMD_Capture();
		mViewGroupCamera = mDMDCapture.initShooter(this, mCallbackInterface, getWindowManager().getDefaultDisplay().getRotation(), true, true);
		mRelativeLayoutRoot.addView(mViewGroupCamera);
		mViewGroupCamera.setOnClickListener(mCameraOnClickListener);

		//Text View instruction
		mTextViewInstruction = new TextView(this);
		mTextViewInstruction.setTextSize(32f);
		mTextViewInstruction.setGravity(Gravity.CENTER);
		setInstructionMessage(R.string.instruction_tap_start);
		mRelativeLayoutRoot.addView(mTextViewInstruction);

		//View Preview Capture animation
		mViewPreviewCaptureEffect = new View(this);
		mViewPreviewCaptureEffect.setLayoutParams(new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
		mViewPreviewCaptureEffect.setBackgroundColor(Color.WHITE);

		//ImageView Camera Capture animation
		mImageViewCameraCaptureEffect = new ImageViewBordered(this);
		mImageViewCameraCaptureEffect.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
		mImageViewCameraCaptureEffect.setScaleType(ScaleType.FIT_XY);
		mBitmapCameraCaptureEffect = null;
		//
		mAnimationSetCameraCaptureEffect = new AnimationSet(true);
		mAnimationSetCameraCaptureEffect.setInterpolator(new AccelerateInterpolator());
		//Anim1
		mAlphaAnimationCameraCaptureEffect = new AlphaAnimation(0.65f, 0.0f);
		mAlphaAnimationCameraCaptureEffect.setDuration(400);
		mAlphaAnimationCameraCaptureEffect.setStartOffset(0);
		mAlphaAnimationCameraCaptureEffect.setRepeatCount(0);
		mAlphaAnimationCameraCaptureEffect.setFillAfter(true);
		mAlphaAnimationCameraCaptureEffect.setAnimationListener(new AnimationListener() {
			public void onAnimationStart(Animation animation) {
				//mImageViewCameraCaptureEffect.setImageBitmap(mBitmapCameraCaptureEffect);
			}

			public void onAnimationRepeat(Animation animation) {}
			public void onAnimationEnd(Animation animation) {
				if(mViewPreviewCaptureEffect.getParent() != null) {
					mHandler.post(new Runnable() {
						public void run() {
							if(mViewPreviewCaptureEffect.getParent() != null) {
								mViewGroupCamera.removeView(mViewPreviewCaptureEffect);
								mViewGroupCamera.invalidate();
							}
						}
					});
				}
			}
		});
		//Anim2
		Animation animationTranslate = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 1.0f);
		animationTranslate.setInterpolator(new AccelerateInterpolator());
		animationTranslate.setDuration(550);
		animationTranslate.setStartOffset(0);
		animationTranslate.setFillAfter(true);
		animationTranslate.setRepeatCount(0);
		animationTranslate.setAnimationListener(new AnimationListener() {
			public void onAnimationStart(Animation animation) {
			}

			public void onAnimationRepeat(Animation animation) {}

			public void onAnimationEnd(Animation animation) {
				mHandler.post(new Runnable() {
					public void run() {
						if(mImageViewCameraCaptureEffect.getParent() != null) {
							mViewGroupCamera.removeView(mImageViewCameraCaptureEffect);
							mImageViewCameraCaptureEffect.setImageDrawable(null);
						}
						if(mBitmapCameraCaptureEffect != null) {
							mBitmapCameraCaptureEffect.recycle();
							mBitmapCameraCaptureEffect = null;
						}
					}
				});
			}
		});

		//Anim3
		Animation animationScale = new ScaleAnimation(
				1.0f, 0.01f,
				1.0f, 0.01f,
				Animation.RELATIVE_TO_SELF, 1.0f,
				Animation.RELATIVE_TO_SELF, 1.0f);
		animationScale.setInterpolator(new AccelerateInterpolator());
		animationScale.setDuration(550);
		animationScale.setStartOffset(0);
		animationScale.setFillAfter(true);
		animationScale.setRepeatCount(0);

		//setting animations
		mAnimationSetCameraCaptureEffect.addAnimation(animationTranslate);
		mAnimationSetCameraCaptureEffect.addAnimation(animationScale);

		if(mDMDCapture.isTablet()) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		}
		else {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		}

		setContentView(mRelativeLayoutRoot);
		//showAngle();
	}

	@Override
	protected void onPause() {
		super.onPause();
		if(mIsCapturing) {
			//clear the flag to prevent the screen of being on
			getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

			mIsCapturing = false;
			setInstructionMessage(R.string.instruction_tap_start);
		}
		mDMDCapture.stopShooting();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mDMDCapture.restart(this, mDisplayMetrics.widthPixels, mDisplayMetrics.heightPixels);
		mTextViewInstruction.setVisibility(View.VISIBLE);
	}

	@Override
	public void onBackPressed() {
		if(mIsStitching) {
			return;
		}
		if(mIsCapturing) {
			//clear the flag to prevent the screen of being on
			getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

			mDMDCapture.restart(this, mDisplayMetrics.widthPixels, mDisplayMetrics.heightPixels);
			mIsCapturing = false;
			setInstructionMessage(R.string.instruction_tap_start);
		}
		else {
			super.onBackPressed();
		}
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
	}

	private void setInstructionMessage(int msgID) {
		if(mCurrentInstructionMessageID == msgID)
			return;

		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(mDisplayMetrics.widthPixels, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_HORIZONTAL);

		if(msgID == R.string.instruction_empty || msgID == R.string.instruction_hold_vertically || msgID == R.string.instruction_tap_start
				|| msgID == R.string.instruction_focusing) {
			params.addRule(RelativeLayout.CENTER_VERTICAL);
		}
		else {
			params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		}

		mTextViewInstruction.setLayoutParams(params);
		mTextViewInstruction.setText(msgID);
		mCurrentInstructionMessageID = msgID;
	}

	private void toastMessage(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	private View.OnClickListener mCameraOnClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			if(mIsCapturing) {
				//clear the flag to prevent the screen of being on
				getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

				if(mDMDCapture.finishShooting()) {
					mIsStitching = true;
					mTextViewInstruction.setVisibility(View.INVISIBLE);
				}
				mIsCapturing = false;
				setInstructionMessage(R.string.instruction_tap_start);
			}
			else {
				mNumberTakenImages = 0;
				mPanoramaName = mSimpleDateFormat.format(new Date());

				if(mDMDCapture.startShooting()) {
					setInstructionMessage(R.string.instruction_focusing);
					mIsCapturing = true;
					//set flag to keep the screen on
					getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
				}
			}
		}
	};

	private CallbackInterfaceShooter mCallbackInterface = new CallbackInterfaceShooter() {

		@Override
		public void takingPhoto() {
			if(mImageViewCameraCaptureEffect.getParent() != null) {
				mViewGroupCamera.removeView(mImageViewCameraCaptureEffect);
				mImageViewCameraCaptureEffect.setImageDrawable(null);
			}
			if(mViewPreviewCaptureEffect.getParent() != null) {
				mViewGroupCamera.removeView(mViewPreviewCaptureEffect);
			}

			mImageViewCameraCaptureEffect.setImageBitmap(mBitmapCameraCaptureEffect);
			mViewGroupCamera.addView(mImageViewCameraCaptureEffect);
			mViewGroupCamera.addView(mViewPreviewCaptureEffect);
			mViewPreviewCaptureEffect.startAnimation(mAlphaAnimationCameraCaptureEffect);
		}

		@Override
		public void stitchingCompleted(HashMap<String, Object> info) {
			/*File equiFolder = new File(Environment.getExternalStorageDirectory() + "/" + Globals.EQUI_FOLDER_NAME + "/");
*/
			File equiFolder = new File(Environment.getExternalStoragePublicDirectory(
					Environment.DIRECTORY_DCIM), "VDA");

			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");




			if(equiFolder.exists() == false) {
				equiFolder.mkdir();
			}

			if(imageNumber ==1) {
				String fname = sharedPref.getString("phoneNumber","") + "-" + dateFormat.format(new Date()) + "-SCENE-1";
				mEquiPath = equiFolder.getPath() + "/" + fname + ".png";

				panoFilePath_one = new File(equiFolder, fname + ".png");
				thumbPanoFilePath_one = new File(equiFolder.getPath(), fname + "-thumbnail.png");


				panoImageURL1 = panoFilePath_one;
				panoThumbImageURL1 = thumbPanoFilePath_one;
			}

			mDMDCapture.genEquiAt(mEquiPath, 800, 0, 0);

			//##########################################

			int obj = (Integer) info.get(FinishShootingEnum.fovx.name());
			Log.wtf("@__@", "++++++   stitchingCompleted:"+obj);
			lAngle = obj;
			//##########################################

		}

		@Override
		public void shootingCompleted(boolean finished) {
			//clear the flag to prevent the screen of being on
			getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

			if(finished) {
				mTextViewInstruction.setVisibility(View.INVISIBLE);
				mIsStitching = true;
			}
			mIsCapturing = false;
		}

		@Override
		public void preparingToShoot() {
		}

		@Override
		public void photoTaken() {
			if(mNumberTakenImages == 0) {
				setInstructionMessage(R.string.instruction_first_shot);
			}
			else {
				setInstructionMessage(R.string.instruction_finish_shot);
			}
			mNumberTakenImages++;
			mImageViewCameraCaptureEffect.startAnimation(mAnimationSetCameraCaptureEffect);
		}

		@Override
		public void deviceVerticalityChanged(int isVertical) {
			if(!mIsCapturing) {
				if(isVertical == 1) {
					setInstructionMessage(R.string.instruction_tap_start);
				}
				else {
					setInstructionMessage(R.string.instruction_hold_vertically);
				}
			}
		}

		@Override
		public void compassEvent(HashMap<String, Object> info) {
			if(info != null) {
				Object obj = info.get(DMD_Capture.CompassActionEnum.kDMDCompassInterference.name());
				if(obj != null && obj instanceof Boolean && ((Boolean)obj).equals(Boolean.TRUE)) {
					toastMessage(getString(R.string.compass_interference_msg));
				}

				//##########################################

				Log.wtf("@__@", "++++++   compassEvent:"+obj.toString());

				//############################################
			}
		}

		@Override
		public void canceledPreparingToShoot() {
		}

		@Override
		public void shotTakenPreviewReady(Bitmap bitmapPreview) {
			if(mBitmapCameraCaptureEffect != null) {
				mBitmapCameraCaptureEffect.recycle();
				mBitmapCameraCaptureEffect = null;
			}
			mBitmapCameraCaptureEffect = bitmapPreview;
		}

		@Override
		public void onFinishGeneratingEqui() {
			new SingleMediaScanner(ShooterActivity.this, mEquiPath);
			saveAngle();
			mIsStitching = false;
			/*Intent intentViewer = new Intent(ShooterActivity.this, ViewerActivity.class);
			intentViewer.putExtra("PanoramaName", mPanoramaName);
			startActivity(intentViewer);*/




			/*Intent intent = new Intent();
			intent.setClass(ShooterActivity.this, ShowPanoPictureTaken.class);*/
			 editor = sharedPref.edit();

			 Utils.images_array = new ArrayList<File>();


			if(imageNumber ==1) {
				panoImageName1 = mEquiPath;


				File imgFile1 = new File(ShooterActivity.panoImageName1);

				if(imgFile1.exists())
				{
					Bitmap myBitmap = BitmapFactory.decodeFile(imgFile1.getAbsolutePath());

					Matrix matrix = new Matrix();

					matrix.postRotate(90);

					Bitmap scaledBitmap = Bitmap.createScaledBitmap(myBitmap,myBitmap.getWidth(),myBitmap.getHeight(),true);

					Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap , 0, 0, scaledBitmap .getWidth(), scaledBitmap .getHeight(), matrix, true);
					// ImageView imageView=(ImageView)findViewById(R.id.imageView);
					// panoPicOne.setImageBitmap(rotatedBitmap);
					Utils.panoBitmap1 = rotatedBitmap;

					FileOutputStream fosr;
					File file = new File(thumbPanoFilePath_one.getPath());

					try {

						fosr = new FileOutputStream(file);
						Bitmap b = Bitmap.createScaledBitmap(Utils.panoBitmap1, 250, 250, false);
						b.compress(Bitmap.CompressFormat.PNG,100, fosr);
						fosr.flush();
						fosr.close();
						//   MediaStore.Images.Media.insertImage(getContentResolver(), b, "Screen", "screen");
					}catch (IOException e) {

						e.printStackTrace();
					}
				}
				Utils.images_array.add(panoImageURL1);
				//images_array.add(thumbPanoFilePath_one);

			}

			editor.commit();
			Intent intent = new Intent();
			intent.setClass(ShooterActivity.this, ShowPanoPictureTaken.class);
			// intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
			startActivityForResult(intent,67);
		//	startActivity(intent);
		//	finish();
			//toastMessage("Panorama saved in gallery");



		}
	};

	private void saveAngle()
	{
		try {
			ExifInterface ei=new ExifInterface(mEquiPath);
			ei.setAttribute("UserComment", lAngle+"");
			ei.setAttribute("CopyRight", lAngle+"");
			ei.saveAttributes();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 67) {
			setResult(3455);
			finish();
		}

	}
}
