package com.rusin.kupandatest.net.object;


import java.util.ArrayList;

public class ItemsResponse {
    public KuResult result;

    public class KuResult {
        public int error;
        public int count;
        public KuData data;
    }

    public class KuData {
        public ArrayList<KuItem> items;
    }

    public class KuItem {
        public String id;
        public String title_75;
        public OriginPrice origin_price;
        public String image_item;
    }

    public class OriginPrice {
        public int amount;
        public KuCurrency currency;
    }
    public class KuCurrency{
        public int currency_id;
        public String short_title;
        public String title;
        public String system_name;
    }
}
