package io.bidmachine.iab.vast;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.internal.partials.BidMachineFilesBridge;
import com.safedk.android.internal.partials.BidMachineNetworkBridge;
import io.bidmachine.iab.CacheControl;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.measurer.MraidAdMeasurer;
import io.bidmachine.iab.measurer.VastAdMeasurer;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.iab.vast.activity.VastActivity;
import io.bidmachine.iab.vast.activity.VastView;
import io.bidmachine.iab.vast.processor.DefaultMediaPicker;
import io.bidmachine.iab.vast.processor.VastAd;
import io.bidmachine.iab.vast.processor.VastMediaPicker;
import io.bidmachine.iab.vast.processor.VastProcessor;
import io.bidmachine.iab.vast.processor.VastProcessorResult;
import io.bidmachine.iab.vast.tags.AppodealExtensionTag;
import io.bidmachine.iab.vast.tags.MediaFileTag;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes11.dex */
public class VastRequest {
    public static final String PARAMS_ERROR_CODE = "params_error_code";
    private Uri c;
    private VastAd d;
    private Bundle f;
    private VastMediaPicker g;
    private VastVideoLoadedListener h;
    private VastAdMeasurer i;
    private Float k;
    private float l;
    private boolean m;
    private int n;
    private boolean p;
    private static final VastUrlProcessorRegistry.OnUrlReadyCallback z = new k();
    private static int A = 5;
    private CacheControl b = CacheControl.FullLoad;
    private VideoType e = VideoType.NonRewarded;
    private float j = 3.0f;
    private int o = 0;
    private boolean q = false;
    private boolean r = true;
    private boolean s = true;
    private boolean t = false;
    private boolean u = false;
    private int v = -1;
    private float w = 5.0f;
    private final AtomicBoolean x = new AtomicBoolean(false);
    private final AtomicBoolean y = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12257a = UUID.randomUUID().toString();

    public class Builder {
        public Builder() {
        }

        public Builder addExtra(String key, String value) {
            VastRequest.this.addExtra(key, value);
            return this;
        }

        public VastRequest build() {
            return VastRequest.this;
        }

        public Builder forceUseNativeCloseTime(boolean forceUseNativeCloseTime) {
            VastRequest.this.m = forceUseNativeCloseTime;
            return this;
        }

        public Builder setAdMeasurer(VastAdMeasurer vastAdMeasurer) {
            VastRequest.this.i = vastAdMeasurer;
            return this;
        }

        public Builder setAutoClose(boolean autoClose) {
            VastRequest.this.p = autoClose;
            return this;
        }

        public Builder setCacheControl(CacheControl cacheControl) {
            VastRequest.this.b = cacheControl;
            return this;
        }

        public Builder setCompanionCloseTime(int closeTime) {
            VastRequest.this.l = closeTime;
            return this;
        }

        public Builder setMaxDuration(int maxDurationMillis) {
            VastRequest.this.n = maxDurationMillis;
            return this;
        }

        public Builder setMediaFilePicker(VastMediaPicker<MediaFileTag> mediaFilePicker) {
            VastRequest.this.g = mediaFilePicker;
            return this;
        }

        public Builder setPlaceholderTimeoutSec(float placeholderTimeoutSec) {
            VastRequest.this.j = placeholderTimeoutSec;
            return this;
        }

        public Builder setPreloadCompanion(boolean preload) {
            VastRequest.this.s = preload;
            return this;
        }

        public Builder setUseScreenSizeForCompanionOrientation(boolean use) {
            VastRequest.this.r = use;
            return this;
        }

        public Builder setUseScreenSizeForVideoOrientation(boolean use) {
            VastRequest.this.q = use;
            return this;
        }

