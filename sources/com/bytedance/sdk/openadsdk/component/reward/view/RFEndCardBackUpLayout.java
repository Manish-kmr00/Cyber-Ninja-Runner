package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.vZF;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.aBv;
import com.bytedance.sdk.openadsdk.core.widget.oX;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class RFEndCardBackUpLayout extends com.bytedance.sdk.openadsdk.core.ML.KZx {
    private static final String TAG = "TTAD.RFEndCardBackUpL";
    private com.bytedance.sdk.openadsdk.component.reward.pA.pA adContext;
    private PAGLogoView adLogo;
    private aBv ivIcon;
    private boolean mInit;
    private oX rbScore;
    private int shownAdCount;
    private com.bytedance.sdk.openadsdk.core.ML.omh tvDesc;
    private com.bytedance.sdk.openadsdk.core.ML.omh tvDownload;
    private TextView tvTitle;

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

    public RFEndCardBackUpLayout(Context context) {
        super(context);
        setVisibility(8);
        setId(Sn.rtW);
    }

    public void init(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        this.adContext = pAVar;
        if (pAVar.Og.rjD()) {
            initViews();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            initViews();
        }
    }

    private void initViews() {
        if (this.mInit) {
            return;
        }
        this.mInit = true;
        if (this.adContext.Og.fS() && this.shownAdCount > 1) {
            initOneSlotMultipleAdsLayout();
            return;
        }
        yFO yfo = this.adContext.Og;
        if (yfo.rjD()) {
            initViewsForVast();
        } else {
            initViewsDefault();
            initData(yfo, this.tvDownload);
        }
    }

    private void initData(yFO yfo, com.bytedance.sdk.openadsdk.core.ML.omh omhVar) {
        setDownloadButtonData(omhVar, yfo, -1);
        bindIconData(this.ivIcon, yfo);
        aBv abv = this.ivIcon;
        if (abv != null) {
            abv.setOnClickListener(this.adContext.roi.ML());
        }
        oX oXVar = this.rbScore;
        if (oXVar != null) {
            Vgu.pA((TextView) null, oXVar, yfo);
            if (yfo.Wo() != null) {
                this.rbScore.setVisibility(0);
            }
            this.rbScore.setOnClickListener(this.adContext.roi.ML());
        }
        if (this.tvTitle != null) {
            if (yfo.Wo() != null && !TextUtils.isEmpty(yfo.Wo().Og())) {
                this.tvTitle.setText(yfo.Wo().Og());
            } else if (!TextUtils.isEmpty(yfo.HSv())) {
                this.tvTitle.setText(yfo.HSv());
            } else {
                this.tvTitle.setVisibility(8);
            }
            this.tvTitle.setOnClickListener(this.adContext.roi.ML());
        }
        if (this.tvDesc != null) {
            String strSXO = yfo.SXO();
            if (!TextUtils.isEmpty(strSXO)) {
                this.tvDesc.setText(strSXO);
            } else {
                this.tvDesc.setVisibility(8);
            }
            this.tvDesc.setOnClickListener(this.adContext.roi.ML());
        }
        this.adLogo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/view/RFEndCardBackUpLayout$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_RFEndCardBackUpLayout$1_onClick_e3cd0b4f7141da5a0d1c7900657d88b3(view);
            }

            public void safedk_RFEndCardBackUpLayout$1_onClick_e3cd0b4f7141da5a0d1c7900657d88b3(View p0) {
                try {
                    TTWebsiteActivity.pA(RFEndCardBackUpLayout.this.adContext.SzT, RFEndCardBackUpLayout.this.adContext.Og, RFEndCardBackUpLayout.this.adContext.ML);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void bindIconData(com.bytedance.sdk.openadsdk.core.ML.ZZv zZv, yFO yfo) {
        if (zZv == null || yfo.fJy() == null || TextUtils.isEmpty(yfo.fJy().pA())) {
            return;
        }
        com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(yfo.fJy(), zZv, yfo);
    }

    private void bindTitleData(TextView textView, yFO yfo, String str) {
        if (textView != null) {
            if (yfo.Wo() != null && !TextUtils.isEmpty(yfo.Wo().Og())) {
                textView.setText(yfo.Wo().Og());
            } else {
                textView.setText(str);
            }
        }
    }

    private void initOneSlotMultipleAdsLayout() {
        Context context = getContext();
        setBackgroundColor(Color.parseColor("#C2FFFFFF"));
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(Vgu.KZx(context, 16.0f), 0, Vgu.KZx(context, 16.0f), 0);
        layoutParams.gravity = 17;
        addView(ml, layoutParams);
        if (this.adContext.YkC == 2) {
            com.bytedance.sdk.openadsdk.core.ML.ML ml2 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
            ml2.setOrientation(0);
            ml.addView(ml2, new FrameLayout.LayoutParams(-1, -2));
            initOneSlotMultipleAdsLayoutLandscape(ml2, this.shownAdCount);
        } else if (this.shownAdCount == 2) {
            initOneSlotMultipleAdsLayoutForTwoAdVertical(ml);
        } else {
            initOneSlotMultipleAdsLayoutForThreeAdVertical(ml);
        }
        PAGLogoView pAGLogoView = new PAGLogoView(this.adContext.SzT);
        pAGLogoView.setId(520093757);
        ml.addView(pAGLogoView);
        pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/view/RFEndCardBackUpLayout$2;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_RFEndCardBackUpLayout$2_onClick_44d18a2021a676cfae96a2f3caf48cf7(view);
            }

            public void safedk_RFEndCardBackUpLayout$2_onClick_44d18a2021a676cfae96a2f3caf48cf7(View p0) {
                TTWebsiteActivity.pA(RFEndCardBackUpLayout.this.adContext.SzT, RFEndCardBackUpLayout.this.adContext.Og, RFEndCardBackUpLayout.this.adContext.ML);
            }
        });
    }

    private void initOneSlotMultipleAdsLayoutLandscape(com.bytedance.sdk.openadsdk.core.ML.ML ml, int i) {
        if (this.adContext.Og instanceof vZF) {
            List<yFO> listZZv = ((vZF) this.adContext.Og).xoO().ZZv();
            for (int i2 = 0; i2 < listZZv.size() && i2 < i && i2 < 3; i2++) {
                initSingleCardInTwoCardStyleLandscape(ml, listZZv.get(i2), i2, i);
            }
        }
    }

    private void initSingleCardInTwoCardStyleLandscape(com.bytedance.sdk.openadsdk.core.ML.ML ml, yFO yfo, int i, int i2) {
        Context context = getContext();
        com.bytedance.sdk.openadsdk.core.ML.ML ml2 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml2.setOrientation(1);
        ml2.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        if (i > 0) {
            layoutParams.setMargins(Vgu.KZx(context, 12.0f), 0, 0, 0);
        }
        ml2.setBackground(new pA(context));
        ml.addView(ml2, layoutParams);
        com.bytedance.sdk.openadsdk.core.ML.ML ml3 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml3.setOrientation(0);
        ml3.setGravity(48);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = Vgu.KZx(context, 20.0f);
        layoutParams2.leftMargin = Vgu.KZx(context, 17.0f);
        layoutParams2.rightMargin = Vgu.KZx(context, 30.0f);
        ml2.addView(ml3, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ML.ZZv abv = new aBv(context);
        ml3.addView(abv, new FrameLayout.LayoutParams(Vgu.KZx(context, 44.0f), Vgu.KZx(context, 44.0f)));
        bindIconData(abv, yfo);
        com.bytedance.sdk.openadsdk.core.ML.ML ml4 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml4.setOrientation(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = Vgu.KZx(context, 7.0f);
        ml3.addView(ml4, layoutParams3);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar.setSingleLine(true);
        omhVar.setEllipsize(TextUtils.TruncateAt.END);
        omhVar.setTextSize(18.0f);
        omhVar.setTextColor(Color.parseColor("#161823"));
        omhVar.setGravity(GravityCompat.START);
        omhVar.setTypeface(null, 1);
        ml4.addView(omhVar, new FrameLayout.LayoutParams(-1, -2));
        bindTitleData(omhVar, yfo, yfo.HSv());
        com.bytedance.sdk.openadsdk.core.ML.ML ml5 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml5.setOrientation(0);
        ml5.setGravity(16);
        ml4.addView(ml5, new FrameLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar2 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar2.setTextSize(16.0f);
        omhVar2.setTextColor(Color.parseColor("#80161823"));
        ml5.addView(omhVar2, new ViewGroup.LayoutParams(-2, -2));
        oX oXVar = new oX(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = Vgu.KZx(context, 8.0f);
        ml5.addView(oXVar, layoutParams4);
        Vgu.pA(omhVar2, oXVar, yfo, 18);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar3 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        if (i2 == 2) {
            omhVar3.setSingleLine(true);
        } else {
            omhVar3.setLines(2);
        }
        omhVar3.setEllipsize(TextUtils.TruncateAt.END);
        omhVar3.setTextSize(16.0f);
        omhVar3.setTextColor(Color.parseColor("#80161823"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        int i3 = layoutParams2.leftMargin;
        layoutParams5.rightMargin = i3;
        layoutParams5.leftMargin = i3;
        layoutParams5.topMargin = Vgu.KZx(context, 12.0f);
        ml2.addView(omhVar3, layoutParams5);
        bindDescData(omhVar3, yfo);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar4 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar4.setGravity(17);
        omhVar4.setId(520093707);
        omhVar4.setText(com.bytedance.sdk.component.utils.yFO.pA(context, "tt_video_download_apk"));
        omhVar4.setTextColor(-1);
        omhVar4.setTextSize(2, 16.0f);
        omhVar4.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_reward_full_video_backup_btn_bg"));
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, Vgu.KZx(context, 36.0f));
        layoutParams6.setMargins(Vgu.KZx(context, 20.0f), Vgu.KZx(context, 22.0f), Vgu.KZx(context, 20.0f), Vgu.KZx(context, 20.0f));
        ml2.addView(omhVar4, layoutParams6);
        setDownloadButtonData(omhVar4, yfo, i);
    }

    private void initOneSlotMultipleAdsLayoutForThreeAdVertical(com.bytedance.sdk.openadsdk.core.ML.ML ml) {
        if (this.adContext.Og instanceof vZF) {
            List<yFO> listZZv = ((vZF) this.adContext.Og).xoO().ZZv();
            for (int i = 0; i < listZZv.size() && i < 3; i++) {
                initSingleCardInThreeCardStyle(ml, listZZv.get(i), i);
            }
        }
    }

    private void initSingleCardInThreeCardStyle(com.bytedance.sdk.openadsdk.core.ML.ML ml, yFO yfo, int i) {
        Context context = getContext();
        com.bytedance.sdk.openadsdk.core.ML.ML ml2 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml2.setOrientation(1);
        ml2.setGravity(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, i > 0 ? Vgu.KZx(context, 12.0f) : 0, 0, 0);
        ml2.setBackground(new pA(context));
        ml.addView(ml2, layoutParams);
        com.bytedance.sdk.openadsdk.core.ML.ML ml3 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml3.setOrientation(0);
        ml3.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = Vgu.KZx(context, 20.0f);
        layoutParams2.leftMargin = Vgu.KZx(context, 17.0f);
        layoutParams2.rightMargin = Vgu.KZx(context, 30.0f);
        ml2.addView(ml3, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ML.ZZv abv = new aBv(context);
        ml3.addView(abv, new FrameLayout.LayoutParams(Vgu.KZx(context, 70.0f), Vgu.KZx(context, 63.0f)));
        bindIconData(abv, yfo);
        com.bytedance.sdk.openadsdk.core.ML.ML ml4 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml4.setOrientation(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = Vgu.KZx(context, 7.0f);
        ml3.addView(ml4, layoutParams3);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar.setSingleLine(true);
        omhVar.setEllipsize(TextUtils.TruncateAt.END);
        omhVar.setTextSize(18.0f);
        omhVar.setTextColor(Color.parseColor("#161823"));
        omhVar.setGravity(GravityCompat.START);
        omhVar.setTypeface(null, 1);
        ml4.addView(omhVar, new FrameLayout.LayoutParams(-1, -2));
        bindTitleData(omhVar, yfo, yfo.HSv());
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar2 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar2.setSingleLine(true);
        omhVar2.setEllipsize(TextUtils.TruncateAt.END);
        omhVar2.setTextSize(16.0f);
        omhVar2.setTextColor(Color.parseColor("#80161823"));
        ml4.addView(omhVar2, new FrameLayout.LayoutParams(-1, -2));
        bindDescData(omhVar2, yfo);
        com.bytedance.sdk.openadsdk.core.ML.ML ml5 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml5.setOrientation(0);
        ml5.setGravity(16);
        ml4.addView(ml5, new FrameLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar3 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar3.setTextSize(16.0f);
        omhVar3.setTextColor(Color.parseColor("#80161823"));
        ml5.addView(omhVar3, new ViewGroup.LayoutParams(-2, -2));
        oX oXVar = new oX(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = Vgu.KZx(context, 8.0f);
        ml5.addView(oXVar, layoutParams4);
        Vgu.pA(omhVar3, oXVar, yfo, 18);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar4 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar4.setGravity(17);
        omhVar4.setId(520093707);
        omhVar4.setText(com.bytedance.sdk.component.utils.yFO.pA(context, "tt_video_download_apk"));
        omhVar4.setTextColor(-1);
        omhVar4.setTextSize(2, 16.0f);
        omhVar4.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_reward_full_video_backup_btn_bg"));
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, Vgu.KZx(context, 36.0f));
        layoutParams5.setMargins(Vgu.KZx(context, 20.0f), Vgu.KZx(context, 22.0f), Vgu.KZx(context, 20.0f), Vgu.KZx(context, 20.0f));
        ml2.addView(omhVar4, layoutParams5);
        setDownloadButtonData(omhVar4, yfo, i);
    }

    private void initOneSlotMultipleAdsLayoutForTwoAdVertical(com.bytedance.sdk.openadsdk.core.ML.ML ml) {
        if (this.adContext.Og instanceof vZF) {
            List<yFO> listZZv = ((vZF) this.adContext.Og).xoO().ZZv();
            for (int i = 0; i < listZZv.size() && i < 2; i++) {
                initSingleCardInTwoCardStyle(ml, listZZv.get(i), i);
            }
        }
    }

    private void initSingleCardInTwoCardStyle(com.bytedance.sdk.openadsdk.core.ML.ML ml, yFO yfo, int i) {
        Context context = getContext();
        com.bytedance.sdk.openadsdk.core.ML.ML ml2 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml2.setOrientation(1);
        ml2.setGravity(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, i > 0 ? Vgu.KZx(context, 12.0f) : 0, 0, 0);
        ml2.setBackground(new pA(context));
        ml.addView(ml2, layoutParams);
        com.bytedance.sdk.openadsdk.core.ML.ZZv abv = new aBv(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(Vgu.KZx(context, 70.0f), Vgu.KZx(context, 63.0f));
        layoutParams2.setMargins(0, Vgu.KZx(context, 24.0f), 0, Vgu.KZx(context, 12.0f));
        ml2.addView(abv, layoutParams2);
        bindIconData(abv, yfo);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar.setSingleLine(true);
        omhVar.setEllipsize(TextUtils.TruncateAt.END);
        omhVar.setTextSize(18.0f);
        omhVar.setTextColor(Color.parseColor("#161823"));
        omhVar.setGravity(17);
        omhVar.setTypeface(null, 1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(Vgu.KZx(context, 56.0f), 0, Vgu.KZx(context, 56.0f), 0);
        ml2.addView(omhVar, layoutParams3);
        bindTitleData(omhVar, yfo, yfo.HSv());
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar2 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar2.setSingleLine(true);
        omhVar2.setEllipsize(TextUtils.TruncateAt.END);
        omhVar2.setTextSize(16.0f);
        omhVar2.setTextColor(Color.parseColor("#80161823"));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins(Vgu.KZx(context, 56.0f), Vgu.KZx(context, 4.0f), Vgu.KZx(context, 56.0f), 0);
        ml2.addView(omhVar2, layoutParams4);
        bindDescData(omhVar2, yfo);
        com.bytedance.sdk.openadsdk.core.ML.ML ml3 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml3.setOrientation(0);
        ml3.setGravity(16);
        ml2.addView(ml3, new FrameLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar3 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar3.setTextSize(16.0f);
        omhVar3.setTextColor(Color.parseColor("#80161823"));
        ml3.addView(omhVar3, new ViewGroup.LayoutParams(-2, -2));
        oX oXVar = new oX(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = Vgu.KZx(context, 8.0f);
        ml3.addView(oXVar, layoutParams5);
        Vgu.pA(omhVar3, oXVar, yfo, 18);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar4 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar4.setGravity(17);
        omhVar4.setId(520093707);
        omhVar4.setText(com.bytedance.sdk.component.utils.yFO.pA(context, "tt_video_download_apk"));
        omhVar4.setTextColor(-1);
        omhVar4.setTextSize(2, 16.0f);
        omhVar4.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_reward_full_video_backup_btn_bg"));
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, Vgu.KZx(context, 36.0f));
        layoutParams6.setMargins(Vgu.KZx(context, 20.0f), Vgu.KZx(context, 36.0f), Vgu.KZx(context, 20.0f), Vgu.KZx(context, 20.0f));
        ml2.addView(omhVar4, layoutParams6);
        setDownloadButtonData(omhVar4, yfo, i);
    }

    private void bindDescData(com.bytedance.sdk.openadsdk.core.ML.omh omhVar, yFO yfo) {
        if (omhVar == null) {
            return;
        }
        String strFw = yfo.fw();
        if (TextUtils.isEmpty(strFw)) {
            return;
        }
        omhVar.setText(strFw);
    }

    private void setDownloadButtonData(com.bytedance.sdk.openadsdk.core.ML.omh omhVar, yFO yfo, int i) {
        com.bytedance.sdk.openadsdk.core.Og.ML mlPA = this.adContext.roi.pA(this.adContext, yfo);
        mlPA.pA(com.bytedance.sdk.openadsdk.XT.pA.pA.SD.pA(this.adContext.SzT, yfo, this.adContext.ML));
        if (i != -1) {
            HashMap map = new HashMap();
            map.put("ad_show_order", Integer.valueOf(i + 1));
            mlPA.pA(map);
        }
        omhVar.setOnClickListener(mlPA);
        omhVar.setOnTouchListener(mlPA);
        CharSequence charSequenceGy = yfo.gy();
        if (TextUtils.isEmpty(charSequenceGy)) {
            return;
        }
        omhVar.setText(charSequenceGy);
    }

    private void initViewsForVast() {
        Context context = getContext();
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv.setId(Sn.omh);
        zZv.setVisibility(8);
        addView(zZv, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.component.Bzk.ZZv zZv2 = new com.bytedance.sdk.component.Bzk.ZZv(context, true);
        zZv2.setVisibility(8);
        zZv2.setId(Sn.Bzk);
        addView(zZv2, new FrameLayout.LayoutParams(-1, -1));
    }

    private void initViewsDefault() {
        FrameLayout.LayoutParams layoutParams;
        Context context = getContext();
        boolean z = this.adContext.Og.rtW() == 1;
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setGravity(1);
        ml.setOrientation(1);
        if (z) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(Vgu.KZx(context, 327.0f), -2);
        }
        layoutParams.gravity = 17;
        int iKZx = Vgu.KZx(context, 24.0f);
        layoutParams.rightMargin = iKZx;
        layoutParams.leftMargin = iKZx;
        addView(ml, layoutParams);
        aBv abv = new aBv(context);
        this.ivIcon = abv;
        abv.setBackgroundColor(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(Vgu.KZx(context, 80.0f), Vgu.KZx(context, 80.0f));
        layoutParams2.bottomMargin = Vgu.KZx(context, 12.0f);
        ml.addView(this.ivIcon, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.tvTitle = omhVar;
        omhVar.setEllipsize(TextUtils.TruncateAt.END);
        this.tvTitle.setGravity(17);
        this.tvTitle.setMaxLines(2);
        this.tvTitle.setMaxWidth(Vgu.KZx(context, 180.0f));
        this.tvTitle.setTextColor(-1);
        this.tvTitle.setTextSize(2, 24.0f);
        ml.addView(this.tvTitle, new LinearLayout.LayoutParams(-1, -2));
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar2 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.tvDesc = omhVar2;
        omhVar2.setEllipsize(TextUtils.TruncateAt.END);
        this.tvDesc.setGravity(17);
        this.tvDesc.setMaxLines(2);
        this.tvDesc.setTextColor(Color.parseColor("#BFFFFFFF"));
        this.tvDesc.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = Vgu.KZx(context, 8.0f);
        ml.addView(this.tvDesc, layoutParams3);
        this.rbScore = new oX(context, true);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, Vgu.KZx(context, 16.0f));
        layoutParams4.topMargin = Vgu.KZx(context, 12.0f);
        this.rbScore.setVisibility(8);
        ml.addView(this.rbScore, layoutParams4);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar3 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.tvDownload = omhVar3;
        omhVar3.setId(520093707);
        this.tvDownload.setGravity(17);
        this.tvDownload.setText(com.bytedance.sdk.component.utils.yFO.pA(context, "tt_video_download_apk"));
        this.tvDownload.setTextColor(-1);
        this.tvDownload.setTextSize(2, 16.0f);
        this.tvDownload.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_reward_full_video_backup_btn_bg"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, Vgu.KZx(context, 44.0f));
        layoutParams5.topMargin = Vgu.KZx(context, 54.0f);
        ml.addView(this.tvDownload, layoutParams5);
        this.adLogo = new PAGLogoView(context);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, Vgu.KZx(context, 14.0f));
        layoutParams6.gravity = 8388691;
        layoutParams6.leftMargin = Vgu.KZx(context, 18.0f);
        if (z) {
            layoutParams6.bottomMargin = Vgu.KZx(context, 61.0f);
        } else {
            layoutParams6.bottomMargin = Vgu.KZx(context, 24.0f);
        }
        addView(this.adLogo, layoutParams6);
    }

    public void setShownAdCount(int i) {
        this.shownAdCount = i;
    }

    private static final class pA extends Drawable {
        private final int KZx;
        private final Drawable Og;
        Path pA = new Path();

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public pA(Context context) {
            this.Og = com.bytedance.sdk.component.utils.yFO.KZx(context, "tt_ad_bg_header_gradient");
            this.KZx = Vgu.KZx(context, 8.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.clipPath(this.pA);
            canvas.drawColor(-1);
            this.Og.draw(canvas);
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, i2, i3, i4);
            float f = i3;
            this.Og.setBounds(i, i2, i3, (int) (((1.0f * f) / this.Og.getIntrinsicWidth()) * this.Og.getIntrinsicHeight()));
            this.pA.reset();
            Path path = this.pA;
            RectF rectF = new RectF(0.0f, 0.0f, f, i4);
            int i5 = this.KZx;
            path.addRoundRect(rectF, i5, i5, Path.Direction.CCW);
        }
    }
}
