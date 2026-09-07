package com.yandex.mobile.ads.impl;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class ui {
    public static ti a(JSONObject jsonValue) {
        Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
        Object objOpt = jsonValue.opt(ViewHierarchyConstants.DIMENSION_TOP_KEY);
        String str = objOpt instanceof String ? (String) objOpt : null;
        Object objOpt2 = jsonValue.opt("right");
        String str2 = objOpt2 instanceof String ? (String) objOpt2 : null;
        Object objOpt3 = jsonValue.opt("left");
        String str3 = objOpt3 instanceof String ? (String) objOpt3 : null;
        Object objOpt4 = jsonValue.opt("bottom");
        return new ti(str, str2, str3, objOpt4 instanceof String ? (String) objOpt4 : null);
    }
}
