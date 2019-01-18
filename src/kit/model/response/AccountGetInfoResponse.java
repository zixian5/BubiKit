package kit.model.response;

import com.google.gson.Gson;

import java.util.List;

public class AccountGetInfoResponse {
    /**
     * error_code : 0
     * result : {"address":"a002423c235a7ba9649347ff85b6be1c51980d1eff0398","assets":[{"amount":1400,"property":{"code":"CNY","issuer":"a002423c235a7ba9649347ff85b6be1c51980d1eff0398"}},{"amount":1000,"property":{"code":"USD","issuer":"a002423c235a7ba9649347ff85b6be1c51980d1eff0398"}}],"assets_hash":"9696b03e4c3169380882e0217a986717adfc5877b495068152e6aa25370ecf4a","contract":null,"metadatas":[{"key":"123","value":"123_value","version":1},{"key":"456","value":"456_value","version":1},{"key":"abcd","value":"abcd_value","version":1}],"nonce":1,"priv":{"master_weight":1,"thresholds":{"tx_threshold":1}},"storage_hash":"82c8407cc7cd77897be3100c47ed9d43ec4097ee1c00e2c13447187e5b1ac66c"}
     */

    private int error_code;
    private ResultBean result;

    public static AccountGetInfoResponse objectFromData(String str) {

        return new Gson().fromJson(str, AccountGetInfoResponse.class);
    }

    @Override
    public String toString() {
        return "AccountGetInfoResponse{" +
                "error_code=" + error_code +
                ", result=" + result +
                '}';
    }

    public static AccountGetInfoResponse objectFromData(String str, String key) {

        try {
            org.json.JSONObject jsonObject = new org.json.JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), AccountGetInfoResponse.class);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * address : a002423c235a7ba9649347ff85b6be1c51980d1eff0398
         * assets : [{"amount":1400,"property":{"code":"CNY","issuer":"a002423c235a7ba9649347ff85b6be1c51980d1eff0398"}},{"amount":1000,"property":{"code":"USD","issuer":"a002423c235a7ba9649347ff85b6be1c51980d1eff0398"}}]
         * assets_hash : 9696b03e4c3169380882e0217a986717adfc5877b495068152e6aa25370ecf4a
         * contract : null
         * metadatas : [{"key":"123","value":"123_value","version":1},{"key":"456","value":"456_value","version":1},{"key":"abcd","value":"abcd_value","version":1}]
         * nonce : 1
         * priv : {"master_weight":1,"thresholds":{"tx_threshold":1}}
         * storage_hash : 82c8407cc7cd77897be3100c47ed9d43ec4097ee1c00e2c13447187e5b1ac66c
         */

        private String address;
        private String assets_hash;
        private Object contract;
        private int nonce;
        private PrivBean priv;
        private String storage_hash;
        private List<AssetsBean> assets;
        private List<MetadatasBean> metadatas;

        public static ResultBean objectFromData(String str) {

            return new Gson().fromJson(str, ResultBean.class);
        }

        public static ResultBean objectFromData(String str, String key) {

            try {
                org.json.JSONObject jsonObject = new org.json.JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ResultBean.class);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "address='" + address + '\'' +
                    ", assets_hash='" + assets_hash + '\'' +
                    ", contract=" + contract +
                    ", nonce=" + nonce +
                    ", priv=" + priv +
                    ", storage_hash='" + storage_hash + '\'' +
                    ", assets=" + assets +
                    ", metadatas=" + metadatas +
                    '}';
        }

        public String getAssets_hash() {
            return assets_hash;
        }

        public void setAssets_hash(String assets_hash) {
            this.assets_hash = assets_hash;
        }

        public Object getContract() {
            return contract;
        }

        public void setContract(Object contract) {
            this.contract = contract;
        }

        public int getNonce() {
            return nonce;
        }

        public void setNonce(int nonce) {
            this.nonce = nonce;
        }

        public PrivBean getPriv() {
            return priv;
        }

