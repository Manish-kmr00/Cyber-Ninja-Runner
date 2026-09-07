package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdqn {
    public static final zzfww zza;
    public static final zzfww zzb;
    private final String zzc;
    private final zzdqm zzd;
    private final zzdqm zze;

    static {
        zzdqm zzdqmVar = zzdqm.PUBLIC_API_CALL;
        zzdqm zzdqmVar2 = zzdqm.PUBLIC_API_CALLBACK;
        zzdqn zzdqnVar = new zzdqn("tqgt", zzdqmVar, zzdqmVar2);
        zzdqm zzdqmVar3 = zzdqm.PUBLIC_API_CALL;
        zzdqm zzdqmVar4 = zzdqm.DYNAMITE_ENTER;
        zzdqn zzdqnVar2 = new zzdqn("l.dl", zzdqmVar3, zzdqmVar4);
        zzdqm zzdqmVar5 = zzdqm.READ_FROM_DISK_START;
        zzdqn zzdqnVar3 = new zzdqn("l.rccde", zzdqmVar4, zzdqmVar5);
        zzdqn zzdqnVar4 = new zzdqn("l.rfd", zzdqmVar5, zzdqm.READ_FROM_DISK_END);
        zzdqm zzdqmVar6 = zzdqm.CLIENT_SIGNALS_START;
        zzdqn zzdqnVar5 = new zzdqn("l.rcc", zzdqmVar4, zzdqmVar6);
        zzdqm zzdqmVar7 = zzdqm.CLIENT_SIGNALS_END;
        zzdqn zzdqnVar6 = new zzdqn("l.cs", zzdqmVar6, zzdqmVar7);
        zzdqn zzdqnVar7 = new zzdqn("l.cts", zzdqmVar7, zzdqm.SERVICE_CONNECTED);
        zzdqm zzdqmVar8 = zzdqm.GMS_SIGNALS_START;
        zzdqm zzdqmVar9 = zzdqm.GMS_SIGNALS_END;
        zzdqn zzdqnVar8 = new zzdqn("l.gs", zzdqmVar8, zzdqmVar9);
        zzdqm zzdqmVar10 = zzdqm.GET_SIGNALS_SDKCORE_START;
        zzdqn zzdqnVar9 = new zzdqn("l.jse", zzdqmVar9, zzdqmVar10);
        zzdqm zzdqmVar11 = zzdqm.GET_SIGNALS_SDKCORE_END;
        zzdqn zzdqnVar10 = new zzdqn("l.gs-sdkcore", zzdqmVar10, zzdqmVar11);
        zzdqn zzdqnVar11 = new zzdqn("l.gs-pp", zzdqmVar11, zzdqmVar2);
        zzdqm zzdqmVar12 = zzdqm.RENDERING_START;
        zzdqn zzdqnVar12 = new zzdqn("l.render", zzdqmVar12, zzdqmVar2);
        zzdqm zzdqmVar13 = zzdqm.RENDERING_WEBVIEW_CREATION_START;
        zzdqn zzdqnVar13 = new zzdqn("l.render.pre", zzdqmVar12, zzdqmVar13);
        zzdqm zzdqmVar14 = zzdqm.RENDERING_WEBVIEW_CREATION_END;
        zzdqn zzdqnVar14 = new zzdqn("l.render.wvc", zzdqmVar13, zzdqmVar14);
        zzdqn zzdqnVar15 = new zzdqn("l.render.acc", zzdqmVar14, zzdqm.RENDERING_AD_COMPONENT_CREATION_END);
        zzdqn zzdqnVar16 = new zzdqn("l.render.cfg-wv", zzdqm.RENDERING_CONFIGURE_WEBVIEW_START, zzdqm.RENDERING_CONFIGURE_WEBVIEW_END);
        zzdqm zzdqmVar15 = zzdqm.RENDERING_WEBVIEW_LOAD_HTML_START;
        zzdqm zzdqmVar16 = zzdqm.RENDERING_WEBVIEW_LOAD_HTML_END;
        zza = zzfww.zzt(zzdqnVar, zzdqnVar2, zzdqnVar3, zzdqnVar4, zzdqnVar5, zzdqnVar6, zzdqnVar7, zzdqnVar8, zzdqnVar9, zzdqnVar10, zzdqnVar11, zzdqnVar12, zzdqnVar13, zzdqnVar14, zzdqnVar15, zzdqnVar16, new zzdqn("l.render.wvlh", zzdqmVar15, zzdqmVar16), new zzdqn("l.render.post", zzdqmVar16, zzdqmVar2), new zzdqn("l.sodv", zzdqm.SIGNAL_ON_DISK_VALIDATION_START, zzdqm.SIGNAL_ON_DISK_VALIDATION_END), new zzdqn("l.sodck", zzdqm.SIGNAL_ON_DISK_CACHE_KEY_START, zzdqm.SIGNAL_ON_DISK_CACHE_KEY_END), new zzdqn("l.sodrar", zzdqm.SIGNAL_ON_DISK_READ_AND_REMOVE_START, zzdqm.SIGNAL_ON_DISK_READ_AND_REMOVE_END), new zzdqn("l.soddc", zzdqm.SIGNAL_ON_DISK_DECODE_START, zzdqm.SIGNAL_ON_DISK_DECODE_END));
        zzdqm zzdqmVar17 = zzdqm.PUBLIC_API_CALL;
        zzdqm zzdqmVar18 = zzdqm.PUBLIC_API_CALLBACK;
        zzdqn zzdqnVar17 = new zzdqn("l.al", zzdqmVar17, zzdqmVar18);
        zzdqm zzdqmVar19 = zzdqm.DYNAMITE_ENTER;
        zzdqn zzdqnVar18 = new zzdqn("l.al2", zzdqmVar19, zzdqmVar18);
        zzdqn zzdqnVar19 = new zzdqn("l.dl", zzdqmVar17, zzdqmVar19);
        zzdqm zzdqmVar20 = zzdqm.CLIENT_SIGNALS_START;
        zzdqn zzdqnVar20 = new zzdqn("l.rcc", zzdqmVar19, zzdqmVar20);
        zzdqm zzdqmVar21 = zzdqm.CLIENT_SIGNALS_END;
        zzdqn zzdqnVar21 = new zzdqn("l.cs", zzdqmVar20, zzdqmVar21);
        zzdqn zzdqnVar22 = new zzdqn("l.cts", zzdqmVar21, zzdqm.SERVICE_CONNECTED);
        zzdqm zzdqmVar22 = zzdqm.GMS_SIGNALS_START;
        zzdqm zzdqmVar23 = zzdqm.GMS_SIGNALS_END;
        zzdqn zzdqnVar23 = new zzdqn("l.gs", zzdqmVar22, zzdqmVar23);
        zzdqm zzdqmVar24 = zzdqm.GET_AD_DICTIONARY_SDKCORE_START;
        zzdqn zzdqnVar24 = new zzdqn("l.jse", zzdqmVar23, zzdqmVar24);
        zzdqm zzdqmVar25 = zzdqm.GET_AD_DICTIONARY_SDKCORE_END;
        zzdqn zzdqnVar25 = new zzdqn("l.gad-js", zzdqmVar24, zzdqmVar25);
        zzdqm zzdqmVar26 = zzdqm.HTTP_RESPONSE_READY;
        zzdqn zzdqnVar26 = new zzdqn("l.http", zzdqmVar25, zzdqmVar26);
        zzdqm zzdqmVar27 = zzdqm.NORMALIZATION_AD_RESPONSE_START;
        zzdqn zzdqnVar27 = new zzdqn("l.jse-nml", zzdqmVar26, zzdqmVar27);
        zzdqm zzdqmVar28 = zzdqm.NORMALIZATION_AD_RESPONSE_END;
        zzdqn zzdqnVar28 = new zzdqn("l.nml-js", zzdqmVar27, zzdqmVar28);
        zzdqm zzdqmVar29 = zzdqm.BINDER_CALL_START;
        zzdqn zzdqnVar29 = new zzdqn("l.nml-gmsg", zzdqmVar28, zzdqmVar29);
        zzdqm zzdqmVar30 = zzdqm.SERVER_RESPONSE_PARSE_START;
        zzdqn zzdqnVar30 = new zzdqn("l.binder", zzdqmVar29, zzdqmVar30);
        zzdqm zzdqmVar31 = zzdqm.RENDERING_START;
        zzdqn zzdqnVar31 = new zzdqn("l.sr", zzdqmVar30, zzdqmVar31);
        zzdqn zzdqnVar32 = new zzdqn("l.render", zzdqmVar31, zzdqmVar18);
        zzdqn zzdqnVar33 = new zzdqn("l.t2", zzdqm.RENDERING_ADSTRING_TYPE2_FETCH_START, zzdqm.RENDERING_ADSTRING_TYPE2_FETCH_END);
        zzdqm zzdqmVar32 = zzdqm.RENDERING_WEBVIEW_CREATION_START;
        zzdqm zzdqmVar33 = zzdqm.RENDERING_WEBVIEW_CREATION_END;
        zzdqn zzdqnVar34 = new zzdqn("l.render.wvc", zzdqmVar32, zzdqmVar33);
        zzdqn zzdqnVar35 = new zzdqn("l.render.acc", zzdqmVar33, zzdqm.RENDERING_AD_COMPONENT_CREATION_END);
        zzdqn zzdqnVar36 = new zzdqn("l.render.cfg-wv", zzdqm.RENDERING_CONFIGURE_WEBVIEW_START, zzdqm.RENDERING_CONFIGURE_WEBVIEW_END);
        zzdqn zzdqnVar37 = new zzdqn("l.render.pre", zzdqmVar31, zzdqmVar32);
        zzdqm zzdqmVar34 = zzdqm.RENDERING_WEBVIEW_LOAD_HTML_END;
        zzb = zzfww.zzt(zzdqnVar17, zzdqnVar18, zzdqnVar19, zzdqnVar20, zzdqnVar21, zzdqnVar22, zzdqnVar23, zzdqnVar24, zzdqnVar25, zzdqnVar26, zzdqnVar27, zzdqnVar28, zzdqnVar29, zzdqnVar30, zzdqnVar31, zzdqnVar32, zzdqnVar33, zzdqnVar34, zzdqnVar35, zzdqnVar36, zzdqnVar37, new zzdqn("l.render.post", zzdqmVar34, zzdqmVar18), new zzdqn("l.render.wvlh", zzdqm.RENDERING_WEBVIEW_LOAD_HTML_START, zzdqmVar34));
    }

    public zzdqn(String str, zzdqm zzdqmVar, zzdqm zzdqmVar2) {
        this.zzc = str;
        this.zzd = zzdqmVar;
        this.zze = zzdqmVar2;
    }

    public final zzdqm zza() {
        return this.zzd;
    }

    public final zzdqm zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzc;
    }
}
