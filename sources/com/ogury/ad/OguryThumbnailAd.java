package com.ogury.ad;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.json.m5;
import com.ogury.ad.common.OguryMediation;
import com.ogury.ad.internal.a7;
import com.ogury.ad.internal.a8;
import com.ogury.ad.internal.b8;
import com.ogury.ad.internal.d;
import com.ogury.ad.internal.d7;
import com.ogury.ad.internal.ea;
import com.ogury.ad.internal.h;
import com.ogury.ad.internal.j4;
import com.ogury.ad.internal.m6;
import com.ogury.ad.internal.r5;
import com.ogury.ad.internal.s6;
import com.ogury.ad.internal.t5;
import com.ogury.ad.internal.t7;
import com.ogury.ad.internal.x;
import com.ogury.ad.internal.y;
import com.ogury.ad.internal.y8;
import com.ogury.ad.internal.z5;
import com.ogury.ad.internal.z6;
import com.ogury.core.internal.IntegrationLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001dJ%\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018¢\u0006\u0004\b\"\u0010#J\u0015\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010$J-\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0018¢\u0006\u0004\b\"\u0010)J\r\u0010+\u001a\u00020*¢\u0006\u0004\b+\u0010,J!\u0010/\u001a\u00020\u000b2\u0012\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040-\"\u00020\u0004¢\u0006\u0004\b/\u00100J3\u00103\u001a\u00020\u000b2\"\u00102\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001e010-\"\n\u0012\u0006\b\u0001\u0012\u00020\u001e01H\u0007¢\u0006\u0004\b3\u00104J!\u00105\u001a\u00020\u000b2\u0012\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040-\"\u00020\u0004¢\u0006\u0004\b5\u00100J3\u00108\u001a\u00020\u000b2\"\u00107\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u000206010-\"\n\u0012\u0006\b\u0001\u0012\u00020601H\u0007¢\u0006\u0004\b8\u00104J\u0015\u00109\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b9\u0010$¨\u0006:"}, d2 = {"Lcom/ogury/ad/OguryThumbnailAd;", "Lcom/ogury/ad/internal/t5;", "Landroid/content/Context;", "context", "", "adUnitId", "Lcom/ogury/ad/common/OguryMediation;", "oguryMediation", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/ogury/ad/common/OguryMediation;)V", "campaignId", "", "setCampaignId", "(Ljava/lang/String;)V", "creativeId", "setCreativeId", "dspCreativeId", "setDspCreativeId", "dspAwsRegion", "setDspAwsRegion", "Lcom/ogury/ad/OguryThumbnailAdListener;", "thumbnailAdListener", "setListener", "(Lcom/ogury/ad/OguryThumbnailAdListener;)V", "", "maxWidth", "maxHeight", "load", "(II)V", "()V", "Landroid/app/Activity;", "activity", "leftMargin", "topMargin", m5.v, "(Landroid/app/Activity;II)V", "(Landroid/app/Activity;)V", "Lcom/ogury/ad/OguryThumbnailGravity;", "gravity", "xMargin", "yMargin", "(Landroid/app/Activity;Lcom/ogury/ad/OguryThumbnailGravity;II)V", "", "isLoaded", "()Z", "", "packages", "setWhiteListPackages", "([Ljava/lang/String;)V", "Ljava/lang/Class;", "activities", "setBlackListActivities", "([Ljava/lang/Class;)V", "setWhiteListFragmentPackages", "", "fragments", "setBlackListFragments", "logWhiteListedActivities", "sdk-ads_prodRelease"}, k = 1, mv = {2, 0, 0})
public final class OguryThumbnailAd implements t5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s6 f7253a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OguryThumbnailAd(Context context, String adUnitId) {
        this(context, adUnitId, null, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
    }

    private final void setCampaignId(String campaignId) {
        s6 s6Var = this.f7253a;
        s6Var.getClass();
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        y yVar = s6Var.c;
        yVar.getClass();
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        yVar.b.b = campaignId;
    }

    private final void setCreativeId(String creativeId) {
        s6 s6Var = this.f7253a;
        s6Var.getClass();
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        y yVar = s6Var.c;
        yVar.getClass();
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        yVar.b.c = creativeId;
    }

    private final void setDspAwsRegion(String dspAwsRegion) {
        s6 s6Var = this.f7253a;
        s6Var.getClass();
        Intrinsics.checkNotNullParameter(dspAwsRegion, "dspAwsRegion");
        y yVar = s6Var.c;
        yVar.getClass();
        Intrinsics.checkNotNullParameter(dspAwsRegion, "dspAwsRegion");
        yVar.b.e = dspAwsRegion;
    }

    private final void setDspCreativeId(String dspCreativeId) {
        s6 s6Var = this.f7253a;
        s6Var.getClass();
        Intrinsics.checkNotNullParameter(dspCreativeId, "dspCreativeId");
        y yVar = s6Var.c;
        yVar.getClass();
        Intrinsics.checkNotNullParameter(dspCreativeId, "dspCreativeId");
        yVar.b.d = dspCreativeId;
    }

    public final boolean isLoaded() {
        x xVar = this.f7253a.k;
        return xVar != null && xVar.o;
    }

    public final void load(int maxWidth, int maxHeight) throws JSONException {
        IntegrationLogger.d("[Ads] Thumbnail Ad - load() called with maxWidth: " + maxWidth + " maxHeight: " + maxHeight);
        this.f7253a.a(maxWidth, maxHeight);
    }

    public final void logWhiteListedActivities(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        s6 s6Var = this.f7253a;
        s6Var.getClass();
        Intrinsics.checkNotNullParameter(activity, "activity");
        t7 t7Var = ea.f7294a;
        a8 publisherActivityFilter = s6Var.e;
        b8 publisherFragmentFilter = s6Var.f;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(publisherActivityFilter, "publisherActivityFilter");
        Intrinsics.checkNotNullParameter(publisherFragmentFilter, "publisherFragmentFilter");
        Application application = activity.getApplication();
        Intrinsics.checkNotNull(application);
        h hVar = new h(application);
        z6 z6VarA = new a7(publisherActivityFilter, publisherFragmentFilter, y8.f7455a, ea.f7294a).a(activity, hVar, new j4(new j4.a(application, hVar, r5.f7394a, false)));
        if (z6VarA instanceof m6) {
            ea.a(activity, ((m6) z6VarA).c);
        } else {
            Intrinsics.checkNotNullParameter("Cannot log whitelisted activities when using fragment filter", "msg");
            Log.i("OGURY", "Cannot log whitelisted activities when using fragment filter");
        }
    }

    @SafeVarargs
    public final void setBlackListActivities(Class<? extends Activity>... activities) {
        Intrinsics.checkNotNullParameter(activities, "activities");
        s6 s6Var = this.f7253a;
        s6Var.getClass();
        Intrinsics.checkNotNullParameter(activities, "activities");
        a8 a8Var = s6Var.e;
        List<? extends Class<? extends Activity>> list = ArraysKt.toList(activities);
        a8Var.getClass();
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        a8Var.b = list;
    }

    @SafeVarargs
    public final void setBlackListFragments(Class<? extends Object>... fragments) {
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        s6 s6Var = this.f7253a;
        s6Var.getClass();
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        b8 b8Var = s6Var.f;
        List<? extends Class<?>> listAsList = ArraysKt.asList(fragments);
        b8Var.getClass();
        Intrinsics.checkNotNullParameter(listAsList, "<set-?>");
        b8Var.b = listAsList;
    }

    public final void setListener(OguryThumbnailAdListener thumbnailAdListener) {
        IntegrationLogger.d("[Ads] Thumbnail Ad - setListener() called");
        s6 s6Var = this.f7253a;
        Intrinsics.checkNotNullParameter(this, "ad");
        z5 z5Var = thumbnailAdListener != null ? new z5(this, thumbnailAdListener) : null;
        s6Var.getClass();
        IntegrationLogger.d("[Ads][Thumbnail] Registering to ad listener");
        if (z5Var == null) {
            IntegrationLogger.d("[Ads][Thumbnail] Ad listener is null");
        }
        s6Var.i = z5Var;
        x xVar = s6Var.k;
        if (xVar != null) {
            xVar.t = z5Var;
        }
    }

    public final void setWhiteListFragmentPackages(String... packages) {
        Intrinsics.checkNotNullParameter(packages, "packages");
        s6 s6Var = this.f7253a;
        s6Var.getClass();
        Intrinsics.checkNotNullParameter(packages, "packages");
        b8 b8Var = s6Var.f;
        List<String> listAsList = ArraysKt.asList(packages);
        b8Var.getClass();
        Intrinsics.checkNotNullParameter(listAsList, "<set-?>");
        b8Var.f7270a = listAsList;
    }

    public final void setWhiteListPackages(String... packages) {
        Intrinsics.checkNotNullParameter(packages, "packages");
        s6 s6Var = this.f7253a;
        s6Var.getClass();
        Intrinsics.checkNotNullParameter(packages, "packages");
        a8 a8Var = s6Var.e;
        List<String> list = ArraysKt.toList(packages);
        a8Var.getClass();
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        a8Var.f7261a = list;
    }

    public final void show(Activity activity, int leftMargin, int topMargin) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IntegrationLogger.d("[Ads] Thumbnail Ad - show() called with activity: " + activity.getClass().getName() + " leftMargin: " + leftMargin + " topMargin: " + topMargin);
        this.f7253a.a(activity, new d7(OguryThumbnailGravity.TOP_LEFT.getValue(), leftMargin, topMargin));
    }

    public /* synthetic */ OguryThumbnailAd(Context context, String str, OguryMediation oguryMediation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? null : oguryMediation);
    }

    public OguryThumbnailAd(Context context, String adUnitId, OguryMediation oguryMediation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.f7253a = new s6(applicationContext, new d(adUnitId), oguryMediation);
    }

    public final void load() {
        IntegrationLogger.d("[Ads] Thumbnail Ad - load() called");
        this.f7253a.b();
    }

    public final void show(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IntegrationLogger.d("[Ads] Thumbnail Ad - show() called with activity: " + activity.getClass().getName());
        this.f7253a.a(activity);
    }

    public final void show(Activity activity, OguryThumbnailGravity gravity, int xMargin, int yMargin) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(gravity, "gravity");
        IntegrationLogger.d("[Ads] Thumbnail Ad - show() called with activity: " + activity.getClass().getName() + " gravity: " + gravity.ordinal() + " xMargin: " + xMargin + " yMargin: " + yMargin);
        this.f7253a.a(activity, new d7(gravity.getValue(), xMargin, yMargin));
    }
}
