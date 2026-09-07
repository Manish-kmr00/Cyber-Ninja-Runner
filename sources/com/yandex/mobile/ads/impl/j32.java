package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes11.dex */
public interface j32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j32 f9285a = new a();

    final class a implements j32 {
        a() {
        }

        public final boolean b(gc0 gc0Var) {
            String str = gc0Var.m;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || MimeTypes.TEXT_EXOPLAYER_CUES.equals(str);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final h32 a(gc0 gc0Var) {
            String str = gc0Var.m;
            if (str != null) {
                str.hashCode();
                byte b = -1;
                switch (str.hashCode()) {
                    case -1351681404:
                        if (str.equals("application/dvbsubs")) {
                            b = 0;
                        }
                        break;
                    case -1248334819:
                        if (str.equals("application/pgs")) {
                            b = 1;
                        }
                        break;
                    case -1026075066:
                        if (str.equals("application/x-mp4-vtt")) {
                            b = 2;
                        }
                        break;
                    case -1004728940:
                        if (str.equals("text/vtt")) {
                            b = 3;
                        }
                        break;
                    case 691401887:
                        if (str.equals("application/x-quicktime-tx3g")) {
                            b = 4;
                        }
                        break;
                    case 822864842:
                        if (str.equals("text/x-ssa")) {
                            b = 5;
                        }
                        break;
                    case 930165504:
                        if (str.equals("application/x-mp4-cea-608")) {
                            b = 6;
                        }
                        break;
                    case 1201784583:
                        if (str.equals(MimeTypes.TEXT_EXOPLAYER_CUES)) {
                            b = 7;
                        }
                        break;
                    case 1566015601:
                        if (str.equals("application/cea-608")) {
                            b = 8;
                        }
                        break;
                    case 1566016562:
                        if (str.equals("application/cea-708")) {
                            b = 9;
                        }
                        break;
                    case 1668750253:
                        if (str.equals("application/x-subrip")) {
                            b = 10;
                        }
                        break;
                    case 1693976202:
                        if (str.equals("application/ttml+xml")) {
                            b = Ascii.VT;
                        }
                        break;
                }
                switch (b) {
                    case 0:
                        return new r40(gc0Var.o);
                    case 1:
                        return new sg1();
                    case 2:
                        return new y11();
                    case 3:
                        return new vj2();
                    case 4:
                        return new q72(gc0Var.o);
                    case 5:
                        return new y12(gc0Var.o);
                    case 6:
                    case 8:
                        return new yn(str, gc0Var.E);
                    case 7:
                        return new g70();
                    case 9:
                        return new zn(gc0Var.E, gc0Var.o);
                    case 10:
                        return new e32();
                    case 11:
                        return new k72();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }
}
