package com.inmobi.media;

import android.view.MotionEvent;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public final class F6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ba f3069a;
    public final String b;
    public float c;
    public float d;
    public float e;
    public float f;
    public int g;
    public int h;
    public float i;
    public JSONArray j;
    public MotionEvent k;
    public int l;

    public F6(Ba mListener) {
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        this.f3069a = mListener;
        this.b = "F6";
        this.l = Integer.MAX_VALUE;
        this.g = -1;
        this.h = -1;
    }

    public final void a(MotionEvent endEvent) {
        float y;
        float x;
        float f;
        Intrinsics.checkNotNullParameter(endEvent, "event");
        int actionMasked = endEvent.getActionMasked();
        if (actionMasked == 0) {
            String TAG = this.b;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            endEvent.toString();
            this.g = endEvent.getPointerId(endEvent.getActionIndex());
            this.j = new JSONArray();
            JSONArray jSONArray = new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(AbstractC3420j2.a(endEvent.getX())), Integer.valueOf(AbstractC3420j2.a(endEvent.getY()))}));
            JSONArray jSONArray2 = this.j;
            if (jSONArray2 != null) {
                jSONArray2.put(jSONArray);
                return;
            }
            return;
        }
        String str = " \n ";
        if (actionMasked == 1) {
            String TAG2 = this.b;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            endEvent.toString();
            this.g = -1;
            JSONArray jSONArray3 = this.j;
            if (jSONArray3 == null || jSONArray3.length() <= 5) {
                return;
            }
            Ba ba = this.f3069a;
            Intrinsics.checkNotNullParameter(this, "movementGestureDetector");
            if (ba.getRenderingConfig().getSupportedGestures().contains(2)) {
                L4 l4 = ba.i;
                if (l4 != null) {
                    String str2 = Ba.O0;
                    StringBuilder sbA = O5.a(str2, "TAG", "onPanDetected\n ");
                    JSONArray jSONArray4 = this.j;
                    ((M4) l4).a(str2, StringsKt.trimIndent(sbA.append(jSONArray4 != null ? Integer.valueOf(jSONArray4.length()) : null).append(" \n ").append(this.j).toString()));
                }
                ba.b("window.imraidview.onGestureDetected('2', '" + this.j + "');");
            } else {
                L4 l5 = ba.i;
                if (l5 != null) {
                    String TAG3 = Ba.O0;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((M4) l5).c(TAG3, "Pan gesture is disabled from config");
                }
            }
            this.j = new JSONArray();
            return;
        }
        if (actionMasked == 2) {
            float y2 = 0.0f;
            JSONArray jSONArray5 = this.j;
            int i = this.g;
            if (i == -1 || this.h == -1) {
                if (i == -1 || jSONArray5 == null || jSONArray5.length() <= 0 || jSONArray5.length() >= 50) {
                    return;
                }
                try {
                    int iA = AbstractC3420j2.a(endEvent.getX());
                    int iA2 = AbstractC3420j2.a(endEvent.getY());
                    JSONArray jSONArray6 = jSONArray5.getJSONArray(jSONArray5.length() - 1);
                    JSONArray jSONArray7 = new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(iA), Integer.valueOf(iA2)}));
                    float f2 = jSONArray6.getInt(0) - jSONArray7.getInt(0);
                    float f3 = jSONArray6.getInt(1) - jSONArray7.getInt(1);
                    if (((int) Math.sqrt((f3 * f3) + (f2 * f2))) > 100) {
                        jSONArray5.put(jSONArray7);
                        return;
                    }
                    return;
                } catch (JSONException unused) {
                    return;
                }
            }
            int iFindPointerIndex = endEvent.findPointerIndex(i);
            int iFindPointerIndex2 = endEvent.findPointerIndex(this.h);
            if (iFindPointerIndex >= 0) {
                x = endEvent.getX(iFindPointerIndex);
                y = endEvent.getY(iFindPointerIndex);
            } else {
                C3339d5 c3339d5 = C3339d5.f3292a;
                P1 event = new P1(new IllegalArgumentException("Index for mPtrID1=" + this.g + " is " + iFindPointerIndex + " | Pointer count=" + endEvent.getPointerCount()));
                Intrinsics.checkNotNullParameter(event, "event");
                C3339d5.c.a(event);
                y = 0.0f;
                x = 0.0f;
            }
            if (iFindPointerIndex2 >= 0) {
                float x2 = endEvent.getX(iFindPointerIndex2);
                y2 = endEvent.getY(iFindPointerIndex2);
                f = x2;
            } else {
                C3339d5 c3339d6 = C3339d5.f3292a;
                P1 event2 = new P1(new IllegalArgumentException("Index for mPtrID1=" + this.h + " is " + iFindPointerIndex2 + " | Pointer count=" + endEvent.getPointerCount()));
                Intrinsics.checkNotNullParameter(event2, "event");
                C3339d5.c.a(event2);
                f = 0.0f;
            }
            float degrees = ((float) Math.toDegrees(((float) Math.atan2(this.d - this.f, this.c - this.e)) - ((float) Math.atan2(y2 - y, f - x)))) % 360;
            if (degrees < -180.0f) {
                degrees += 360.0f;
            }
            if (degrees > 180.0f) {
                degrees -= 360.0f;
            }
            this.i = Math.abs(degrees);
            return;
        }
        if (actionMasked == 3) {
            String TAG4 = this.b;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            endEvent.toString();
            this.g = -1;
            this.h = -1;
            return;
        }
        if (actionMasked == 5) {
            String TAG5 = this.b;
            Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
            endEvent.toString();
            this.h = endEvent.getPointerId(endEvent.getActionIndex());
            this.k = MotionEvent.obtain(endEvent);
            int iFindPointerIndex3 = endEvent.findPointerIndex(this.g);
            int iFindPointerIndex4 = endEvent.findPointerIndex(this.h);
            if (iFindPointerIndex3 >= 0) {
                this.e = endEvent.getX(iFindPointerIndex3);
                this.f = endEvent.getY(iFindPointerIndex3);
            } else {
                C3339d5 c3339d7 = C3339d5.f3292a;
                P1 event3 = new P1(new IllegalArgumentException("Index for mPtrID1=" + this.g + " is " + iFindPointerIndex3 + " | Pointer count=" + endEvent.getPointerCount()));
                Intrinsics.checkNotNullParameter(event3, "event");
                C3339d5.c.a(event3);
            }
            if (iFindPointerIndex4 >= 0) {
                this.c = endEvent.getX(iFindPointerIndex4);
                this.d = endEvent.getY(iFindPointerIndex4);
            } else {
                C3339d5 c3339d8 = C3339d5.f3292a;
                P1 event4 = new P1(new IllegalArgumentException("Index for mPtrID2=" + this.h + " is " + iFindPointerIndex4 + " | Pointer count=" + endEvent.getPointerCount()));
                Intrinsics.checkNotNullParameter(event4, "event");
                C3339d5.c.a(event4);
            }
            float f4 = this.e - this.c;
            float f5 = this.f - this.d;
            this.l = (int) Math.sqrt((f5 * f5) + (f4 * f4));
            return;
        }
        if (actionMasked != 6) {
            return;
        }
        String TAG6 = this.b;
        Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
        endEvent.toString();
        this.h = -1;
        if (this.i > 30.0f) {
            MotionEvent initialEvent = this.k;
            if (initialEvent != null) {
                Ba ba2 = this.f3069a;
                Intrinsics.checkNotNullParameter(this, "movementGestureDetector");
                Intrinsics.checkNotNullParameter(initialEvent, "initialEvent");
                Intrinsics.checkNotNullParameter(endEvent, "endEvent");
                if (ba2.getRenderingConfig().getSupportedGestures().contains(3)) {
                    L4 l6 = ba2.i;
                    if (l6 != null) {
                        String str3 = Ba.O0;
                        ((M4) l6).a(str3, StringsKt.trimIndent(O5.a(str3, "TAG", " Rotation detected ").append(this.i).append(" \n ").append(initialEvent).append(" \n ").append(endEvent).toString()));
                    }
                    JSONArray jSONArray8 = new JSONArray();
                    jSONArray8.put(new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(AbstractC3420j2.a(initialEvent.getX())), Integer.valueOf(AbstractC3420j2.a(initialEvent.getY()))})));
                    jSONArray8.put(new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(AbstractC3420j2.a(initialEvent.getX(1))), Integer.valueOf(AbstractC3420j2.a(initialEvent.getY(1)))})));
                    jSONArray8.put(new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(AbstractC3420j2.a(endEvent.getX())), Integer.valueOf(AbstractC3420j2.a(endEvent.getY()))})));
                    jSONArray8.put(new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(AbstractC3420j2.a(endEvent.getX(1))), Integer.valueOf(AbstractC3420j2.a(endEvent.getY(1)))})));
                    ba2.b("window.imraidview.onGestureDetected('3', '" + jSONArray8 + "');");
                } else {
                    L4 l7 = ba2.i;
                    if (l7 != null) {
                        String TAG7 = Ba.O0;
                        Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                        ((M4) l7).c(TAG7, "Rotation gesture is disabled from config");
                    }
                }
            }
            this.i = 0.0f;
        } else {
            str = " \n ";
        }
        float x3 = endEvent.getX() - endEvent.getX(1);
        float y3 = endEvent.getY() - endEvent.getY(1);
        if (Math.abs(((int) Math.sqrt((y3 * y3) + (x3 * x3))) - this.l) > 500) {
            MotionEvent initialEvent2 = this.k;
            if (initialEvent2 != null) {
                Ba ba3 = this.f3069a;
                Intrinsics.checkNotNullParameter(this, "movementGestureDetector");
                Intrinsics.checkNotNullParameter(initialEvent2, "initialEvent");
                Intrinsics.checkNotNullParameter(endEvent, "endEvent");
                if (ba3.getRenderingConfig().getSupportedGestures().contains(4)) {
                    L4 l8 = ba3.i;
                    if (l8 != null) {
                        String TAG8 = Ba.O0;
                        Intrinsics.checkNotNullExpressionValue(TAG8, "TAG");
                        ((M4) l8).a(TAG8, StringsKt.trimIndent(" onScaleDetected\n " + initialEvent2 + str + endEvent));
                    }
                    JSONArray jSONArray9 = new JSONArray();
                    float f6 = 2;
                    jSONArray9.put(new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(AbstractC3420j2.a((endEvent.getX(1) + endEvent.getX()) / f6)), Integer.valueOf(AbstractC3420j2.a((endEvent.getY(1) + endEvent.getY()) / f6))})));
                    ba3.b("window.imraidview.onGestureDetected('4', '" + jSONArray9 + "');");
                } else {
                    L4 l9 = ba3.i;
                    if (l9 != null) {
                        String TAG9 = Ba.O0;
                        Intrinsics.checkNotNullExpressionValue(TAG9, "TAG");
                        ((M4) l9).c(TAG9, "Pinch gesture is disabled from config");
                    }
                }
            }
            this.l = Integer.MAX_VALUE;
        }
    }
}
