package net.pubnative.lite.sdk.mraid.nativefeature;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.internal.partials.VerveFilesBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import net.pubnative.lite.sdk.mraid.internal.MRAIDLog;
import net.pubnative.lite.sdk.mraid.internal.MRAIDNativeFeatureManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MRAIDNativeFeatureProvider {
    public static final String ACTION_HANDLE_CUSTOM_EVENT = "android.provider.calendar.action.HANDLE_CUSTOM_EVENT";
    public static final String AUTHORITY = "com.android.calendar";
    public static final String DESCRIPTION = "description";
    public static final String DISPLAY_COLOR = "displayColor";
    public static final String EVENT_COLOR = "eventColor";
    public static final String EVENT_COLOR_KEY = "eventColor_index";
    public static final String EVENT_LOCATION = "eventLocation";
    public static final String EXTRA_CUSTOM_APP_URI = "customAppUri";
    public static final String EXTRA_EVENT_ALL_DAY = "allDay";
    public static final String EXTRA_EVENT_BEGIN_TIME = "beginTime";
    public static final String EXTRA_EVENT_END_TIME = "endTime";
    public static final String STATUS = "eventStatus";
    private static final String TAG = "MRAIDNativeFeatureProvider";
    public static final String TITLE = "title";
    private final Context context;
    private final MRAIDNativeFeatureManager nativeFeatureManager;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.C);
        p0.startActivity(p1);
    }

    public MRAIDNativeFeatureProvider(Context context, MRAIDNativeFeatureManager mRAIDNativeFeatureManager) {
        this.context = context;
        this.nativeFeatureManager = mRAIDNativeFeatureManager;
    }

    public final void callTel(String str) {
        if (this.nativeFeatureManager.isTelSupported()) {
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.context, new Intent("android.intent.action.DIAL", Uri.parse(str)));
        }
    }

    public void createCalendarEvent(String str) {
        if (this.nativeFeatureManager.isCalendarSupported()) {
            try {
                JSONObject jSONObject = new JSONObject(str.replace("\\", "").replace("\"{", "{").replace("}\"", "}"));
                String strOptString = jSONObject.optString("description", "Untitled");
                String strOptString2 = jSONObject.optString("location", "unknown");
                String strOptString3 = jSONObject.optString("summary");
                int i = 2;
                String[] strArr = {"yyyy-MM-dd'T'HH:mmZ", "yyyy-MM-dd'T'HH:mm:ssZ"};
                String[] strArr2 = new String[2];
                strArr2[0] = jSONObject.getString("start");
                strArr2[1] = jSONObject.optString("end");
                int i2 = 0;
                long time = 0;
                long time2 = 0;
                while (i2 < i) {
                    if (!TextUtils.isEmpty(strArr2[i2])) {
                        strArr2[i2] = strArr2[i2].replaceAll("([+-]\\d\\d):(\\d\\d)$", "$1$2");
                        int i3 = 0;
                        while (i3 < i) {
                            try {
                                Date date = new SimpleDateFormat(strArr[i3], Locale.US).parse(strArr2[i2]);
                                if (date != null) {
                                    if (i2 == 0) {
                                        time = date.getTime();
                                        break;
                                    } else {
                                        time2 = date.getTime();
                                        break;
                                    }
                                }
                                break;
                            } catch (ParseException unused) {
                                i3++;
                                i = 2;
                            }
                        }
                    }
                    i2++;
                    i = 2;
                }
                Intent type = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
                type.putExtra("title", strOptString);
                type.putExtra("description", strOptString3);
                type.putExtra(EVENT_LOCATION, strOptString2);
                if (time > 0) {
                    type.putExtra(EXTRA_EVENT_BEGIN_TIME, time);
                }
                if (time2 > 0) {
                    type.putExtra("endTime", time2);
                }
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.context, type);
            } catch (JSONException e) {
                MRAIDLog.e(TAG, "Error parsing JSON: " + e.getLocalizedMessage());
            }
        }
    }

    public void playVideo(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(str), "video/*");
        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.context, intent);
    }

    public void openBrowser(String str) {
        if (str.startsWith("market:")) {
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.context, new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } else if (str.startsWith("http:") || str.startsWith("https:")) {
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.context, new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }

    public void storePicture(final String str) {
        if (this.nativeFeatureManager.isStorePictureSupported()) {
            new Thread(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.nativefeature.MRAIDNativeFeatureProvider$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9704xb1d58248(str);
                }
            }).start();
        }
    }

    /* JADX INFO: renamed from: lambda$storePicture$0$net-pubnative-lite-sdk-mraid-nativefeature-MRAIDNativeFeatureProvider, reason: not valid java name */
    /* synthetic */ void m9704xb1d58248(String str) {
        try {
            storePictureInGallery(str);
        } catch (Exception e) {
            MRAIDLog.e(TAG, e.getLocalizedMessage());
        }
    }

    public void sendSms(String str) {
        if (this.nativeFeatureManager.isSmsSupported()) {
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.context, new Intent("android.intent.action.SENDTO", Uri.parse(str)));
        }
    }

    private void storePictureInGallery(String str) {
        String str2 = getAlbumDir() + "/img" + new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date()) + ".png";
        String str3 = TAG;
        MRAIDLog.i(str3, "Saving image into: " + str2);
        File file = new File(str2);
        try {
            copyStream(new URL(str).openStream(), VerveFilesBridge.fileOutputStreamCtor(file));
            MediaScannerConnection.scanFile(this.context, new String[]{file.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: net.pubnative.lite.sdk.mraid.nativefeature.MRAIDNativeFeatureProvider$$ExternalSyntheticLambda1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str4, Uri uri) {
                    MRAIDLog.d("File saves successfully to " + str4);
                }
            });
            MRAIDLog.i(str3, "Saved image successfully");
        } catch (MalformedURLException e) {
            MRAIDLog.e(TAG, "Not able to save image due to invalid URL: " + e.getLocalizedMessage());
        } catch (IOException e2) {
            MRAIDLog.e(TAG, "Unable to save image: " + e2.getLocalizedMessage());
        }
    }

    private void copyStream(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr, 0, 1024);
                if (i == -1) {
                    return;
                } else {
                    outputStream.write(bArr, 0, i);
                }
            }
        } catch (Exception e) {
            MRAIDLog.i(TAG, "Error saving picture: " + e.getLocalizedMessage());
        }
    }

    private File getAlbumDir() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Image");
            if (file.mkdirs() || file.exists()) {
                return file;
            }
            MRAIDLog.i(TAG, "Failed to create camera directory");
            return null;
        }
        MRAIDLog.i(TAG, "External storage is not mounted READ/WRITE.");
        return null;
    }
}
