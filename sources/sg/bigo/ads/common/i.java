package sg.bigo.ads.common;

import android.graphics.Point;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Point f13209a;
    public Point b;

    public final String a() {
        return this.f13209a != null ? this.f13209a.x + StringUtils.COMMA + this.f13209a.y : "";
    }

    public final String b() {
        return this.b != null ? this.b.x + StringUtils.COMMA + this.b.y : "";
    }
}
