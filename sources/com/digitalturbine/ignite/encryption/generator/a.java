package com.digitalturbine.ignite.encryption.generator;

import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.stats.CodePackage;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes11.dex */
public final class a {
    public final AlgorithmParameterSpec a() {
        com.digitalturbine.ignite.authenticator.logger.a.a("%s : create specs", "KeyGeneratorSpecCreator");
        return new KeyGenParameterSpec.Builder("dtx_ignite_service_storage", 3).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").setRandomizedEncryptionRequired(false).build();
    }
}
