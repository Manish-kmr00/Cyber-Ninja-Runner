package com.pubmatic.sdk.video.player;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.adjust.sdk.Constants;
import com.json.x8;
import com.pubmatic.sdk.common.POBAdSize;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.models.POBDeviceInfo;
import com.pubmatic.sdk.common.network.POBTrackerHandler;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.video.POBVastError;
import com.pubmatic.sdk.video.POBVastErrorHandler;
import com.pubmatic.sdk.video.POBVastPlayerConfig;
import com.pubmatic.sdk.video.POBVideoLogConstants;
import com.pubmatic.sdk.video.R;
import com.pubmatic.sdk.video.vastmodels.POBCompanion;
import com.pubmatic.sdk.video.vastmodels.POBIcon;
import com.pubmatic.sdk.video.vastmodels.POBLinear;
import com.pubmatic.sdk.video.vastmodels.POBMediaFile;
import com.pubmatic.sdk.video.vastmodels.POBTracking;
import com.pubmatic.sdk.video.vastmodels.POBVast;
import com.pubmatic.sdk.video.vastmodels.POBVastAd;
import com.pubmatic.sdk.video.vastmodels.POBVastCreative;
import com.pubmatic.sdk.video.vastparser.POBVastParser;
import com.pubmatic.sdk.video.vastparser.POBVastParserListener;
import com.pubmatic.sdk.video.xmlserialiser.POBXMLNodeListener;
import com.pubmatic.sdk.webrendering.POBUIUtil;
import com.pubmatic.sdk.webrendering.ui.POBCustomProductPageView;
import com.pubmatic.sdk.webrendering.ui.POBOnSkipOptionUpdateListener;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes6.dex */
public class POBVastPlayer extends FrameLayout implements POBVideoPlayerView.POBVideoPlayerListener, POBProgressiveEventListener {
    public static final int MEDIA_CONTROL_VISIBILITY_DELAY = 200;
    private POBCompanion A;
    private Queue B;
    private POBIconView C;
    private POBOnSkipOptionUpdateListener D;
    private POBEndCardRendering E;
    private String F;
    private boolean G;
    private final POBVastPlayerConfig H;
    private Linearity I;
    private final MutableContextWrapper J;
    private boolean K;
    private boolean L;
    private String M;
    private POBVastParserListener N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7825a;
    private Map b;
    private POBTrackerHandler c;
    private POBVastPlayerListener d;
    private int e;
    private POBAdSize f;
    private POBVideoPlayer g;
    private TextView h;
    private ImageButton i;
    private ImageButton j;
    private boolean k;
    private POBVastAd l;
    private String m;
    private boolean n;
    private boolean o;
    private POBVastError p;
    private boolean q;
    private POBMediaFile r;
    private final View.OnClickListener s;
    private double t;
    private long u;
    private List v;
    private TextView w;
    private POBVastErrorHandler x;
    private POBDeviceInfo y;
    private POBProgressiveEventHandler z;

    public enum Linearity {
        LINEAR,
        NON_LINEAR,
        ANY
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7827a;

