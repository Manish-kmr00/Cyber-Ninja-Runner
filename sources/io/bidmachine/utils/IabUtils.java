package io.bidmachine.utils;

import io.bidmachine.core.Utils;
import io.bidmachine.iab.CacheControl;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.protobuf.AdExtension;
import io.bidmachine.protobuf.CreativeLoadingMethod;

/* JADX INFO: loaded from: classes11.dex */
public class IabUtils {
    private static final CacheControl DEFAULT_CACHE_CONTROL = CacheControl.FullLoad;

    public static CacheControl toCacheControl(Object obj) {
        CreativeLoadingMethod creativeLoadingMethodValueOf;
        if (obj == null) {
            return DEFAULT_CACHE_CONTROL;
        }
        if (obj instanceof CacheControl) {
            return (CacheControl) obj;
        }
        if (obj instanceof CreativeLoadingMethod) {
            creativeLoadingMethodValueOf = (CreativeLoadingMethod) obj;
        } else if (obj instanceof String) {
            try {
                creativeLoadingMethodValueOf = CreativeLoadingMethod.valueOf((String) obj);
            } catch (IllegalArgumentException unused) {
                creativeLoadingMethodValueOf = null;
            }
        } else {
            creativeLoadingMethodValueOf = null;
        }
        if (creativeLoadingMethodValueOf != null) {
            int i = AnonymousClass1.$SwitchMap$io$bidmachine$protobuf$CreativeLoadingMethod[creativeLoadingMethodValueOf.ordinal()];
            if (i == 1) {
                return CacheControl.Stream;
            }
            if (i == 2) {
                return CacheControl.PartialLoad;
            }
            return DEFAULT_CACHE_CONTROL;
        }
        return DEFAULT_CACHE_CONTROL;
    }

    /* JADX INFO: renamed from: io.bidmachine.utils.IabUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$protobuf$CreativeLoadingMethod;

        static {
            int[] iArr = new int[CreativeLoadingMethod.values().length];
            $SwitchMap$io$bidmachine$protobuf$CreativeLoadingMethod = iArr;
            try {
                iArr[CreativeLoadingMethod.Stream.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$CreativeLoadingMethod[CreativeLoadingMethod.PartialLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001c  */
    public static BMError mapError(IabError iabError) {
        BMError bMError;
        int code = iabError.getCode();
        if (code == 1) {
            bMError = BMError.NoConnection;
        } else if (code == 3) {
            bMError = BMError.NoFill;
        } else if (code == 5) {
            bMError = BMError.PlaceholderTimeout;
        } else if (code == 6) {
            bMError = BMError.Expired;
        } else if (code == 7) {
            bMError = BMError.NoFill;
        } else {
            bMError = BMError.InternalUnknownError;
        }
        return new BMError(bMError, code, iabError.getMessage());
    }

    public static IabElementStyle transform(AdExtension.ControlAsset controlAsset) {
        if (controlAsset == null) {
            return null;
        }
        try {
            IabElementStyle iabElementStyle = new IabElementStyle();
            iabElementStyle.setMargin(controlAsset.getMargin());
            iabElementStyle.setPadding(controlAsset.getPadding());
            iabElementStyle.setContent(controlAsset.getContent());
            iabElementStyle.setFillColor(Utils.safeParseColor(controlAsset.getFill()));
            iabElementStyle.setFontStyle(Integer.valueOf(controlAsset.getFontStyle()));
            iabElementStyle.setWidth(Integer.valueOf(controlAsset.getWidth()));
            iabElementStyle.setHeight(Integer.valueOf(controlAsset.getHeight()));
            iabElementStyle.setHideAfter(Float.valueOf(controlAsset.getHideafter()));
            iabElementStyle.setHorizontalPosition(Utils.parseHorizontalPosition(controlAsset.getX()));
            iabElementStyle.setVerticalPosition(Utils.parseVerticalPosition(controlAsset.getY()));
            iabElementStyle.setOpacity(Float.valueOf(controlAsset.getOpacity()));
            iabElementStyle.setOutlined(Boolean.valueOf(controlAsset.getOutlined()));
            iabElementStyle.setStrokeColor(Utils.safeParseColor(controlAsset.getStroke()));
            iabElementStyle.setStrokeWidth(Float.valueOf(controlAsset.getStrokeWidth()));
            iabElementStyle.setStyle(controlAsset.getStyle());
            iabElementStyle.setVisible(Boolean.valueOf(controlAsset.getVisible()));
            return iabElementStyle;
        } catch (Exception unused) {
            return null;
        }
    }
}
