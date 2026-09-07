package sg.bigo.ads.core.mraid;

import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;

/* JADX INFO: loaded from: classes8.dex */
public enum g {
    CLOSE("close"),
    UNLOAD(MraidJsMethods.UNLOAD),
    EXPAND { // from class: sg.bigo.ads.core.mraid.g.1
        @Override // sg.bigo.ads.core.mraid.g
        final boolean a(n nVar) {
            return nVar == n.INLINE;
        }
    },
    USE_CUSTOM_CLOSE("usecustomclose"),
    OPEN { // from class: sg.bigo.ads.core.mraid.g.2
        @Override // sg.bigo.ads.core.mraid.g
        final boolean a(n nVar) {
            return true;
        }
    },
    RESIZE { // from class: sg.bigo.ads.core.mraid.g.3
        @Override // sg.bigo.ads.core.mraid.g
        final boolean a(n nVar) {
            return true;
        }
    },
    SET_ORIENTATION_PROPERTIES("setOrientationProperties"),
    PLAY_VIDEO { // from class: sg.bigo.ads.core.mraid.g.4
        @Override // sg.bigo.ads.core.mraid.g
        final boolean a(n nVar) {
            return nVar == n.INLINE;
        }
    },
    STORE_PICTURE { // from class: sg.bigo.ads.core.mraid.g.5
        @Override // sg.bigo.ads.core.mraid.g
        final boolean a(n nVar) {
            return true;
        }
    },
    CREATE_CALENDAR_EVENT { // from class: sg.bigo.ads.core.mraid.g.6
        @Override // sg.bigo.ads.core.mraid.g
        final boolean a(n nVar) {
            return true;
        }
    },
    UNSPECIFIED("");

    final String l;

    g(String str) {
        this.l = str;
    }

    /* synthetic */ g(String str, byte b) {
        this(str);
    }

    static g a(String str) {
        for (g gVar : values()) {
            if (gVar.l.equals(str)) {
                return gVar;
            }
        }
        return UNSPECIFIED;
    }

    boolean a(n nVar) {
        return false;
    }
}
