package com.json.sdk;

import android.app.Activity;
import android.content.Context;
import com.json.gr;
import com.json.vj;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class SSAFactory {
    public static gr getPublisherInstance(Activity activity) throws Exception {
        return vj.b((Context) activity);
    }

    public static gr getPublisherTestInstance(Activity activity, int i) throws Exception {
        return vj.a(activity, i);
    }
}
