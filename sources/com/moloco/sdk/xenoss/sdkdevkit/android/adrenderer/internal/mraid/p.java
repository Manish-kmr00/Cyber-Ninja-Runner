package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public enum p {
    Portrait,
    Landscape,
    None;


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6652a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final p a(String str) {
            if (str != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != 3387192) {
                    if (iHashCode != 729267099) {
                        if (iHashCode == 1430647483 && str.equals("landscape")) {
                            return p.Landscape;
                        }
                    } else if (str.equals("portrait")) {
                        return p.Portrait;
                    }
                } else if (str.equals("none")) {
                    return p.None;
                }
            }
            return null;
        }

        public a() {
        }
    }
}
