package vda.irestore.com.vda_android;

import android.Manifest;
import android.app.ActionBar;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import vda.irestore.com.vda_android.Global.Utils;


public class AndroidCameraApi extends Activity {
    //Zooming
    protected float fingerSpacing = 0;
    protected float zoomLevel = 1f;
    protected float maximumZoomLevel;
    protected Rect zoom;
    private static final String TAG = "AndroidCameraApi_pinchZoom";
    private Button takePictureButton;
    private Size jpegSizes[] = null;
    private TextureView textureView;
    private Size previewsize;
    private CaptureRequest.Builder previewBuilder;
    private CameraCaptureSession previewSession;
    ImageView getpicture, getFromGallary;
    static Bitmap bitmapOne, bitmapTwo;
    Typeface typeFace;
    CameraCharacteristics characteristics;
    CameraCharacteristics cameraCharacteristics;
    public static File imageURL1;
    public static String imageName1;
    public static File imageURL2;
    public static String imageName2;
    public static int imageNumber = 1;
    Intent GalIntent;
    public static File thumbnailURL1;
    public static File thumbnailURL2;CameraCaptureSession.CaptureCallback previewSSession;

    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();

    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);
        ORIENTATIONS.append(Surface.ROTATION_90, 0);
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }

    private String cameraId;
    protected CameraDevice cameraDevice;
    protected CameraCaptureSession cameraCaptureSessions;
    protected CaptureRequest captureRequest;
    protected CaptureRequest.Builder captureRequestBuilder;
    private Size imageDimension;
    private ImageReader imageReader;
    private File file;
    private static final int REQUEST_CAMERA_PERMISSION = 200;
    private boolean mFlashSupported;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    Uri uri;
    Cursor c1 = null;
    private int count =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_camera_api);
        //    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        typeFace = Typeface.createFromAsset(getAssets(), "AvenirLTStd-Book.otf");

        //  setActionBar();
        textureView = (TextureView) findViewById(R.id.textureview);
        textureView.setSurfaceTextureListener(surfaceTextureListener);
        getpicture = (ImageView) findViewById(R.id.getpicture);
        //  getFromGallary = (ImageView) findViewById(R.id.getFromGallary);

      /*  final ContentResolver cr = getContentResolver();
        final String[] p1 = new String[] {
                MediaStore.Images.ImageColumns._ID,
                MediaStore.Images.ImageColumns.DATA
        };
        Cursor c1 = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, p1, null, null,
                p1[1] + " DESC");*/

    /*    final String[] imageColumns = {MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA};
        final String imageOrderBy = MediaStore.Images.Media._ID + " DESC";
        c1 = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, imageColumns, null, null, imageOrderBy);


        if (c1.moveToFirst()) {
            Log.i("testing", "last picture (" + c1.getInt(0) + ") taken on: " +
                    new Date(c1.getLong(1)));
            //   final ImageView imageView = (ImageView) findViewById(R.id.pictureView);
            String imageLocation = c1.getString(1);
            *//*String fullPath = c1.getString(c1.getColumnIndex(MediaStore.Images.Media.DATA));
            Log.i("testing", "last picture "+fullPath);*//*
            File imageFile = new File(imageLocation);
            if (imageFile.exists()) {
                Log.i("testing", "last picture exists");
                // TODO: is there a better way to do this?

                Bitmap bm = ImagePicker.getImageResized(AndroidCameraApi_pinchZoom.this, Uri.fromFile(new File(imageLocation)));
                int rotation = ImagePicker.getRotation(AndroidCameraApi_pinchZoom.this, Uri.fromFile(new File(imageLocation)), false);
                bm = ImagePicker.rotate(bm, rotation);
               *//* Bitmap bm = BitmapFactory.decodeFile(imageLocation);
                getFromGallary.setImageBitmap(bm);*//*

                getFromGallary.setImageBitmap(bm);
            }

        }

        c1.close();*/
        getpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPicture();
            }
        });

      /*  getFromGallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetImageFromGallery();
            }
        });*/
    }

    public void onDestroy() {
        super.onDestroy();
        if (c1 != null) {
            c1.close();
        }

    }

    public void GetImageFromGallery() {

        GalIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(Intent.createChooser(GalIntent, "Select Image From Gallery"), 2);

    }

    /*  @Override
      protected void onActivityResult(int requestCode, int resultCode, Intent data) {
          if (requestCode == 2) {

              if (data != null) {

                    *//*  if(imageNumber==count) {
                        Log.i("shrinika","111111"+data.getData());

                    bitmapOne = ImagePicker.getImageFromResult(this, resultCode, data);
                    uri = data.getData();
                    thumbnailURL1 = new File(uri.toString());

                    }*//*
                File internalStorage = new File(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DCIM), "YellowCards");
                if (!internalStorage.exists()) {
                    internalStorage.mkdir();
                }
                Random generator = new Random();
                int n = 100000;
                n = generator.nextInt(n);
                String fname = "Image-" + n;

                File reportFilePath = new File(internalStorage, fname + "_" + count + ".png");


                if (imageNumber == count) {
                    Log.i("shrinika", "111111" + data.getData());

                    bitmapOne = ImagePicker.getImageFromResult(this, resultCode, data);
                    uri = data.getData();

                    try {
                        FileOutputStream out = new FileOutputStream(reportFilePath);
                        bitmapOne.compress(Bitmap.CompressFormat.PNG, 100, out);
                        out.flush();
                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    thumbnailURL1 = reportFilePath;

                    // thumbnailURL1 =

                    // thumbnailURL1 = new File(uri.toString());
                   *//* thumbnailURL1.renameTo(thumbreportFilePath);
                    thumbnailURL1  = thumbnailURL1;*//*

                }

                Intent intent = new Intent();
                intent.setClass(AndroidCameraApi_pinchZoom.this, ShowPictureTakenActivity.class);
                startActivity(intent);
                finish();

                  *//*  Intent intent = new Intent(AndroidCameraApi.this, ShowPictureTakenActivity.class);
                    startActivityForResult(intent, 8);*//* //for update
            }
        }
        *//*if (requestCode == 8 && resultCode == RESULT_OK) {
            Log.i("vidisha","hello11111");
            setResult(resultCode, data);
            finish();
        }*//*
    }*/
    private float getFingerSpacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
            CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

            characteristics = manager.getCameraCharacteristics(cameraDevice.getId());
            maximumZoomLevel = characteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);

            Rect rect = characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            if (rect == null) return false;
            float currentFingerSpacing;
            Log.i("rtgs","5555555555555");
            if (event.getPointerCount() == 2) { //Multi touch.
                currentFingerSpacing = getFingerSpacing(event);
                float delta = 0.05f; //Control this value to control the zooming sensibility
                if (fingerSpacing != 0) {
                    Log.i("rtgs","333333333333");
                    if (currentFingerSpacing > fingerSpacing) { //Don't over zoom-in
                        if ((maximumZoomLevel - zoomLevel) <= delta) {
                            delta = maximumZoomLevel - zoomLevel;
                        }
                        zoomLevel = zoomLevel + delta;
                    } else if (currentFingerSpacing < fingerSpacing){ //Don't over zoom-out
                        if ((zoomLevel - delta) < 1f) {
                            delta = zoomLevel - 1f;
                        }
                        zoomLevel = zoomLevel - delta;
                    }
                    float ratio = (float) 1 / zoomLevel; //This ratio is the ratio of cropped Rect to Camera's original(Maximum) Rect
                    //croppedWidth and croppedHeight are the pixels cropped away, not pixels after cropped
                    int croppedWidth = rect.width() - Math.round((float)rect.width() * ratio);
                    int croppedHeight = rect.height() - Math.round((float)rect.height() * ratio);
                    //Finally, zoom represents the zoomed visible area
                    zoom = new Rect(croppedWidth/2, croppedHeight/2,
                            rect.width() - croppedWidth/2, rect.height() - croppedHeight/2);
                    previewBuilder.set(CaptureRequest.SCALER_CROP_REGION, zoom);
                }
                fingerSpacing = currentFingerSpacing;
            } else { //Single touch point, needs to return true in order to detect one more touch point
                return true;
            }

            Log.i("rtgs","rrrrrrrrrrrrrrrrrrrr");

            previewSession.setRepeatingRequest(previewBuilder.build(), previewSSession, null);
            return true;
        } catch (final Exception e) {
            //Error handling up to you
            Log.i("rtgs","44444444444444"+e);
            return true;
        }
    }
    void getPicture() {
        if (cameraDevice == null) {
            return;
        }
        CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            characteristics = manager.getCameraCharacteristics(cameraDevice.getId());

            if (characteristics != null) {
                jpegSizes = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP).getOutputSizes(ImageFormat.JPEG);
            }
            int width = 640, height = 480;
            if (jpegSizes != null && jpegSizes.length > 0) {
                width = jpegSizes[0].getWidth();
                height = jpegSizes[0].getHeight();
            }
            ImageReader reader = ImageReader.newInstance(width, height, ImageFormat.JPEG, 1);
            List<Surface> outputSurfaces = new ArrayList<Surface>(2);
            outputSurfaces.add(reader.getSurface());
            outputSurfaces.add(new Surface(textureView.getSurfaceTexture()));
            final CaptureRequest.Builder capturebuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
            capturebuilder.addTarget(reader.getSurface());
            //  capturebuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
            if (zoom != null) {
                capturebuilder.set(CaptureRequest.SCALER_CROP_REGION, zoom);
            }
            cameraCharacteristics = manager.getCameraCharacteristics("" + cameraDevice.getId());

            //   int[] flashModeValues = characteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
            //   Log.i("flash modes",""+characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE));


           /* List<String> flashModes = parameters.getSupportedFlashModes();
            if (flashModes.contains(Camera.Parameters.FLASH_MODE_AUTO))
            {
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_AUTO);
            }*/
            final int rotation = cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
            // final int rotation= getWindowManager().getDefaultDisplay().getRotation();
            Log.i("vidisha", "when" + rotation+"  "+CameraCharacteristics.SENSOR_ORIENTATION);
           /* captureBuilder.set(CaptureRequest.JPEG_ORIENTATION, rotation);
            int rotation= getWindowManager().getDefaultDisplay().getRotation();*/
            //  capturebuilder.set(CaptureRequest.JPEG_ORIENTATION, ORIENTATIONS.get(rotation));
            //  capturebuilder.set(CaptureRequest.FLASH_MODE, CaptureRequest.FLASH_MODE_TORCH);
            ImageReader.OnImageAvailableListener imageAvailableListener = new ImageReader.OnImageAvailableListener() {
                @Override
                public void onImageAvailable(ImageReader reader) {
                    Image image = null;
                    try {
                        image = reader.acquireLatestImage();
                        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
                        byte[] bytes = new byte[buffer.capacity()];
                        buffer.get(bytes);


                        File internalStorage = new File(Environment.getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_DCIM), "DamageAssistant");
                        if (!internalStorage.exists()) {
                            internalStorage.mkdir();
                        }
                        Random generator = new Random();
                        int n = 100000;
                        n = generator.nextInt(n);
                        String fname = "Image-" + n ;

                        File reportFilePath = new File(internalStorage, fname + ".png");
                        File thumbreportFilePath = new File(internalStorage, fname + "_thumb.png");

                        BitmapFactory.Options options = new BitmapFactory.Options();
                        ;

                        options.inPurgeable = true;
                        //   Bitmap original = BitmapFactory.decodeByteArray(bytes, 0, (bytes != null) ? bytes.length : 0);
                        //  Log.i("iRestore", "lenght====" + bytes.length / (1024 * 1024));
                      /*  Bitmap resized = Bitmap.createScaledBitmap(original, 1200, 1200, true);
                        ByteArrayOutputStream blob = new ByteArrayOutputStream();
                        resized.compress(Bitmap.CompressFormat.JPEG, 100, blob);
                        original.recycle();
                        resized.recycle();
                        byte[] desired = blob.toByteArray();
*/
                        // save(bytes);


                        if (imageNumber == 1) {

                            Bitmap b = BitmapFactory.decodeByteArray(bytes, 0, (bytes != null) ? bytes.length : 0);
                            Bitmap resizedBitmap = null;
                            int originalWidth = b.getWidth();
                            int originalHeight = b.getHeight();
                            int newWidth = -1;
                            int newHeight = -1;
                            float multFactor = -1.0F;
                            if(originalHeight > originalWidth) {
                                newHeight = 1200 ;
                                multFactor = (float) originalWidth/(float) originalHeight;
                                newWidth = (int) (newHeight*multFactor);
                            } else if(originalWidth > originalHeight) {
                                newWidth = 1200 ;
                                multFactor = (float) originalHeight/ (float)originalWidth;
                                newHeight = (int) (newWidth*multFactor);
                            } else if(originalHeight == originalWidth) {
                                newHeight = 1200 ;
                                newWidth = 1200 ;
                            }
                            resizedBitmap = Bitmap.createScaledBitmap(b, newWidth, newHeight, false);
                            int width = resizedBitmap.getWidth();
                            int height = resizedBitmap.getHeight();

                            // b = Bitmap.createScaledBitmap(b, width, height, false);
/*
                            int w1 = b.getWidth();
                            int h1 = b.getHeight();*/
                            // Setting post rotate to 90
                            Matrix mtx = new Matrix();
                            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)

                                mtx.postRotate(rotation);
                            else
                                mtx.postRotate(ORIENTATIONS.get(rotation));

                            // Rotating Bitmap
                            Utils.assetImage = Bitmap.createBitmap(resizedBitmap, 0, 0, width, height, mtx, false);
                            imageURL1 = reportFilePath;
                            thumbnailURL1 = thumbreportFilePath;
                            imageName1 = reportFilePath.getName();


                            ContentValues values = new ContentValues();

                            values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
                            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                            values.put(MediaStore.MediaColumns.DATA, thumbnailURL1.getPath());

                            AndroidCameraApi.this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                            FileOutputStream fosr;
                            File file = new File(imageURL1.getPath());
                            try {

                                fosr = new FileOutputStream(file);
                              /*  int screenWidth = getResources().getDisplayMetrics().widthPixels;
                                int screenHeight = getResources().getDisplayMetrics().heightPixels;
                                Bitmap b = Bitmap.createScaledBitmap(bitmapOne, screenWidth, screenHeight, false);*/
                                Utils.assetImage.compress(Bitmap.CompressFormat.JPEG, 100, fosr);

                                fosr.flush();
                                fosr.close();
                            } catch (Exception e) {

                            }

                            FileOutputStream fosr1;
                            File file1 = new File(thumbreportFilePath.getPath());

                            try {

                                fosr1 = new FileOutputStream(file1);


                                Bitmap resizedBitmap1 = null;
                                int originalWidth1 = Utils.assetImage.getWidth();
                                int originalHeight1 = Utils.assetImage.getHeight();
                                int newWidth1 = -1;
                                int newHeight1 = -1;
                                float multFactor1 = -1.0F;
                                if(originalHeight1 > originalWidth1) {
                                    newHeight1 = 150 ;
                                    multFactor1 = (float) originalWidth1/(float) originalHeight1;
                                    newWidth1 = (int) (newHeight1*multFactor1);
                                } else if(originalWidth1 > originalHeight1) {
                                    newWidth1 = 150 ;
                                    multFactor1 = (float) originalHeight1/ (float)originalWidth1;
                                    newHeight1 = (int) (newWidth1*multFactor1);
                                } else if(originalHeight1 == originalWidth1) {
                                    newHeight1 = 150 ;
                                    newWidth1 = 150 ;
                                }
                                resizedBitmap1 = Bitmap.createScaledBitmap(Utils.assetImage, newWidth, newHeight, false);


                               /* Bitmap b1 = Bitmap.createScaledBitmap(Utils.assetImage, 100, 100, false);
                                b1.compress(Bitmap.CompressFormat.JPEG,100, fosr1);

                                fosr1.flush();
                                fosr1.close();*/
                                resizedBitmap1.compress(Bitmap.CompressFormat.JPEG,100, fosr1);
                                fosr1.flush();
                                fosr1.close();
                                //   MediaStore.Images.Media.insertImage(getContentResolver(), b, "Screen", "screen");
                            }catch (FileNotFoundException e) {

                                e.printStackTrace();
                            } catch (Exception e) {

                                e.printStackTrace();
                            }


                        }

                        if (imageNumber == 2) {

                            Bitmap b = BitmapFactory.decodeByteArray(bytes, 0, (bytes != null) ? bytes.length : 0);
                            Bitmap resizedBitmap = null;
                            int originalWidth = b.getWidth();
                            int originalHeight = b.getHeight();
                            int newWidth = -1;
                            int newHeight = -1;
                            float multFactor = -1.0F;
                            if(originalHeight > originalWidth) {
                                newHeight = 1200 ;
                                multFactor = (float) originalWidth/(float) originalHeight;
                                newWidth = (int) (newHeight*multFactor);
                            } else if(originalWidth > originalHeight) {
                                newWidth = 1200 ;
                                multFactor = (float) originalHeight/ (float)originalWidth;
                                newHeight = (int) (newWidth*multFactor);
                            } else if(originalHeight == originalWidth) {
                                newHeight = 1200 ;
                                newWidth = 1200 ;
                            }
                            resizedBitmap = Bitmap.createScaledBitmap(b, newWidth, newHeight, false);
                            int width = resizedBitmap.getWidth();
                            int height = resizedBitmap.getHeight();

                            // b = Bitmap.createScaledBitmap(b, width, height, false);
/*
                            int w1 = b.getWidth();
                            int h1 = b.getHeight();*/
                            // Setting post rotate to 90
                            Matrix mtx = new Matrix();
                            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                                mtx.postRotate(rotation);
                            else
                                mtx.postRotate(ORIENTATIONS.get(rotation));
                            // Rotating Bitmap
                            Utils.assetImage1 = Bitmap.createBitmap(resizedBitmap, 0, 0, width, height, mtx, false);
                            imageURL2 = reportFilePath;
                            imageName2= reportFilePath.getName();


                            ContentValues values = new ContentValues();

                            values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
                            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                            values.put(MediaStore.MediaColumns.DATA, thumbnailURL1.getPath());

                            AndroidCameraApi.this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                            FileOutputStream fosr;
                            File file = new File(imageURL2.getPath());
                            try {

                                fosr = new FileOutputStream(file);
                              /*  int screenWidth = getResources().getDisplayMetrics().widthPixels;
                                int screenHeight = getResources().getDisplayMetrics().heightPixels;
                                Bitmap b = Bitmap.createScaledBitmap(bitmapOne, screenWidth, screenHeight, false);*/
                                Utils.assetImage1.compress(Bitmap.CompressFormat.JPEG, 100, fosr);

                                fosr.flush();
                                fosr.close();
                            } catch (Exception e) {

                            }

                        }


                        Intent intent = new Intent();
                        intent.setClass(AndroidCameraApi.this, ShowPictureTakenActivity.class);
                        startActivity(intent);
                        //  finish();//to finish the camera back activities


                    } catch (Exception ee) {
                    } finally {
                        if (image != null)
                            image.close();
                    }
                }

            };


            HandlerThread handlerThread = new HandlerThread("takepicture");
            handlerThread.start();
            final Handler handler = new Handler(handlerThread.getLooper());
            reader.setOnImageAvailableListener(imageAvailableListener, handler);

            previewSSession = new CameraCaptureSession.CaptureCallback() {
                @Override
                public void onCaptureStarted(CameraCaptureSession session, CaptureRequest request, long timestamp, long frameNumber) {
                    super.onCaptureStarted(session, request, timestamp, frameNumber);
                }

                @Override
                public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) {
                    super.onCaptureCompleted(session, request, result);
                    startCamera();
                }
            };
            cameraDevice.createCaptureSession(outputSurfaces, new CameraCaptureSession.StateCallback() {
                @Override
                public void onConfigured(CameraCaptureSession session) {
                    try {
                        session.capture(capturebuilder.build(), previewSSession, handler);
                    } catch (Exception e) {
                    }
                }

                @Override
                public void onConfigureFailed(CameraCaptureSession session) {
                }
            }, handler);
        } catch (Exception e) {
        }
    }

    public void openCamera() {
        CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            String camerId = manager.getCameraIdList()[0];
            characteristics = manager.getCameraCharacteristics(camerId);
            StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
           /* try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    manager.setTorchMode(camerId, true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            previewsize = map.getOutputSizes(SurfaceTexture.class)[0];
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            manager.openCamera(camerId, stateCallback, null);
        }catch (Exception e)
        {
        }
    }
    private TextureView.SurfaceTextureListener surfaceTextureListener=new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            openCamera();
        }
        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        }
        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            return false;
        }
        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        }
    };
    private CameraDevice.StateCallback stateCallback=new CameraDevice.StateCallback() {
        @Override
        public void onOpened(CameraDevice camera) {
            cameraDevice=camera;
            startCamera();
        }
        @Override
        public void onDisconnected(CameraDevice camera) {
        }
        @Override
        public void onError(CameraDevice camera, int error) {
        }
    };
    @Override
    protected void onPause() {
        super.onPause();
        if(cameraDevice!=null)
        {
            cameraDevice.close();
        }
    }
    void  startCamera()
    {
        if(cameraDevice==null||!textureView.isAvailable()|| previewsize==null)
        {
            return;
        }

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        final Matrix matrix = new Matrix();
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        RectF textureRectF = new RectF(0, 0, width, height);
        RectF previewRectF = new RectF(0, 0, textureView.getHeight(), textureView.getWidth());
        float centerX = textureRectF.centerX();
        float centerY = textureRectF.centerY();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            previewRectF.offset(centerX - previewRectF.centerX(), centerY - previewRectF.centerY());
            matrix.setRectToRect(textureRectF, previewRectF, Matrix.ScaleToFit.FILL);
            float scale = Math.max((float) width / textureView.getWidth(), (float) height / textureView.getHeight());
            matrix.postScale(scale, scale, centerX, centerY);
            matrix.postRotate(90 * (rotation - 2), centerX, centerY);
        }

        // textureView.setTransform(matrix);
        Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                // Any UI task, example
                textureView.setTransform(matrix);
            }
        };
        handler.sendEmptyMessage(1);
        SurfaceTexture texture=textureView.getSurfaceTexture();
        if(texture==null)
        {
            return;
        }
        texture.setDefaultBufferSize(previewsize.getWidth(),previewsize.getHeight());

        Surface surface=new Surface(texture);
        try
        {
            previewBuilder=cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
            //previewBuilder.set(CaptureRequest.FLASH_MODE, CaptureRequest.FLASH_MODE_OFF);//vidisha added
        }catch (Exception e)
        {
        }

        previewBuilder.addTarget(surface);
        try
        {
            cameraDevice.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() {
                @Override
                public void onConfigured(CameraCaptureSession session) {
                    previewSession=session;
                    getChangedPreview();
                }
                @Override
                public void onConfigureFailed(CameraCaptureSession session) {
                }
            },null);
        }catch (Exception e)
        {
        }
    }
    void getChangedPreview()
    {
        if(cameraDevice==null)
        {
            return;
        }
        previewBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
        HandlerThread thread=new HandlerThread("changed Preview");
        thread.start();
        Handler handler=new Handler(thread.getLooper());
        try
        {
            previewSession.setRepeatingRequest(previewBuilder.build(), null, handler);
        }catch (Exception e){}
    }

    private static File getOutputMediaFile() {
        File mediaStorageDir = new File(
                Environment
                        .getExternalStorageDirectory(),
                "DamageAssistant");
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }
        // Create a media file name
       /* String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());
        File mediaFile;
        mediaFile = new File(mediaStorageDir.getPath() + File.separator
                + "IMG_" + timeStamp + ".jpg");*/

        Random generator = new Random();
        int n = 100000;
        n = generator.nextInt(n);
        String fname = "Image-" + n ;

        File reportFilePath = new File(mediaStorageDir, fname + ".png");
        File thumbreportFilePath = new File(mediaStorageDir, fname + "_thumbnail.png");

        return reportFilePath;
    }
}