package com.yandex.div.internal.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yandex.div.core.util.SafeAlertDialog;
import com.yandex.div.internal.Assert;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes9.dex */
public class Views {
    private static final int[] HIT_TEST_ARRAY = new int[2];
    public static final int VIEW_SIDE_BOTTOM = 1;
    public static final int VIEW_SIDE_LEFT = 2;
    public static final int VIEW_SIDE_RIGHT = 4;
    public static final int VIEW_SIDE_TOP = 8;

    public interface ViewProcessor {
        void process(View view);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewSideFlags {
    }

    public static <T extends View> T findViewAndCast(Activity activity, int i) {
        T t = (T) activity.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("View with id [" + activity.getResources().getResourceName(i) + "] doesn't exist");
    }

    public static <T extends View> T findViewAndCast(View view, int i) {
        T t = (T) view.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("View with id [" + view.getResources().getResourceName(i) + "] doesn't exist");
    }

    public static <T extends View> T findOptionalViewAndCast(View view, int i) {
        return (T) view.findViewById(i);
    }

    public static <VIEW extends View> VIEW inflate(ViewGroup viewGroup, int i) {
        return (VIEW) LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
    }

    public static <VIEW extends View> VIEW inflate(Context context, ViewGroup viewGroup, int i) {
        return (VIEW) LayoutInflater.from(context).inflate(i, viewGroup, false);
    }

    public static <V extends View> V inflate(Context context, int i) {
        return (V) LayoutInflater.from(context).inflate(i, (ViewGroup) null);
    }

    public static void setTextOrHide(TextView textView, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            textView.setText((CharSequence) null);
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
    }

    public static boolean isVisible(View view) {
        return view.getVisibility() == 0;
    }

    public static boolean hitTest(View view, float f, float f2) {
        int[] iArr = HIT_TEST_ARRAY;
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        if (f < i || f > i + view.getWidth()) {
            return false;
        }
        int i2 = iArr[1];
        return f2 >= ((float) i2) && f2 <= ((float) (i2 + view.getHeight()));
    }

    public static void setPadding(View view, int i, int i2) {
        setPaddingPixelSize(view, view.getResources().getDimensionPixelSize(i), i2);
    }

    public static void setPadding(View view, int i, int i2, Void r3) {
        setPaddingPixelSize(view, i, i2);
    }

    public static void traverseViewTree(View view, ViewProcessor viewProcessor) {
        ArrayDeque arrayDeque = new ArrayDeque();
        viewProcessor.process(view);
        if (view instanceof ViewGroup) {
            arrayDeque.add((ViewGroup) view);
        }
        while (!arrayDeque.isEmpty()) {
            ViewGroup viewGroup = (ViewGroup) arrayDeque.remove();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                viewProcessor.process(childAt);
                if (childAt instanceof ViewGroup) {
                    arrayDeque.add((ViewGroup) childAt);
                }
            }
        }
    }

    private static void setPaddingPixelSize(View view, int i, int i2) {
        int paddingLeft = (i2 & 2) != 0 ? i : view.getPaddingLeft();
        int paddingTop = (i2 & 8) != 0 ? i : view.getPaddingTop();
        int paddingRight = (i2 & 4) != 0 ? i : view.getPaddingRight();
        if ((i2 & 1) == 0) {
            i = view.getPaddingBottom();
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, i);
    }

    public static int getBottomMargin(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return 0;
    }

    public static int getVerticalMargins(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    public static int getHeightWithMargins(View view) {
        return view.getHeight() + getVerticalMargins(view);
    }

    public static SafeAlertDialog styleAlertDialog(SafeAlertDialog safeAlertDialog, Typeface typeface) {
        if (typeface == null) {
            return safeAlertDialog;
        }
        TextView textView = (TextView) safeAlertDialog.findViewById(R.id.message);
        Assert.assertNotNull("AlertDialog message textview not found", textView);
        if (textView != null) {
            textView.setTypeface(typeface);
        }
        return safeAlertDialog;
    }
}
