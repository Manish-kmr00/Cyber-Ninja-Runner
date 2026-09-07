package net.pubnative.lite.sdk.utils.svgparser;

import java.util.HashMap;
import java.util.Map;
import net.pubnative.lite.sdk.utils.svgparser.utils.TextScanner;

/* JADX INFO: loaded from: classes7.dex */
public class PreserveAspectRatio {
    public static final PreserveAspectRatio BOTTOM;
    public static final PreserveAspectRatio END;
    public static final PreserveAspectRatio FULLSCREEN;
    public static final PreserveAspectRatio FULLSCREEN_START;
    public static final PreserveAspectRatio LETTERBOX;
    public static final PreserveAspectRatio START;
    public static final PreserveAspectRatio STRETCH;
    public static final PreserveAspectRatio TOP;
    public static final PreserveAspectRatio UNSCALED;
    private static final Map<String, Alignment> aspectRatioKeywords;
    private final Alignment alignment;
    private final Scale scale;

    public enum Alignment {
        none,
        xMinYMin,
        xMidYMin,
        xMaxYMin,
        xMinYMid,
        xMidYMid,
        xMaxYMid,
        xMinYMax,
        xMidYMax,
        xMaxYMax
    }

    public enum Scale {
        meet,
        slice
    }

    static {
        HashMap map = new HashMap(10);
        aspectRatioKeywords = map;
        UNSCALED = new PreserveAspectRatio(null, null);
        STRETCH = new PreserveAspectRatio(Alignment.none, null);
        LETTERBOX = new PreserveAspectRatio(Alignment.xMidYMid, Scale.meet);
        START = new PreserveAspectRatio(Alignment.xMinYMin, Scale.meet);
        END = new PreserveAspectRatio(Alignment.xMaxYMax, Scale.meet);
        TOP = new PreserveAspectRatio(Alignment.xMidYMin, Scale.meet);
        BOTTOM = new PreserveAspectRatio(Alignment.xMidYMax, Scale.meet);
        FULLSCREEN = new PreserveAspectRatio(Alignment.xMidYMid, Scale.slice);
        FULLSCREEN_START = new PreserveAspectRatio(Alignment.xMinYMin, Scale.slice);
        map.put("none", Alignment.none);
        map.put("xMinYMin", Alignment.xMinYMin);
        map.put("xMidYMin", Alignment.xMidYMin);
        map.put("xMaxYMin", Alignment.xMaxYMin);
        map.put("xMinYMid", Alignment.xMinYMid);
        map.put("xMidYMid", Alignment.xMidYMid);
        map.put("xMaxYMid", Alignment.xMaxYMid);
        map.put("xMinYMax", Alignment.xMinYMax);
        map.put("xMidYMax", Alignment.xMidYMax);
        map.put("xMaxYMax", Alignment.xMaxYMax);
    }

    PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.alignment = alignment;
        this.scale = scale;
    }

    public static PreserveAspectRatio of(String str) {
        try {
            return parsePreserveAspectRatio(str);
        } catch (SVGParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    public Scale getScale() {
        return this.scale;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
        return this.alignment == preserveAspectRatio.alignment && this.scale == preserveAspectRatio.scale;
    }

    public String toString() {
        return this.alignment + " " + this.scale;
    }

    private static PreserveAspectRatio parsePreserveAspectRatio(String str) throws SVGParseException {
        Scale scale;
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        String strNextToken = textScanner.nextToken();
        if ("defer".equals(strNextToken)) {
            textScanner.skipWhitespace();
            strNextToken = textScanner.nextToken();
        }
        Alignment alignment = aspectRatioKeywords.get(strNextToken);
        textScanner.skipWhitespace();
        if (textScanner.empty()) {
            scale = null;
        } else {
            String strNextToken2 = textScanner.nextToken();
            strNextToken2.hashCode();
            if (strNextToken2.equals("meet")) {
                scale = Scale.meet;
            } else if (strNextToken2.equals("slice")) {
                scale = Scale.slice;
            } else {
                throw new SVGParseException("Invalid preserveAspectRatio definition: " + str);
            }
        }
        return new PreserveAspectRatio(alignment, scale);
    }
}
