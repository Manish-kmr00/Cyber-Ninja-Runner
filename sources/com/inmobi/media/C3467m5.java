package com.inmobi.media;

import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.Calendar;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.m5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3467m5 extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3483n5 f3373a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3467m5(C3483n5 c3483n5) {
        super(0);
        this.f3373a = c3483n5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws JSONException {
        C3423j5 c3423j5 = this.f3373a.f3381a;
        JSONObject jSONObject = c3423j5.f3345a;
        JSONArray jSONArray = c3423j5.b;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("vitals", jSONObject);
        jSONObject2.put(CreativeInfo.f, jSONArray);
        String string = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        AbstractC3568t6.a("IncompleteLogFinalizer", string, this.f3373a.f3381a.c.f3312a);
        String str = this.f3373a.f3381a.c.f3312a;
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        C3368f6 c3368f6 = this.f3373a.f3381a.c;
        AbstractC3415ib.d().b(new C3368f6(str, timeInMillis, 0, c3368f6.d, true, c3368f6.f));
        return Unit.INSTANCE;
    }
}
