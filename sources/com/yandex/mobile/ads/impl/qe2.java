package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class qe2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wj f10012a;
    private final g92 b;
    private final vb2<gb1> c;
    private final ma2 d;
    private final tf2 e;
    private final mj0 f;

    public /* synthetic */ qe2(Context context, lp1 lp1Var, wj wjVar) {
        this(context, lp1Var, wjVar, h92.a(wjVar.b()), new vb2(context, new hb1()), new ma2(context, lp1Var), new tf2(), new mj0());
    }

    public final Object a(JSONObject jsonValue) throws p61 {
        m92 m92VarA;
        sf2 sf2Var;
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
        try {
            m92VarA = this.d.a(this.b.a("vast", jsonValue), this.f10012a);
        } catch (Exception unused) {
            m92VarA = null;
        }
        if (m92VarA == null || m92VarA.b().isEmpty()) {
            throw new p61("Invalid VAST in response");
        }
        ArrayList arrayListA = this.c.a(m92VarA.b());
        if (arrayListA.isEmpty()) {
            throw new p61("Invalid VAST in response");
        }
        JSONObject settingsJson = jsonValue.optJSONObject("settings");
        if (settingsJson != null) {
            this.e.getClass();
            Intrinsics.checkNotNullParameter(settingsJson, "settingsJson");
            boolean zOptBoolean = settingsJson.optBoolean("volumeControlVisible", true);
            boolean zOptBoolean2 = settingsJson.optBoolean("isProgressBarHidden", false);
            try {
                Result.Companion companion = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(Double.valueOf(settingsJson.getDouble("initialVolume")));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                objM7904constructorimpl = null;
            }
            sf2Var = new sf2(zOptBoolean, zOptBoolean2, (Double) objM7904constructorimpl);
        } else {
            sf2Var = null;
        }
        JSONObject jSONObjectOptJSONObject = jsonValue.optJSONObject("preview");
        return new db2(arrayListA, sf2Var, jSONObjectOptJSONObject != null ? this.f.b(jSONObjectOptJSONObject) : null);
    }

    public qe2(Context context, lp1 reporter, wj base64EncodingParameters, g92 valueReader, vb2<gb1> videoAdInfoListCreator, ma2 vastXmlParser, tf2 videoSettingsParser, mj0 imageParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        Intrinsics.checkNotNullParameter(valueReader, "valueReader");
        Intrinsics.checkNotNullParameter(videoAdInfoListCreator, "videoAdInfoListCreator");
        Intrinsics.checkNotNullParameter(vastXmlParser, "vastXmlParser");
        Intrinsics.checkNotNullParameter(videoSettingsParser, "videoSettingsParser");
        Intrinsics.checkNotNullParameter(imageParser, "imageParser");
        this.f10012a = base64EncodingParameters;
        this.b = valueReader;
        this.c = videoAdInfoListCreator;
        this.d = vastXmlParser;
        this.e = videoSettingsParser;
        this.f = imageParser;
    }
}
