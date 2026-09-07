package net.pubnative.lite.sdk.vpaid.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import net.pubnative.lite.sdk.CountdownStyle;
import net.pubnative.lite.sdk.utils.ViewUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CountDownViewFactory {

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.vpaid.widget.CountDownViewFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$CountdownStyle;

        static {
            int[] iArr = new int[CountdownStyle.values().length];
            $SwitchMap$net$pubnative$lite$sdk$CountdownStyle = iArr;
            try {
                iArr[CountdownStyle.PIE_CHART.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$CountdownStyle[CountdownStyle.TIMER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$CountdownStyle[CountdownStyle.PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public CountDownView createCountdownView(Context context, CountdownStyle countdownStyle, ViewGroup viewGroup) {
        int i = AnonymousClass1.$SwitchMap$net$pubnative$lite$sdk$CountdownStyle[countdownStyle.ordinal()];
        if (i == 1) {
            PieChartCountdownView pieChartCountdownView = new PieChartCountdownView(context);
            pieChartCountdownView.setLayoutParams(createPieChartLayoutParams(context, viewGroup));
            return pieChartCountdownView;
        }
        if (i == 2) {
            TimerCountDownView timerCountDownView = new TimerCountDownView(context);
            timerCountDownView.setLayoutParams(createTimerLayoutParams(context, viewGroup));
            return timerCountDownView;
        }
        if (i == 3) {
            ProgressCountDownView progressCountDownView = new ProgressCountDownView(context);
            progressCountDownView.setLayoutParams(createProgressLayoutParams(context, viewGroup));
            return progressCountDownView;
        }
        return new PieChartCountdownView(context);
    }

    private ViewGroup.LayoutParams createPieChartLayoutParams(Context context, ViewGroup viewGroup) {
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) ViewUtils.convertDpToPixel(40.0f, context), (int) ViewUtils.convertDpToPixel(40.0f, context));
            int iConvertDpToPixel = (int) ViewUtils.convertDpToPixel(5.0f, context);
            layoutParams.setMargins(iConvertDpToPixel, iConvertDpToPixel, iConvertDpToPixel, iConvertDpToPixel);
            layoutParams.addRule(10);
            layoutParams.addRule(20);
            return layoutParams;
        }
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) ViewUtils.convertDpToPixel(40.0f, context), (int) ViewUtils.convertDpToPixel(40.0f, context));
            int iConvertDpToPixel2 = (int) ViewUtils.convertDpToPixel(5.0f, context);
            layoutParams2.setMargins(iConvertDpToPixel2, iConvertDpToPixel2, iConvertDpToPixel2, iConvertDpToPixel2);
            layoutParams2.gravity = 8388659;
            return layoutParams2;
        }
        return new ViewGroup.LayoutParams((int) ViewUtils.convertDpToPixel(40.0f, context), (int) ViewUtils.convertDpToPixel(40.0f, context));
    }

    private ViewGroup.LayoutParams createTimerLayoutParams(Context context, ViewGroup viewGroup) {
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, (int) ViewUtils.convertDpToPixel(35.0f, context));
            layoutParams.addRule(10);
            layoutParams.addRule(20);
            return layoutParams;
        }
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, (int) ViewUtils.convertDpToPixel(35.0f, context));
            layoutParams2.gravity = 8388659;
            return layoutParams2;
        }
        return new RelativeLayout.LayoutParams(-2, (int) ViewUtils.convertDpToPixel(35.0f, context));
    }

    private ViewGroup.LayoutParams createProgressLayoutParams(Context context, ViewGroup viewGroup) {
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, (int) ViewUtils.convertDpToPixel(40.0f, context));
            layoutParams.addRule(12);
            layoutParams.addRule(20);
            return layoutParams;
        }
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 8388691;
            layoutParams2.setMargins(0, 0, 0, (int) ViewUtils.convertDpToPixel(40.0f, context));
            return layoutParams2;
        }
        return new ViewGroup.LayoutParams(-2, -2);
    }
}