        public void setPriv(PrivBean priv) {
            this.priv = priv;
        }

        public String getStorage_hash() {
            return storage_hash;
        }

        public void setStorage_hash(String storage_hash) {
            this.storage_hash = storage_hash;
        }

        public List<AssetsBean> getAssets() {
            return assets;
        }

        public void setAssets(List<AssetsBean> assets) {
            this.assets = assets;
        }

        public List<MetadatasBean> getMetadatas() {
            return metadatas;
        }

        public void setMetadatas(List<MetadatasBean> metadatas) {
            this.metadatas = metadatas;
        }

        public static class PrivBean {
            /**
             * master_weight : 1
             * thresholds : {"tx_threshold":1}
             */

            private int master_weight;
            private ThresholdsBean thresholds;

            public static PrivBean objectFromData(String str) {

                return new Gson().fromJson(str, PrivBean.class);
            }

            public static PrivBean objectFromData(String str, String key) {

                try {
                    org.json.JSONObject jsonObject = new org.json.JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), PrivBean.class);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            public String toString() {
                return "PrivBean{" +
                        "master_weight=" + master_weight +
                        ", thresholds=" + thresholds +
                        '}';
            }

            public int getMaster_weight() {
                return master_weight;
            }

            public void setMaster_weight(int master_weight) {
                this.master_weight = master_weight;
            }

            public ThresholdsBean getThresholds() {
                return thresholds;
            }

            public void setThresholds(ThresholdsBean thresholds) {
                this.thresholds = thresholds;
            }

            public static class ThresholdsBean {
                /**
                 * tx_threshold : 1
                 */

                private int tx_threshold;

                public static ThresholdsBean objectFromData(String str) {

                    return new Gson().fromJson(str, ThresholdsBean.class);
                }

                public static ThresholdsBean objectFromData(String str, String key) {

                    try {
                        org.json.JSONObject jsonObject = new org.json.JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), ThresholdsBean.class);
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                @Override
                public String toString() {
                    return "ThresholdsBean{" +
                            "tx_threshold=" + tx_threshold +
                            '}';
                }

                public int getTx_threshold() {
                    return tx_threshold;
                }

                public void setTx_threshold(int tx_threshold) {
                    this.tx_threshold = tx_threshold;
                }
            }
        }

        public static class AssetsBean {
            /**
             * amount : 1400
             * property : {"code":"CNY","issuer":"a002423c235a7ba9649347ff85b6be1c51980d1eff0398"}
             */

            private int amount;
            private PropertyBean property;

            public static AssetsBean objectFromData(String str) {

                return new Gson().fromJson(str, AssetsBean.class);
            }

            public static AssetsBean objectFromData(String str, String key) {

                try {
                    org.json.JSONObject jsonObject = new org.json.JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), AssetsBean.class);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public PropertyBean getProperty() {
                return property;
            }

            public void setProperty(PropertyBean property) {
                this.property = property;
            }

            public static class PropertyBean {
                /**
                 * code : CNY
                 * issuer : a002423c235a7ba9649347ff85b6be1c51980d1eff0398
                 */

                private String code;
                private String issuer;

                public static PropertyBean objectFromData(String str) {

                    return new Gson().fromJson(str, PropertyBean.class);
                }

                public static PropertyBean objectFromData(String str, String key) {

                    try {
                        org.json.JSONObject jsonObject = new org.json.JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), PropertyBean.class);
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getIssuer() {
                    return issuer;
                }

                public void setIssuer(String issuer) {
                    this.issuer = issuer;
                }
            }
        }

        public static class MetadatasBean {
            /**
             * key : 123
             * value : 123_value
             * version : 1
             */

            private String key;
            private String value;
            private int version;

            public static MetadatasBean objectFromData(String str) {

                return new Gson().fromJson(str, MetadatasBean.class);
            }

            public static MetadatasBean objectFromData(String str, String key) {

                try {
                    org.json.JSONObject jsonObject = new org.json.JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), MetadatasBean.class);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }
        }
    }
}
