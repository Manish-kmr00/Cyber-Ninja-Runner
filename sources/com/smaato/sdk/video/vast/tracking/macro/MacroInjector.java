package com.smaato.sdk.video.vast.tracking.macro;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Maps;
import com.smaato.sdk.core.util.fi.BiFunction;
import com.smaato.sdk.video.utils.UriUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public final class MacroInjector {
    private final AdBreakInfoMacros adBreakInfoMacros;
    private final CapabilitiesInfoMacro capabilitiesInfoMacro;
    private final ClickInfoMacros clickInfoMacros;
    private final ClientInfoMacros clientInfoMacros;
    private final ErrorInfoMacros errorInfoMacros;
    private final GenericMacros genericMacros;
    private final PlayerStateInfoMacros playerStateInfoMacros;
    private final PublisherInfoMacro publisherInfoMacro;
    private final RegulationInfoMacros regulationInfoMacros;
    private final UriUtils uriUtils;
    private final VerificationInfoMacros verificationInfoMacros;

    MacroInjector(UriUtils uriUtils, AdBreakInfoMacros adBreakInfoMacros, CapabilitiesInfoMacro capabilitiesInfoMacro, ClientInfoMacros clientInfoMacros, GenericMacros genericMacros, PlayerStateInfoMacros playerStateInfoMacros, PublisherInfoMacro publisherInfoMacro, RegulationInfoMacros regulationInfoMacros, VerificationInfoMacros verificationInfoMacros, ClickInfoMacros clickInfoMacros, ErrorInfoMacros errorInfoMacros) {
        this.uriUtils = (UriUtils) Objects.requireNonNull(uriUtils);
        this.adBreakInfoMacros = (AdBreakInfoMacros) Objects.requireNonNull(adBreakInfoMacros);
        this.capabilitiesInfoMacro = (CapabilitiesInfoMacro) Objects.requireNonNull(capabilitiesInfoMacro);
        this.clientInfoMacros = (ClientInfoMacros) Objects.requireNonNull(clientInfoMacros);
        this.genericMacros = (GenericMacros) Objects.requireNonNull(genericMacros);
        this.playerStateInfoMacros = (PlayerStateInfoMacros) Objects.requireNonNull(playerStateInfoMacros);
        this.publisherInfoMacro = (PublisherInfoMacro) Objects.requireNonNull(publisherInfoMacro);
        this.regulationInfoMacros = (RegulationInfoMacros) Objects.requireNonNull(regulationInfoMacros);
        this.verificationInfoMacros = (VerificationInfoMacros) Objects.requireNonNull(verificationInfoMacros);
        this.clickInfoMacros = (ClickInfoMacros) Objects.requireNonNull(clickInfoMacros);
        this.errorInfoMacros = (ErrorInfoMacros) Objects.requireNonNull(errorInfoMacros);
    }

    public String injectMacros(String str, PlayerState playerState) {
        return inject(str, createMacros(playerState));
    }

    public Set<String> injectMacros(Collection<String> collection, PlayerState playerState) {
        Map mapCreateMacros = createMacros(playerState);
        HashSet hashSet = new HashSet(collection.size());
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            hashSet.add(inject(it.next(), mapCreateMacros));
        }
        return hashSet;
    }

    private String inject(String str, Map map) {
        return (String) Maps.reduce(map, str, new BiFunction() { // from class: com.smaato.sdk.video.vast.tracking.macro.MacroInjector$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.f$0.m5727x140db2e3((Map.Entry) obj, (String) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$inject$0$com-smaato-sdk-video-vast-tracking-macro-MacroInjector, reason: not valid java name */
    /* synthetic */ String m5727x140db2e3(Map.Entry entry, String str) {
        return str.replace((CharSequence) entry.getKey(), this.uriUtils.encodeQueryString((String) entry.getValue()));
    }

    private Map createMacros(PlayerState playerState) {
        return Maps.merge(this.adBreakInfoMacros.toMap(playerState), this.capabilitiesInfoMacro.toMap(), this.clientInfoMacros.toMap(), this.genericMacros.toMap(), this.playerStateInfoMacros.toMap(playerState), this.publisherInfoMacro.toMap(), this.regulationInfoMacros.toMap(), this.verificationInfoMacros.toMap(), this.clickInfoMacros.toMap(playerState.clickPositionX, playerState.clickPositionY), this.errorInfoMacros.toMap(playerState.errorCode));
    }
}
