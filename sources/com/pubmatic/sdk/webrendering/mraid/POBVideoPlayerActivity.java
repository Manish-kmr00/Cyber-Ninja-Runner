package com.pubmatic.sdk.webrendering.mraid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;
import com.pubmatic.sdk.common.R;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.webrendering.POBUIUtil;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.PubMaticVideoBridge;
import com.safedk.android.utils.Logger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class POBVideoPlayerActivity extends Activity {
    public static final String ACTION_FINISH = "com.pubmatic.sdk.webrendering.mraid.POBVideoPlayerActivity.finish";
    public static final String ALLOW_ORIENTATION_KEY = "AllowOrientationChange";
    public static final String FORCE_ORIENTATION_KEY = "ForceOrientation";
    public static final String MSG_VIDEO_PLAYER_EMPTY_URL = "Can't launch video player due to null or empty value of URL";
    private static List g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediaController f7911a;
    private VideoView b;
    private int c;
    private boolean d;
    private BroadcastReceiver e;
    private int f;

    public interface POBVideoPlayerActivityListener {
        void onDismiss();

        void onStart();
    }

    protected class POBVideoPlayerBroadcast extends BroadcastReceiver {
        protected POBVideoPlayerBroadcast() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !POBVideoPlayerActivity.ACTION_FINISH.equals(intent.getAction())) {
                return;
            }
            POBVideoPlayerActivity.this.finish();
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            POBVideoPlayerActivity.this.finish();
        }
    }

    class b implements MediaPlayer.OnCompletionListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/webrendering/mraid/POBVideoPlayerActivity$b;->onCompletion(Landroid/media/MediaPlayer;)V");
            CreativeInfoManager.onVideoCompleted(com.safedk.android.utils.h.F, mediaPlayer, "media-player");
            safedk_POBVideoPlayerActivity$b_onCompletion_ccb4de6b0c7b67256c3ac7a53123a614(mediaPlayer);
        }

        public void safedk_POBVideoPlayerActivity$b_onCompletion_ccb4de6b0c7b67256c3ac7a53123a614(MediaPlayer p0) {
            POBVideoPlayerActivity.this.d = true;
        }
    }

    private void b() {
        List<POBVideoPlayerActivityListener> list = g;
        if (list != null) {
            for (POBVideoPlayerActivityListener pOBVideoPlayerActivityListener : list) {
                if (this.f == pOBVideoPlayerActivityListener.hashCode()) {
                    pOBVideoPlayerActivityListener.onDismiss();
                    a(pOBVideoPlayerActivityListener);
                    return;
                }
            }
        }
    }

    private void c() {
        List<POBVideoPlayerActivityListener> list = g;
        if (list != null) {
            for (POBVideoPlayerActivityListener pOBVideoPlayerActivityListener : list) {
                if (this.f == pOBVideoPlayerActivityListener.hashCode()) {
                    pOBVideoPlayerActivityListener.onStart();
                    return;
                }
            }
        }
    }

    private void d() {
        VideoView videoView = this.b;
        if (videoView == null) {
            POBLog.debug("POBVideoPlayerActivity", "Unable to pause video, VideoView not available.", new Object[0]);
            return;
        }
        videoView.pause();
        this.c = this.b.getCurrentPosition();
        POBLog.debug("POBVideoPlayerActivity", "VideoView visibility is false. Seeked position =" + this.c, new Object[0]);
    }

    private void e() {
        if (this.d) {
            POBLog.debug("POBVideoPlayerActivity", "Video Ad is completed", new Object[0]);
            return;
        }
        VideoView videoView = this.b;
        if (videoView == null) {
            POBLog.debug("POBVideoPlayerActivity", "Unable to resume video, VideoView not available.", new Object[0]);
        } else if (videoView.isPlaying()) {
            this.b.seekTo(this.c);
        } else {
            POBLog.debug("POBVideoPlayerActivity", "VideoView visibility is false. Seeked position =" + this.c, new Object[0]);
        }
    }

    public static void safedk_POBUtils_startActivity_77a045103a3f673fe5e6fdc8c1e6b82c(Context p0, Intent p1) throws Exception {
        Logger.d("SafeDK-Special|SafeDK: Call> Lcom/pubmatic/sdk/common/utility/POBUtils;->startActivity(Landroid/content/Context;Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.F);
        POBUtils.startActivity(p0, p1);
    }

    public static void startNewActivity(Context context, String str, Bundle bundle, POBVideoPlayerActivityListener pOBVideoPlayerActivityListener) {
        if (g == null) {
            g = new ArrayList();
        }
        g.add(pOBVideoPlayerActivityListener);
        Intent intent = new Intent(context, (Class<?>) POBVideoPlayerActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("URL", str);
        intent.putExtra("listener_hash_code", pOBVideoPlayerActivityListener.hashCode());
        intent.putExtra("bundle_extra", bundle);
        try {
            safedk_POBUtils_startActivity_77a045103a3f673fe5e6fdc8c1e6b82c(context, intent);
        } catch (Exception e) {
            POBLog.warn("POBVideoPlayerActivity", "Error in starting video player activity. Error: %s", e.getMessage());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(com.safedk.android.utils.h.F, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String string;
        boolean z;
        super.onCreate(bundle);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("URL");
        if (POBUtils.isNullOrEmpty(stringExtra)) {
            POBLog.error("POBVideoPlayerActivity", MSG_VIDEO_PLAYER_EMPTY_URL, new Object[0]);
            finish();
        }
        Bundle bundleExtra = intent.getBundleExtra("bundle_extra");
        if (bundleExtra != null) {
            string = bundleExtra.getString("ForceOrientation");
            z = bundleExtra.getBoolean(ALLOW_ORIENTATION_KEY, true);
        } else {
            string = null;
            z = true;
        }
        if (!z) {
            if (string == null) {
                string = "none";
            }
            string.hashCode();
            switch (string) {
                case "sensor_landscape":
                    setRequestedOrientation(6);
                    break;
                case "reverse_portrait":
                    setRequestedOrientation(7);
                    break;
                case "portrait":
                    setRequestedOrientation(1);
                    break;
                case "landscape":
                    setRequestedOrientation(0);
                    break;
            }
        }
        View viewA = a(a(stringExtra), -1, -1);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            POBUtils.setSystemFitWindowsForEdgeToEdge(viewA, getWindow());
        }
        setContentView(viewA);
        POBVideoPlayerBroadcast pOBVideoPlayerBroadcast = new POBVideoPlayerBroadcast();
        this.e = pOBVideoPlayerBroadcast;
        try {
            if (i >= 33) {
                registerReceiver(pOBVideoPlayerBroadcast, new IntentFilter(ACTION_FINISH), 4);
            } else {
                registerReceiver(pOBVideoPlayerBroadcast, new IntentFilter(ACTION_FINISH));
            }
        } catch (Exception e) {
            POBLog.warn("POBVideoPlayerActivity", "Error in registering broadcast receiver. Error: %s", e.getMessage());
        }
        this.f = getIntent().getIntExtra("listener_hash_code", 0);
        c();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        a();
        try {
            unregisterReceiver(this.e);
        } catch (Exception e) {
            POBLog.warn("POBVideoPlayerActivity", "Error in unregistering broadcast receiver. Error: %s", e.getMessage());
        }
        this.e = null;
        b();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        d();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        e();
    }

    private void a(POBVideoPlayerActivityListener pOBVideoPlayerActivityListener) {
        List list = g;
        if (list != null) {
            list.remove(pOBVideoPlayerActivityListener);
            if (g.isEmpty()) {
                g = null;
            }
        }
    }

    private void a() {
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.suspend();
        }
        this.b = null;
        this.f7911a = null;
    }

    private View a(View view, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, 0, 0, 0);
        if (view != null) {
            frameLayout.addView(view, layoutParams);
        }
        ImageButton imageButtonCreateSkipButton = POBUIUtil.createSkipButton(this, R.id.pob_close_btn, com.pubmatic.sdk.webrendering.R.drawable.pob_ic_close_black_24dp);
        frameLayout.addView(imageButtonCreateSkipButton);
        imageButtonCreateSkipButton.setOnClickListener(new a());
        return frameLayout;
    }

    private View a(String str) {
        this.b = new VideoView(this);
        if (this.f7911a == null) {
            MediaController mediaController = new MediaController(this);
            this.f7911a = mediaController;
            mediaController.setMediaPlayer(this.b);
        }
        this.b.setMediaController(this.f7911a);
        this.f7911a.setAnchorView(this.b);
        this.b.setOnCompletionListener(new b());
        PubMaticVideoBridge.VideoViewSetVideoUri(this.b, Uri.parse(str));
        PubMaticVideoBridge.VideoViewPlay(this.b);
        return this.b;
    }
}
