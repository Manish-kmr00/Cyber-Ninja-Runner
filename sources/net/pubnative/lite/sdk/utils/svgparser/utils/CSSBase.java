package net.pubnative.lite.sdk.utils.svgparser.utils;

/* JADX INFO: loaded from: classes11.dex */
public class CSSBase {
    protected CSSParser.Ruleset cssRuleset;

    protected CSSBase(String str) {
        this.cssRuleset = new CSSParser(CSSParser.Source.RenderOptions, null).parse(str);
    }
}
