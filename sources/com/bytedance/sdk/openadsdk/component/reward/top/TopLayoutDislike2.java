package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.ML.ML;
import com.bytedance.sdk.openadsdk.core.ML.ZZv;
import com.bytedance.sdk.openadsdk.core.ML.omh;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.core.widget.SD;
import com.bytedance.sdk.openadsdk.utils.Bzk;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes7.dex */
public class TopLayoutDislike2 extends ML implements pA<TopLayoutDislike2> {
    private boolean hasCutDown;
    private boolean hasShowClose;
    private boolean isVast;
    private ZZv mCloseBtn;
    private View mImgDislike;
    private ImageView mImgSound;
    private boolean mIsSoundMute;
    private CharSequence mProgressStr;
    private ImageView mSkipIV;
    private TextView mTextViewCountDown;
    private Og mTopListener;
    private boolean shouldShowSkipTime;
    private int skipTime;
    private int videoDuration;

    public void clickDislike() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.ML, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public TopLayoutDislike2(Context context) {
        this(context, null);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgressStr = "";
        setOrientation(0);
    }

    public void setShouldShowSkipTime(boolean z) {
        this.shouldShowSkipTime = z;
    }

    public TopLayoutDislike2 load(yFO yfo) {
        initView();
        this.mImgDislike.setVisibility(0);
        ((ImageView) this.mImgDislike).setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(aBv.pA(), "tt_reward_full_feedback"));
        if (!oX.vkV().Sn(String.valueOf(yfo.Wf())) || yfo.aBv() == 5 || yfo.aBv() == 6) {
            this.mSkipIV.setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(aBv.pA(), "tt_close_btn"));
        } else {
            this.mSkipIV.setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(aBv.pA(), "tt_skip_btn"));
        }
        if (this.mSkipIV.getDrawable() != null) {
            this.mSkipIV.getDrawable().setAutoMirrored(true);
        }
        this.mSkipIV.setVisibility(8);
        this.videoDuration = yfo.Bf() == null ? 0 : ((int) yfo.Bf().JG()) * yfo.Bf().TX();
        if (com.bytedance.sdk.openadsdk.core.model.aBv.ZZv(yfo) && yfo.Bzk() != null) {
            this.videoDuration = (int) yfo.Bzk().Og();
        } else if (com.bytedance.sdk.openadsdk.core.model.aBv.ML(yfo) && yfo.Bzk() != null) {
            this.videoDuration = (int) yfo.Bzk().ZZv();
        }
        if (this.videoDuration <= 0) {
            this.videoDuration = 10;
        }
        if (yfo.PKZ() == 8 && yfo.rB() != null) {
            this.skipTime = aBv.ZZv().yFO(yfo.rB().getCodeId());
        } else {
            this.skipTime = aBv.ZZv().SGo(yfo.rB().getCodeId());
        }
        if (WQf.KZx(yfo)) {
            this.skipTime = aBv.ZZv().pA(String.valueOf(yfo.Wf()), yfo.kK());
            this.videoDuration = yfo.mK();
        }
        int i = this.skipTime;
        this.shouldShowSkipTime = i == -1 || i >= this.videoDuration;
        if (yfo.rjD()) {
            this.mImgDislike.setVisibility(8);
            this.isVast = true;
        }
        this.mTextViewCountDown.setVisibility(4);
        this.mTextViewCountDown.setText("");
        this.mTextViewCountDown.setEnabled(false);
        this.mTextViewCountDown.setClickable(false);
        initListener();
        return this;
    }

    private ImageView getCommonRingBGImageView() {
        ZZv zZv = new ZZv(getContext());
        int iKZx = Vgu.KZx(getContext(), 5.0f);
        zZv.setPadding(iKZx, iKZx, iKZx, iKZx);
        zZv.setScaleType(ImageView.ScaleType.CENTER);
        zZv.setBackground(com.bytedance.sdk.openadsdk.core.widget.ZZv.pA());
        return zZv;
    }

    private void initView() {
        int iKZx = Vgu.KZx(getContext(), 16.0f);
        int iKZx2 = Vgu.KZx(getContext(), 20.0f);
        int iKZx3 = Vgu.KZx(getContext(), 28.0f);
        this.mImgSound = getCommonRingBGImageView();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iKZx3, iKZx3);
        layoutParams.leftMargin = iKZx;
        layoutParams.topMargin = iKZx2;
        this.mImgSound.setLayoutParams(layoutParams);
        ImageView commonRingBGImageView = getCommonRingBGImageView();
        this.mImgDislike = commonRingBGImageView;
        commonRingBGImageView.setId(520093713);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iKZx3, iKZx3);
        layoutParams2.topMargin = iKZx2;
        layoutParams2.leftMargin = iKZx;
        this.mImgDislike.setLayoutParams(layoutParams2);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 0);
        layoutParams3.weight = 1.0f;
        view.setLayoutParams(layoutParams3);
        omh omhVar = new omh(getContext());
        this.mTextViewCountDown = omhVar;
        omhVar.setBackground(com.bytedance.sdk.openadsdk.core.widget.ZZv.Og());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, Vgu.KZx(getContext(), 28.0f));
        layoutParams4.topMargin = Vgu.KZx(getContext(), 20.0f);
        int iKZx4 = Vgu.KZx(getContext(), 16.0f);
        layoutParams2.rightMargin = iKZx4;
        layoutParams4.rightMargin = iKZx4;
        int iKZx5 = Vgu.KZx(getContext(), 12.0f);
        Vgu.KZx(getContext(), 5.0f);
        this.mTextViewCountDown.setPadding(iKZx5, 0, iKZx5, 0);
        this.mTextViewCountDown.setLayoutParams(layoutParams4);
        this.mTextViewCountDown.setGravity(17);
        this.mTextViewCountDown.setTextColor(-1);
        this.mTextViewCountDown.setTextSize(14.0f);
        this.mTextViewCountDown.setVisibility(8);
        ImageView commonRingBGImageView2 = getCommonRingBGImageView();
        this.mSkipIV = commonRingBGImageView2;
        commonRingBGImageView2.setId(520093714);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(iKZx3, iKZx3);
        layoutParams5.topMargin = iKZx2;
        layoutParams5.rightMargin = iKZx;
        this.mSkipIV.setLayoutParams(layoutParams5);
        this.mSkipIV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ZZv zZvOg = SD.Og(getContext());
        this.mCloseBtn = zZvOg;
        zZvOg.setId(520093708);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 8388661;
        layoutParams6.topMargin = Vgu.KZx(getContext(), 20.0f);
        layoutParams6.rightMargin = Vgu.KZx(getContext(), 24.0f);
        this.mCloseBtn.setLayoutParams(layoutParams6);
        this.mCloseBtn.setContentDescription(com.bytedance.sdk.component.utils.yFO.pA(getContext(), "tt_ad_close_text"));
        this.mCloseBtn.setVisibility(8);
        addView(this.mImgSound);
        addView(this.mImgDislike);
        addView(view);
        addView(this.mTextViewCountDown);
        addView(this.mSkipIV);
        addView(this.mCloseBtn);
    }

    private void initListener() {
        View view = this.mImgDislike;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/top/TopLayoutDislike2$1;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view2);
                    safedk_TopLayoutDislike2$1_onClick_07c8465f593befce97bf882266401e5e(view2);
                }

                public void safedk_TopLayoutDislike2$1_onClick_07c8465f593befce97bf882266401e5e(View p0) {
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.KZx(p0);
                    }
                }
            });
        }
        ImageView imageView = this.mImgSound;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/top/TopLayoutDislike2$2;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view2);
                    safedk_TopLayoutDislike2$2_onClick_3ac04b14d259e05ac6c7043f98736e22(view2);
                }

                public void safedk_TopLayoutDislike2$2_onClick_3ac04b14d259e05ac6c7043f98736e22(View p0) {
                    Drawable drawablePA;
                    TopLayoutDislike2 topLayoutDislike2 = TopLayoutDislike2.this;
                    topLayoutDislike2.mIsSoundMute = !topLayoutDislike2.mIsSoundMute;
                    if (TopLayoutDislike2.this.mSkipIV != null) {
                        drawablePA = TopLayoutDislike2.this.mIsSoundMute ? com.bytedance.sdk.component.utils.yFO.KZx(TopLayoutDislike2.this.getContext(), "tt_reward_full_mute") : com.bytedance.sdk.component.utils.yFO.KZx(TopLayoutDislike2.this.getContext(), "tt_reward_full_unmute");
                    } else {
                        drawablePA = TopLayoutDislike2.this.mIsSoundMute ? Bzk.pA(TopLayoutDislike2.this.getContext(), "tt_mute_wrapper") : Bzk.pA(TopLayoutDislike2.this.getContext(), "tt_unmute_wrapper");
                    }
                    TopLayoutDislike2.this.mImgSound.setImageDrawable(drawablePA);
                    if (TopLayoutDislike2.this.mImgSound.getDrawable() != null) {
                        TopLayoutDislike2.this.mImgSound.getDrawable().setAutoMirrored(true);
                    }
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.Og(p0);
                    }
                }
            });
        }
        ImageView imageView2 = this.mSkipIV;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/top/TopLayoutDislike2$3;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view2);
                    safedk_TopLayoutDislike2$3_onClick_27400631db877f6de09e30aa42f2ac4b(view2);
                }

                public void safedk_TopLayoutDislike2$3_onClick_27400631db877f6de09e30aa42f2ac4b(View p0) {
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.pA(p0);
                    }
                }
            });
        } else {
            TextView textView = this.mTextViewCountDown;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/top/TopLayoutDislike2$4;->onClick(Landroid/view/View;)V");
                        CreativeInfoManager.onViewClicked(h.u, view2);
                        safedk_TopLayoutDislike2$4_onClick_bb506814ec67772454de11ab04684503(view2);
                    }

                    public void safedk_TopLayoutDislike2$4_onClick_bb506814ec67772454de11ab04684503(View p0) {
                        if (TopLayoutDislike2.this.mTopListener != null) {
                            TopLayoutDislike2.this.mTopListener.pA(p0);
                        }
                    }
                });
            }
        }
        ZZv zZv = this.mCloseBtn;
        if (zZv != null) {
            zZv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/top/TopLayoutDislike2$5;->onClick(Landroid/view/View;)V");
                    CreativeInfoManager.onViewClicked(h.u, view2);
                    safedk_TopLayoutDislike2$5_onClick_ccdece47b8e4c126ceaafe865e66e5a9(view2);
                }

                public void safedk_TopLayoutDislike2$5_onClick_ccdece47b8e4c126ceaafe865e66e5a9(View p0) {
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.ZZv(p0);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setShowSkip(boolean z) {
        TextView textView = this.mTextViewCountDown;
        if (textView == null) {
            return;
        }
        if (!z) {
            textView.setText("");
        }
        if (this.mSkipIV.getVisibility() == 4) {
            return;
        }
        this.hasShowClose = !z;
        this.mSkipIV.setVisibility((z && this.hasCutDown) ? 0 : 8);
        this.mTextViewCountDown.setVisibility(z & (TextUtils.isEmpty(this.mTextViewCountDown.getText()) ^ true) ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setSkipEnable(boolean z) {
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.setEnabled(z);
            this.mSkipIV.setClickable(z);
            return;
        }
        TextView textView = this.mTextViewCountDown;
        if (textView != null) {
            textView.setEnabled(z);
            this.mTextViewCountDown.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setShowSound(boolean z) {
        ImageView imageView = this.mImgSound;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setSoundMute(boolean z) {
        Drawable drawablePA;
        this.mIsSoundMute = z;
        if (this.mSkipIV != null) {
            if (z) {
                drawablePA = com.bytedance.sdk.component.utils.yFO.KZx(getContext(), "tt_reward_full_mute");
            } else {
                drawablePA = com.bytedance.sdk.component.utils.yFO.KZx(getContext(), "tt_reward_full_unmute");
            }
        } else if (z) {
            drawablePA = Bzk.pA(getContext(), "tt_mute_wrapper");
        } else {
            drawablePA = Bzk.pA(getContext(), "tt_unmute_wrapper");
        }
        this.mImgSound.setImageDrawable(drawablePA);
        if (this.mImgSound.getDrawable() != null) {
            this.mImgSound.getDrawable().setAutoMirrored(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setTime(CharSequence charSequence, CharSequence charSequence2) {
        int i;
        if (!TextUtils.isEmpty(charSequence)) {
            this.mProgressStr = charSequence;
        }
        if (this.mSkipIV == null) {
            return;
        }
        this.hasCutDown = true;
        if (this.shouldShowSkipTime) {
            this.mTextViewCountDown.setText(((Object) this.mProgressStr) + "s");
            updateTime(false);
            return;
        }
        String str = (String) this.mProgressStr;
        try {
            int i2 = this.skipTime;
            if (i2 == 0) {
                i = Integer.parseInt(str);
            } else {
                i = i2 - (this.videoDuration - Integer.parseInt(str));
            }
            if (i > 0) {
                if (this.skipTime == 0) {
                    updateTime(false);
                    return;
                } else {
                    this.mTextViewCountDown.setText(i + "s");
                    updateTime(true);
                    return;
                }
            }
            this.mTextViewCountDown.setText(((Object) this.mProgressStr) + "s");
            updateTime(false);
        } catch (Exception unused) {
        }
    }

    private void updateTime(boolean z) {
        if (this.hasShowClose) {
            return;
        }
        if (this.shouldShowSkipTime) {
            this.mSkipIV.setVisibility(8);
            this.mTextViewCountDown.setVisibility(0);
        } else if (z) {
            this.mTextViewCountDown.setVisibility(0);
            this.mSkipIV.setVisibility(8);
        } else {
            this.mTextViewCountDown.setVisibility(8);
            this.mSkipIV.setVisibility(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setSkipText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.mTextViewCountDown.setText(charSequence);
        if (this.mTextViewCountDown.getVisibility() != 0) {
            this.mTextViewCountDown.setVisibility(0);
        }
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setShowDislike(boolean z) {
        View view = this.mImgDislike;
        if (view == null || this.isVast) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setListener(Og og) {
        this.mTopListener = og;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void clickSkip() {
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.performClick();
        }
        TextView textView = this.mTextViewCountDown;
        if (textView != null) {
            textView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void clickSound() {
        ImageView imageView = this.mImgSound;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void showCountDownText() {
        this.mTextViewCountDown.setVisibility(0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void showSkipButton() {
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this.mTextViewCountDown.setVisibility(8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void showCloseButton() {
        setSkipInvisiable();
        this.mSkipIV.setVisibility(8);
        this.mCloseBtn.setVisibility(0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public View getCloseButton() {
        return this.mCloseBtn;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setSkipInvisiable() {
        this.mTextViewCountDown.setWidth(20);
        this.mTextViewCountDown.setVisibility(4);
        this.mSkipIV.setVisibility(4);
        this.hasShowClose = true;
    }
}
