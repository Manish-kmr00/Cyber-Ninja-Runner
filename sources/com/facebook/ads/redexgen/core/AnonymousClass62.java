package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.62, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AnonymousClass62 {
    public static byte[] A0I;
    public static String[] A0J = {"xyZ8yvYzp3wrHAf7Yx6bEToOMuLBTkeJ", "zRc0P2oS", "sxpemPSbJ0zjH5L170Fpc8WIJnMfTOYM", "JLvxwq6R3Maitb0M5MelMbaPMbiMlz5H", "qno0WD9sdyP92Tf9SwtsGsNlEh6m7cws", "isTf1gingqqcw8OSNjwv80foOygzMJYI", "cYtNYfyLYrQzxoivZChv", "OeXF3cqFYKXlQ2ABbzPAkdUOYZHirWRh"};
    public int A00;
    public C5Q A01;
    public C6F A02;
    public MG A03;
    public boolean A08;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public final C6N A0G = new C2762l3(this);
    public final C6N A0H = new C2761l2(this);
    public C6P A04 = new C6P(this.A0G);
    public C6P A05 = new C6P(this.A0H);
    public boolean A09 = false;
    public boolean A07 = false;
    public boolean A06 = false;
    public boolean A0F = true;
    public boolean A0E = true;

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0I, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 20);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A0I = new byte[]{99, -122, -122, -121, -122, 66, 120, -117, -121, -103, 66, -118, -125, -107, 66, 116, -121, -123, -101, -123, -114, -121, -108, 120, -117, -121, -103, 66, -125, -107, 66, -110, -125, -108, -121, -112, -106, 66, -124, -105, -106, 66, -104, -117, -121, -103, 66, -117, -107, 66, -112, -111, -106, 66, -125, 66, -108, -121, -125, -114, 66, -123, -118, -117, -114, -122, 80, 66, 119, -112, -120, -117, -114, -106, -121, -108, -121, -122, 66, -117, -112, -122, -121, -102, 92, -88, -58, -45, -45, -44, -39, -123, -46, -44, -37, -54, -123, -58, -123, -56, -51, -50, -47, -55, -123, -53, -41, -44, -46, -123, -45, -44, -45, -110, -54, -35, -50, -40, -39, -50, -45, -52, -123, -50, -45, -55, -54, -35, -97};
    }

    public abstract int A1d(int i, C6A c6a, C6H c6h);

    public abstract int A1e(int i, C6A c6a, C6H c6h);

    public abstract int A1f(C6H c6h);

    public abstract int A1g(C6H c6h);

    public abstract int A1h(C6H c6h);

    public abstract int A1i(C6H c6h);

    public abstract int A1j(C6H c6h);

    public abstract int A1k(C6H c6h);

    public abstract Parcelable A1l();

    public abstract View A1n(View view, int i, C6A c6a, C6H c6h);

    public abstract AnonymousClass63 A1o();

    public abstract void A1p(int i);

    public abstract void A1q(int i, int i2, C6H c6h, AnonymousClass60 anonymousClass60);

    public abstract void A1r(int i, AnonymousClass60 anonymousClass60);

    public abstract void A1s(Parcelable parcelable);

    public abstract void A1u(C6A c6a, C6H c6h);

    public abstract void A1x(MG mg, C6H c6h, int i);

    public abstract boolean A1z();

    public abstract boolean A20();

    public abstract boolean A21();

    public abstract boolean A22();

    static {
        A08();
    }

    public static int A00(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                int iMax = Math.max(i2, i3);
                int size2 = A0J[1].length();
                if (size2 != 8) {
                    throw new RuntimeException();
                }
                A0J[1] = "W1fJ2ceK";
                int mode2 = Math.min(size, iMax);
                return mode2;
            case 1073741824:
                return size;
            default:
                int mode3 = Math.max(i2, i3);
                return mode3;
        }
    }

    public static int A01(int i, int i2, int i3, int i4, boolean z) {
        int iMax = Math.max(0, i - i3);
        int i5 = 0;
        int resultMode = 0;
        if (z) {
            if (i4 >= 0) {
                i5 = i4;
                resultMode = 1073741824;
            } else if (i4 == -1) {
                switch (i2) {
                    case Integer.MIN_VALUE:
                    case 1073741824:
                        i5 = iMax;
                        resultMode = i2;
                        break;
                    case 0:
                        i5 = 0;
                        resultMode = 0;
                        break;
                }
            } else if (i4 == -2) {
                i5 = 0;
                resultMode = 0;
            }
        } else if (i4 >= 0) {
            i5 = i4;
            resultMode = 1073741824;
        } else if (i4 == -1) {
            i5 = iMax;
            resultMode = i2;
        } else if (i4 == -2) {
            i5 = iMax;
            resultMode = (i2 == Integer.MIN_VALUE || i2 == 1073741824) ? Integer.MIN_VALUE : 0;
        }
        int size = View.MeasureSpec.makeMeasureSpec(i5, resultMode);
        return size;
    }

    private final int A02(View view) {
        return ((AnonymousClass63) view.getLayoutParams()).A03.bottom;
    }

    private final int A03(View view) {
        return ((AnonymousClass63) view.getLayoutParams()).A03.left;
    }

    private final int A04(View view) {
        return ((AnonymousClass63) view.getLayoutParams()).A03.right;
    }

    private final int A05(View view) {
        return ((AnonymousClass63) view.getLayoutParams()).A03.top;
    }

    private final int A06(C6A c6a, C6H c6h) {
        return 0;
    }

    private final void A09(int i) {
        A0C(i, A0t(i));
    }

    private final void A0A(int i) {
        View child = A0t(i);
        if (child != null) {
            this.A01.A0D(i);
        }
    }

    private final void A0B(int i, int i2) {
        View view = A0t(i);
        if (view != null) {
            A09(i);
            A0E(view, i2);
            String[] strArr = A0J;
            if (strArr[2].charAt(30) != strArr[5].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0J;
            strArr2[0] = "fev5lwy8caKDFGGcVLFTWETO5UF90dOq";
            strArr2[7] = "EDoCIrgXqzBYQTf4WlngJinORtzJmrfl";
            return;
        }
        throw new IllegalArgumentException(A07(85, 44, 81) + i + this.A03.toString());
    }

    private void A0C(int i, View view) {
        this.A01.A0C(i);
    }

    private final void A0D(View view) {
        this.A01.A0F(view);
    }

    private final void A0E(View view, int i) {
        A0F(view, i, (AnonymousClass63) view.getLayoutParams());
    }

    private final void A0F(View view, int i, AnonymousClass63 anonymousClass63) {
        C6K c6kA0F = MG.A0F(view);
        if (c6kA0F.A0a()) {
            this.A03.A0t.A09(c6kA0F);
        } else {
            this.A03.A0t.A0A(c6kA0F);
        }
        this.A01.A0H(view, i, anonymousClass63, c6kA0F.A0a());
    }

    private void A0G(View view, int i, boolean z) {
        C6K c6kA0F = MG.A0F(view);
        if (z || c6kA0F.A0a()) {
            this.A03.A0t.A09(c6kA0F);
        } else {
            this.A03.A0t.A0A(c6kA0F);
        }
        AnonymousClass63 anonymousClass63 = (AnonymousClass63) view.getLayoutParams();
        if (c6kA0F.A0g() || c6kA0F.A0b()) {
            if (c6kA0F.A0b()) {
                c6kA0F.A0S();
            } else {
                c6kA0F.A0O();
            }
            this.A01.A0H(view, i, view.getLayoutParams(), false);
        } else {
            ViewParent parent = view.getParent();
            MG mg = this.A03;
            if (A0J[3].charAt(19) == 'k') {
                throw new RuntimeException();
            }
            A0J[4] = "uqKRxBtg59XPGVJDkfwEUsBOgdJYSppJ";
            if (parent == mg) {
                int currentIndex = this.A01.A07(view);
                if (i == -1) {
                    i = this.A01.A05();
                }
                if (currentIndex != -1) {
                    if (currentIndex != i) {
                        this.A03.A06.A0B(currentIndex, i);
                    }
                } else {
                    throw new IllegalStateException(A07(0, 85, 14) + this.A03.indexOfChild(view) + this.A03.A1J());
                }
            } else {
                this.A01.A0I(view, i, false);
                anonymousClass63.A01 = true;
                C6F c6f = this.A02;
                if (A0J[4].charAt(12) == 'v') {
                    throw new RuntimeException();
                }
                A0J[6] = "si9YLNjLFs";
                if (c6f != null && this.A02.A0F()) {
                    this.A02.A0C(view);
                }
            }
        }
        if (anonymousClass63.A02) {
            View view2 = c6kA0F.A0H;
            if (A0J[1].length() != 8) {
                throw new RuntimeException();
            }
            A0J[1] = "bg493IDm";
            view2.invalidate();
            anonymousClass63.A02 = false;
        }
    }

    private final void A0H(View view, Rect rect) {
        MG.A0o(view, rect);
    }

    private void A0J(C6A c6a, int i, View view) {
        C6K c6kA0F = MG.A0F(view);
        if (c6kA0F.A0f()) {
            return;
        }
        if (c6kA0F.A0Z()) {
            boolean zA0a = c6kA0F.A0a();
            if (A0J[3].charAt(19) == 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A0J;
            strArr[2] = "wfzQKDpvqCerNRZHLtQvgaB031c5C1YU";
            strArr[5] = "KgFz3HBRwd8cETJWtdM1PF8pjKUjBKYl";
            if (!zA0a && !this.A03.A04.A0A()) {
                A0A(i);
                c6a.A0X(c6kA0F);
                return;
            }
        }
        A09(i);
        c6a.A0S(view);
        this.A03.A0t.A0C(c6kA0F);
    }

    private final void A0K(C6A c6a, C6H c6h, AccessibilityEvent accessibilityEvent) {
        if (this.A03 == null || accessibilityEvent == null) {
            return;
        }
        boolean z = true;
        if (!this.A03.canScrollVertically(1) && !this.A03.canScrollVertically(-1) && !this.A03.canScrollHorizontally(-1) && !this.A03.canScrollHorizontally(1)) {
            z = false;
        }
        accessibilityEvent.setScrollable(z);
        if (this.A03.A04 != null) {
            accessibilityEvent.setItemCount(this.A03.A04.A0C());
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005b  */
    /* JADX WARN: Code duplicated, block: B:8:0x002d  */
    private final void A0L(C6A c6a, C6H c6h, AnonymousClass56 anonymousClass56) {
        if (this.A03.canScrollVertically(-1)) {
            anonymousClass56.A0N(8192);
            anonymousClass56.A0R(true);
        } else {
            boolean zCanScrollHorizontally = this.A03.canScrollHorizontally(-1);
            if (A0J[3].charAt(19) == 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A0J;
            strArr[2] = "KDPDh71uiY9dw6lSrmH00w2HuhKAvOYl";
            strArr[5] = "F84YzGx02ov8ufnexIEGkhiaGhnINbYS";
            if (zCanScrollHorizontally) {
                anonymousClass56.A0N(8192);
                anonymousClass56.A0R(true);
            }
        }
        if (this.A03.canScrollVertically(1)) {
            anonymousClass56.A0N(4096);
            anonymousClass56.A0R(true);
        } else {
            MG mg = this.A03;
            if (A0J[3].charAt(19) != 'k') {
                A0J[6] = "8s5rDkFpP";
                if (mg.canScrollHorizontally(1)) {
                    anonymousClass56.A0N(4096);
                    anonymousClass56.A0R(true);
                }
            } else {
                String[] strArr2 = A0J;
                strArr2[2] = "3WqpoC752q4h2Wya5fT3BPHdY3ZkhgYP";
                strArr2[5] = "HauWKBzmz4VUJQZuXSWVI1MWGOc6zBYt";
                if (mg.canScrollHorizontally(1)) {
                    anonymousClass56.A0N(4096);
                    anonymousClass56.A0R(true);
                }
            }
        }
        AnonymousClass53 collectionInfo = AnonymousClass53.A00(A0r(c6a, c6h), A0q(c6a, c6h), A0P(c6a, c6h), A06(c6a, c6h));
        anonymousClass56.A0P(collectionInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M(C6F c6f) {
        if (this.A02 == c6f) {
            this.A02 = null;
        }
    }

    private final boolean A0N() {
        return this.A02 != null && this.A02.A0F();
    }

    public static boolean A0O(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                return size >= i;
            case 0:
                return true;
            case 1073741824:
                return size == i;
            default:
                return false;
        }
    }

    private final boolean A0P(C6A c6a, C6H c6h) {
        return false;
    }

    private final boolean A0Q(C6A c6a, C6H c6h, int i, Bundle bundle) {
        if (this.A03 == null) {
            return false;
        }
        int hScroll = 0;
        int i2 = 0;
        switch (i) {
            case 4096:
                if (this.A03.canScrollVertically(1)) {
                    int hScroll2 = A0X();
                    int vScroll = A0g();
                    int hScroll3 = hScroll2 - vScroll;
                    int vScroll2 = A0d();
                    hScroll = hScroll3 - vScroll2;
                }
                if (this.A03.canScrollHorizontally(1)) {
                    int iA0h = A0h();
                    int vScroll3 = A0e();
                    int i3 = iA0h - vScroll3;
                    int vScroll4 = A0f();
                    i2 = i3 - vScroll4;
                }
                break;
            case 8192:
                if (this.A03.canScrollVertically(-1)) {
                    int hScroll4 = A0X();
                    int vScroll5 = A0g();
                    int hScroll5 = hScroll4 - vScroll5;
                    int vScroll6 = A0d();
                    hScroll = -(hScroll5 - vScroll6);
                }
                if (this.A03.canScrollHorizontally(-1)) {
                    int iA0h2 = A0h();
                    int vScroll7 = A0e();
                    int i4 = iA0h2 - vScroll7;
                    int vScroll8 = A0f();
                    i2 = -(i4 - vScroll8);
                }
                break;
        }
        if (hScroll == 0 && i2 == 0) {
            return false;
        }
        this.A03.scrollBy(i2, hScroll);
        return true;
    }

    private final boolean A0R(C6A c6a, C6H c6h, View view, int i, Bundle bundle) {
        return false;
    }

    private boolean A0S(MG mg, int i, int i2) {
        View focusedChild = mg.getFocusedChild();
        if (focusedChild == null) {
            return false;
        }
        int parentBottom = A0e();
        int parentRight = A0g();
        int parentTop = A0h();
        int parentTop2 = parentTop - A0f();
        int parentLeft = A0X();
        int parentLeft2 = parentLeft - A0d();
        Rect rect = this.A03.A0p;
        A0H(focusedChild, rect);
        if (rect.left - i >= parentTop2 || rect.right - i <= parentBottom || rect.top - i2 >= parentLeft2 || rect.bottom - i2 <= parentRight) {
            return false;
        }
        return true;
    }

    @Deprecated
    private final boolean A0T(MG mg, View view, View view2) {
        return A0N() || mg.A1s();
    }

    private int[] A0U(View view, Rect rect) {
        int[] iArr = new int[2];
        int offScreenRight = A0e();
        int offScreenTop = A0g();
        int dy = A0h() - A0f();
        int offScreenLeft = A0X() - A0d();
        int childBottom = (view.getLeft() + rect.left) - view.getScrollX();
        int childRight = (view.getTop() + rect.top) - view.getScrollY();
        int childLeft = rect.width() + childBottom;
        int parentLeft = rect.height();
        int parentBottom = Math.min(0, childBottom - offScreenRight);
        int parentRight = Math.min(0, childRight - offScreenTop);
        int parentTop = Math.max(0, childLeft - dy);
        int parentLeft2 = Math.max(0, (parentLeft + childRight) - offScreenLeft);
        if (A0a() == 1) {
            if (parentTop == 0) {
                parentTop = Math.max(parentBottom, childLeft - dy);
            }
        } else {
            parentTop = parentBottom != 0 ? parentBottom : Math.min(childBottom - offScreenRight, parentTop);
        }
        if (parentRight == 0) {
            parentRight = Math.min(childRight - offScreenTop, parentLeft2);
        }
        iArr[0] = parentTop;
        iArr[1] = parentRight;
        return iArr;
    }

    public final int A0V() {
        return -1;
    }

    public final int A0W() {
        if (this.A01 != null) {
            return this.A01.A05();
        }
        return 0;
    }

    public final int A0X() {
        return this.A0A;
    }

    public final int A0Y() {
        return this.A0B;
    }

    public final int A0Z() {
        AbstractC13515q a2;
        if (this.A03 != null) {
            MG mg = this.A03;
            if (A0J[3].charAt(19) == 'k') {
                throw new RuntimeException();
            }
            A0J[4] = "NhHtbEzlhB3n2IblVpNcmlHtdyAdrFMd";
            a2 = mg.getAdapter();
        } else {
            a2 = null;
        }
        if (a2 != null) {
            return a2.A0C();
        }
        return 0;
    }

    public final int A0a() {
        return C4h.A01(this.A03);
    }

    public final int A0b() {
        return C4h.A02(this.A03);
    }

    public final int A0c() {
        return C4h.A03(this.A03);
    }

    public final int A0d() {
        if (this.A03 != null) {
            return this.A03.getPaddingBottom();
        }
        return 0;
    }

    public final int A0e() {
        if (this.A03 != null) {
            return this.A03.getPaddingLeft();
        }
        return 0;
    }

    public final int A0f() {
        if (this.A03 != null) {
            return this.A03.getPaddingRight();
        }
        return 0;
    }

    public final int A0g() {
        if (this.A03 != null) {
            return this.A03.getPaddingTop();
        }
        return 0;
    }

    public final int A0h() {
        return this.A0C;
    }

    public final int A0i() {
        return this.A0D;
    }

    public final int A0j(View view) {
        return view.getBottom() + A02(view);
    }

    public final int A0k(View view) {
        return view.getLeft() - A03(view);
    }

    public final int A0l(View view) {
        Rect rect = ((AnonymousClass63) view.getLayoutParams()).A03;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public final int A0m(View view) {
        Rect rect = ((AnonymousClass63) view.getLayoutParams()).A03;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public final int A0n(View view) {
        return view.getRight() + A04(view);
    }

    public final int A0o(View view) {
        return view.getTop() - A05(view);
    }

    public final int A0p(View view) {
        return ((AnonymousClass63) view.getLayoutParams()).A00();
    }

    public int A0q(C6A c6a, C6H c6h) {
        if (this.A03 == null || this.A03.A04 == null || !A20()) {
            return 1;
        }
        return this.A03.A04.A0C();
    }

    public int A0r(C6A c6a, C6H c6h) {
        if (this.A03 == null || this.A03.A04 == null || !A21()) {
            return 1;
        }
        return this.A03.A04.A0C();
    }

    public final View A0s() {
        View focusedChild;
        if (this.A03 == null || (focusedChild = this.A03.getFocusedChild()) == null || this.A01.A0K(focusedChild)) {
            return null;
        }
        return focusedChild;
    }

    public final View A0t(int i) {
        if (this.A01 != null) {
            return this.A01.A09(i);
        }
        return null;
    }

    public final View A0u(View view, int i) {
        return null;
    }

    public AnonymousClass63 A0v(Context context, AttributeSet attributeSet) {
        return new AnonymousClass63(context, attributeSet);
    }

    public AnonymousClass63 A0w(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof AnonymousClass63) {
            return new AnonymousClass63((AnonymousClass63) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new AnonymousClass63((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new AnonymousClass63(layoutParams);
    }

    public final void A0x() {
        if (this.A02 != null) {
            this.A02.A09();
        }
    }

    public final void A0y() {
        if (this.A03 != null) {
            this.A03.requestLayout();
        }
    }

    public final void A0z(int i) {
        if (this.A03 != null) {
            this.A03.A1V(i);
        }
    }

    public final void A10(int i) {
        if (this.A03 != null) {
            this.A03.A1W(i);
        }
    }

    public final void A11(int i, int i2) {
        this.A0C = View.MeasureSpec.getSize(i);
        this.A0D = View.MeasureSpec.getMode(i);
        if (this.A0D == 0 && !MG.A1B) {
            this.A0C = 0;
        }
        this.A0A = View.MeasureSpec.getSize(i2);
        this.A0B = View.MeasureSpec.getMode(i2);
        if (this.A0B == 0 && !MG.A1B) {
            this.A0A = 0;
        }
    }

    public final void A12(int i, int i2) {
        int iA0W = A0W();
        if (iA0W == 0) {
            this.A03.A1c(i, i2);
            String[] strArr = A0J;
            String str = strArr[2];
            String str2 = strArr[5];
            int iCharAt = str.charAt(30);
            int count = str2.charAt(30);
            if (iCharAt != count) {
                throw new RuntimeException();
            }
            A0J[1] = "XwkGDyjU";
            return;
        }
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < iA0W; i5++) {
            View viewA0t = A0t(i5);
            Rect rect = this.A03.A0p;
            A0H(viewA0t, rect);
            int count2 = rect.left;
            if (count2 < i3) {
                i3 = rect.left;
            }
            int count3 = rect.right;
            if (count3 > maxY) {
                maxY = rect.right;
            }
            int count4 = rect.top;
            if (count4 < i4) {
                i4 = rect.top;
            }
            int count5 = rect.bottom;
            if (count5 > maxX) {
                maxX = rect.bottom;
            }
        }
        this.A03.A0p.set(i3, i4, maxY, maxX);
        A15(this.A03.A0p, i, i2);
    }

    public final void A13(int i, int i2) {
        this.A03.setMeasuredDimension(i, i2);
    }

    public final void A14(int i, C6A c6a) {
        View view = A0t(i);
        A0A(i);
        c6a.A0T(view);
    }

    public void A15(Rect rect, int i, int i2) {
        int usedHeight = rect.width() + A0e() + A0f();
        int iHeight = rect.height();
        int usedWidth = A0g();
        int i3 = iHeight + usedWidth;
        int usedWidth2 = A0d();
        int width = i3 + usedWidth2;
        int usedWidth3 = A0c();
        int usedHeight2 = A00(i, usedHeight, usedWidth3);
        int usedWidth4 = A0b();
        A13(usedHeight2, A00(i2, width, usedWidth4));
    }

    public final void A16(View view) {
        A18(view, -1);
    }

    public final void A17(View view) {
        A19(view, -1);
    }

    public final void A18(View view, int i) {
        A0G(view, i, true);
    }

    public final void A19(View view, int i) {
        A0G(view, i, false);
    }

    public final void A1A(View view, int i, int i2) {
        AnonymousClass63 anonymousClass63 = (AnonymousClass63) view.getLayoutParams();
        Rect rectA1D = this.A03.A1D(view);
        int i3 = i + rectA1D.left + rectA1D.right;
        int i4 = i2 + rectA1D.top + rectA1D.bottom;
        int iA01 = A01(A0h(), A0i(), A0e() + A0f() + anonymousClass63.leftMargin + anonymousClass63.rightMargin + i3, anonymousClass63.width, A20());
        int iA0X = A0X();
        int iA0Y = A0Y();
        int widthSpec = A0g();
        int iA02 = A01(iA0X, iA0Y, widthSpec + A0d() + anonymousClass63.topMargin + anonymousClass63.bottomMargin + i4, anonymousClass63.height, A21());
        if (A1W(view, iA01, iA02, anonymousClass63)) {
            view.measure(iA01, iA02);
        }
    }

    public final void A1B(View view, int i, int i2, int i3, int i4) {
        AnonymousClass63 anonymousClass63 = (AnonymousClass63) view.getLayoutParams();
        Rect rect = anonymousClass63.A03;
        view.layout(rect.left + i + anonymousClass63.leftMargin, rect.top + i2 + anonymousClass63.topMargin, (i3 - rect.right) - anonymousClass63.rightMargin, (i4 - rect.bottom) - anonymousClass63.bottomMargin);
    }

    public final void A1C(View view, AnonymousClass56 anonymousClass56) {
        C6K c6kA0F = MG.A0F(view);
        if (c6kA0F != null) {
            boolean zA0a = c6kA0F.A0a();
            if (A0J[4].charAt(12) == 'v') {
                throw new RuntimeException();
            }
            A0J[1] = "uJMRqraa";
            if (!zA0a && !this.A01.A0K(c6kA0F.A0H)) {
                A1K(this.A03.A0r, this.A03.A0s, view, anonymousClass56);
            }
        }
    }

    public final void A1D(View view, C6A c6a) {
        A0D(view);
        c6a.A0T(view);
    }

    public final void A1E(View view, boolean z, Rect rect) {
        Matrix matrix;
        if (z) {
            Rect rect2 = ((AnonymousClass63) view.getLayoutParams()).A03;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        } else {
            rect.set(0, 0, view.getWidth(), view.getHeight());
        }
        MG mg = this.A03;
        String[] strArr = A0J;
        if (strArr[0].charAt(23) != strArr[7].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0J;
        strArr2[0] = "0LJ8GvUexdNG1AG11Ii0XfPOyD5lBlCr";
        strArr2[7] = "NwYNIOYDHD2wNBVOHxFlNgVOQtOI4Jp5";
        if (mg != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.A03.A0q;
            rectF.set(rect);
            matrix.mapRect(rectF);
            int iFloor = (int) Math.floor(rectF.left);
            int iFloor2 = (int) Math.floor(rectF.top);
            double d = rectF.right;
            if (A0J[6].length() == 15) {
                throw new RuntimeException();
            }
            String[] strArr3 = A0J;
            strArr3[0] = "AxZOVdXnwoPa2hByvRQIxFpOdsFmpigD";
            strArr3[7] = "eNbgBcin3tlOsNhY3b3xdMmObUbY1NrP";
            rect.set(iFloor, iFloor2, (int) Math.ceil(d), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public final void A1F(AnonymousClass56 anonymousClass56) {
        A0L(this.A03.A0r, this.A03.A0s, anonymousClass56);
    }

    public final void A1G(C6A c6a) {
        int iA0E = c6a.A0E();
        for (int i = iA0E - 1; i >= 0; i--) {
            View viewA0F = c6a.A0F(i);
            C6K c6kA0F = MG.A0F(viewA0F);
            if (!c6kA0F.A0f()) {
                c6kA0F.A0X(false);
                if (c6kA0F.A0c()) {
                    this.A03.removeDetachedView(viewA0F, false);
                }
                if (this.A03.A05 != null) {
                    this.A03.A05.A0K(c6kA0F);
                }
                c6kA0F.A0X(true);
                c6a.A0R(viewA0F);
            }
        }
        c6a.A0L();
        if (iA0E > 0) {
            this.A03.invalidate();
        }
    }

    public final void A1H(C6A c6a) {
        int childCount = A0W();
        for (int i = childCount - 1; i >= 0; i--) {
            A0J(c6a, i, A0t(i));
        }
    }

    public final void A1I(C6A c6a) {
        for (int iA0W = A0W() - 1; iA0W >= 0; iA0W--) {
            if (!MG.A0F(A0t(iA0W)).A0f()) {
                A14(iA0W, c6a);
            }
        }
    }

    public void A1J(C6A c6a, C6H c6h, int i, int i2) {
        this.A03.A1c(i, i2);
    }

    public void A1K(C6A c6a, C6H c6h, View view, AnonymousClass56 anonymousClass56) {
        AnonymousClass54 itemInfo = AnonymousClass54.A00(A21() ? A0p(view) : 0, 1, A20() ? A0p(view) : 0, 1, false, false);
        anonymousClass56.A0Q(itemInfo);
    }

    public final void A1L(C6F c6f) {
        if (this.A02 != null) {
            C6F c6f2 = this.A02;
            if (A0J[4].charAt(12) == 'v') {
                throw new RuntimeException();
            }
            A0J[6] = "G";
            if (c6f != c6f2 && this.A02.A0F()) {
                C6F c6f3 = this.A02;
                if (A0J[6].length() != 15) {
                    A0J[3] = "jdqDA9lv9LoPYcF6nkiuFYbBQf2p3Jna";
                    c6f3.A09();
                } else {
                    String[] strArr = A0J;
                    strArr[0] = "CfhUeeIqQu1BzHSX9SgRD70OnW7YoiZA";
                    strArr[7] = "rBLjTriW7e2LTgD4knhZEnVORkWVeovT";
                    c6f3.A09();
                }
            }
        }
        this.A02 = c6f;
        this.A02.A0D(this.A03, this);
    }

    public void A1M(MG mg) {
    }

    public final void A1N(MG mg) {
        this.A07 = true;
    }

    public final void A1O(MG mg) {
        A11(View.MeasureSpec.makeMeasureSpec(mg.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(mg.getHeight(), 1073741824));
    }

    public final void A1P(MG mg) {
        if (mg == null) {
            this.A03 = null;
            this.A01 = null;
            this.A0C = 0;
            this.A0A = 0;
        } else {
            this.A03 = mg;
            this.A01 = mg.A01;
            this.A0C = mg.getWidth();
            this.A0A = mg.getHeight();
        }
        this.A0D = 1073741824;
        this.A0B = 1073741824;
    }

    public final void A1Q(MG mg, C6A c6a) {
        this.A07 = false;
        A1w(mg, c6a);
    }

    public final void A1R(boolean z) {
        this.A06 = z;
    }

    public final boolean A1S() {
        int iA0W = A0W();
        for (int i = 0; i < iA0W; i++) {
            ViewGroup.LayoutParams layoutParams = A0t(i).getLayoutParams();
            int childCount = layoutParams.width;
            if (childCount < 0) {
                int childCount2 = layoutParams.height;
                if (childCount2 < 0) {
                    return true;
                }
            }
        }
        if (A0J[4].charAt(12) == 'v') {
            throw new RuntimeException();
        }
        A0J[3] = "WAOKNqtGQ8ovYE750tJA7vys4k4qcWl2";
        return false;
    }

    public final boolean A1T() {
        return this.A03 != null && this.A03.A0B;
    }

    public final boolean A1U() {
        return this.A0E;
    }

    public final boolean A1V(int i, Bundle bundle) {
        return A0Q(this.A03.A0r, this.A03.A0s, i, bundle);
    }

    public final boolean A1W(View view, int i, int i2, AnonymousClass63 anonymousClass63) {
        if (!view.isLayoutRequested()) {
            boolean z = this.A0F;
            String[] strArr = A0J;
            if (strArr[0].charAt(23) != strArr[7].charAt(23)) {
                throw new RuntimeException();
            }
            A0J[4] = "WuiXnf3Uz62WBJXd3E4QIRzbwyGUV3fL";
            if (z && A0O(view.getWidth(), i, anonymousClass63.width) && A0O(view.getHeight(), i2, anonymousClass63.height)) {
                return false;
            }
        }
        return true;
    }

    public final boolean A1X(View view, int i, Bundle bundle) {
        return A0R(this.A03.A0r, this.A03.A0s, view, i, bundle);
    }

    public boolean A1Y(AnonymousClass63 anonymousClass63) {
        return anonymousClass63 != null;
    }

    public final boolean A1Z(MG mg, View view, Rect rect, boolean z) {
        return A1a(mg, view, rect, z, false);
    }

    public final boolean A1a(MG mg, View view, Rect rect, boolean z, boolean z2) {
        int[] scrollAmount = A0U(view, rect);
        int i = scrollAmount[0];
        int i2 = scrollAmount[1];
        if ((z2 && !A0S(mg, i, i2)) || (i == 0 && i2 == 0)) {
            return false;
        }
        if (z) {
            mg.scrollBy(i, i2);
        } else {
            mg.A1e(i, i2);
        }
        return true;
    }

    public final boolean A1b(MG mg, C6H c6h, View view, View view2) {
        return A0T(mg, view, view2);
    }

    public final boolean A1c(MG mg, ArrayList<View> views, int i, int i2) {
        return false;
    }

    public View A1m(int i) {
        int iA0W = A0W();
        for (int i2 = 0; i2 < iA0W; i2++) {
            View child = A0t(i2);
            C6K c6kA0F = MG.A0F(child);
            if (c6kA0F != null) {
                int childCount = c6kA0F.A0I();
                if (childCount == i && !c6kA0F.A0f() && (this.A03.A0s.A07() || !c6kA0F.A0a())) {
                    return child;
                }
            }
        }
        return null;
    }

    public void A1t(AccessibilityEvent accessibilityEvent) {
        A0K(this.A03.A0r, this.A03.A0s, accessibilityEvent);
    }

    public void A1v(C6H c6h) {
    }

    public void A1w(MG mg, C6A c6a) {
    }

    public void A1y(String str) {
        if (this.A03 != null) {
            this.A03.A1n(str);
        }
    }
}
