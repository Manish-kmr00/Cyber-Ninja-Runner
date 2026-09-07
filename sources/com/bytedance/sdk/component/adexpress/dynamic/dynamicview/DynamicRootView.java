package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class DynamicRootView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.ZZv, com.bytedance.sdk.component.adexpress.theme.pA {
    private String bgColor;
    private Map<Integer, String> bgMaterialCenterCalcColor;
    private ML dynamicBaseWidget;
    private int logoUnionHeight;
    private Context mContext;
    private com.bytedance.sdk.component.adexpress.dynamic.JG.pA mDynamicClickListener;
    boolean mIsMute;
    private ThemeStatusBroadcastReceiver mReceiver;
    private com.bytedance.sdk.component.adexpress.Og.BSW mRenderListener;
    private com.bytedance.sdk.component.adexpress.Og.Wx mRenderRequest;
    private ViewGroup mTimeOut;
    private com.bytedance.sdk.component.adexpress.dynamic.Og muteListener;
    protected final com.bytedance.sdk.component.adexpress.Og.Sn renderResult;
    private int scoreCountWithIcon;
    private List<com.bytedance.sdk.component.adexpress.dynamic.KZx> timeOutListener;
    private int timedown;
    private com.bytedance.sdk.component.adexpress.dynamic.ML videoListener;
    public View videoView;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.Og.Wx wx, com.bytedance.sdk.component.adexpress.dynamic.JG.pA pAVar) {
        super(context);
        this.mTimeOut = null;
        this.timedown = 0;
        this.timeOutListener = new ArrayList();
        this.logoUnionHeight = 0;
        this.scoreCountWithIcon = 0;
        this.mContext = context;
        com.bytedance.sdk.component.adexpress.Og.Sn sn = new com.bytedance.sdk.component.adexpress.Og.Sn();
        this.renderResult = sn;
        sn.pA(2);
        this.mDynamicClickListener = pAVar;
        pAVar.pA(this);
        this.mReceiver = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.pA(this);
        this.mIsMute = z;
        this.mRenderRequest = wx;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public void setRenderListener(com.bytedance.sdk.component.adexpress.Og.BSW bsw) {
        this.mRenderListener = bsw;
        this.mDynamicClickListener.pA(bsw);
    }

    public void render(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar, int i) {
        this.dynamicBaseWidget = renderDynamicView(omhVar, this, i);
        this.renderResult.pA(true);
        this.renderResult.pA(this.dynamicBaseWidget.ML);
        this.renderResult.Og(this.dynamicBaseWidget.JG);
        this.renderResult.pA(this.videoView);
        this.mRenderListener.pA(this.renderResult);
    }

    public ML renderDynamicView(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar, ViewGroup viewGroup, int i) {
        if (omhVar == null) {
            return null;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> listBSW = omhVar.BSW();
        ML mlPA = com.bytedance.sdk.component.adexpress.dynamic.pA.Og.pA(this.mContext, this, omhVar);
        if (mlPA instanceof lT) {
            callBackRenderFail(i == 3 ? 128 : Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, "unknow widget");
            return null;
        }
        checkCanOpenLandingPage(omhVar);
        mlPA.KZx();
        if (viewGroup != null) {
            viewGroup.addView(mlPA);
            setClipChildren(viewGroup, omhVar);
        }
        if (listBSW == null || listBSW.size() <= 0) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> it = listBSW.iterator();
        while (it.hasNext()) {
            renderDynamicView(it.next(), mlPA, i);
        }
        return mlPA;
    }

    private void checkCanOpenLandingPage(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML;
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.ML mlSGo = omhVar.SGo();
        if (mlSGo == null || (jgML = mlSGo.ML()) == null) {
            return;
        }
        this.renderResult.Og(jgML.sPI());
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.bgMaterialCenterCalcColor;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.bgMaterialCenterCalcColor = map;
    }

    private void setClipChildren(ViewGroup viewGroup, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !omhVar.WQf()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void updateRenderInfoForVideo(double d, double d2, double d3, double d4, float f) {
        this.renderResult.KZx(d);
        this.renderResult.ZZv(d2);
        this.renderResult.ML(d3);
        this.renderResult.JG(d4);
        this.renderResult.pA(f);
        this.renderResult.Og(f);
        this.renderResult.KZx(f);
        this.renderResult.ZZv(f);
    }

    public void callBackRenderFail(int i, String str) {
        this.renderResult.pA(false);
        this.renderResult.Og(i);
        this.renderResult.pA(str);
        this.mRenderListener.pA(this.renderResult);
    }

    public void setMuteListener(com.bytedance.sdk.component.adexpress.dynamic.Og og) {
        this.muteListener = og;
    }

    public void setDislikeView(View view) {
        this.mDynamicClickListener.Og(view);
    }

    public com.bytedance.sdk.component.adexpress.Og.BSW getRenderListener() {
        return this.mRenderListener;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.JG.pA getDynamicClickListener() {
        return this.mDynamicClickListener;
    }

    private boolean checkSizeValid() {
        return this.dynamicBaseWidget.ML > 0.0f && this.dynamicBaseWidget.JG > 0.0f;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.pA
    public void onThemeChanged(int i) {
        ML ml = this.dynamicBaseWidget;
        if (ml == null) {
            return;
        }
        ml.pA(i);
    }

    public void beginShowFromInvisible() {
        beginShowFromInvisible(this.dynamicBaseWidget, 0);
    }

    public void beginHideFromVisible() {
        beginShowFromInvisible(this.dynamicBaseWidget, 4);
    }

    public void beginShowFromInvisible(ML ml, int i) {
        if (ml == null) {
            return;
        }
        if (ml.getBeginInvisibleAndShow()) {
            ml.setVisibility(i);
            if (ml.DX != null) {
                ml.DX.setVisibility(i);
            }
        }
        int childCount = ml.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (ml.getChildAt(i2) instanceof ML) {
                beginShowFromInvisible((ML) ml.getChildAt(i2), i);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void setTime(CharSequence charSequence, int i, int i2, boolean z) {
        for (int i3 = 0; i3 < this.timeOutListener.size(); i3++) {
            if (this.timeOutListener.get(i3) != null) {
                this.timeOutListener.get(i3).pA(charSequence, i == 1, i2, z);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void setSoundMute(boolean z) {
        com.bytedance.sdk.component.adexpress.dynamic.Og og = this.muteListener;
        if (og != null) {
            og.setSoundMute(z);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void setTimeUpdate(int i) {
        this.videoListener.setTimeUpdate(i);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ZZv
    public void onvideoComplate() {
        try {
            this.videoListener.pA();
        } catch (Exception unused) {
        }
    }

    public ViewGroup getTimeOut() {
        return this.mTimeOut;
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.mTimeOut = viewGroup;
    }

    public int getTimedown() {
        return this.timedown;
    }

    public void setTimedown(int i) {
        this.timedown = i;
    }

    public List<com.bytedance.sdk.component.adexpress.dynamic.KZx> getTimeOutListener() {
        return this.timeOutListener;
    }

    public void setTimeOutListener(com.bytedance.sdk.component.adexpress.dynamic.KZx kZx) {
        this.timeOutListener.add(kZx);
    }

    public void setVideoListener(com.bytedance.sdk.component.adexpress.dynamic.ML ml) {
        this.videoListener = ml;
    }

    public int getScoreCountWithIcon() {
        return this.scoreCountWithIcon;
    }

    public void setScoreCountWithIcon(int i) {
        this.scoreCountWithIcon = i;
    }

    public int getLogoUnionHeight() {
        return this.logoUnionHeight;
    }

    public void setLogoUnionHeight(int i) {
        this.logoUnionHeight = i;
    }

    public com.bytedance.sdk.component.adexpress.Og.Wx getRenderRequest() {
        return this.mRenderRequest;
    }
}
