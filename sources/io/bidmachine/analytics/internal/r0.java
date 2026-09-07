package io.bidmachine.analytics.internal;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class r0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12174a;

        static {
            int[] iArr = new int[q0.a.values().length];
            try {
                iArr[q0.a.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[q0.a.MONITOR_INVALID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[q0.a.MONITOR_NO_CONTENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[q0.a.MONITOR_BAD_CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[q0.a.READER_INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[q0.a.READER_NO_CONTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[q0.a.READER_BAD_CONTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[q0.a.READER_NO_ACCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f12174a = iArr;
        }
    }

    private static final int a(q0.a aVar) {
        switch (a.f12174a[aVar.ordinal()]) {
            case 1:
                return 2000;
            case 2:
                return 2100;
            case 3:
                return 2101;
            case 4:
                return 2102;
            case 5:
                return 2200;
            case 6:
                return 2201;
            case 7:
                return 2202;
            case 8:
                return 2203;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final q0.a a(int i) {
        switch (i) {
            case 2100:
                return q0.a.MONITOR_INVALID;
            case 2101:
                return q0.a.MONITOR_NO_CONTENT;
            case 2102:
                return q0.a.MONITOR_BAD_CONTENT;
            default:
                switch (i) {
                    case 2200:
                        return q0.a.READER_INVALID;
                    case 2201:
                        return q0.a.READER_NO_CONTENT;
                    case 2202:
                        return q0.a.READER_BAD_CONTENT;
                    case 2203:
                        return q0.a.READER_NO_ACCESS;
                    default:
                        return q0.a.UNKNOWN;
                }
        }
    }

    public static final JSONObject a(q0 q0Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", q0Var.a());
        jSONObject.put("type", a(q0Var.c()));
        jSONObject.put("reason", q0Var.b());
        return jSONObject;
    }

    public static final q0 a(JSONObject jSONObject) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(new q0(jSONObject.getString("name"), a(jSONObject.getInt("type")), jSONObject.optString("reason")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        return (q0) objM7904constructorimpl;
    }
}
