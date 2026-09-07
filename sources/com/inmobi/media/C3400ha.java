package com.inmobi.media;

import android.content.Context;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.io.File;
import java.util.Calendar;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;

/* JADX INFO: renamed from: com.inmobi.media.ha, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3400ha extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3414ia f3334a;
    public final /* synthetic */ boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3400ha(C3414ia c3414ia, boolean z) {
        super(0);
        this.f3334a = c3414ia;
        this.b = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws JSONException {
        C3414ia c3414ia = this.f3334a;
        if (!c3414ia.g.isEmpty() && !c3414ia.h.isEmpty()) {
            String strC = c3414ia.c();
            Intrinsics.checkNotNullParameter(strC, "<this>");
            if (!Intrinsics.areEqual(strC, JsonUtils.EMPTY_JSON)) {
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                if (this.f3334a.j.length() == 0) {
                    C3414ia c3414ia2 = this.f3334a;
                    ScheduledExecutorService scheduledExecutorService = AbstractC3554s6.f3426a;
                    Context context = c3414ia2.f3340a;
                    Intrinsics.checkNotNullParameter(context, "context");
                    File file = new File(context.getFilesDir() + "/logging");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    c3414ia2.j = context.getFilesDir() + "/logging/" + timeInMillis + ".txt";
                }
                C3414ia c3414ia3 = this.f3334a;
                if (AbstractC3568t6.a("RemoteLogger", c3414ia3.c(), c3414ia3.j)) {
                    C3414ia c3414ia4 = this.f3334a;
                    boolean z = this.b;
                    String str = c3414ia4.j;
                    C3368f6 data = new C3368f6(str, timeInMillis, 0, 0L, z, c3414ia4.k.get(), 12);
                    C3382g6 c3382g6D = AbstractC3415ib.d();
                    c3382g6D.getClass();
                    Intrinsics.checkNotNullParameter(data, "data");
                    if (D1.a(c3382g6D, "filename=\"" + str + '\"', null, null, null, null, null, 62).isEmpty()) {
                        int i = this.f3334a.c;
                        c3382g6D.a((Object) data);
                        if (c3382g6D.b != null) {
                            O4.a();
                        }
                        ScheduledExecutorService scheduledExecutorService2 = AbstractC3554s6.f3426a;
                        C3414ia c3414ia5 = this.f3334a;
                        AbstractC3539r6.a(c3382g6D, timeInMillis - c3414ia5.b, c3414ia5.c);
                    } else {
                        c3382g6D.b(data);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}
