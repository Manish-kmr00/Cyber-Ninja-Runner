package com.json;

import android.content.Context;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ironsource/si;", "", "<init>", "()V", "a", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
public class si {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.ironsource.si$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u000e"}, d2 = {"Lcom/ironsource/si$a;", "", "Landroid/content/Context;", "context", "Lorg/json/JSONObject;", "a", "Lcom/ironsource/ls;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/ironsource/d8;", "d", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "<init>", "()V", "mediationsdk_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final JSONObject a(Context context) {
            try {
                return IronSourceNetworkBridge.jsonObjectInit(IronSourceUtils.getLastResponse(context));
            } catch (JSONException unused) {
                return IronSourceNetworkBridge.jsonObjectInit();
            }
        }

        @JvmStatic
        public final boolean b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            d8 d8VarD = d(context);
            return d8VarD.d().length() > 0 && d8VarD.e().length() > 0;
        }

        @JvmStatic
        public final ls c(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            d8 d8VarD = d(context);
            if (d8VarD.d().length() <= 0 || d8VarD.e().length() <= 0) {
                d8VarD = null;
            }
            if (d8VarD == null) {
                return null;
            }
            ls lsVar = new ls(context, d8VarD.d(), d8VarD.f(), d8VarD.e());
            lsVar.a(ls.a.CACHE);
            return lsVar;
        }

        @JvmStatic
        public final d8 d(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            JSONObject jSONObjectA = a(context);
            String cachedAppKey = jSONObjectA.optString("appKey");
            String cachedUserId = jSONObjectA.optString("userId");
            String cachedSettings = jSONObjectA.optString("response");
            Intrinsics.checkNotNullExpressionValue(cachedAppKey, "cachedAppKey");
            Intrinsics.checkNotNullExpressionValue(cachedUserId, "cachedUserId");
            Intrinsics.checkNotNullExpressionValue(cachedSettings, "cachedSettings");
            return new d8(cachedAppKey, cachedUserId, cachedSettings);
        }
    }

    @JvmStatic
    public static final boolean a(Context context) {
        return INSTANCE.b(context);
    }

    @JvmStatic
    public static final ls b(Context context) {
        return INSTANCE.c(context);
    }

    @JvmStatic
    public static final d8 c(Context context) {
        return INSTANCE.d(context);
    }
}
