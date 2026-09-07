package com.chartboost.sdk.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/chartboost/sdk/impl/b0;", "Lcom/chartboost/sdk/impl/a;", "Lorg/json/JSONObject;", "response", "a", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "", "Ljava/util/List;", "interceptors", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class b0 implements a<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final List<a<JSONObject>> interceptors = new ArrayList();

    @Override // com.chartboost.sdk.impl.a
    public JSONObject a(JSONObject response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Iterator<a<JSONObject>> it = this.interceptors.iterator();
        while (it.hasNext()) {
            response = it.next().a(response);
        }
        return response;
    }
}
