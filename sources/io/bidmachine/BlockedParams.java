package io.bidmachine;

import com.explorestack.protobuf.adcom.Context;
import io.bidmachine.models.IBlockedParams;
import io.bidmachine.models.RequestParams;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public final class BlockedParams extends RequestParams<BlockedParams> implements IBlockedParams<BlockedParams> {
    private Set<String> blockedApplications;
    private Set<String> blockedCategories;
    private Set<String> blockedDomains;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IBlockedParams
    public BlockedParams addBlockedAdvertiserDomain(String str) {
        if (this.blockedDomains == null) {
            this.blockedDomains = new HashSet();
        }
        this.blockedDomains.add(str);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IBlockedParams
    public BlockedParams addBlockedAdvertiserIABCategory(String str) {
        if (this.blockedCategories == null) {
            this.blockedCategories = new HashSet();
        }
        this.blockedCategories.add(str);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.IBlockedParams
    public BlockedParams addBlockedApplication(String str) {
        if (this.blockedApplications == null) {
            this.blockedApplications = new HashSet();
        }
        this.blockedApplications.add(str);
        return this;
    }

    @Override // io.bidmachine.models.RequestParams
    public void merge(BlockedParams blockedParams) {
        this.blockedDomains = updateList(blockedParams.blockedDomains, this.blockedDomains);
        this.blockedCategories = updateList(blockedParams.blockedCategories, this.blockedCategories);
        this.blockedApplications = updateList(blockedParams.blockedApplications, this.blockedApplications);
    }

    void build(Context.Restrictions.Builder builder) {
        Set<String> set = this.blockedDomains;
        if (set != null) {
            builder.addAllBadv(set);
        }
        Set<String> set2 = this.blockedCategories;
        if (set2 != null) {
            builder.addAllBcat(set2);
        }
        Set<String> set3 = this.blockedApplications;
        if (set3 != null) {
            builder.addAllBapp(set3);
        }
    }

    private <T> Set<T> updateList(Set<T> set, Set<T> set2) {
        if (set == null) {
            return set2;
        }
        if (set2 == null) {
            return new HashSet(set);
        }
        set2.addAll(set);
        return set2;
    }
}
