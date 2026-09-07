package com.bykv.vk.openvk.preload.geckox.model;

import com.bykv.vk.openvk.preload.a.a.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class ComponentModel {

    @b(a = "packages")
    private Map<String, List<UpdatePackage>> packages;

    @b(a = "universal_strategies")
    private Map<String, a> universalStrategies;

    public static class a {
    }

    public Map<String, List<UpdatePackage>> getPackages() {
        return this.packages;
    }

    public Map<String, a> getUniversalStrategies() {
        return this.universalStrategies;
    }
}
