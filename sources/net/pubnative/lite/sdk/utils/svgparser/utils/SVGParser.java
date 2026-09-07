package net.pubnative.lite.sdk.utils.svgparser.utils;

import java.io.InputStream;
import net.pubnative.lite.sdk.utils.svgparser.SVGExternalFileResolver;
import net.pubnative.lite.sdk.utils.svgparser.SVGParseException;

/* JADX INFO: loaded from: classes12.dex */
interface SVGParser {
    SVGBase parseStream(InputStream inputStream) throws SVGParseException;

    SVGParser setExternalFileResolver(SVGExternalFileResolver sVGExternalFileResolver);

    SVGParser setInternalEntitiesEnabled(boolean z);
}
