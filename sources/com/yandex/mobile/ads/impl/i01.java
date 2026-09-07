package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes8.dex */
public interface i01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i01 f9159a = new a();

    final class a implements i01 {
        @Override // com.yandex.mobile.ads.impl.i01
        public final ly1 b(gc0 gc0Var) {
            String str = gc0Var.m;
            if (str != null) {
                str.hashCode();
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new se();
                    case "application/x-icy":
                        return new mi0();
                    case "application/id3":
                        return new pi0(null);
                    case "application/x-emsg":
                        return new w50();
                    case "application/x-scte35":
                        return new l12();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }

        a() {
        }

        @Override // com.yandex.mobile.ads.impl.i01
        public final boolean a(gc0 gc0Var) {
            String str = gc0Var.m;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }
    }

    boolean a(gc0 gc0Var);

    ly1 b(gc0 gc0Var);
}
