package com.bytedance.adsdk.Og;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class JG extends ImageView {
    private static final BSW<Throwable> Og = new BSW<Throwable>() { // from class: com.bytedance.adsdk.Og.JG.1
        @Override // com.bytedance.adsdk.Og.BSW
        public /* bridge */ /* synthetic */ void pA(Throwable th) {
        }
    };
    private static final String pA = "JG";
    private int BF;
    private boolean BSW;
    private int Bzk;
    private final Set<Object> DX;
    private Og IG;
    private int JG;
    private final BSW<SD> KZx;
    private BSW<Throwable> ML;
    private final Runnable Mc;
    private final Bzk SD;
    private com.bytedance.adsdk.ugeno.KZx SGo;
    private long Sd;
    private final Set<ZZv> Sn;
    private int TV;
    private com.bytedance.adsdk.Og.KZx.KZx.KZx TX;
    private int WQf;
    private boolean WV;
    private boolean Wx;
    private final Handler XT;
    private final BSW<Throwable> ZZv;
    private SD aBv;
    private int du;
    private String eG;
    private pA lT;
    private Wx<SD> oX;
    private String omh;
    private JSONArray roi;
    private Handler vZF;
    private int yFO;

    public interface Og {
    }

    private enum ZZv {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public interface pA {
    }

    static /* synthetic */ int ML(JG jg) {
        int i = jg.yFO;
        jg.yFO = i + 1;
        return i;
    }

    static /* synthetic */ int XT(JG jg) {
        int i = jg.BF;
        jg.BF = i - 1;
        return i;
    }

    public JG(Context context) {
        super(context);
        this.KZx = new BSW<SD>() { // from class: com.bytedance.adsdk.Og.JG.6
            @Override // com.bytedance.adsdk.Og.BSW
            public void pA(SD sd) {
                JG.this.setComposition(sd);
            }
        };
        this.ZZv = new BSW<Throwable>() { // from class: com.bytedance.adsdk.Og.JG.7
            @Override // com.bytedance.adsdk.Og.BSW
            public void pA(Throwable th) {
                if (JG.this.JG != 0) {
                    JG jg = JG.this;
                    jg.setImageResource(jg.JG);
                }
                (JG.this.ML == null ? JG.Og : JG.this.ML).pA(th);
            }
        };
        this.JG = 0;
        this.SD = new Bzk();
        this.BSW = false;
        this.WV = false;
        this.Wx = true;
        this.Sn = new HashSet();
        this.DX = new HashSet();
        this.XT = new Handler(Looper.getMainLooper());
        this.yFO = 0;
        this.Sd = 0L;
        this.Mc = new Runnable() { // from class: com.bytedance.adsdk.Og.JG.4
            @Override // java.lang.Runnable
            public void run() {
                Log.i("TMe", "--==--- timer callback, timer: " + JG.this.BF + ", " + JG.this.WQf);
                if (JG.this.BF <= JG.this.WQf) {
                    if (JG.this.TV >= 0 && JG.this.du >= 0) {
                        Log.i("TMe", "--==--- timer end, play anim, startframe: " + JG.this.TV);
                        JG.this.pA();
                        JG jg = JG.this;
                        jg.setFrame(jg.TV);
                        JG.this.pA(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.Og.JG.4.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (JG.this.getFrame() < JG.this.du - 1 || JG.this.getFrame() >= JG.this.du + 2) {
                                    return;
                                }
                                Log.i("TMe", "--==--- timer end, play anim, endframe: " + JG.this.du);
                                JG.this.Og(this);
                                JG.this.JG();
                            }
                        });
                    } else {
                        Log.i("TMe", "--==--- timer end, frame invalid: " + JG.this.TV + StringUtils.COMMA + JG.this.du);
                    }
                    if ((!TextUtils.isEmpty(JG.this.eG) || (JG.this.roi != null && JG.this.roi.length() > 0)) && JG.this.IG != null) {
                        Og unused = JG.this.IG;
                        String unused2 = JG.this.eG;
                        JSONArray unused3 = JG.this.roi;
                        return;
                    }
                    return;
                }
                JG.XT(JG.this);
                JG.this.TX.pA(new StringBuilder().append(JG.this.BF).toString());
                JG.this.invalidate();
                JG.this.DX();
            }
        };
        omh();
    }

    public void pA(com.bytedance.adsdk.ugeno.KZx kZx) {
        this.SGo = kZx;
    }

    private void omh() {
        setSaveEnabled(false);
        this.Wx = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        pA(0.0f, false);
        pA(false, getContext().getApplicationContext());
        setIgnoreDisabledSystemAnimations(false);
        this.SD.pA(Boolean.valueOf(com.bytedance.adsdk.Og.JG.JG.pA(getContext()) != 0.0f));
        Bzk();
        SGo();
        WV();
    }

    private void Bzk() {
        pA(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.Og.JG.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                JG.this.Og(this);
                JG.this.Sn();
                JG.this.BSW();
            }
        });
    }

    private void SGo() {
        pA(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.Og.JG.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < 0.98f) {
                    return;
                }
                JG.ML(JG.this);
                SD.pA globalConfig = JG.this.getGlobalConfig();
                if (globalConfig != null && globalConfig.ZZv > 0 && globalConfig.ZZv > JG.this.yFO) {
                    JG.this.Sn();
                    JG.this.pA();
                    JG.this.setProgress(0.0f);
                } else {
                    JG.this.Og(this);
                    if (JG.this.lT != null) {
                        pA unused = JG.this.lT;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BSW() {
        final SD.pA globalConfig = getGlobalConfig();
        if (globalConfig == null || globalConfig.ML <= 0) {
            return;
        }
        if (TextUtils.isEmpty(globalConfig.JG) && globalConfig.SD == null) {
            return;
        }
        int maxFrame = globalConfig.ML;
        if (maxFrame > getMaxFrame()) {
            maxFrame = (int) getMaxFrame();
        }
        final float maxFrame2 = maxFrame / getMaxFrame();
        pA(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.Og.JG.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < maxFrame2) {
                    return;
                }
                JG.this.Og(this);
                if (JG.this.IG != null) {
                    Og unused = JG.this.IG;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(long j) {
        SD.pA globalConfig = getGlobalConfig();
        if (this.lT != null) {
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(j));
            if (globalConfig == null || globalConfig.Og == null || globalConfig.Og.isEmpty()) {
                return;
            }
            map.putAll(globalConfig.Og);
        }
    }

    private void WV() {
        pA(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.Og.JG.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                vZF vzfWQf;
                final long jElapsedRealtime = SystemClock.elapsedRealtime() - JG.this.Sd;
                JG.this.Og(this);
                String playDelayedELExpressTimeS = JG.this.getPlayDelayedELExpressTimeS();
                if (!TextUtils.isEmpty(playDelayedELExpressTimeS) && (vzfWQf = JG.this.SD.WQf()) != null) {
                    try {
                        int i = Integer.parseInt(vzfWQf.pA(playDelayedELExpressTimeS)) * 1000;
                        if (JG.this.Sd > 0) {
                            long jElapsedRealtime2 = (JG.this.Sd + ((long) i)) - SystemClock.elapsedRealtime();
                            Log.i("TMe", "--==-- lottie delayed time: ".concat(String.valueOf(jElapsedRealtime2)));
                            if (jElapsedRealtime2 > 0) {
                                JG.this.JG();
                                JG.this.setVisibility(8);
                                if (JG.this.vZF == null) {
                                    JG.this.vZF = new Handler(Looper.getMainLooper());
                                }
                                JG.this.vZF.removeCallbacksAndMessages(null);
                                JG.this.vZF.postDelayed(new Runnable() { // from class: com.bytedance.adsdk.Og.JG.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Log.i("TMe", "--==-- lottie real start play");
                                        JG.this.setVisibility(0);
                                        JG.this.pA();
                                        JG.this.pA(jElapsedRealtime);
                                    }
                                }, jElapsedRealtime2);
                                return;
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                JG.this.pA(jElapsedRealtime);
            }
        });
    }

    public void setView(View view) {
        this.SD.pA(view);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        Wx();
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Wx();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Wx();
        super.setImageBitmap(bitmap);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        Bzk bzk;
        if (!this.BSW && drawable == (bzk = this.SD) && bzk.TX()) {
            JG();
        } else if (!this.BSW && (drawable instanceof Bzk)) {
            Bzk bzk2 = (Bzk) drawable;
            if (bzk2.TX()) {
                bzk2.roi();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof Bzk) && ((Bzk) drawable).JG() == yFO.SOFTWARE) {
            this.SD.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        Bzk bzk = this.SD;
        if (drawable2 == bzk) {
            super.invalidateDrawable(bzk);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPlayDelayedELExpressTimeS() {
        SD sdDu;
        Bzk bzk = this.SD;
        if (bzk == null || (sdDu = bzk.du()) == null) {
            return null;
        }
        return sdDu.Bzk();
    }

    private SGo pA(String str) {
        Bzk bzk;
        SD sdDu;
        Map<String, SGo> mapOX;
        if (TextUtils.isEmpty(str) || (bzk = this.SD) == null || (sdDu = bzk.du()) == null || (mapOX = sdDu.oX()) == null) {
            return null;
        }
        return mapOX.get(str);
    }

    private SD.Og getGlobalEvent() {
        SD sdDu;
        Bzk bzk = this.SD;
        if (bzk == null || (sdDu = bzk.du()) == null) {
            return null;
        }
        return sdDu.SGo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SD.pA getGlobalConfig() {
        SD sdDu;
        Bzk bzk = this.SD;
        if (bzk == null || (sdDu = bzk.du()) == null) {
            return null;
        }
        return sdDu.BSW();
    }

    private void pA(int[][] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        try {
            int[] iArr2 = iArr[0];
            int i = iArr2[0];
            final int i2 = iArr2[1];
            if (i < 0 || i2 < 0) {
                return;
            }
            Log.i("TMe", "--==--- inel enter, play anim, startframe: ".concat(String.valueOf(i)));
            oX();
            pA();
            setFrame(i);
            pA(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.Og.JG.12
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (JG.this.getFrame() < i2 - 1 || JG.this.getFrame() >= i2 + 2) {
                        return;
                    }
                    Log.i("TMe", "--==--- inel enter, play anim end, endframe: " + i2 + ", realFrame: " + JG.this.getFrame());
                    JG.this.Og(this);
                    JG.this.JG();
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void pA(String str, String str2, JSONArray jSONArray) {
        SD.Og globalEvent = getGlobalEvent();
        if (globalEvent != null && str != null) {
            if (TextUtils.isEmpty(str2) && !str.contains("CSJNO")) {
                str2 = globalEvent.pA;
            }
            if ((jSONArray == null || jSONArray.length() <= 0) && !str.contains("CSJLELNO")) {
                jSONArray = globalEvent.KZx;
            }
        }
        if (!TextUtils.isEmpty(str2) || jSONArray == null) {
            return;
        }
        jSONArray.length();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int[][] iArr;
        com.bytedance.adsdk.Og.KZx.KZx.pA pAVarPA = pA(motionEvent);
        if (pAVarPA != null) {
            String strBzk = pAVarPA.Bzk();
            if (pAVarPA instanceof com.bytedance.adsdk.Og.KZx.KZx.Og) {
                if (getGlobalConfig() == null || getGlobalConfig().pA != 1) {
                    return super.onTouchEvent(motionEvent);
                }
                return false;
            }
            if (strBzk != null && strBzk.startsWith("CSJCLOSE")) {
                oX();
            }
            SGo sGoPA = pA(pAVarPA.ML());
            if (sGoPA != null && motionEvent.getAction() == 1) {
                pA(strBzk, sGoPA.ML(), sGoPA.SD());
                int[][] iArrJG = sGoPA.JG();
                if (iArrJG != null) {
                    pA(iArrJG);
                } else if (getGlobalEvent() != null && (iArr = getGlobalEvent().Og) != null) {
                    pA(iArr);
                }
            }
            if (strBzk == null || !strBzk.startsWith("CSJNTP")) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        if (getGlobalConfig() == null || getGlobalConfig().pA != 1) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    private com.bytedance.adsdk.Og.KZx.KZx.pA pA(MotionEvent motionEvent) {
        com.bytedance.adsdk.Og.KZx.KZx.Og Og2;
        Bzk bzk = this.SD;
        if (bzk == null || (Og2 = bzk.Og()) == null) {
            return null;
        }
        return pA(Og2, motionEvent);
    }

    private com.bytedance.adsdk.Og.KZx.KZx.pA pA(com.bytedance.adsdk.Og.KZx.KZx.Og og, MotionEvent motionEvent) {
        com.bytedance.adsdk.Og.KZx.KZx.pA pAVarPA;
        for (com.bytedance.adsdk.Og.KZx.KZx.pA pAVar : og.WV()) {
            if (pAVar instanceof com.bytedance.adsdk.Og.KZx.KZx.Og) {
                if (pAVar.omh() && pAVar.JG() > 0.0f) {
                    RectF rectF = new RectF();
                    pAVar.pA(rectF, pAVar.ZZv(), true);
                    if (rectF.width() >= 3.0f && rectF.height() >= 3.0f && (pAVarPA = pA((com.bytedance.adsdk.Og.KZx.KZx.Og) pAVar, motionEvent)) != null) {
                        return pAVarPA;
                    }
                }
            } else if (pAVar.omh() && pAVar.JG() > 0.0f) {
                RectF rectF2 = new RectF();
                Bzk bzk = this.SD;
                if (bzk != null && bzk.SD()) {
                    pAVar.pA(rectF2, pAVar.ZZv(), true);
                    RectF rectFIG = this.SD.IG();
                    if (rectFIG != null) {
                        pA(rectF2, rectFIG);
                    }
                } else {
                    RectF rectF3 = new RectF();
                    pAVar.pA(rectF3, pAVar.ZZv(), true);
                    Og(rectF2, rectF3);
                }
                if (pA(motionEvent, rectF2)) {
                    return pAVar;
                }
            }
        }
        return null;
    }

    private boolean pA(MotionEvent motionEvent, RectF rectF) {
        if (motionEvent != null && rectF != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom) {
                return true;
            }
        }
        return false;
    }

    private void pA(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = rectF2.width();
        float fHeight = rectF2.height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass5.pA[getScaleType().ordinal()];
        if (i == 1) {
            pA(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            Og(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            KZx(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            ZZv(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.Og.JG$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            pA = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pA[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                pA[ImageView.ScaleType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                pA[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void Og(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = this.SD.getBounds().width();
        float fHeight = this.SD.getBounds().height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass5.pA[getScaleType().ordinal()];
        if (i == 1) {
            pA(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            Og(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            KZx(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            ZZv(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF, rectF2);
    }

    private void pA(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 / f4 >= f / f2) {
            float f5 = f2 / f4;
            matrix.preScale(f5, f5);
            matrix.postTranslate(-(((f3 * f5) - f) / 2.0f), 0.0f);
        } else {
            float f6 = f / f3;
            matrix.preScale(f6, f6);
            matrix.postTranslate(0.0f, -(((f4 * f6) - f2) / 2.0f));
        }
    }

    private void Og(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 < f && f4 < f2) {
            matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
            return;
        }
        if (f3 / f4 >= f / f2) {
            float f5 = f / f3;
            matrix.preScale(f5, f5);
            matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
        } else {
            float f6 = f2 / f4;
            matrix.preScale(f6, f6);
            matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
        }
    }

    private void KZx(Matrix matrix, float f, float f2, float f3, float f4) {
        matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
    }

    private void ZZv(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 >= f || f4 >= f2) {
            if (f3 / f4 >= f / f2) {
                float f5 = f / f3;
                matrix.preScale(f5, f5);
                matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
                return;
            } else {
                float f6 = f2 / f4;
                matrix.preScale(f6, f6);
                matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
                return;
            }
        }
        if (f3 / f4 >= f / f2) {
            float f7 = f / f3;
            matrix.preScale(f7, f7);
            matrix.postTranslate(0.0f, (f2 - (f4 * f7)) / 2.0f);
        } else {
            float f8 = f2 / f4;
            matrix.preScale(f8, f8);
            matrix.postTranslate((f - (f3 * f8)) / 2.0f, 0.0f);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        KZx kZx = new KZx(super.onSaveInstanceState());
        kZx.pA = this.omh;
        kZx.Og = this.Bzk;
        kZx.KZx = this.SD.Mc();
        kZx.ZZv = this.SD.BF();
        kZx.ML = this.SD.ZZv();
        kZx.JG = this.SD.vZF();
        kZx.SD = this.SD.Sd();
        return kZx;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof KZx)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        KZx kZx = (KZx) parcelable;
        super.onRestoreInstanceState(kZx.getSuperState());
        this.omh = kZx.pA;
        if (!this.Sn.contains(ZZv.SET_ANIMATION) && !TextUtils.isEmpty(this.omh)) {
            setAnimation(this.omh);
        }
        this.Bzk = kZx.Og;
        if (!this.Sn.contains(ZZv.SET_ANIMATION) && (i = this.Bzk) != 0) {
            setAnimation(i);
        }
        if (!this.Sn.contains(ZZv.SET_PROGRESS)) {
            pA(kZx.KZx, false);
        }
        if (!this.Sn.contains(ZZv.PLAY_OPTION) && kZx.ZZv) {
            pA();
        }
        if (!this.Sn.contains(ZZv.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(kZx.ML);
        }
        if (!this.Sn.contains(ZZv.SET_REPEAT_MODE)) {
            setRepeatMode(kZx.JG);
        }
        if (this.Sn.contains(ZZv.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(kZx.SD);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.WV) {
            this.SD.BSW();
        }
        com.bytedance.adsdk.ugeno.KZx kZx = this.SGo;
        if (kZx != null) {
            kZx.SD();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        oX();
        Handler handler = this.vZF;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        KZx();
        Og();
        com.bytedance.adsdk.ugeno.KZx kZx = this.SGo;
        if (kZx != null) {
            kZx.omh();
        }
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.SD.SD(z);
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.SD.omh(z);
    }

    public void pA(boolean z, Context context) {
        this.SD.pA(z, context);
    }

    public void setClipToCompositionBounds(boolean z) {
        this.SD.pA(z);
    }

    public boolean getClipToCompositionBounds() {
        return this.SD.KZx();
    }

    public void setCacheComposition(boolean z) {
        this.Wx = z;
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.SD.ZZv(z);
    }

    public void setAnimation(int i) {
        this.Bzk = i;
        this.omh = null;
        setCompositionTask(pA(i));
    }

    private Wx<SD> pA(final int i) {
        if (isInEditMode()) {
            return new Wx<>(new Callable<WV<SD>>() { // from class: com.bytedance.adsdk.Og.JG.13
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
                public WV<SD> call() throws Exception {
                    return JG.this.Wx ? omh.Og(JG.this.getContext(), i) : omh.Og(JG.this.getContext(), i, (String) null);
                }
            }, true);
        }
        return this.Wx ? omh.pA(getContext(), i) : omh.pA(getContext(), i, (String) null);
    }

    public void setAnimation(String str) {
        this.omh = str;
        this.Bzk = 0;
        setCompositionTask(Og(str));
    }

    private Wx<SD> Og(final String str) {
        if (isInEditMode()) {
            return new Wx<>(new Callable<WV<SD>>() { // from class: com.bytedance.adsdk.Og.JG.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
                public WV<SD> call() throws Exception {
                    return JG.this.Wx ? omh.KZx(JG.this.getContext(), str) : omh.KZx(JG.this.getContext(), str, null);
                }
            }, true);
        }
        return this.Wx ? omh.Og(getContext(), str) : omh.Og(getContext(), str, (String) null);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        pA(str, (String) null);
    }

    public void pA(String str, String str2) {
        pA(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void pA(InputStream inputStream, String str) {
        setCompositionTask(omh.pA(inputStream, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.Wx ? omh.pA(getContext(), str) : omh.pA(getContext(), str, (String) null));
    }

    public void setFailureListener(BSW<Throwable> bsw) {
        this.ML = bsw;
    }

    public void setFallbackResource(int i) {
        this.JG = i;
    }

    private void setCompositionTask(Wx<SD> wx) {
        this.Sn.add(ZZv.SET_ANIMATION);
        aBv();
        Wx();
        this.oX = wx.pA(this.KZx).KZx(this.ZZv);
    }

    private void Wx() {
        Wx<SD> wx = this.oX;
        if (wx != null) {
            wx.Og(this.KZx);
            this.oX.ZZv(this.ZZv);
        }
    }

    private com.bytedance.adsdk.Og.KZx.KZx.KZx pA(com.bytedance.adsdk.Og.KZx.KZx.Og og, String str) {
        for (com.bytedance.adsdk.Og.KZx.KZx.pA pAVar : og.WV()) {
            if (pAVar instanceof com.bytedance.adsdk.Og.KZx.KZx.Og) {
                com.bytedance.adsdk.Og.KZx.KZx.KZx kZxPA = pA((com.bytedance.adsdk.Og.KZx.KZx.Og) pAVar, str);
                if (kZxPA != null) {
                    return kZxPA;
                }
            } else if (TextUtils.equals(str, pAVar.Bzk()) && (pAVar instanceof com.bytedance.adsdk.Og.KZx.KZx.KZx)) {
                return (com.bytedance.adsdk.Og.KZx.KZx.KZx) pAVar;
            }
        }
        return null;
    }

    private com.bytedance.adsdk.Og.KZx.KZx.KZx KZx(String str) {
        com.bytedance.adsdk.Og.KZx.KZx.Og Og2;
        Bzk bzk = this.SD;
        if (bzk == null || (Og2 = bzk.Og()) == null) {
            return null;
        }
        return pA(Og2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sn() {
        Bzk bzk;
        int i;
        int i2;
        final int i3;
        if (this.aBv == null || (bzk = this.SD) == null) {
            return;
        }
        vZF vzfWQf = bzk.WQf();
        SD.KZx kZxOmh = this.aBv.omh();
        if (kZxOmh == null || vzfWQf == null) {
            return;
        }
        final int i4 = kZxOmh.pA;
        if (i4 < 0) {
            Log.i("TMe", "--==--- timer fail, ke is invalid: ".concat(String.valueOf(i4)));
            return;
        }
        final int i5 = -1;
        if (kZxOmh.ML == null || kZxOmh.ML.length < 2) {
            i = -1;
            i2 = -1;
        } else {
            i = kZxOmh.ML[0];
            i2 = kZxOmh.ML[1];
        }
        String strPA = vzfWQf.pA(kZxOmh.KZx);
        String strPA2 = vzfWQf.pA(kZxOmh.ZZv);
        try {
            i3 = Integer.parseInt(strPA);
            try {
                i5 = Integer.parseInt(strPA2);
            } catch (NumberFormatException unused) {
            }
        } catch (NumberFormatException unused2) {
            i3 = -1;
        }
        Log.i("TMe", "--==--- prepare timer, startS: " + i3 + ", lenS: " + i5);
        if (!TextUtils.isEmpty(kZxOmh.Og)) {
            Log.i("TMe", "--==--- timer, id:" + kZxOmh.Og);
            com.bytedance.adsdk.Og.KZx.KZx.KZx KZx2 = KZx(kZxOmh.Og);
            if (KZx2 != null) {
                Log.i("TMe", "--==--- timer success");
                this.eG = kZxOmh.JG;
                this.roi = kZxOmh.SD;
                this.TX = KZx2;
                this.BF = i3;
                this.WQf = i3 - i5;
                this.TV = i;
                this.du = i2;
                KZx2.pA(new StringBuilder().append(this.BF).toString());
                pA(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.Og.JG.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (JG.this.getFrame() < i4 - 1 || JG.this.getFrame() >= i4 + 2) {
                            return;
                        }
                        Log.i("TMe", "--==--- enter timer point, frame: " + JG.this.getFrame());
                        JG.this.Og(this);
                        if (i3 >= 0 && i5 >= 0) {
                            Log.i("TMe", "--==--- enter timer callback, start timer");
                            JG.this.DX();
                        } else {
                            Log.i("TMe", "--==--- enter timer callback, NOT start timer");
                        }
                        JG.this.JG();
                    }
                });
                return;
            }
            return;
        }
        Log.i("TMe", "--==--- timer fail, id is invalid: " + kZxOmh.Og);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DX() {
        this.XT.postDelayed(this.Mc, 1000L);
    }

    private void oX() {
        this.XT.removeCallbacksAndMessages(null);
    }

    public void setComposition(SD sd) {
        if (ML.pA) {
            Log.v(pA, "Set Composition \n".concat(String.valueOf(sd)));
        }
        this.SD.setCallback(this);
        this.aBv = sd;
        this.BSW = true;
        boolean zPA = this.SD.pA(sd, getContext().getApplicationContext());
        this.BSW = false;
        if (getDrawable() != this.SD || zPA) {
            if (!zPA) {
                XT();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<Object> it = this.DX.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public SD getComposition() {
        return this.aBv;
    }

    public void pA() {
        if (this.Sd == 0) {
            this.Sd = SystemClock.elapsedRealtime();
        }
        this.Sn.add(ZZv.PLAY_OPTION);
        this.SD.BSW();
    }

    public void setMinFrame(int i) {
        this.SD.pA(i);
    }

    public float getMinFrame() {
        return this.SD.Sn();
    }

    public void setMinProgress(float f) {
        this.SD.pA(f);
    }

    public void setMaxFrame(int i) {
        this.SD.Og(i);
    }

    public float getMaxFrame() {
        return this.SD.DX();
    }

    public void setMaxProgress(float f) {
        this.SD.Og(f);
    }

    public void setMinFrame(String str) {
        this.SD.Og(str);
    }

    public void setMaxFrame(String str) {
        this.SD.KZx(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.SD.ZZv(str);
    }

    public void setSpeed(float f) {
        this.SD.KZx(f);
    }

    public float getSpeed() {
        return this.SD.oX();
    }

    public void pA(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.SD.pA(animatorUpdateListener);
    }

    public void Og(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.SD.Og(animatorUpdateListener);
    }

    public void Og() {
        this.SD.aBv();
    }

    public void pA(Animator.AnimatorListener animatorListener) {
        this.SD.pA(animatorListener);
    }

    public void Og(Animator.AnimatorListener animatorListener) {
        this.SD.Og(animatorListener);
    }

    public void KZx() {
        this.SD.XT();
    }

    @Deprecated
    public void pA(boolean z) {
        this.SD.ML(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.Sn.add(ZZv.SET_REPEAT_MODE);
        this.SD.ZZv(i);
    }

    public int getRepeatMode() {
        return this.SD.vZF();
    }

    public void setRepeatCount(int i) {
        this.Sn.add(ZZv.SET_REPEAT_COUNT);
        this.SD.ML(i);
    }

    public int getRepeatCount() {
        return this.SD.Sd();
    }

    public boolean ZZv() {
        return this.SD.TX();
    }

    public void setImageAssetsFolder(String str) {
        this.SD.pA(str);
    }

    public String getImageAssetsFolder() {
        return this.SD.ZZv();
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.SD.Og(z);
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.SD.ML();
    }

    public Bitmap pA(String str, Bitmap bitmap) {
        return this.SD.pA(str, bitmap);
    }

    public void setImageAssetDelegate(com.bytedance.adsdk.Og.ZZv zZv) {
        this.SD.pA(zZv);
    }

    public void setDefaultFontFileExtension(String str) {
        this.SD.SD(str);
    }

    public void setFontAssetDelegate(com.bytedance.adsdk.Og.KZx kZx) {
        this.SD.pA(kZx);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.SD.pA(map);
    }

    public void setTextDelegate(vZF vzf) {
        this.SD.pA(vzf);
    }

    public void ML() {
        this.Sn.add(ZZv.PLAY_OPTION);
        this.SD.eG();
    }

    public void JG() {
        this.WV = false;
        this.SD.roi();
    }

    public void setFrame(int i) {
        this.SD.KZx(i);
    }

    public int getFrame() {
        return this.SD.yFO();
    }

    public void setProgress(float f) {
        pA(f, true);
    }

    private void pA(float f, boolean z) {
        if (z) {
            this.Sn.add(ZZv.SET_PROGRESS);
        }
        this.SD.ZZv(f);
    }

    public float getProgress() {
        return this.SD.Mc();
    }

    public long getDuration() {
        SD sd = this.aBv;
        if (sd != null) {
            return (long) sd.ML();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.SD.KZx(z);
    }

    public XT getPerformanceTracker() {
        return this.SD.omh();
    }

    private void aBv() {
        this.aBv = null;
        this.SD.SGo();
    }

    public void setSafeMode(boolean z) {
        this.SD.JG(z);
    }

    public void setRenderMode(yFO yfo) {
        this.SD.pA(yfo);
    }

    public yFO getRenderMode() {
        return this.SD.JG();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.SD.ML(z);
    }

    private void XT() {
        boolean zZZv = ZZv();
        setImageDrawable(null);
        setImageDrawable(this.SD);
        if (zZZv) {
            this.SD.Wx();
        }
    }

    private static class KZx extends View.BaseSavedState {
        public static final Parcelable.Creator<KZx> CREATOR = new Parcelable.Creator<KZx>() { // from class: com.bytedance.adsdk.Og.JG.KZx.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public KZx createFromParcel(Parcel parcel) {
                return new KZx(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public KZx[] newArray(int i) {
                return new KZx[i];
            }
        };
        int JG;
        float KZx;
        String ML;
        int Og;
        int SD;
        boolean ZZv;
        String pA;

        KZx(Parcelable parcelable) {
            super(parcelable);
        }

        private KZx(Parcel parcel) {
            super(parcel);
            this.pA = parcel.readString();
            this.KZx = parcel.readFloat();
            this.ZZv = parcel.readInt() == 1;
            this.ML = parcel.readString();
            this.JG = parcel.readInt();
            this.SD = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.pA);
            parcel.writeFloat(this.KZx);
            parcel.writeInt(this.ZZv ? 1 : 0);
            parcel.writeString(this.ML);
            parcel.writeInt(this.JG);
            parcel.writeInt(this.SD);
        }
    }

    public void setLottieClicklistener(Og og) {
        this.IG = og;
    }

    public void setLottieAnimListener(pA pAVar) {
        this.lT = pAVar;
    }
}
