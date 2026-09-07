package com.bytedance.sdk.openadsdk.core.Wx.Og;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.ZZv.SD;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.lT;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.omh.WQf;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class JG extends com.bytedance.sdk.openadsdk.core.ML.KZx implements com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA, TV.pA, KZx.pA {
    private static final Integer Sd = 0;
    private static final Integer TX = 1;
    private String BF;
    protected boolean BSW;
    private final AtomicBoolean Bf;
    protected ImageView Bzk;
    private ViewTreeObserver.OnGlobalLayoutListener CIG;
    public Og DX;
    private final Runnable FQ;
    private boolean Gx;
    private final ViewTreeObserver.OnScrollChangedListener HSv;
    private final Handler IG;
    public SD JG;
    protected FrameLayout KZx;
    public boolean ML;
    private final boolean Mc;
    protected com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx Og;
    protected RelativeLayout SD;
    protected ImageView SGo;
    boolean Sn;
    private final AtomicBoolean SzT;
    private boolean TV;
    private com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx Vgu;
    private boolean WQf;
    protected String WV;
    protected int Wx;
    private boolean XT;
    protected boolean ZZv;
    private ViewGroup aBv;
    private boolean du;
    private boolean eG;
    private View gbA;
    private boolean lT;
    private final Context oX;
    protected ImageView omh;
    protected final yFO pA;
    private final String qmB;
    private long rB;
    private long roi;
    private String vZF;
    private boolean xy;
    private boolean yFO;

    public interface Og {
        void pA(boolean z, long j, long j2, long j3, boolean z2);
    }

    public interface pA {
        void pA(View view, int i);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
    public void Og(long j, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void setAdCreativeClickListener(pA pAVar) {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
        if (kZx != null) {
            ((KZx) kZx).pA(pAVar);
        }
    }

    public void setVideoPlayCallback(com.bytedance.sdk.openadsdk.core.Wx.Og.Og og) {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
        if (kZx != null) {
            ((KZx) kZx).pA(og);
        }
    }

    public void setControllerStatusCallBack(Og og) {
        this.DX = og;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
    public void pA(long j, int i) {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx interfaceC0160KZx = this.Vgu;
        if (interfaceC0160KZx != null) {
            interfaceC0160KZx.i_();
        }
    }

    private void ZZv() {
        pA(0L, 0);
        this.Vgu = null;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
    public void pA() {
        new Object[]{"embeded_ad", "onTimeOut、、、、、、、、"};
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA
    public void pA(long j, long j2) {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx interfaceC0160KZx = this.Vgu;
        if (interfaceC0160KZx != null) {
            interfaceC0160KZx.pA(j, j2);
        }
    }

    public JG(Context context, yFO yfo, boolean z, SD sd) {
        this(context, yfo, z, "embeded_ad", false, false, sd);
    }

    public JG(Context context, yFO yfo, String str, boolean z, boolean z2, SD sd) {
        this(context, yfo, false, str, z, z2, sd);
    }

    public JG(Context context, yFO yfo, SD sd) {
        this(context, yfo, false, sd);
    }

    public JG(Context context, yFO yfo, boolean z, String str, boolean z2, boolean z3, SD sd) {
        super(context);
        this.XT = true;
        this.ZZv = true;
        this.yFO = false;
        this.ML = false;
        this.WQf = true;
        this.TV = false;
        this.du = true;
        this.BSW = true;
        this.WV = "embeded_ad";
        this.Wx = 50;
        this.eG = true;
        this.Mc = false;
        this.IG = new TV(Sn.Og().getLooper(), this);
        this.xy = false;
        this.qmB = Build.MODEL;
        this.Sn = false;
        this.SzT = new AtomicBoolean(false);
        this.FQ = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.JG.4
            @Override // java.lang.Runnable
            public void run() {
                JG jg = JG.this;
                jg.pA(jg.lT, JG.Sd.intValue());
            }
        };
        this.Gx = true;
        this.Bf = new AtomicBoolean(false);
        this.HSv = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.JG.6
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                JG.this.aBv();
            }
        };
        try {
            if (yfo.rX()) {
                this.BF = CacheDirFactory.getICacheDir(0).Og();
            }
        } catch (Throwable unused) {
        }
        if (sd != null) {
            this.JG = sd;
        }
        this.WV = str;
        this.oX = context;
        this.pA = yfo;
        this.yFO = z;
        setContentDescription("NativeVideoTsView");
        this.TV = z2;
        this.du = z3;
        Og();
        ML();
    }

    protected void Og() {
        yFO yfo = this.pA;
        if (yfo == null) {
            return;
        }
        int iWf = yfo.Wf();
        int iOg = aBv.ZZv().Og(iWf);
        int iKZx = DX.KZx(aBv.pA());
        if (iOg == 1) {
            this.XT = gbA.ZZv(iKZx);
        } else if (iOg == 2) {
            this.XT = gbA.ML(iKZx) || gbA.ZZv(iKZx) || gbA.JG(iKZx);
        } else if (iOg == 3) {
            this.XT = false;
        } else if (iOg == 4) {
            this.Sn = true;
        } else if (iOg == 5) {
            this.XT = gbA.ZZv(iKZx) || gbA.JG(iKZx);
        }
        if (!this.yFO) {
            if (!this.ML || !WQf.Og(this.WV)) {
                this.ZZv = aBv.ZZv().KZx(String.valueOf(iWf));
            }
        } else {
            this.ZZv = false;
        }
        if ("open_ad".equals(this.WV)) {
            this.XT = true;
            this.ZZv = true;
        }
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
        if (kZx != null) {
            kZx.ZZv(this.XT);
        }
        this.ML = true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Og og;
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx;
        if (!this.yFO && (og = this.DX) != null && (kZx = this.Og) != null) {
            og.pA(kZx.DX(), this.Og.omh(), this.Og.Bzk(), this.Og.ML(), this.XT);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private View pA(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        new FrameLayout.LayoutParams(-1, -1).gravity = 17;
        frameLayout.setVisibility(8);
        this.aBv = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams);
        frameLayout.addView(frameLayout2);
        this.KZx = frameLayout2;
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(view);
        this.gbA = view;
        return frameLayout;
    }

    private RelativeLayout Og(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.SD sd = new com.bytedance.sdk.openadsdk.core.ML.SD(context);
        sd.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        sd.setVisibility(8);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        zZv.setLayoutParams(layoutParams);
        zZv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.omh = zZv;
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv2 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        zZv2.setLayoutParams(layoutParams2);
        zZv2.setVisibility(8);
        zZv2.setBackground(com.bytedance.sdk.component.utils.yFO.KZx(context, "tt_new_play_video"));
        this.SGo = zZv2;
        sd.addView(zZv);
        sd.addView(zZv2);
        return sd;
    }

    private void ML() {
        addView(pA(this.oX));
        XT();
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.JG.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                JG.this.aBv();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                JG.this.aBv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBv() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Handler handler = this.IG;
        if (handler == null || jElapsedRealtime - this.rB <= 500) {
            return;
        }
        this.rB = jElapsedRealtime;
        handler.sendEmptyMessageDelayed(1, 500L);
    }

    public void setVideoAdClickListenerTTNativeAd(PAGNativeAd pAGNativeAd) {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
        if (kZx != null) {
            ((KZx) kZx).pA(pAGNativeAd);
        }
    }

    public void SD() {
        View view;
        if (this.oX == null || (view = this.gbA) == null || view.getParent() == null || this.pA == null || this.SD != null) {
            return;
        }
        ViewParent parent = this.gbA.getParent();
        RelativeLayout relativeLayoutOg = Og(this.oX);
        if (parent != null && (parent instanceof ViewGroup)) {
            pA(relativeLayoutOg, (ViewGroup) parent, this.gbA);
        }
        this.SD = relativeLayoutOg;
        if (this.BSW) {
            Vgu.pA((View) this.SGo, 0);
        }
        if (this.pA.Bf() != null && this.pA.Bf().SGo() != null) {
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.pA.Bf().SGo(), this.pA.Bf().KZx(), this.pA.Bf().Og(), this.omh, this.pA);
        }
        ImageView imageView = this.SGo;
        if (imageView != null) {
            imageView.setClickable(true);
            this.SGo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.JG.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/Wx/Og/JG$2;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view2);
                    safedk_JG$2_onClick_dcfb109509c2af0a480fe2a8e5e14a53(view2);
                }

                public void safedk_JG$2_onClick_dcfb109509c2af0a480fe2a8e5e14a53(View p0) {
                    JG.this.KZx();
                }
            });
        }
    }

    private void pA(View view, ViewGroup viewGroup, View view2) {
        int iIndexOfChild = viewGroup.indexOfChild(view2);
        viewGroup.removeViewInLayout(view2);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    private void XT() {
        this.Og = new KZx(this.oX, this.KZx, this.pA, this.WV, !lT(), this.TV, this.du, this.JG);
        yFO();
        if (this.CIG == null) {
            this.CIG = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.JG.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (JG.this.aBv == null || JG.this.aBv.getViewTreeObserver() == null || JG.this.Og == null) {
                        return;
                    }
                    ((KZx) JG.this.Og).pA(JG.this.aBv.getWidth(), JG.this.aBv.getHeight());
                    JG.this.aBv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    JG.this.CIG = null;
                }
            };
            this.aBv.getViewTreeObserver().addOnGlobalLayoutListener(this.CIG);
        }
    }

    public void setVideoAdLoadListener(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.ZZv zZv) {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
        if (kZx != null) {
            kZx.pA(zZv);
        }
    }

    public boolean pA(long j, boolean z, boolean z2) {
        boolean zPA = false;
        this.aBv.setVisibility(0);
        this.roi = j;
        if (!lT()) {
            return true;
        }
        this.Og.pA(false);
        yFO yfo = this.pA;
        if (yfo != null && yfo.Bf() != null) {
            com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = yFO.pA(CacheDirFactory.getICacheDir(this.pA.FK()).KZx(), this.pA);
            ogPA.Og(this.pA.nCO());
            ogPA.pA(this.aBv.getWidth());
            ogPA.Og(this.aBv.getHeight());
            ogPA.KZx(this.pA.tM());
            ogPA.pA(j);
            ogPA.pA(Bzk());
            pA(ogPA);
            if (z2) {
                this.Og.Og(ogPA);
                return true;
            }
            zPA = this.Og.pA(ogPA);
        }
        if (((j > 0 && !z && !z2) || (j > 0 && z)) && this.Og != null) {
            com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX.pA pAVar = new com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX.pA();
            pAVar.pA(this.Og.ML());
            pAVar.KZx(this.Og.omh());
            pAVar.Og(this.Og.JG());
            com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.Og(this.Og.Wx(), pAVar);
        }
        return zPA;
    }

    private void yFO() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
        if (kZx == null) {
            return;
        }
        kZx.ZZv(this.XT);
        ((KZx) this.Og).pA((KZx.pA) this);
        this.Og.pA(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        vZF();
        getViewTreeObserver().addOnScrollChangedListener(this.HSv);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        vZF();
    }

    private void vZF() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
        if (kZx == null) {
            XT();
        } else if ((kZx instanceof KZx) && !lT()) {
            ((KZx) this.Og).XT();
        }
        if (this.Og == null || !this.SzT.get()) {
            return;
        }
        this.SzT.set(false);
        Og();
        if (omh()) {
            Vgu.pA((View) this.SD, 8);
            ImageView imageView = this.Bzk;
            if (imageView != null) {
                Vgu.pA((View) imageView, 8);
            }
            yFO yfo = this.pA;
            if (yfo != null && yfo.Bf() != null) {
                com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = yFO.pA(CacheDirFactory.getICacheDir(this.pA.FK()).KZx(), this.pA);
                ogPA.Og(this.pA.nCO());
                ogPA.pA(this.aBv.getWidth());
                ogPA.Og(this.aBv.getHeight());
                ogPA.KZx(this.pA.tM());
                ogPA.pA(0L);
                ogPA.pA(Bzk());
                pA(ogPA);
                this.Og.pA(ogPA);
                this.Og.KZx(false);
                return;
            }
            WV.pA("NativeVideoTsView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        if (this.Og.DX()) {
            this.Og.DX();
            Og(true);
        } else {
            SD();
            Vgu.pA((View) this.SD, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Sd();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.HSv);
        }
        ViewGroup viewGroup = this.aBv;
        if (viewGroup == null || this.CIG == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver2 = viewGroup.getViewTreeObserver();
        if (viewTreeObserver2.isAlive()) {
            viewTreeObserver2.removeOnGlobalLayoutListener(this.CIG);
            this.CIG = null;
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Sd();
    }

    private void Sd() {
        this.DX = null;
        if ((this.Og instanceof KZx) && !lT()) {
            ((KZx) this.Og).rB();
        }
        SGo();
        pA(false);
        TX();
    }

    private void TX() {
        if (!this.SzT.get()) {
            this.SzT.set(true);
            com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
            if (kZx != null) {
                kZx.pA(true, 3);
            }
        }
        this.Bf.set(false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            TX();
        }
    }

    @Override // com.bytedance.sdk.component.utils.TV.pA
    public void pA(Message message) {
        if (message.what == 1) {
            BF();
        }
    }

    private void BF() {
        this.lT = BSW();
        xy.pA(this.FQ);
    }

    private boolean WQf() {
        yFO yfo = this.pA;
        if (yfo == null) {
            return false;
        }
        return yfo.le();
    }

    private boolean TV() {
        if (lT() || !WQf()) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
    }

    private void du() {
        if (lT() || !WQf()) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_isfromvideodetailpage", Boolean.FALSE);
        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_is_from_detail_page", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(boolean z, int i) {
        if (this.pA == null || this.Og == null) {
            return;
        }
        boolean zTV = TV();
        du();
        if (zTV && this.Og.DX()) {
            this.Og.DX();
            Og(true);
            ZZv();
            return;
        }
        if (z && this.WQf && !this.Og.DX() && !this.Og.BSW()) {
            if (this.Og.WV() != null && this.Og.WV().SD()) {
                if (this.XT || i == 1) {
                    com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
                    if (kZx != null) {
                        setIsQuiet(kZx.Sn());
                    }
                    if ("ALP-AL00".equals(this.qmB)) {
                        this.Og.Og();
                    } else {
                        if (!Bzk.Og().DX()) {
                            zTV = true;
                        }
                        ((KZx) this.Og).omh(zTV);
                    }
                    pA(false);
                    com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx interfaceC0160KZx = this.Vgu;
                    if (interfaceC0160KZx != null) {
                        interfaceC0160KZx.h_();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.XT && this.Og.WV() == null) {
                if (!this.SzT.get()) {
                    this.SzT.set(true);
                }
                this.Bf.set(false);
                vZF();
                return;
            }
            return;
        }
        if (this.Og.WV() == null || !this.Og.WV().JG()) {
            return;
        }
        this.Og.pA();
        pA(true);
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx interfaceC0160KZx2 = this.Vgu;
        if (interfaceC0160KZx2 != null) {
            interfaceC0160KZx2.g_();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx;
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx2;
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx3;
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx4;
        if (!"open_ad".equals(this.WV)) {
            this.WQf = z;
            super.onWindowFocusChanged(z);
            com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(this.pA, z);
            roi();
            if (TV() && (kZx4 = this.Og) != null && kZx4.DX()) {
                du();
                Vgu.pA((View) this.SD, 8);
                Og(true);
                ZZv();
                return;
            }
            Og();
            if (lT() || !omh() || (kZx2 = this.Og) == null || kZx2.BSW()) {
                if (omh()) {
                    return;
                }
                if (!z && (kZx = this.Og) != null && kZx.WV() != null && this.Og.WV().JG()) {
                    eG();
                    pA(false, Sd.intValue());
                    return;
                } else {
                    if (z) {
                        this.IG.obtainMessage(1).sendToTarget();
                        return;
                    }
                    return;
                }
            }
            if (this.IG != null) {
                if (z && (kZx3 = this.Og) != null && !kZx3.DX()) {
                    this.IG.obtainMessage(1).sendToTarget();
                    return;
                } else {
                    eG();
                    pA(false, Sd.intValue());
                    return;
                }
            }
            return;
        }
        eG();
    }

    private void eG() {
        this.IG.removeMessages(1);
        Sn.KZx().removeCallbacks(this.FQ);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx;
        yFO yfo;
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx2;
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx3;
        super.onWindowVisibilityChanged(i);
        roi();
        if (this.Gx) {
            this.Gx = i == 0;
        }
        if (TV() && (kZx3 = this.Og) != null && kZx3.DX()) {
            du();
            Vgu.pA((View) this.SD, 8);
            Og(true);
            ZZv();
            return;
        }
        Og();
        if (lT() || !omh() || (kZx = this.Og) == null || kZx.BSW() || (yfo = this.pA) == null) {
            return;
        }
        if (this.eG && yfo.Bf() != null) {
            this.pA.Bf();
            com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = yFO.pA(CacheDirFactory.getICacheDir(this.pA.FK()).KZx(), this.pA);
            ogPA.Og(this.pA.nCO());
            ogPA.pA(this.aBv.getWidth());
            ogPA.Og(this.aBv.getHeight());
            ogPA.KZx(this.pA.tM());
            ogPA.pA(this.roi);
            ogPA.pA(Bzk());
            pA(ogPA);
            this.Og.pA(ogPA);
            this.eG = false;
            Vgu.pA((View) this.SD, 8);
        } else {
            WV.pA("NativeVideoTsView", "attachTask materialMeta.getVideo() is null !!");
        }
        if (i != 0 || this.IG == null || (kZx2 = this.Og) == null || kZx2.DX()) {
            return;
        }
        this.IG.obtainMessage(1).sendToTarget();
    }

    private void roi() {
        if (this.Og == null || lT()) {
            return;
        }
        if ((!WQf() || com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_is_update_flag", false)) && WQf()) {
            long jOmh = this.Og.omh();
            long jJG = this.Og.JG() + jOmh;
            boolean zPA = com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_native_video_complete", false);
            long jPA = com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_current_play_position", 0L);
            long jPA2 = com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_total_play_duration", jJG);
            long jPA3 = com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_duration", jOmh);
            com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.FALSE);
            this.Og.KZx(zPA);
            this.Og.pA(jPA);
            this.Og.Og(jPA2);
            this.Og.KZx(jPA3);
            WV.pA("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + zPA + ",position=" + jPA + ",totalPlayDuration=" + jPA2 + ",duration=" + jPA3);
        }
    }

    public com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx getNativeVideoController() {
        return this.Og;
    }

    public boolean omh() {
        return this.XT;
    }

    public void setIsAutoPlay(boolean z) {
        if (this.xy) {
            return;
        }
        int iOg = aBv.ZZv().Og(this.pA.Wf());
        if (z && iOg != 4 && (!DX.ML(this.oX) ? !(!DX.JG(this.oX) ? DX.ZZv(this.oX) : Mc() || IG()) : !Mc())) {
            z = false;
        }
        this.XT = z;
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
        if (kZx != null) {
            kZx.ZZv(z);
        }
        if (!this.XT) {
            SD();
            RelativeLayout relativeLayout = this.SD;
            if (relativeLayout != null) {
                Vgu.pA((View) relativeLayout, 0);
                yFO yfo = this.pA;
                if (yfo != null && yfo.Bf() != null) {
                    com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.pA.Bf().SGo(), this.pA.Bf().KZx(), this.pA.Bf().Og(), this.omh, this.pA);
                }
            }
        } else {
            Vgu.pA((View) this.SD, 8);
        }
        this.xy = true;
    }

    private boolean Mc() {
        return 2 == aBv.ZZv().Og(this.pA.Wf());
    }

    private boolean IG() {
        return 5 == aBv.ZZv().Og(this.pA.Wf());
    }

    public boolean Bzk() {
        return this.ZZv;
    }

    public void setIsQuiet(boolean z) {
        this.ZZv = z;
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
        if (kZx != null) {
            kZx.Og(z);
        }
    }

    private boolean lT() {
        return this.yFO;
    }

    public void setVideoAdInteractionListener(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx interfaceC0160KZx) {
        this.Vgu = interfaceC0160KZx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.pA
    public void JG() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx interfaceC0160KZx = this.Vgu;
        if (interfaceC0160KZx != null) {
            interfaceC0160KZx.d_();
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        this.BSW = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.KZx.pA
    public void pA(int i) {
        Og();
    }

    protected void KZx() {
        if (WV()) {
            return;
        }
        Sn();
    }

    protected void pA(boolean z) {
        if (this.Bzk == null) {
            this.Bzk = new ImageView(getContext());
            if (Bzk.Og().oX() != null) {
                this.Bzk.setImageBitmap(Bzk.Og().oX());
            } else {
                this.Bzk.setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(aBv.pA(), "tt_new_play_video"));
            }
            this.Bzk.setScaleType(ImageView.ScaleType.FIT_XY);
            int iKZx = Vgu.KZx(getContext(), this.Wx);
            int iKZx2 = Vgu.KZx(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iKZx, iKZx);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = iKZx2;
            layoutParams.bottomMargin = iKZx2;
            this.aBv.addView(this.Bzk, layoutParams);
            this.Bzk.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Wx.Og.JG.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/Wx/Og/JG$5;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view);
                    safedk_JG$5_onClick_cf6fe5c49efe1fffb73f7b0f49993d3b(view);
                }

                public void safedk_JG$5_onClick_cf6fe5c49efe1fffb73f7b0f49993d3b(View p0) {
                    JG.this.Sn();
                }
            });
        }
        if (z) {
            this.Bzk.setVisibility(0);
        } else {
            this.Bzk.setVisibility(8);
        }
    }

    public void Og(boolean z) {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
        if (kZx != null) {
            kZx.KZx(z);
            com.bykv.vk.openvk.pA.pA.pA.ZZv.Og ogWx = this.Og.Wx();
            if (ogWx != null) {
                ogWx.Og();
                View viewKZx = ogWx.KZx();
                if (viewKZx != null) {
                    if (viewKZx.getParent() != null) {
                        ((ViewGroup) viewKZx.getParent()).removeView(viewKZx);
                    }
                    viewKZx.setVisibility(0);
                    addView(viewKZx);
                    ogWx.pA(this.pA, new WeakReference<>(this.oX), false);
                }
            }
        }
    }

    public void SGo() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.Og ogWx;
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
        if (kZx == null || (ogWx = kZx.Wx()) == null) {
            return;
        }
        ogWx.pA();
        View viewKZx = ogWx.KZx();
        if (viewKZx != null) {
            viewKZx.setVisibility(8);
            if (viewKZx.getParent() != null) {
                ((ViewGroup) viewKZx.getParent()).removeView(viewKZx);
            }
        }
    }

    private void rB() {
        Vgu.ML(this.Bzk);
        Vgu.ML(this.SD);
    }

    public void setVideoCacheUrl(String str) {
        this.vZF = str;
    }

    boolean BSW() {
        return lT.pA(this, 50, WQf.Og(this.WV) ? 1 : 5);
    }

    public boolean WV() {
        boolean z = false;
        if (DX.KZx(aBv.pA()) == 0) {
            return false;
        }
        if (this.Og.WV() != null && this.Og.WV().JG()) {
            pA(false, Sd.intValue());
            Handler handler = this.IG;
            z = true;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
        return z;
    }

    public void Wx() {
        if (getNativeVideoController() == null || !(getNativeVideoController() instanceof KZx)) {
            return;
        }
        KZx kZx = (KZx) getNativeVideoController();
        kZx.pA(kZx.Wx(), this);
    }

    public void Sn() {
        if (DX.KZx(aBv.pA()) != 0 && BSW()) {
            if (this.Og.WV() != null && this.Og.WV().SD()) {
                pA(true, TX.intValue());
                Og();
                Handler handler = this.IG;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(1, 500L);
                    return;
                }
                return;
            }
            if (omh() || this.Bf.get()) {
                return;
            }
            this.Bf.set(true);
            rB();
            yFO yfo = this.pA;
            if (yfo != null && yfo.Bf() != null) {
                rB();
                this.pA.Bf();
                com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = yFO.pA(CacheDirFactory.getICacheDir(this.pA.FK()).KZx(), this.pA);
                ogPA.Og(this.pA.nCO());
                ogPA.pA(this.aBv.getWidth());
                ogPA.Og(this.aBv.getHeight());
                ogPA.KZx(this.pA.tM());
                ogPA.pA(this.roi);
                ogPA.pA(Bzk());
                ogPA.pA(CacheDirFactory.getICacheDir(this.pA.FK()).KZx());
                pA(ogPA);
                this.Og.pA(ogPA);
            }
            Handler handler2 = this.IG;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(1, 500L);
            }
            pA(false);
        }
    }

    public double getCurrentPlayTime() {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
        if (kZx != null) {
            return (kZx.ML() * 1.0d) / 1000.0d;
        }
        return 0.0d;
    }

    public void DX() {
        yFO yfo = this.pA;
        if (yfo == null || yfo.dGZ() == null) {
            return;
        }
        this.pA.dGZ().DX();
        this.pA.dGZ().pA().ML(this.roi);
    }

    public com.bytedance.sdk.openadsdk.core.WV.JG pA(List<Pair<View, FriendlyObstructionPurpose>> list) {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx kZx = this.Og;
        if (kZx instanceof KZx) {
            return ((KZx) kZx).pA(this, list);
        }
        return null;
    }

    private void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        try {
            if (this.pA.rX()) {
                kZx.pA(this.BF);
            }
        } catch (Throwable unused) {
        }
    }
}
