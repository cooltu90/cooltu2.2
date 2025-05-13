package com.codingtu.cooltu.processor.container;

import com.codingtu.cooltu.lib4j.data.map.ListValueMap;
import com.codingtu.cooltu.lib4j.es.Es;
import com.codingtu.cooltu.processor.DealerType;
import com.codingtu.cooltu.processor.deal.ActBaseDealer;
import com.codingtu.cooltu.processor.deal.base.BaseDealer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DealerMap {
    public static Map<String, ActBaseDealer> ACT_BASE_DEALER_MAP = new HashMap<>();
    public static ListValueMap<Integer, BaseDealer> DEALER_MAP = new ListValueMap<>();

    public static void putActBaseDealer(ActBaseDealer actBaseDealer) {
        ACT_BASE_DEALER_MAP.put(actBaseDealer.javaInfo.fullName, actBaseDealer);
    }

    public static void put(BaseDealer dealer) {
        put(DealerType.DEFAULT, dealer);
    }

    public static void put(DealerType dealerType, BaseDealer dealer) {
        DEALER_MAP.get(dealerType.ordinal()).add(dealer);
    }

    public static void create() {
        Es.maps(DEALER_MAP).ls(new Es.MapEach<Integer, List<BaseDealer>>() {
            @Override
            public boolean each(Integer integer, List<BaseDealer> dealers) {
                Es.es(dealers).ls(new Es.EachEs<BaseDealer>() {
                    @Override
                    public boolean each(int position, BaseDealer dealer) {
                        dealer.create();
                        return false;
                    }
                });
                return false;
            }
        });
        DEALER_MAP.clear();
    }
}
