package io.bidmachine;

/* JADX INFO: loaded from: classes12.dex */
class NetworkAssetParams {
    private final String adapterVersion;
    private final String classpath;
    private final String name;
    private final String sdkVersion;

    public NetworkAssetParams(String str, String str2, String str3, String str4) {
        this.name = str;
        this.adapterVersion = str2;
        this.classpath = str3;
        this.sdkVersion = str4;
    }

    public String getName() {
        return this.name;
    }

    public String getAdapterVersion() {
        return this.adapterVersion;
    }

    public String getClasspath() {
        return this.classpath;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }
}
