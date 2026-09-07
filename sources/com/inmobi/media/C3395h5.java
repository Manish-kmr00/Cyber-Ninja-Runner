package com.inmobi.media;

import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.h5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3395h5 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3331a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3395h5(C3409i5 c3409i5, ArrayList arrayList) {
        super(1);
        this.f3331a = arrayList;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws JSONException {
        String text$default;
        C3368f6 dbData = (C3368f6) obj;
        Intrinsics.checkNotNullParameter(dbData, "dbData");
        CopyOnWriteArrayList copyOnWriteArrayList = AbstractC3526q6.f3406a;
        String fileName = dbData.f3312a;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        C3423j5 c3423j5 = null;
        try {
            Iterator it = AbstractC3526q6.f3406a.iterator();
            while (it.hasNext()) {
                C3414ia c3414ia = (C3414ia) ((WeakReference) it.next()).get();
                if (Intrinsics.areEqual(c3414ia != null ? c3414ia.j : null, fileName)) {
                    return Unit.INSTANCE;
                }
            }
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
        String filePath = dbData.f3312a;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            try {
                text$default = FilesKt.readText$default(file, null, 1, null);
            } catch (Exception unused) {
                text$default = null;
            }
        } else {
            text$default = null;
        }
        if (text$default != null) {
            JSONObject jSONObject = new JSONObject(text$default);
            JSONObject jSONObject2 = jSONObject.getJSONObject("vitals");
            JSONArray jSONArray = jSONObject.getJSONArray(CreativeInfo.f);
            Intrinsics.checkNotNull(jSONObject2);
            Intrinsics.checkNotNull(jSONArray);
            c3423j5 = new C3423j5(jSONObject2, jSONArray, dbData);
        }
        if (c3423j5 != null) {
            this.f3331a.add(c3423j5);
        }
        return Unit.INSTANCE;
    }
}