        a(int i) {
            this.f7827a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (POBVastPlayer.this.i != null && POBVastPlayer.this.h != null && POBVastPlayer.this.G) {
                int i = this.f7827a / 1000;
                if (!POBVastPlayer.this.o) {
                    if (POBVastPlayer.this.t > i) {
                        POBVastPlayer.this.h.setText(String.valueOf(((int) POBVastPlayer.this.t) - i));
                    } else if (POBVastPlayer.this.t != POBVastPlayer.this.u) {
                        POBVastPlayer.this.i.setVisibility(0);
                        POBVastPlayer.this.o = true;
                        POBVastPlayer.this.h.setVisibility(8);
                        if (!POBVastPlayer.this.n) {
                            POBVastPlayer.this.a(true);
                        }
                    }
                }
            }
            if (POBVastPlayer.this.z != null) {
                POBVastPlayer.this.z.onProgress(this.f7827a / 1000);
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.pob_learn_more_btn) {
                POBVastPlayer.this.g();
                return;
            }
            if (id == com.pubmatic.sdk.common.R.id.pob_close_btn) {
                if (POBVastPlayer.this.g != null) {
                    if (POBVastPlayer.this.g.getPlayerState() != POBVideoPlayer.VideoPlayerState.ERROR) {
                        if (POBVastPlayer.this.d != null) {
                            POBVastPlayer.this.d.onSkip();
                            return;
                        }
                        return;
                    } else {
                        if (POBVastPlayer.this.d != null) {
                            POBVastPlayer.this.d.onClose();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (id != com.pubmatic.sdk.common.R.id.pob_forward_btn) {
                if (id != com.pubmatic.sdk.common.R.id.pob_custom_product_close_btn || POBVastPlayer.this.d == null) {
                    return;
                }
                POBVastPlayer.this.d.onClose();
                return;
            }
            POBVastPlayer.this.k();
            if (POBVastPlayer.this.g != null) {
                POBVastPlayer.this.g.stop();
                POBVastPlayer.this.c();
            }
        }
    }

    class c implements POBVastParserListener {
        c() {
        }

        @Override // com.pubmatic.sdk.video.vastparser.POBVastParserListener
        public void onFailure(POBVast pOBVast, POBVastError pOBVastError) {
            if (pOBVast == null || pOBVast.getAds() == null || pOBVast.getAds().isEmpty()) {
                POBVastPlayer.this.a((POBVastAd) null, pOBVastError);
            } else {
                POBVastPlayer.this.a(pOBVast.getAds().get(0), pOBVastError);
            }
        }

        @Override // com.pubmatic.sdk.video.vastparser.POBVastParserListener
        public void onSuccess(POBVast pOBVast) {
            if (pOBVast.getAds() == null || pOBVast.getAds().isEmpty()) {
                return;
            }
            POBVastPlayer.this.c(pOBVast.getAds().get(0));
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (POBVastPlayer.this.d != null) {
                POBVastPlayer.this.d.onDsaInfoIconClick();
            }
        }
    }

    class e implements POBOnSkipOptionUpdateListener {
        e() {
        }

        @Override // com.pubmatic.sdk.webrendering.ui.POBOnSkipOptionUpdateListener
        public void onSkipOptionUpdate(boolean z) {
            POBVastPlayer.this.a(z);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBIconView f7834a;
        final /* synthetic */ POBIcon b;

        h(POBIconView pOBIconView, POBIcon pOBIcon) {
            this.f7834a = pOBIconView;
            this.b = pOBIcon;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (POBVastPlayer.this.C != null) {
                POBVastPlayer.this.c(this.f7834a, this.b);
            }
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBIconView f7835a;

        i(POBIconView pOBIconView) {
            this.f7835a = pOBIconView;
        }

        @Override // java.lang.Runnable
        public void run() {
            POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_REMOVING_ICON, new Object[0]);
            POBVastPlayer.this.removeView(this.f7835a);
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (POBVastPlayer.this.M != null) {
                POBVastPlayer pOBVastPlayer = POBVastPlayer.this;
                pOBVastPlayer.a(pOBVastPlayer.M);
                POBVastPlayer.this.j();
            }
        }
    }

    protected POBVastPlayer(MutableContextWrapper mutableContextWrapper, POBVastPlayerConfig pOBVastPlayerConfig) {
        super(mutableContextWrapper);
        this.f7825a = 0;
        this.e = 3;
        this.k = false;
        this.n = false;
        this.o = false;
        this.q = true;
        this.s = new b();
        this.B = new LinkedList();
        this.G = true;
        this.I = Linearity.ANY;
        this.K = false;
        this.N = new c();
        this.J = mutableContextWrapper;
        POBTrackerHandler trackerHandler = POBInstanceProvider.getTrackerHandler(POBInstanceProvider.getNetworkHandler(mutableContextWrapper));
        this.c = trackerHandler;
        this.x = new POBVastErrorHandler(trackerHandler);
        this.H = pOBVastPlayerConfig;
        this.v = new ArrayList();
        this.b = Collections.synchronizedMap(new HashMap(4));
    }

    private int a(int i2) {
        return i2 == -1 ? 402 : 405;
    }

    public static POBVastPlayer createInstance(Context context, POBVastPlayerConfig pOBVastPlayerConfig) {
        return new POBVastPlayer(new MutableContextWrapper(context.getApplicationContext()), pOBVastPlayerConfig);
    }

    private Queue<POBCompanion> getCompanions() {
        LinkedList linkedList = new LinkedList();
        POBVastAd pOBVastAd = this.l;
        if (pOBVastAd != null) {
            List<POBCompanion> companions = pOBVastAd.getCompanions();
            if (this.K && companions != null && 2 == companions.size()) {
                linkedList.addAll(companions);
            } else {
                POBCompanion pOBCompanionA = a(this.l);
                if (pOBCompanionA != null) {
                    linkedList.add(pOBCompanionA);
                }
            }
        }
        return linkedList;
    }

    private Map<Object, Object> getVASTMacros() {
        this.b.put("[ADCOUNT]", String.valueOf(this.f7825a));
        this.b.put("[CACHEBUSTING]", Integer.valueOf(POBUtils.getRandomNumber(10000000, 99999999)));
        return this.b;
    }

    public void destroy() {
        POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_VAST_PLAYER_DESTROY, new Object[0]);
        if (!this.v.contains(POBVastAd.POBVastAdParameter.IMPRESSIONS.name()) && this.v.contains(POBVastCreative.POBEventTypes.LOADED.name())) {
            a(POBVastCreative.POBEventTypes.NOT_USED);
        } else if (this.G) {
            h();
        }
        POBVideoPlayer pOBVideoPlayer = this.g;
        if (pOBVideoPlayer != null) {
            pOBVideoPlayer.destroy();
        }
        POBEndCardRendering pOBEndCardRendering = this.E;
        if (pOBEndCardRendering != null) {
            pOBEndCardRendering.setListener(null);
        }
        POBIconView pOBIconView = this.C;
        if (pOBIconView != null) {
            pOBIconView.destroy();
            this.C = null;
        }
        removeAllViews();
        this.f7825a = 0;
        this.E = null;
        this.d = null;
        this.N = null;
        this.A = null;
        this.p = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    public void enableDsaInfoIcon(boolean z) {
        this.k = z;
    }

    public boolean getSkipabilityEnabled() {
        return this.G;
    }

    public POBVastPlayerConfig getVastPlayerConfig() {
        return this.H;
    }

    public void load(String str) {
        Trace.beginSection("POB Vast Parsing");
        POBVastParser pOBVastParser = new POBVastParser(POBInstanceProvider.getNetworkHandler(getContext().getApplicationContext()), this.e, this.N);
        pOBVastParser.setWrapperTimeout(this.H.getWrapperUriTimeout());
        pOBVastParser.parse(str);
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onBufferUpdate(int i2) {
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onClick() {
        g();
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onCompletion() {
        setOnClickListener(null);
        POBVastCreative.POBEventTypes pOBEventTypes = POBVastCreative.POBEventTypes.COMPLETE;
        a(pOBEventTypes);
        b(pOBEventTypes);
        POBVastPlayerListener pOBVastPlayerListener = this.d;
        if (pOBVastPlayerListener != null) {
            pOBVastPlayerListener.onPlaybackCompleted(this.u);
        }
        TextView textView = this.h;
        if (textView != null) {
            textView.setVisibility(8);
        }
        c();
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onFailure(int i2, String str) {
        a(this.l, new POBVastError(a(i2), str));
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            if (imageButton.getId() == com.pubmatic.sdk.common.R.id.pob_forward_btn || !this.i.isShown()) {
                TextView textView = this.h;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                POBUIUtil.updateSkipButtonToCloseButton(this.i);
                this.i.setVisibility(0);
                this.o = true;
                a(true);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onMute(boolean z) {
        if (z) {
            POBVastCreative.POBEventTypes pOBEventTypes = POBVastCreative.POBEventTypes.MUTE;
            a(pOBEventTypes);
            b(pOBEventTypes);
        } else {
            POBVastCreative.POBEventTypes pOBEventTypes2 = POBVastCreative.POBEventTypes.UNMUTE;
            a(pOBEventTypes2);
            b(pOBEventTypes2);
        }
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onPause() {
        POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_VAST_PLAYER_VIDEO_PLAYER_PAUSED, new Object[0]);
        POBVastCreative.POBEventTypes pOBEventTypes = POBVastCreative.POBEventTypes.PAUSE;
        a(pOBEventTypes);
        b(pOBEventTypes);
    }

    @Override // com.pubmatic.sdk.video.player.POBProgressiveEventListener
    public void onProgressReached(Map<POBVastCreative.POBEventTypes, List<String>> map) {
        for (Map.Entry<POBVastCreative.POBEventTypes, List<String>> entry : map.entrySet()) {
            POBVastCreative.POBEventTypes key = entry.getKey();
            POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_VAST_PLAYER_EXECUTE_TRACKER_EVENT, key.name());
            List<String> value = entry.getValue();
            b(key);
            if (value != null && this.l != null) {
                a(value);
                this.v.add(key.name());
            }
        }
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onProgressUpdate(int i2) {
        post(new a(i2));
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onReadyToPlay(POBVideoPlayerView pOBVideoPlayerView) {
        Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/video/player/POBVastPlayer;->onReadyToPlay(Lcom/pubmatic/sdk/video/player/POBVideoPlayerView;)V");
        CreativeInfoManager.onAdReadyToPlay(com.safedk.android.utils.h.F, this, pOBVideoPlayerView);
        safedk_POBVastPlayer_onReadyToPlay_4f2b32bbddb4b239cffa1137b721cd39(pOBVideoPlayerView);
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onResume() {
        POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_VAST_PLAYER_VIDEO_PLAYER_PLAY, new Object[0]);
        POBVastCreative.POBEventTypes pOBEventTypes = POBVastCreative.POBEventTypes.RESUME;
        a(pOBEventTypes);
        b(pOBEventTypes);
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onStart() {
        Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/video/player/POBVastPlayer;->onStart()V");
        CreativeInfoManager.onAdStarted(com.safedk.android.utils.h.F, this);
        safedk_POBVastPlayer_onStart_5a75b23c8260057e4a20d83a124f5b6f();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (30 == Build.VERSION.SDK_INT && i2 == 0) {
            bringToFront();
        }
    }

    public void pause() {
        POBVideoPlayer pOBVideoPlayer = this.g;
        if (pOBVideoPlayer == null || pOBVideoPlayer.getPlayerState() != POBVideoPlayer.VideoPlayerState.PLAYING || this.g.getPlayerState() == POBVideoPlayer.VideoPlayerState.STOPPED) {
            return;
        }
        this.g.pause();
    }

    public void play() {
        POBVideoPlayer pOBVideoPlayer = this.g;
        if (pOBVideoPlayer != null) {
            if ((pOBVideoPlayer.getPlayerState() != POBVideoPlayer.VideoPlayerState.PAUSED && this.g.getPlayerState() != POBVideoPlayer.VideoPlayerState.LOADED) || this.g.getPlayerState() == POBVideoPlayer.VideoPlayerState.STOPPED || this.g.getPlayerState() == POBVideoPlayer.VideoPlayerState.COMPLETE) {
                return;
            }
            this.g.play();
        }
    }

    public void safedk_POBVastPlayer_onReadyToPlay_4f2b32bbddb4b239cffa1137b721cd39(POBVideoPlayerView p0) {
        this.f7825a++;
        long mediaDuration = p0.getMediaDuration() / 1000;
        this.u = mediaDuration;
        if (this.G) {
            this.t = POBVastPlayerUtil.getSkipOffset(this.t, this.H, mediaDuration);
            POBLog.debug("POBVastPlayer", "Video skipOffset: " + this.t, new Object[0]);
        }
        POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_VAST_PLAYER_SKIP_OFFSET, Long.valueOf(this.u), Double.valueOf(this.t));
        Trace.endSection();
        POBVastPlayerListener pOBVastPlayerListener = this.d;
        if (pOBVastPlayerListener != null) {
            pOBVastPlayerListener.onReadyToPlay(this.l, (float) this.t);
        }
        a(POBVastCreative.POBEventTypes.LOADED);
        a(this.u);
        Queue<POBCompanion> companions = getCompanions();
        this.B = companions;
        if (companions.size() <= 1) {
            this.M = POBVastPlayerUtil.getCustomProductPageClickUrl(this.l, this.m);
        }
    }

    public void safedk_POBVastPlayer_onStart_5a75b23c8260057e4a20d83a124f5b6f() {
        POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_VAST_PLAYER_VIDEO_PLAYER_PLAY, new Object[0]);
        b(true);
        POBVastAd.POBVastAdParameter pOBVastAdParameter = POBVastAd.POBVastAdParameter.IMPRESSIONS;
        if (this.l != null) {
            POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_VAST_PLAYER_EXECUTE_TRACKER_EVENT, pOBVastAdParameter.name());
            a(this.l.getCombinedList(pOBVastAdParameter));
            this.v.add(pOBVastAdParameter.name());
            a(POBVastCreative.POBEventTypes.START);
            if (this.d != null && (this.l.getCreative() instanceof POBLinear)) {
                this.d.onVideoStarted(this.u, this.H.isPlayOnMute() ? 0.0f : 1.0f);
            }
            m();
        }
    }

    public void setAutoPlayOnForeground(boolean z) {
        POBVideoPlayer pOBVideoPlayer = this.g;
        if (pOBVideoPlayer != null) {
            pOBVideoPlayer.setAutoPlayOnForeground(z);
        }
    }

    public void setBaseContext(Context context) {
        this.J.setBaseContext(context);
    }

    public void setBidBundleId(String str) {
        this.m = str;
    }

    public void setDeviceInfo(POBDeviceInfo pOBDeviceInfo) {
        this.y = pOBDeviceInfo;
    }

    public void setEnableLearnMoreButton(boolean z) {
        this.q = z;
    }

    public void setEndCardSize(POBAdSize pOBAdSize) {
        this.f = pOBAdSize;
    }

    public void setFSCEnabled(boolean z) {
        this.L = z;
    }

    public void setLinearity(Linearity linearity) {
        this.I = linearity;
    }

    public void setMaxWrapperThreshold(int i2) {
        this.e = i2;
    }

    public void setOnSkipOptionUpdateListener(POBOnSkipOptionUpdateListener pOBOnSkipOptionUpdateListener) {
        this.D = pOBOnSkipOptionUpdateListener;
    }

    public void setPlacementType(String str) {
        this.F = str;
        this.K = "interstitial".equals(str);
    }

    public void setShowEndCardOnSkip(boolean z) {
        this.n = z;
    }

    public void setSkipabilityEnabled(boolean z) {
        this.G = z;
    }

    public void setVastPlayerListener(POBVastPlayerListener pOBVastPlayerListener) {
        this.d = pOBVastPlayerListener;
    }

    class f implements com.pubmatic.sdk.video.player.a {
        f() {
        }

        @Override // com.pubmatic.sdk.video.player.a
        public void a() {
            if (POBVastPlayer.this.A != null) {
                POBVastPlayer pOBVastPlayer = POBVastPlayer.this;
                pOBVastPlayer.a(pOBVastPlayer.A.getTrackingEventUrls(POBVastCreative.POBEventTypes.CREATIVE_VIEW));
            }
        }

        @Override // com.pubmatic.sdk.video.player.a
        public void b() {
            POBVastPlayer.this.g();
        }

        @Override // com.pubmatic.sdk.video.player.a
        public void c() {
            if (POBVastPlayer.this.A == null) {
                POBVastPlayer.this.g();
                return;
            }
            if (POBUtils.isNullOrEmpty(POBVastPlayer.this.A.getClickThroughURL())) {
                POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_END_CARD_NO_CLICK_THROUGH_URL, new Object[0]);
                POBVastPlayer pOBVastPlayer = POBVastPlayer.this;
                pOBVastPlayer.b(pOBVastPlayer.l);
            } else {
                POBVastPlayer pOBVastPlayer2 = POBVastPlayer.this;
                pOBVastPlayer2.a(pOBVastPlayer2.A.getClickThroughURL());
            }
            List<String> clickTrackers = POBVastPlayer.this.A.getClickTrackers();
            if (clickTrackers != null && !clickTrackers.isEmpty()) {
                POBVastPlayer.this.a(clickTrackers);
            } else {
                POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_END_CARD_NO_CLICK_TRACKERS, new Object[0]);
                POBVastPlayer.this.j();
            }
        }

        @Override // com.pubmatic.sdk.video.player.a
        public void d() {
            if (POBVastPlayer.this.E != null && !POBVastPlayer.this.B.isEmpty()) {
                POBVastPlayer.this.c();
                return;
            }
            POBVastPlayer.this.o();
            POBVastPlayer.this.a();
            if (POBVastPlayer.this.j != null) {
                POBVastPlayer.this.j.bringToFront();
            }
        }

        @Override // com.pubmatic.sdk.video.player.a
        public void onClose() {
            if (POBVastPlayer.this.d != null) {
                POBVastPlayer.this.d.onClose();
            }
        }

        @Override // com.pubmatic.sdk.video.player.a
        public void onEndCardWillLeaveApp() {
            POBVastPlayer.this.i();
        }

        @Override // com.pubmatic.sdk.video.player.a
        public void a(String str, boolean z) {
            List<String> clickTrackers;
            if (POBVastPlayer.this.A != null && (clickTrackers = POBVastPlayer.this.A.getClickTrackers()) != null) {
                POBVastPlayer.this.a(clickTrackers);
            }
            if (z) {
                POBVastPlayer.this.l();
            } else {
                POBVastPlayer.this.a(str);
            }
        }

        @Override // com.pubmatic.sdk.video.player.a
        public void a(POBVastError pOBVastError) {
            POBVastPlayer pOBVastPlayer = POBVastPlayer.this;
            pOBVastPlayer.a(pOBVastPlayer.l, pOBVastError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(POBVastAd pOBVastAd) {
        POBVastError pOBVastError;
        Linearity linearity;
        POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_VAST_PLAYER_RENDERING_STARTED, new Object[0]);
        this.l = pOBVastAd;
        this.b.put("[ADSERVINGID]", pOBVastAd.getAdServingId());
        this.b.put("[PODSEQUENCE]", String.valueOf(this.l.getAdSequence()));
        this.v = new ArrayList();
        POBVastCreative creative = pOBVastAd.getCreative();
        if (creative == null) {
            pOBVastError = new POBVastError(400, POBVideoLogConstants.MSG_VAST_PLAYER_NO_CREATIVE);
        } else if (creative.getVastCreativeType() == POBVastCreative.CreativeType.LINEAR && ((linearity = this.I) == Linearity.LINEAR || linearity == Linearity.ANY)) {
            a((POBLinear) creative);
            pOBVastError = null;
        } else {
            pOBVastError = new POBVastError(201, POBVideoLogConstants.MSG_VAST_PLAYER_LINEARITY_NOT_FOUND);
        }
        if (pOBVastError != null) {
            a(this.l, pOBVastError);
        }
    }

    private void d() {
        if (this.n) {
            this.i = POBUIUtil.createSkipButton(getContext(), com.pubmatic.sdk.common.R.id.pob_forward_btn, com.pubmatic.sdk.webrendering.R.drawable.pob_ic_forward_24);
        } else {
            this.i = POBUIUtil.createSkipButton(getContext(), com.pubmatic.sdk.common.R.id.pob_close_btn, com.pubmatic.sdk.common.R.drawable.pob_ic_close_black_24dp);
        }
        this.i.setVisibility(8);
        this.o = false;
        this.i.setOnClickListener(this.s);
        addView(this.i);
    }

    private void e() {
        TextView textViewCreateSkipDurationTextView = POBUIUtil.createSkipDurationTextView(getContext(), com.pubmatic.sdk.webrendering.R.id.pob_skip_duration_timer);
        this.h = textViewCreateSkipDurationTextView;
        addView(textViewCreateSkipDurationTextView, POBUIUtil.getLayoutParamsForTopRightPosition(getContext()));
    }

    private void f() {
        if (this.G) {
            e();
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        b(this.l);
        j();
    }

    private void h() {
        POBVideoPlayer pOBVideoPlayer;
        List list = this.v;
        POBVastCreative.POBEventTypes pOBEventTypes = POBVastCreative.POBEventTypes.CLOSE_LINEAR;
        if (list.contains(pOBEventTypes.name())) {
            return;
        }
        List list2 = this.v;
        POBVastCreative.POBEventTypes pOBEventTypes2 = POBVastCreative.POBEventTypes.CLOSE;
        if (list2.contains(pOBEventTypes2.name()) || this.l == null || (pOBVideoPlayer = this.g) == null) {
            return;
        }
        if (!this.n && pOBVideoPlayer.getPlayerState() != POBVideoPlayer.VideoPlayerState.COMPLETE) {
            k();
        }
        if (this.l.getCombinedTrackingEventList(pOBEventTypes).isEmpty()) {
            a(pOBEventTypes2);
        } else {
            a(pOBEventTypes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        POBVastPlayerListener pOBVastPlayerListener = this.d;
        if (pOBVastPlayerListener != null) {
            pOBVastPlayerListener.onEndCardWillLeaveApp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.l != null) {
            POBVastAd.POBVastAdParameter pOBVastAdParameter = POBVastAd.POBVastAdParameter.CLICKTRACKING;
            POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_VAST_PLAYER_EXECUTE_TRACKER_EVENT, pOBVastAdParameter.name());
            List<String> combinedList = this.l.getCombinedList(pOBVastAdParameter);
            if (combinedList.isEmpty()) {
                POBLog.debug("POBVastPlayer", POBVideoLogConstants.EMPTY_TRACKER_URL_LIST_LOG, new Object[0]);
            } else {
                a(combinedList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        POBVastCreative.POBEventTypes pOBEventTypes = POBVastCreative.POBEventTypes.SKIP;
        b(pOBEventTypes);
        a(pOBEventTypes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        POBVastPlayerListener pOBVastPlayerListener = this.d;
        if (pOBVastPlayerListener != null) {
            pOBVastPlayerListener.shouldForwardClickEvent();
        }
    }

    private void m() {
        POBVastAd pOBVastAd = this.l;
        if (pOBVastAd != null) {
            a(pOBVastAd.getClosestIcon());
        }
    }

    private boolean n() {
        return this.B.size() > 1 || !POBUtils.isNullOrEmpty(this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        POBCustomProductPageView pOBCustomProductPageView = new POBCustomProductPageView(this.J.getBaseContext());
        pOBCustomProductPageView.setInstallButtonClickListener(new j());
        addView(pOBCustomProductPageView);
    }

    private void p() {
        POBVideoPlayer pOBVideoPlayer = this.g;
        if (pOBVideoPlayer != null) {
            pOBVideoPlayer.setPrepareTimeout(this.H.getMediaUriTimeout());
            this.g.playOnMute(this.H.isPlayOnMute());
        }
    }

    class g implements POBVastHTMLView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBIcon f7833a;

        g(POBIcon pOBIcon) {
            this.f7833a = pOBIcon;
        }

        @Override // com.pubmatic.sdk.video.player.POBVastHTMLView.b
        public void a() {
            POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_ICON_LOADED, new Object[0]);
            if (POBVastPlayer.this.C != null) {
                POBVastPlayer pOBVastPlayer = POBVastPlayer.this;
                pOBVastPlayer.b(pOBVastPlayer.C, this.f7833a);
            }
        }

        @Override // com.pubmatic.sdk.video.player.POBVastHTMLView.b
        public void a(String str) {
            POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_ICON_CLICKED, new Object[0]);
            List<String> clickTrackers = this.f7833a.getClickTrackers();
            if (clickTrackers != null) {
                POBVastPlayer.this.a(clickTrackers);
            }
            POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_ICON_OPEN_LANDING_PAGE, str);
            if (POBVastPlayer.this.d != null) {
                POBVastPlayer.this.d.onIndustryIconClick(str);
            }
        }

        @Override // com.pubmatic.sdk.video.player.POBVastHTMLView.b
        public void a(POBVastError pOBVastError) {
            POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_ICON_RENDERING_FAILURE, new Object[0]);
        }
    }

    private void b(POBVastCreative.POBEventTypes pOBEventTypes) {
        POBVastPlayerListener pOBVastPlayerListener = this.d;
        if (pOBVastPlayerListener != null) {
            pOBVastPlayerListener.onVideoEventOccurred(pOBEventTypes);
        }
    }

    private void b() {
        ImageButton imageButtonCreateDsaInfoIconButton = POBUIUtil.createDsaInfoIconButton(this.J, com.pubmatic.sdk.common.R.id.pob_dsa_info_btn, com.pubmatic.sdk.common.R.drawable.pob_dsa_info_icon, this.K, false);
        this.j = imageButtonCreateDsaInfoIconButton;
        imageButtonCreateDsaInfoIconButton.setOnClickListener(new d());
        addView(this.j);
    }

    private void a(POBVastCreative.POBEventTypes pOBEventTypes) {
        if (this.l != null) {
            POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_VAST_PLAYER_EXECUTE_TRACKER_EVENT, pOBEventTypes.name());
            a(this.l.getCombinedTrackingEventList(pOBEventTypes));
            this.v.add(pOBEventTypes.name());
            return;
        }
        POBLog.debug("POBVastPlayer", "Selected Vast Ad is null", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List list) {
        this.c.sendTrackers(POBTrackerHandler.sanitizeURLScheme((List<String>) list, POBInstanceProvider.getSdkConfig().isRequestSecureCreative()), getVASTMacros());
    }

    private void a(POBLinear pOBLinear) {
        POBVastError pOBVastError;
        List<POBMediaFile> mediaFiles = pOBLinear.getMediaFiles();
        if (mediaFiles != null && !mediaFiles.isEmpty()) {
            this.t = pOBLinear.getSkipOffset();
            boolean zIsWiFiConnected = POBInstanceProvider.getNetworkMonitor(getContext().getApplicationContext()).isWiFiConnected();
            int scaleFactor = POBVastPlayerUtil.getScaleFactor(getContext().getApplicationContext());
            int bitRate = POBVastPlayerUtil.getBitRate(scaleFactor == 1, zIsWiFiConnected);
            POBLog.info("POBVastPlayer", POBVideoLogConstants.MSG_EXPECTED_BIT_RATE, scaleFactor == 1 ? "low" : Constants.HIGH, zIsWiFiConnected ? x8.b : "non-wifi", Integer.valueOf(bitRate));
            POBVideoPlayer.SupportedMediaType[] supportedMediaTypeArr = POBVideoPlayer.SUPPORTED_MEDIA_TYPE;
            POBDeviceInfo pOBDeviceInfo = this.y;
            POBMediaFile pOBMediaFileFilterMediaFiles = POBVastPlayerUtil.filterMediaFiles(mediaFiles, supportedMediaTypeArr, bitRate, pOBDeviceInfo.screenWidth, pOBDeviceInfo.screenHeight);
            this.r = pOBMediaFileFilterMediaFiles;
            if (pOBMediaFileFilterMediaFiles != null) {
                POBLog.info("POBVastPlayer", POBVideoLogConstants.MSG_SELECTED_MEDIAL_FILE, pOBMediaFileFilterMediaFiles.toString(), mediaFiles.toString(), Integer.valueOf(bitRate), this.r.getWidth() + VastAttributes.HORIZONTAL_POSITION + this.r.getHeight(), Arrays.toString(supportedMediaTypeArr));
                String mediaFileURL = this.r.getMediaFileURL();
                POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_VAST_SELECTED_MEDIA_FILE, mediaFileURL);
                this.g = a(getContext());
                p();
                f();
                if (this.k) {
                    b();
                }
                if (mediaFileURL != null) {
                    Trace.endSection();
                    Trace.beginSection("POB Rendering");
                    this.g.load(mediaFileURL);
                    pOBVastError = null;
                } else {
                    pOBVastError = new POBVastError(403, POBVideoLogConstants.MSG_VAST_PLAYER_LINEAR_MEDIA_NOT_SUPPORTED);
                }
                b(false);
            } else {
                pOBVastError = new POBVastError(403, POBVideoLogConstants.MSG_VAST_PLAYER_LINEAR_MEDIA_NOT_SUPPORTED);
            }
        } else {
            pOBVastError = new POBVastError(401, POBVideoLogConstants.MSG_VAST_PLAYER_LINEAR_MEDIA_NOT_FOUND);
        }
        if (pOBVastError != null) {
            a(this.l, pOBVastError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(POBVastAd pOBVastAd) {
        if (pOBVastAd != null) {
            a(pOBVastAd.getClosestClickThroughURL());
        }
    }

    private void b(boolean z) {
        POBVideoPlayer pOBVideoPlayer = this.g;
        if (pOBVideoPlayer != null) {
            POBPlayerController controllerView = pOBVideoPlayer.getControllerView();
            if (controllerView != null) {
                if (z) {
                    com.pubmatic.sdk.video.player.b.b(controllerView, 200);
                } else {
                    com.pubmatic.sdk.video.player.b.a(controllerView, 200);
                }
            }
            TextView textView = this.w;
            if (textView != null) {
                if (z) {
                    com.pubmatic.sdk.video.player.b.b(textView, 200);
                } else {
                    com.pubmatic.sdk.video.player.b.a(textView, 200);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        POBVastError pOBVastError;
        POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_RENDERING_END_CARD, new Object[0]);
        if ("interstitial".equals(this.F)) {
            POBMraidEndCardView pOBMraidEndCardView = new POBMraidEndCardView(this.J.getBaseContext(), n());
            this.E = pOBMraidEndCardView;
            pOBMraidEndCardView.setFSCEnabled(this.L);
            this.E.setSkipAfter(this.H.getEndCardSkipAfter());
            this.E.setOnSkipOptionUpdateListener(new e());
        } else {
            POBEndCardView pOBEndCardView = new POBEndCardView(getContext());
            this.E = pOBEndCardView;
            pOBEndCardView.setFSCEnabled(this.L);
        }
        this.E.setLearnMoreTitle(POBUIUtil.getLocalizedStringForKey(getContext(), "openwrap_learn_more_title", "Learn More"));
        this.E.setListener(new f());
        if (this.l != null) {
            if (this.B.isEmpty() && (pOBVastError = this.p) != null) {
                a(this.l, pOBVastError);
            }
            POBCompanion pOBCompanion = (POBCompanion) this.B.poll();
            this.A = pOBCompanion;
            if (pOBCompanion != null) {
                POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_RENDERING_COMPANION_END_CARD, pOBCompanion);
            }
            this.E.render(this.A);
            addView(this.E.getView());
            b(false);
            ImageButton imageButton = this.i;
            if (imageButton != null) {
                removeView(imageButton);
            }
            ImageButton imageButton2 = this.j;
            if (imageButton2 != null) {
                a(imageButton2);
                this.j.bringToFront();
            }
            POBIconView pOBIconView = this.C;
            if (pOBIconView != null) {
                a(pOBIconView);
                this.C.bringToFront();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(POBIconView pOBIconView, POBIcon pOBIcon) {
        new Handler().postDelayed(new h(pOBIconView, pOBIcon), ((long) pOBIcon.getOffset()) * 1000);
    }

    private POBVideoPlayerView a(Context context) {
        POBVideoPlayerView pOBVideoPlayerView = new POBVideoPlayerView(context);
        pOBVideoPlayerView.setListener(this);
        pOBVideoPlayerView.setFSCEnabled(this.L);
        POBPlayerController pOBVideoPlayerController = new POBVideoPlayerController(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 80;
        pOBVideoPlayerView.setControllerView(pOBVideoPlayerController, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        addView(pOBVideoPlayerView, layoutParams2);
        a(pOBVideoPlayerView);
        return pOBVideoPlayerView;
    }

    private void a(POBVideoPlayerView pOBVideoPlayerView) {
        if (this.q) {
            TextView textViewA = com.pubmatic.sdk.video.player.b.a(getContext(), R.id.pob_learn_more_btn, POBUIUtil.getLocalizedStringForKey(getContext(), "openwrap_learn_more_title", "Learn More"), getResources().getColor(com.pubmatic.sdk.webrendering.R.color.pob_controls_background_color));
            this.w = textViewA;
            textViewA.setOnClickListener(this.s);
            pOBVideoPlayerView.addView(this.w);
        }
    }

    private void a(long j2) {
        this.z = new POBProgressiveEventHandler(this);
        a(((int) (25 * j2)) / 100, POBVastCreative.POBEventTypes.FIRST_QUARTILE);
        a(((int) (50 * j2)) / 100, POBVastCreative.POBEventTypes.MID_POINT);
        a(((int) (75 * j2)) / 100, POBVastCreative.POBEventTypes.THIRD_QUARTILE);
        POBVastAd pOBVastAd = this.l;
        if (pOBVastAd != null) {
            for (POBXMLNodeListener pOBXMLNodeListener : pOBVastAd.getCombinedObjectList(POBVastAd.POBVastAdParameter.PROGRESS_TRACKING_EVENT)) {
                if (pOBXMLNodeListener instanceof POBTracking) {
                    POBTracking pOBTracking = (POBTracking) pOBXMLNodeListener;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(pOBTracking.getUrl());
                    this.z.addProgressUrls(Integer.valueOf((int) POBUtils.convertToSeconds(String.valueOf(j2), pOBTracking.getOffset())), POBVastCreative.POBEventTypes.PROGRESS, arrayList);
                }
            }
        }
    }

    private void a(int i2, POBVastCreative.POBEventTypes pOBEventTypes) {
        POBVastAd pOBVastAd = this.l;
        if (pOBVastAd == null || this.z == null) {
            return;
        }
        this.z.addProgressUrls(Integer.valueOf(i2), pOBEventTypes, pOBVastAd.getCombinedTrackingEventList(pOBEventTypes));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(POBVastAd pOBVastAd, POBVastError pOBVastError) {
        if (pOBVastAd != null) {
            this.x.executeVastErrorsWithMacros(pOBVastAd.getCombinedList(POBVastAd.POBVastAdParameter.ERRORS), getVASTMacros(), pOBVastError, POBVastPlayerUtil.generateErrorQueryParams(getContext(), this.y, this.r));
        } else {
            this.x.executeVastErrors(null, pOBVastError);
        }
        Trace.endSection();
        POBError pOBErrorConvertToPOBError = POBVastErrorHandler.convertToPOBError(pOBVastError);
        if (pOBErrorConvertToPOBError != null) {
            a(pOBErrorConvertToPOBError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        POBOnSkipOptionUpdateListener pOBOnSkipOptionUpdateListener = this.D;
        if (pOBOnSkipOptionUpdateListener != null) {
            pOBOnSkipOptionUpdateListener.onSkipOptionUpdate(z);
        }
    }

    private void a(POBError pOBError) {
        POBLog.error("POBVastPlayer", pOBError.toString(), new Object[0]);
        POBVastPlayerListener pOBVastPlayerListener = this.d;
        if (pOBVastPlayerListener != null) {
            pOBVastPlayerListener.onFailedToPlay(pOBError);
        }
    }

    private void a(View view) {
        if (!this.K || view.getLayoutParams() == null) {
            return;
        }
        ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = 80;
    }

    private POBCompanion a(POBVastAd pOBVastAd) {
        List<POBCompanion> combinedCompanions = pOBVastAd.getCombinedCompanions();
        if (combinedCompanions != null && !combinedCompanions.isEmpty()) {
            float width = getWidth();
            float height = getHeight();
            POBAdSize pOBAdSize = this.f;
            if (pOBAdSize != null) {
                width = POBUtils.convertDpToPixelWithFloatPrecession(pOBAdSize.getAdWidth());
                height = POBUtils.convertDpToPixelWithFloatPrecession(this.f.getAdHeight());
            }
            POBCompanion suitableEndCardCompanion = POBVastPlayerUtil.getSuitableEndCardCompanion(combinedCompanions, width, height);
            if (suitableEndCardCompanion == null) {
                this.p = new POBVastError(601, POBVideoLogConstants.MSG_NO_MATCHING_END_CARD_FOUND);
                return suitableEndCardCompanion;
            }
            POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_SELECTED_END_CARD + suitableEndCardCompanion, new Object[0]);
            return suitableEndCardCompanion;
        }
        this.p = new POBVastError(603, POBVideoLogConstants.MSG_NO_END_CARD);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        POBVastPlayerListener pOBVastPlayerListener = this.d;
        if (pOBVastPlayerListener != null) {
            pOBVastPlayerListener.onOpenLandingPage(str);
        }
    }

    private void a(POBIcon pOBIcon) {
        if (pOBIcon != null && pOBIcon.getResource() != null && pOBIcon.getOffset() <= this.u && !POBUtils.isNullOrEmpty(pOBIcon.getResource().getResource())) {
            POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_RENDERING_ICON, pOBIcon.getProgram(), Integer.valueOf(pOBIcon.getOffset()), Integer.valueOf(pOBIcon.getDuration()));
            POBIconView pOBIconView = new POBIconView(getContext());
            this.C = pOBIconView;
            pOBIconView.setId(R.id.pob_industry_icon_one);
            this.C.setListener(new g(pOBIcon));
            this.C.a(pOBIcon);
            return;
        }
        POBLog.debug("POBVastPlayer", POBVideoLogConstants.MSG_ICON_UNAVAILABLE_RESOURCE, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(POBIconView pOBIconView, POBIcon pOBIcon) {
        long duration = ((long) pOBIcon.getDuration()) * 1000;
        if (duration > 0) {
            new Handler().postDelayed(new i(pOBIconView), duration);
        }
        a(pOBIconView, pOBIcon);
        List<String> viewTrackers = pOBIcon.getViewTrackers();
        if (viewTrackers != null) {
            a(viewTrackers);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            POBUIUtil.updateSkipButtonToCloseButton(imageButton);
            this.i.setId(com.pubmatic.sdk.common.R.id.pob_custom_product_close_btn);
            addView(this.i);
            this.i.setVisibility(0);
            this.i.bringToFront();
        }
    }

    private void a(POBIconView pOBIconView, POBIcon pOBIcon) {
        addView(pOBIconView, com.pubmatic.sdk.video.player.b.a(getContext(), pOBIcon.getContentWidth(), pOBIcon.getContentHeight(), this.j, this.K));
    }
}
