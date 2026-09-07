package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.Layout;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class D3 {
    public static byte[] A00;
    public static String[] A01 = {"aXQ8cQ350VCAT2mitcvykUGHubvGx6C9", "NAK0YApfoevBcA8nU2", "YHwKc8bJ3fYIczYaga21kucMEh7K8adi", "qYAOAoZ496ND8", "6pHjubFxbGGqNA8P9d", "3r9qhhsI1oDbETggKvxV5tdwn", "sRn13xQSljRP603ULBb8dNJbjS", "vNgqutu69Vtz3tnibxv52jRaXo"};
    public static final int A02;
    public static final int A03;
    public static final ConcurrentHashMap<Integer, Integer> A04;
    public static final AtomicInteger A05;

    public static String A0B(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0C() {
        A00 = new byte[]{120, 118, -127, -127, 122, -121, 105, -114, -123, 122, -35, -26, -29, -35, -27, -39, -19, -23, -17, -20, -35, -33, -124, -121, -118, -110, -125, -112, -125, -126, 125, -127, -118, -121, -127, -119, 125, -126, -125, -118, 127, -105, 125, -117, -111, -40, -35, -29, -44, -31, -30, -29, -40, -29, -40, -48, -37, -39, -29, -49, -45, -47, -45, -49, -42, -39, -36, -28, -43, -30, -49, -45, -36, -39, -45, -37, -29, -49, -33, -34, -49, -45, -28, -47, -125, -115, 121, 125, -116, 127, 123, -114, -125, -112, 127, 121, 123, -115, 121, 125, -114, 123, 121, -112, 76, -90, -103, -85, -107, -90, -104, -103, -104, -109, -86, -99, -104, -103, -93, -50, -53, -66, -53, -48, -53, -119, -55, -63, -64, -59, -47, -55, -11, -29, -16, -11, -81, -11, -25, -12, -21, -24, -81, -17, -25, -26, -21, -9, -17, -36, -43, -48, -40, -36, -52, -80, -53, -66, -68, -82, -69, -84, -75, -78, -84, -76};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static boolean A0e(C2699k1 c2699k1, EnumC12541u enumC12541u, Map<String, String> map) {
        String str = map.get(A0B(84, 21, 11));
        boolean z = str != null && str.equals(Boolean.TRUE.toString());
        if (z && (A0d(c2699k1, enumC12541u) || A0b(enumC12541u, map))) {
            return true;
        }
        String str2 = map.get(A0B(57, 27, 97));
        return z && (str2 != null && str2.equals(Boolean.TRUE.toString())) && A0c(enumC12541u, map);
    }

    static {
        A0C();
        A03 = AnonymousClass43.A02(-1, 0);
        A02 = AnonymousClass43.A02(ViewCompat.MEASURED_STATE_MASK, 115);
        A05 = new AtomicInteger(1);
        A04 = new ConcurrentHashMap<>();
    }

    public static int A00() {
        int i;
        int newValue;
        do {
            i = A05.get();
            newValue = i + 1;
            if (newValue > 16777215) {
                newValue = 1;
            }
        } while (!A05.compareAndSet(i, newValue));
        return i;
    }

    public static int A01(int i) {
        return (int) TypedValue.applyDimension(2, i, CP.A04);
    }

    public static int A02(int i) {
        if (A0a(i)) {
            return AnonymousClass43.A05(i, -1, 0.4f);
        }
        return AnonymousClass43.A05(i, ViewCompat.MEASURED_STATE_MASK, 0.2f);
    }

    public static int A03(TextView textView) {
        Layout layout;
        int lineCount;
        if (textView == null || textView.getLayout() == null || (lineCount = (layout = textView.getLayout()).getLineCount()) <= 0) {
            return 0;
        }
        double ellipsisCount = layout.getEllipsisCount(lineCount - 1);
        double ellipsisCount2 = ellipsisCount / (((double) textView.getText().length()) - ellipsisCount);
        if (A01[3].length() == 20) {
            throw new RuntimeException();
        }
        A01[3] = "IkK7ljd8WWfE470H6O9Fo";
        return (int) Math.ceil(ellipsisCount2);
    }

    public static int A04(TextView textView, int i) {
        int lineHeightTitle = A03(textView);
        int lines = 0;
        int extraLinesRequired = textView.getLineHeight();
        while (i > extraLinesRequired && lines < lineHeightTitle) {
            lines++;
            i -= extraLinesRequired;
        }
        return lines;
    }

    public static Drawable A05(int i, int i2) {
        return A08(i, A02(i), i2);
    }

    public static Drawable A06(int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(i2);
        return gradientDrawable;
    }

    public static Drawable A07(int i, int i2) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, i2);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static Drawable A08(int i, int i2, int i3) {
        return A09(i, i2, i, i3);
    }

    public static Drawable A09(int i, int i2, int i3, int i4) {
        return new RippleDrawable(ColorStateList.valueOf(i2), A06(i, i4), A07(i3, i4));
    }

    public static TextView A0A(ViewGroup viewGroup) {
        for (int i = 0; i < i; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (A01[3].length() == 20) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[0] = "6RJtTYzLBnUcHRvsTatmkmWKIun16hlE";
                strArr[2] = "BwINbhkVgYMYeGJED3O8k6L5SNrYNN6g";
                return textView;
            }
            if (childAt instanceof ViewGroup) {
                A0A((ViewGroup) childAt);
            }
        }
        return null;
    }

    public static void A0D(int i, View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(i / 3);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration((i / 3) * 2);
        scaleAnimation2.setInterpolator(new BounceInterpolator());
        scaleAnimation.setAnimationListener(new i3(view, scaleAnimation2));
        view.startAnimation(scaleAnimation);
    }

    public static void A0E(int i, View view) {
        Integer viewId = A04.get(Integer.valueOf(i));
        if (viewId != null) {
            view.setId(viewId.intValue());
        } else {
            A0I(view);
        }
    }

    public static void A0F(View view) {
        A0L(view, 8);
    }

    public static void A0G(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            A0R((ViewGroup) parent);
        }
    }

    public static void A0H(View view) {
        if (view == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (A01[3].length() == 20) {
            throw new RuntimeException();
        }
        A01[3] = "DU33ZJN3ug5gIBKNKyYbqVVAVCFz";
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }

    public static void A0I(View view) {
        if (view == null) {
            return;
        }
        view.setId(View.generateViewId());
    }

    public static void A0J(View view) {
        A0L(view, 0);
    }

    public static void A0K(View view, int i) {
        view.setBackground(new ColorDrawable(i));
    }

    public static void A0L(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public static void A0M(View view, int i, int i2) {
        A0Q(view, A08(i, A02(i), i2));
    }

    public static void A0N(View view, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{A03, A02});
        gradientDrawable.setCornerRadius(i);
        gradientDrawable.setStroke(i2, i3);
        A0Q(view, gradientDrawable);
    }

    public static void A0O(View view, int i, int i2, int i3) {
        A0Q(view, A09(i, A02(i), i2, i3));
    }

    public static void A0P(View view, Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{A03, A02});
        gradientDrawable.setCornerRadius(0.0f);
        A0Q(view, gradientDrawable);
    }

    public static void A0Q(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void A0R(ViewGroup viewGroup) {
        A0S(viewGroup, 200);
    }

    public static void A0S(ViewGroup viewGroup, int i) {
        A0U(viewGroup, new AutoTransition(), i);
    }

    public static void A0T(ViewGroup viewGroup, Transition transition) {
        A0U(viewGroup, transition, 200);
    }

    public static void A0U(ViewGroup viewGroup, Transition transition, int i) {
        transition.setDuration(i);
        transition.setInterpolator(new AccelerateDecelerateInterpolator());
        TransitionManager.beginDelayedTransition(viewGroup, transition);
    }

    public static void A0V(Button button) {
        Typeface typeface = Typeface.create(A0B(Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 13, 77), 0);
        button.setTypeface(typeface);
    }

    public static void A0W(TextView textView, boolean z, int i) {
        Typeface typeface;
        if (z) {
            typeface = Typeface.create(A0B(Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 17, 115), 0);
        } else {
            Typeface typeface2 = Typeface.SANS_SERIF;
            typeface = Typeface.create(typeface2, 0);
        }
        textView.setTypeface(typeface);
        if (A01[5].length() != 25) {
            throw new RuntimeException();
        }
        A01[3] = "EYVeEO4Fu";
        textView.setTextSize(2, i);
    }

    public static void A0X(Toast toast, String str, int i, int i2, int i3) {
        if (toast == null) {
            return;
        }
        toast.setGravity(i, i2, i3);
        TextView textViewA0A = A0A((ViewGroup) toast.getView());
        if (textViewA0A != null) {
            textViewA0A.setText(str);
            textViewA0A.setGravity(17);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x006b  */
    /* JADX WARN: Code duplicated, block: B:12:0x0075  */
    /* JADX WARN: Code duplicated, block: B:6:0x000e  */
    public static void A0Y(Map<String, String> map, AbstractC2855md abstractC2855md) {
        byte b;
        String strA0B;
        if (abstractC2855md == null) {
            return;
        }
        String strA0i = abstractC2855md.A0i();
        switch (strA0i.hashCode()) {
            case -1364000502:
                if (strA0i.equals(A0B(105, 14, 37))) {
                    b = 1;
                } else {
                    b = -1;
                }
                strA0B = A0B(0, 10, 6);
                switch (b) {
                    case 0:
                        map.put(strA0B, AdPlacementType.INTERSTITIAL.name());
                        break;
                    case 1:
                        map.put(strA0B, AdPlacementType.REWARDED_VIDEO.name());
                        break;
                }
                map.put(A0B(149, 8, 88), abstractC2855md.A0d());
                map.put(A0B(84, 21, 11), String.valueOf(abstractC2855md.A1D()));
                map.put(A0B(57, 27, 97), String.valueOf(abstractC2855md.A19()));
                map.put(A0B(22, 23, 15), String.valueOf(abstractC2855md.A0a()));
                return;
            case 604727084:
                String strA0B2 = A0B(45, 12, 96);
                if (A01[3].length() == 20) {
                    throw new RuntimeException();
                }
                A01[3] = "p9FB";
                if (strA0i.equals(strA0B2)) {
                    b = 0;
                } else {
                    b = -1;
                }
                strA0B = A0B(0, 10, 6);
                switch (b) {
                    case 0:
                        map.put(strA0B, AdPlacementType.INTERSTITIAL.name());
                        break;
                    case 1:
                        map.put(strA0B, AdPlacementType.REWARDED_VIDEO.name());
                        break;
                }
                map.put(A0B(149, 8, 88), abstractC2855md.A0d());
                map.put(A0B(84, 21, 11), String.valueOf(abstractC2855md.A1D()));
                map.put(A0B(57, 27, 97), String.valueOf(abstractC2855md.A19()));
                map.put(A0B(22, 23, 15), String.valueOf(abstractC2855md.A0a()));
                return;
            default:
                b = -1;
                strA0B = A0B(0, 10, 6);
                switch (b) {
                    case 0:
                        map.put(strA0B, AdPlacementType.INTERSTITIAL.name());
                        break;
                    case 1:
                        map.put(strA0B, AdPlacementType.REWARDED_VIDEO.name());
                        break;
                }
                map.put(A0B(149, 8, 88), abstractC2855md.A0d());
                map.put(A0B(84, 21, 11), String.valueOf(abstractC2855md.A1D()));
                map.put(A0B(57, 27, 97), String.valueOf(abstractC2855md.A19()));
                map.put(A0B(22, 23, 15), String.valueOf(abstractC2855md.A0a()));
                return;
        }
    }

    public static void A0Z(View... viewArr) {
        for (View view : viewArr) {
            A0H(view);
        }
    }

    public static boolean A0a(int i) {
        return AnonymousClass43.A00(i) < 0.5d;
    }

    public static boolean A0b(EnumC12541u enumC12541u, Map<String, String> extraData) {
        boolean nonIabDestination = !A0B(157, 9, 58).equals(extraData.get(A0B(10, 12, 107)));
        boolean nonCtaClick = enumC12541u != EnumC12541u.A08;
        return nonIabDestination && nonCtaClick;
    }

    public static boolean A0c(EnumC12541u enumC12541u, Map<String, String> extraData) {
        boolean zEquals = A0B(157, 9, 58).equals(extraData.get(A0B(10, 12, 107)));
        boolean ctaClick = enumC12541u != EnumC12541u.A08;
        return zEquals && ctaClick;
    }

    public static boolean A0d(C2699k1 c2699k1, EnumC12541u enumC12541u) {
        return enumC12541u == EnumC12541u.A08 && C14499m.A2m(c2699k1);
    }
}
