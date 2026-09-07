package com.json;

import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/ironsource/fc;", "Lcom/ironsource/d2;", "Lcom/ironsource/f1;", "adProperties", "", "", "", "a", "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public abstract class fc implements d2 {
    public final Map<String, Object> a(f1 adProperties) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        String string = adProperties.getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String().toString();
        Intrinsics.checkNotNullExpressionValue(string, "adProperties.adFormat.toString()");
        map.put(fl.EVENTS_LEVEL_PLAY_AD_FORMAT_NAME, string);
        map.put("adf", Integer.valueOf(vt.b(adProperties.getCom.ironsource.mediationsdk.impressionData.ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT java.lang.String())));
        String string2 = adProperties.getAdId().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "adProperties.adId.toString()");
        map.put(fl.EVENTS_LEVEL_PLAY_AD_ID, string2);
        map.put("mediationAdUnitId", adProperties.getAdUnitId());
        map.put("isMultipleAdUnits", 1);
        return map;
    }
}