        public Builder setVideoCloseTime(int closeTimeSec) {
            VastRequest.this.k = Float.valueOf(closeTimeSec);
            return this;
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12259a;

        static {
            int[] iArr = new int[CacheControl.values().length];
            f12259a = iArr;
            try {
                iArr[CacheControl.FullLoad.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12259a[CacheControl.Stream.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12259a[CacheControl.PartialLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12260a;
        final /* synthetic */ VastRequestListener b;
        final /* synthetic */ Context c;

        b(String str, VastRequestListener vastRequestListener, Context context) {
            this.f12260a = str;
            this.b = vastRequestListener;
            this.c = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new URL(this.f12260a).openStream()));
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String line = bufferedReader2.readLine();
                            if (line != null) {
                                stringBuffer.append(line).append(System.getProperty("line.separator"));
                            } else {
                                try {
                                    break;
                                } catch (IOException unused) {
                                }
                            }
                        }
                        bufferedReader2.close();
                        VastRequest.this.loadVideoWithData(this.c, stringBuffer.toString(), this.b);
                    } catch (Exception e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        VastLog.e("VastRequest", e);
                        VastRequest.this.sendVastSpecError(VastSpecError.XML_PARSING);
                        VastRequest.this.a(IabError.throwable("Exception during loading xml by url", e), this.b);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    class c extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f12261a;
        final /* synthetic */ String b;
        final /* synthetic */ VastRequestListener c;

        c(Context context, String str, VastRequestListener vastRequestListener) {
            this.f12261a = context;
            this.b = str;
            this.c = vastRequestListener;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            VastRequest.this.loadVideoWithDataSync(this.f12261a, this.b, this.c);
        }
    }

    class d extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f12262a;
        final /* synthetic */ VastRequestListener b;

        d(Context context, VastRequestListener vastRequestListener) {
            this.f12262a = context;
            this.b = vastRequestListener;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            VastRequest vastRequest = VastRequest.this;
            vastRequest.a(this.f12262a, vastRequest.d, this.b);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VastRequestListener f12263a;

        e(VastRequestListener vastRequestListener) {
            this.f12263a = vastRequestListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12263a.onVastLoaded(VastRequest.this);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IabError f12264a;
        final /* synthetic */ VastRequestListener b;

        f(IabError iabError, VastRequestListener vastRequestListener) {
            this.f12264a = iabError;
            this.b = vastRequestListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            VastRequestListener vastRequestListener;
            VastRequest vastRequest;
            IabError iabErrorExpired;
            if (VastRequest.this.i != null) {
                VastRequest.this.i.onError(this.f12264a);
            }
            if (this.b != null) {
                if (VastRequest.this.b == CacheControl.PartialLoad && VastRequest.this.x.get() && !VastRequest.this.y.get()) {
                    vastRequestListener = this.b;
                    vastRequest = VastRequest.this;
                    iabErrorExpired = IabError.expired(String.format("%s load failed after display - %s", vastRequest.b, this.f12264a));
                } else {
                    vastRequestListener = this.b;
                    vastRequest = VastRequest.this;
                    iabErrorExpired = this.f12264a;
                }
                vastRequestListener.onVastLoadFailed(vastRequest, iabErrorExpired);
            }
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VastActivityListener f12265a;
        final /* synthetic */ IabError b;

        g(VastActivityListener vastActivityListener, IabError iabError) {
            this.f12265a = vastActivityListener;
            this.b = iabError;
        }

        @Override // java.lang.Runnable
        public void run() {
            VastActivityListener vastActivityListener = this.f12265a;
            if (vastActivityListener != null) {
                vastActivityListener.onVastShowFailed(VastRequest.this, this.b);
            }
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VastViewListener f12266a;
        final /* synthetic */ VastView b;
        final /* synthetic */ IabError c;

        h(VastViewListener vastViewListener, VastView vastView, IabError iabError) {
            this.f12266a = vastViewListener;
            this.b = vastView;
            this.c = iabError;
        }

        @Override // java.lang.Runnable
        public void run() {
            VastViewListener vastViewListener = this.f12266a;
            if (vastViewListener != null) {
                vastViewListener.onShowFailed(this.b, VastRequest.this, this.c);
            }
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VastAd f12267a;

        i(VastAd vastAd) {
            this.f12267a = vastAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VastRequest.this.h != null) {
                VastRequest.this.h.onSuccess(VastRequest.this, this.f12267a);
            }
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IabError f12268a;

        j(IabError iabError) {
            this.f12268a = iabError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VastRequest.this.h != null) {
                VastRequest.this.h.onError(VastRequest.this, this.f12268a);
            }
        }
    }

    static class k implements VastUrlProcessorRegistry.OnUrlReadyCallback {
        k() {
        }

        @Override // io.bidmachine.iab.vast.VastUrlProcessorRegistry.OnUrlReadyCallback
        public void onUrlReady(String str) {
            VastLog.d("VastRequest", "Fire url: %s", str);
            Utils.simpleTrackUrl(str);
        }
    }

    static class l implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f12269a;
        public File b;

        public l(File file) {
            this.b = file;
            this.f12269a = file.lastModified();
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            long j = this.f12269a;
            long j2 = ((l) obj).f12269a;
            if (j > j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
    }

    private VastRequest() {
    }

    public static Builder newBuilder() {
        return new VastRequest().new Builder();
    }

    public static void setCacheSize(int cacheSize) {
        if (cacheSize > 0) {
            A = cacheSize;
        }
    }

    public void addExtra(String key, String value) {
        if (this.f == null) {
            this.f = new Bundle();
        }
        this.f.putString(key, value);
    }

    public boolean canDisplay() {
        return this.x.get() && (this.b != CacheControl.FullLoad || checkFile());
    }

    public boolean checkFile() {
        try {
            Uri uri = this.c;
            return (uri == null || TextUtils.isEmpty(uri.getPath()) || !new File(this.c.getPath()).exists()) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void destroy() {
        this.h = null;
        VastRequestManager.a(this);
    }

    public void display(Context context, VideoType videoType, VastActivityListener vastActivityListener) {
        display(context, videoType, vastActivityListener, null, null, null);
    }

    public void fireErrorUrls(List<String> urls, Bundle params) {
        fireUrls(urls, params);
    }

    public void fireUrls(List<String> urls, Bundle params) {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (params != null) {
            bundle.putAll(params);
        }
        if (urls != null) {
            VastUrlProcessorRegistry.processUrls(urls, bundle, z);
        } else {
            VastLog.d("VastRequest", "Url list is null", new Object[0]);
        }
    }

    public CacheControl getCacheControl() {
        return this.b;
    }

    public float getCompanionCloseTime() {
        return this.l;
    }

    public Uri getFileUri() {
        return this.c;
    }

    public int getForceOrientation() {
        return this.v;
    }

    public float getFusedVideoCloseTimeSec() {
        return this.w;
    }

    public String getId() {
        return this.f12257a;
    }

    public int getMaxDurationMillis() {
        return this.n;
    }

    public float getPlaceholderTimeoutSec() {
        return this.j;
    }

    public int getPreferredVideoOrientation() {
        if (!shouldUseScreenSizeForVideoOrientation()) {
            return 0;
        }
        VastAd vastAd = this.d;
        if (vastAd == null) {
            return 2;
        }
        MediaFileTag pickedMediaFileTag = vastAd.getPickedMediaFileTag();
        return Utils.orientationBySize(pickedMediaFileTag.getWidth(), pickedMediaFileTag.getHeight());
    }

    public int getRequestedOrientation() {
        return this.o;
    }

    public VastAd getVastAd() {
        return this.d;
    }

    public Float getVideoCloseTime() {
        return this.k;
    }

    public VideoType getVideoType() {
        return this.e;
    }

    public boolean isAutoClose() {
        return this.p;
    }

    public boolean isForceUseNativeCloseTime() {
        return this.m;
    }

    public boolean isR1() {
        return this.t;
    }

    public boolean isR2() {
        return this.u;
    }

    public void loadVideoWithData(final Context context, final String xmlData, final VastRequestListener vastRequestListener) {
        IabError iabErrorThrowable;
        VastLog.d("VastRequest", "loadVideoWithData\n%s", xmlData);
        this.d = null;
        if (Utils.isNetworkAvailable(context)) {
            try {
                new c(context, xmlData, vastRequestListener).start();
                return;
            } catch (Exception e2) {
                VastLog.e("VastRequest", e2);
                iabErrorThrowable = IabError.throwable("Exception during creating background thread", e2);
            }
        } else {
            iabErrorThrowable = IabError.NO_NETWORK;
        }
        a(iabErrorThrowable, vastRequestListener);
    }

    public void loadVideoWithDataSync(final Context context, final String xmlData, final VastRequestListener vastRequestListener) {
        String str;
        VastMediaPicker defaultMediaPicker = this.g;
        if (defaultMediaPicker == null) {
            defaultMediaPicker = new DefaultMediaPicker(context);
        }
        VastProcessorResult vastProcessorResultProcess = new VastProcessor(this, defaultMediaPicker).process(xmlData);
        VastAd vastAd = vastProcessorResultProcess.getVastAd();
        this.d = vastAd;
        if (vastAd == null) {
            VastSpecError vastSpecError = vastProcessorResultProcess.getVastSpecError();
            if (vastSpecError != null) {
                sendVastSpecError(vastSpecError);
                str = String.format("VastAd is null during loadVideoWithDataSync with VastSpecCode - %s", Integer.valueOf(vastSpecError.getCode()));
            } else {
                str = "VastAd is null during loadVideoWithDataSync without VastSpecCode";
            }
            a(IabError.badContent(str), vastRequestListener);
            return;
        }
        vastAd.setVastRequest(this);
        AppodealExtensionTag appodealExtension = this.d.getAppodealExtension();
        if (appodealExtension != null) {
            Boolean boolIsAutoRotate = appodealExtension.isAutoRotate();
            if (boolIsAutoRotate != null) {
                if (boolIsAutoRotate.booleanValue()) {
                    this.q = false;
                    this.r = false;
                } else {
                    this.q = true;
                    this.r = true;
                }
            }
            if (appodealExtension.getPostBannerTag().getCloseTimeSec() > 0.0f) {
                this.l = appodealExtension.getPostBannerTag().getCloseTimeSec();
            }
            this.t = appodealExtension.isR1();
            this.u = appodealExtension.isR2();
            Integer forceOrientation = appodealExtension.getForceOrientation();
            if (forceOrientation != null) {
                this.v = forceOrientation.intValue();
            }
        }
        this.w = a(this.d, appodealExtension).floatValue();
        VastAdMeasurer vastAdMeasurer = this.i;
        if (vastAdMeasurer != null) {
            vastAdMeasurer.onVastModelLoaded(this);
        }
        int i2 = a.f12259a[this.b.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                a(vastRequestListener);
                return;
            } else if (i2 != 3) {
                return;
            } else {
                a(vastRequestListener);
            }
        }
        a(context, this.d, vastRequestListener);
    }

    public void loadVideoWithUrl(final Context context, final String urlString, final VastRequestListener vastRequestListener) {
        IabError iabErrorThrowable;
        VastLog.d("VastRequest", "loadVideoWithUrl - %s", urlString);
        this.d = null;
        if (Utils.isNetworkAvailable(context)) {
            try {
                new b(urlString, vastRequestListener, context).start();
                return;
            } catch (Exception e2) {
                VastLog.e("VastRequest", e2);
                iabErrorThrowable = IabError.throwable("Exception during creating background thread", e2);
            }
        } else {
            iabErrorThrowable = IabError.NO_NETWORK;
        }
        a(iabErrorThrowable, vastRequestListener);
    }

    public void performCache(final Context context, final VastRequestListener vastRequestListener) {
        if (this.d == null) {
            a(IabError.internal("VastAd is null during performCache"), vastRequestListener);
            return;
        }
        try {
            new d(context, vastRequestListener).start();
        } catch (Exception e2) {
            VastLog.e("VastRequest", e2);
            a(IabError.throwable("Exception during creating background thread", e2), vastRequestListener);
        }
    }

    public void sendVastSpecError(VastSpecError vastSpecError) {
        VastLog.d("VastRequest", "sendVastSpecError - %s", vastSpecError);
        try {
            if (this.d != null) {
                Bundle bundle = new Bundle();
                bundle.putInt(PARAMS_ERROR_CODE, vastSpecError.getCode());
                fireErrorUrls(this.d.getErrorUrlList(), bundle);
            }
        } catch (Exception e2) {
            VastLog.e("VastRequest", e2);
        }
    }

    public synchronized void setVastVideoLoadedListener(VastVideoLoadedListener vastVideoLoadedListener) {
        this.h = vastVideoLoadedListener;
    }

    public boolean shouldPreloadCompanion() {
        return this.s;
    }

    public boolean shouldUseScreenSizeForCompanionOrientation() {
        return this.r;
    }

    public boolean shouldUseScreenSizeForVideoOrientation() {
        return this.q;
    }

    public void display(Context context, VideoType videoType, VastActivityListener vastActivityListener, VastView vastView, VastPlaybackListener vastPlaybackListener, MraidAdMeasurer postBannerAdMeasurer) {
        VastLog.d("VastRequest", "display", new Object[0]);
        this.y.set(true);
        if (this.d == null) {
            a(IabError.internal("VastAd is null during display VastActivity"), vastActivityListener);
            return;
        }
        this.e = videoType;
        this.o = context.getResources().getConfiguration().orientation;
        IabError iabErrorDisplay = new VastActivity.Builder().setRequest(this).setListener(vastActivityListener).setVastView(vastView).setPlaybackListener(vastPlaybackListener).setAdMeasurer(this.i).setPostBannerAdMeasurer(postBannerAdMeasurer).display(context);
        if (iabErrorDisplay != null) {
            a(iabErrorDisplay, vastActivityListener);
        }
    }

    public void display(VastView vastView) {
        this.y.set(true);
        if (this.d == null) {
            a(IabError.internal("VastAd is null during display VastView"), vastView, vastView.getListener());
            return;
        }
        this.e = VideoType.NonRewarded;
        VastRequestManager.store(this);
        vastView.display(this, Boolean.FALSE);
    }

    private String b(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir.getPath() + "/vast_rtb_cache/";
        }
        return null;
    }

    private Uri a(Context context, String str) throws IOException {
        String strB = b(context);
        if (strB == null) {
            throw new FileNotFoundException("No dir for caching file");
        }
        File file = new File(strB);
        if (!file.exists()) {
            file.mkdirs();
        }
        int length = 230 - file.getPath().length();
        String str2 = "temp" + System.currentTimeMillis();
        String strReplace = str.substring(0, Math.min(length, str.length())).replace(RemoteSettings.FORWARD_SLASH_STRING, "").replace(":", "");
        File file2 = new File(file, strReplace);
        if (file2.exists()) {
            return Uri.fromFile(file2);
        }
        File file3 = new File(file, str2);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        InputStream inputStreamUrlConnectionGetInputStream = BidMachineNetworkBridge.urlConnectionGetInputStream(httpURLConnection);
        FileOutputStream fileOutputStreamFileOutputStreamCtor = BidMachineFilesBridge.fileOutputStreamCtor(file3);
        long contentLength = httpURLConnection.getContentLength();
        byte[] bArr = new byte[1024];
        long j2 = 0;
        while (true) {
            int i2 = inputStreamUrlConnectionGetInputStream.read(bArr);
            if (i2 <= 0) {
                break;
            }
            fileOutputStreamFileOutputStreamCtor.write(bArr, 0, i2);
            j2 += (long) i2;
        }
        fileOutputStreamFileOutputStreamCtor.close();
        if (contentLength != j2) {
            throw new IllegalStateException("The downloaded file size does not match the stated size");
        }
        file3.renameTo(new File(file, strReplace));
        return Uri.fromFile(new File(file, strReplace));
    }

    private void a(Context context) {
        File[] fileArrListFiles;
        try {
            String strB = b(context);
            if (strB == null || (fileArrListFiles = new File(strB).listFiles()) == null || fileArrListFiles.length <= A) {
                return;
            }
            l[] lVarArr = new l[fileArrListFiles.length];
            for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                lVarArr[i2] = new l(fileArrListFiles[i2]);
            }
            Arrays.sort(lVarArr);
            for (int i3 = 0; i3 < fileArrListFiles.length; i3++) {
                fileArrListFiles[i3] = lVarArr[i3].b;
            }
            for (int i4 = A; i4 < fileArrListFiles.length; i4++) {
                if (!Uri.fromFile(fileArrListFiles[i4]).equals(this.c)) {
                    fileArrListFiles[i4].delete();
                }
            }
        } catch (Exception e2) {
            VastLog.e("VastRequest", e2);
        }
    }

    private Float a(VastAd vastAd, VastExtension vastExtension) {
        Float closeTimeSec = vastExtension != null ? vastExtension.getCloseTimeSec() : null;
        if (isForceUseNativeCloseTime()) {
            closeTimeSec = Utils.max(closeTimeSec, getVideoCloseTime());
        }
        Float fMin = Utils.min(closeTimeSec, vastAd.getDurationSec());
        return fMin == null ? Float.valueOf(5.0f) : fMin;
    }

    private synchronized void a(IabError iabError) {
        if (this.h == null) {
            return;
        }
        Utils.onUiThread(new j(iabError));
    }

    private synchronized void a(VastAd vastAd) {
        if (this.h == null) {
            return;
        }
        Utils.onUiThread(new i(vastAd));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, VastAd vastAd, VastRequestListener vastRequestListener) {
        String str;
        IabError iabErrorBadContent;
        try {
            Uri uriA = a(context, vastAd.getPickedMediaFileTag().getText());
            if (uriA != null && !TextUtils.isEmpty(uriA.getPath()) && new File(uriA.getPath()).exists()) {
                Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(uriA.getPath(), 1);
                if (bitmapCreateVideoThumbnail != null) {
                    if (!bitmapCreateVideoThumbnail.equals(Bitmap.createBitmap(bitmapCreateVideoThumbnail.getWidth(), bitmapCreateVideoThumbnail.getHeight(), bitmapCreateVideoThumbnail.getConfig()))) {
                        try {
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            mediaMetadataRetriever.setDataSource(context, uriA);
                            long j2 = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                            int i2 = this.n;
                            if (i2 == 0 || j2 <= i2) {
                                this.c = uriA;
                                a(vastAd);
                                a(vastRequestListener);
                            } else {
                                sendVastSpecError(VastSpecError.DURATION);
                                a(IabError.badContent("Estimated duration does not match actual duration"), vastRequestListener);
                            }
                        } catch (Exception e2) {
                            VastLog.e("VastRequest", e2);
                            sendVastSpecError(VastSpecError.BAD_FILE);
                            iabErrorBadContent = IabError.throwable("Exception during metadata retrieval", e2);
                            a(iabErrorBadContent, vastRequestListener);
                        }
                    } else {
                        VastLog.d("VastRequest", "Empty thumbnail", new Object[0]);
                        sendVastSpecError(VastSpecError.BAD_FILE);
                        str = "Thumbnail is empty";
                    }
                    a(context);
                    return;
                }
                VastLog.d("VastRequest", "Video file not supported", new Object[0]);
                sendVastSpecError(VastSpecError.BAD_FILE);
                str = "Failed to get thumbnail by file URI";
                iabErrorBadContent = IabError.badContent(str);
                a(iabErrorBadContent, vastRequestListener);
                a(context);
                return;
            }
            VastLog.d("VastRequest", "fileUri is null", new Object[0]);
            sendVastSpecError(VastSpecError.BAD_URI);
            a(IabError.badContent("Can't find video by local URI"), vastRequestListener);
        } catch (Exception e3) {
            VastLog.e("VastRequest", e3);
            sendVastSpecError(VastSpecError.BAD_URI);
            a(IabError.throwable("Exception during caching media file", e3), vastRequestListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IabError iabError, VastRequestListener vastRequestListener) {
        VastLog.d("VastRequest", "sendLoadFailed - %s", iabError);
        a(iabError);
        Utils.onUiThread(new f(iabError, vastRequestListener));
    }

    private void a(VastRequestListener vastRequestListener) {
        if (this.x.getAndSet(true)) {
            return;
        }
        VastLog.d("VastRequest", "sendLoaded", new Object[0]);
        if (vastRequestListener != null) {
            Utils.onUiThread(new e(vastRequestListener));
        }
    }

    private void a(IabError iabError, VastActivityListener vastActivityListener) {
        VastLog.d("VastRequest", "sendShowFailed - %s", iabError);
        Utils.onUiThread(new g(vastActivityListener, iabError));
    }

    private void a(IabError iabError, VastView vastView, VastViewListener vastViewListener) {
        VastLog.d("VastRequest", "sendShowFailed - %s", iabError);
        Utils.onUiThread(new h(vastViewListener, vastView, iabError));
    }
}
