package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class he1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qa2 f9086a;
    private final ke1 b;
    private final te1 c;

    public final mn2 a(List verifications) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(verifications, "verifications");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Iterator it = verifications.iterator();
        while (it.hasNext()) {
            oa2 oa2Var = (oa2) it.next();
            try {
                this.c.getClass();
                listCreateListBuilder.add(te1.a(oa2Var));
            } catch (pa2 e) {
                this.f9086a.a(e);
            } catch (Exception unused) {
                op0.c(new Object[0]);
            }
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        if (listBuild.isEmpty()) {
            return null;
        }
        return b9.a(c9.a(), d9.a(bg1.a(), this.b.a(), listBuild));
    }

    public /* synthetic */ he1(Context context, qa2 qa2Var) {
        this(context, qa2Var, new ke1(context), new te1());
    }

    public he1(Context context, qa2 verificationNotExecutedListener, ke1 omSdkJsLoader, te1 omSdkVerificationScriptResourceCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(verificationNotExecutedListener, "verificationNotExecutedListener");
        Intrinsics.checkNotNullParameter(omSdkJsLoader, "omSdkJsLoader");
        Intrinsics.checkNotNullParameter(omSdkVerificationScriptResourceCreator, "omSdkVerificationScriptResourceCreator");
        this.f9086a = verificationNotExecutedListener;
        this.b = omSdkJsLoader;
        this.c = omSdkVerificationScriptResourceCreator;
    }
}
