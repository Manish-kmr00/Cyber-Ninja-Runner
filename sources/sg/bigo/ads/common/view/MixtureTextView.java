package sg.bigo.ads.common.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes4.dex */
public class MixtureTextView extends RelativeLayout {
    private static int[] s = {R.attr.textSize, R.attr.textColor, R.attr.text};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Layout f13317a;
    private int b;
    private int c;
    private int d;
    private CharSequence e;
    private TextPaint f;
    private List<List<Rect>> g;
    private List<Integer> h;
    private List<Layout> i;
    private List<Integer> j;
    private HashSet<Integer> k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private Map<Integer, Point> t;
    private a u;
    private boolean v;

    public interface a {
        void a(UnderlineSpan underlineSpan);
    }

    public MixtureTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13317a = null;
        this.c = -9601400;
        this.g = new ArrayList();
        this.h = null;
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new HashSet<>();
        this.t = new HashMap();
        this.v = true;
        this.d = e.b(getContext(), 14);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, this.d);
        this.c = typedArrayObtainStyledAttributes.getColor(1, this.c);
        this.e = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.f = textPaint;
        textPaint.setDither(true);
        this.f.setAntiAlias(true);
        this.f.setColor(this.c);
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        this.q = true;
    }

    private static CharSequence a(CharSequence charSequence, int i, int i2) {
        if (q.a(charSequence)) {
            return null;
        }
        if (!(charSequence instanceof SpannableString)) {
            if (charSequence instanceof String) {
                return ((String) charSequence).substring(i, i2);
            }
            return null;
        }
        SpannableString spannableString = (SpannableString) charSequence;
        SpannableString spannableString2 = new SpannableString(TextUtils.substring(spannableString, i, i2));
        Object[] spans = spannableString.getSpans(i, i2, Object.class);
        for (int length = spans.length - 1; length >= 0; length--) {
            Object obj = spans[length];
            int spanStart = spannableString.getSpanStart(obj) - i;
            int spanEnd = spannableString.getSpanEnd(obj) - i;
            try {
                int length2 = spannableString2.length();
                if (spanEnd >= spanStart && spanStart <= length2 && spanEnd <= length2 && spanStart >= 0) {
                    spannableString2.setSpan(obj, spanStart, spanEnd, 33);
                }
            } catch (Exception unused) {
            }
        }
        return spannableString2;
    }

    private List<Rect> a(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            Point point = this.t.get(Integer.valueOf(i3));
            int i4 = point.x;
            int i5 = point.y;
            if (i4 <= i && i5 >= i2) {
                arrayList.add(new Rect(childAt.getLeft(), i, childAt.getRight(), i2));
            }
        }
        Collections.sort(arrayList, new Comparator<Rect>() { // from class: sg.bigo.ads.common.view.MixtureTextView.1
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Rect rect, Rect rect2) {
                return rect.left > rect2.left ? 1 : -1;
            }
        });
        if (arrayList.size() < 2) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        Rect rect = (Rect) arrayList.get(0);
        Rect rect2 = (Rect) arrayList.get(1);
        for (int i6 = 1; i6 < arrayList.size(); i6++) {
            if (!Rect.intersects(rect, rect2)) {
                if (arrayList2.size() - i6 < 2) {
                    break;
                }
                Rect rect3 = rect2;
                rect2 = (Rect) arrayList.get(i6 + 1);
                rect = rect3;
            } else {
                int iMin = Math.min(rect.left, rect2.left);
                int iMax = Math.max(rect.right, rect2.right);
                arrayList2.remove(rect);
                arrayList2.remove(rect2);
                arrayList2.add(new Rect(iMin, i, iMax, i2));
                if (arrayList2.size() < 2) {
                    break;
                }
                rect = (Rect) arrayList.get(0);
                rect2 = (Rect) arrayList.get(1);
            }
        }
        return arrayList2;
    }

    private static void a(Rect rect, List<Rect> list, int i, int i2, int i3) {
        if (rect.right < i3) {
            list.add(new Rect(rect.right, i, i3, i2));
        }
    }

    private boolean a(Canvas canvas) {
        boolean z = canvas == null;
        int i = this.b;
        List<List<Rect>> list = this.g;
        CharSequence charSequence = this.e;
        int length = charSequence != null ? charSequence.length() : 0;
        int lineEnd = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Rect rect = list.get(i3).get(0);
            int iWidth = rect.width();
            int iHeight = rect.height();
            CharSequence charSequenceA = a(this.e, lineEnd, length);
            StaticLayout staticLayout = (q.a(charSequenceA) || this.f == null) ? null : new StaticLayout(charSequenceA, this.f, iWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.f13317a = staticLayout;
            if (staticLayout != null) {
                int iMin = Math.min(staticLayout.getLineCount(), iHeight / i);
                if (!z) {
                    canvas.save();
                    canvas.translate(rect.left, rect.top);
                    canvas.clipRect(0, 0, rect.width(), this.f13317a.getLineBottom(iMin - 1) - this.f13317a.getLineTop(0));
                    this.f13317a.draw(canvas);
                    canvas.restore();
                }
                lineEnd += this.f13317a.getLineEnd(iMin - 1);
                if (canvas != null) {
                    this.i.add(this.f13317a);
                    this.j.add(Integer.valueOf(iMin));
                }
                i2 += iMin;
                if (lineEnd >= length) {
                    break;
                }
            }
        }
        if (z) {
            int i4 = this.l + (i2 * i);
            this.l = i4;
            if (i4 > this.r) {
                int height = getHeight();
                int i5 = this.l;
                if (height != i5 && this.n != 1073741824) {
                    this.o = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                    this.p = true;
                    requestLayout();
                    return true;
                }
            }
        }
        return false;
    }

    private static void b(Rect rect, List<Rect> list, int i, int i2, int i3) {
        if (rect.left > i3) {
            list.add(new Rect(i3, i, rect.left, i2));
        }
    }

    private void getAllYCors() {
        int i = this.b;
        HashSet<Integer> hashSet = this.k;
        hashSet.clear();
        this.t.clear();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                childAt.getTop();
                int top = (((childAt.getTop() - getPaddingTop()) / i) * i) + getPaddingTop();
                hashSet.add(Integer.valueOf(top));
                int bottom = childAt.getBottom() - getPaddingTop();
                if (bottom % i != 0) {
                    bottom = ((bottom / i) + 1) * i;
                }
                int paddingTop = bottom + getPaddingTop();
                hashSet.add(Integer.valueOf(paddingTop));
                this.t.put(Integer.valueOf(i2), new Point(top, paddingTop));
            }
        }
        hashSet.add(Integer.valueOf(getPaddingTop()));
        hashSet.add(Integer.valueOf(this.n == 1073741824 ? getHeight() : Integer.MAX_VALUE));
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        this.h = arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.l = getPaddingBottom() + getPaddingTop();
        int i = this.b;
        List<List<Rect>> list = this.g;
        List<Integer> list2 = this.h;
        list.clear();
        if (list2 != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= list2.size() - 1) {
                    break;
                }
                int iIntValue = list2.get(i3).intValue();
                i3++;
                int iIntValue2 = list2.get(i3).intValue();
                ArrayList arrayList = new ArrayList();
                List<Rect> listA = a(iIntValue, iIntValue2);
                int size = listA.size();
                if (size == 0) {
                    arrayList.add(new Rect(paddingLeft, iIntValue, width, iIntValue2));
                } else if (size != 1) {
                    b(listA.get(i2), arrayList, iIntValue, iIntValue2, paddingLeft);
                    int i4 = i2;
                    for (int i5 = 1; i4 < listA.size() - i5; i5 = 1) {
                        Rect rect = listA.get(i4);
                        i4++;
                        Rect rect2 = listA.get(i4);
                        if (rect.right < rect2.left) {
                            arrayList.add(new Rect(rect.right, iIntValue, rect2.left, iIntValue2));
                        }
                    }
                    a(listA.get(listA.size() - 1), arrayList, iIntValue, iIntValue2, width);
                } else {
                    Rect rect3 = listA.get(i2);
                    b(rect3, arrayList, iIntValue, iIntValue2, paddingLeft);
                    a(rect3, arrayList, iIntValue, iIntValue2, width);
                }
                list.add(arrayList);
                i2 = 0;
            }
            ArrayList arrayList2 = new ArrayList(list);
            int size2 = list.size();
            int i6 = 0;
            int i7 = 0;
            while (i7 < size2) {
                List<Rect> list3 = list.get(i7);
                if (list3.size() > 1) {
                    int i8 = i6 + i7;
                    arrayList2.remove(list3);
                    i6--;
                    Rect rect4 = list3.get(0);
                    int iHeight = rect4.height() / i;
                    this.l -= ((list3.size() - 1) * iHeight) * i;
                    int i9 = i8;
                    int i10 = 0;
                    while (i10 < iHeight) {
                        int i11 = i9;
                        int i12 = 0;
                        while (i12 < list3.size()) {
                            int i13 = i * i10;
                            arrayList2.add(i11, Arrays.asList(new Rect(list3.get(i12).left, rect4.top + i13, list3.get(i12).right, rect4.top + i13 + i)));
                            i12++;
                            i11++;
                            size2 = size2;
                            list = list;
                            list3 = list3;
                            i6++;
                        }
                        i10++;
                        i9 = i11;
                        list = list;
                    }
                }
                i7++;
                size2 = size2;
                list = list;
            }
            this.g = arrayList2;
        }
        if (a(null)) {
            return;
        }
        a(canvas);
        super.dispatchDraw(canvas);
    }

    public CharSequence getText() {
        return this.e;
    }

    public int getTextColor() {
        return this.c;
    }

    public int getTextSize() {
        return this.d;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int offsetForHorizontal;
        a aVar;
        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0 && q.b(this.e)) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (this.i.isEmpty() || this.j.isEmpty()) {
                offsetForHorizontal = 0;
            } else {
                offsetForHorizontal = 0;
                int i = 0;
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    Layout layout = this.i.get(i2);
                    int iIntValue = this.j.get(i2).intValue();
                    if (layout != null) {
                        int lineForVertical = layout.getLineForVertical(y);
                        if (lineForVertical + 1 <= iIntValue) {
                            offsetForHorizontal += layout == null ? 0 : layout.getOffsetForHorizontal(Math.min(lineForVertical, layout.getLineCount() - 1), x);
                            break;
                        }
                        i += iIntValue;
                        y -= this.b * i;
                        offsetForHorizontal += layout.getLineEnd(iIntValue - 1);
                    }
                }
            }
            if (offsetForHorizontal < this.e.length()) {
                CharSequence charSequence = this.e;
                if (charSequence instanceof SpannableString) {
                    UnderlineSpan[] underlineSpanArr = (UnderlineSpan[]) ((SpannableString) charSequence).getSpans(offsetForHorizontal, offsetForHorizontal, UnderlineSpan.class);
                    if (underlineSpanArr.length > 0 && (aVar = this.u) != null) {
                        aVar.a(underlineSpanArr[0]);
                        return true;
                    }
                }
            }
        }
        return zOnInterceptTouchEvent;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.v) {
            this.n = View.MeasureSpec.getMode(this.m);
            this.v = false;
            this.r = getMeasuredHeight();
        }
        super.onLayout(z, i, i2, i3, i4);
        if (this.q) {
            getAllYCors();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!this.q) {
            super.onMeasure(i, i2);
            return;
        }
        this.m = i2;
        this.f.setTextSize(this.d);
        StaticLayout staticLayout = new StaticLayout("测量行高", this.f, 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f13317a = staticLayout;
        this.b = staticLayout.getLineBottom(0) - this.f13317a.getLineTop(0);
        if (this.p) {
            super.onMeasure(i, this.o);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setClickListener(a aVar) {
        this.u = aVar;
    }

    public void setText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.q = false;
            requestLayout();
        } else {
            this.q = true;
            this.e = charSequence;
            requestLayout();
            invalidate();
        }
    }

    public void setTextColor(int i) {
        this.f.setColor(i);
        this.c = i;
        invalidate();
    }

    public void setTextSize(int i) {
        this.d = i;
        this.f.setTextSize(i);
        requestLayout();
        invalidate();
    }
}
