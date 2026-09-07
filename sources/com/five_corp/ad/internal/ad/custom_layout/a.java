package com.five_corp.ad.internal.ad.custom_layout;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1275a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final c g;
    public final String h;

    public a(int i, int i2, int i3, int i4, int i5, int i6, c cVar, String str) {
        this.f1275a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = cVar;
        this.h = str;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("CustomLayoutClickConfig{clickType=");
        switch (this.f1275a) {
            case 1:
                str = "NONE";
                break;
            case 2:
                str = "PAUSE_RESUME";
                break;
            case 3:
                str = "REDIRECT";
                break;
            case 4:
                str = "PLAY_IN_FULLSCREEN";
                break;
            case 5:
                str = "TOGGLE_SOUND";
                break;
            case 6:
                str = "REPLAY";
                break;
            case 7:
                str = "CLOSE";
                break;
            case 8:
                str = "OPEN_URL";
                break;
            case 9:
                str = "INFORMATION_ICON";
                break;
            default:
                str = "null";
                break;
        }
        return sb.append(str).append(", x=").append(this.b).append(", y=").append(this.c).append(", zIndex=").append(this.d).append(", width=").append(this.e).append(", height=").append(this.f).append(", condition=").append(this.g).append(", url=").append(this.h).append(AbstractJsonLexerKt.END_OBJ).toString();
    }
}
