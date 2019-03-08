package com.example.gaoying20190308.bean;

import java.util.List;

public class UserBean {
 private String msg;
    private List<DataEntity> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public class DataEntity {

        private String sellerid;
        private String sellerName;
        private List<?> list;
        public boolean ischeck;

        public DataEntity(boolean ischeck) {
            this.ischeck = ischeck;
        }

        public boolean isIscheck() {
            return ischeck;
        }

        public void setIscheck(boolean ischeck) {
            this.ischeck = ischeck;
        }

        public void setSellerid(String sellerid) {
            this.sellerid = sellerid;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public void setList(List<?> list) {
            this.list = list;
        }

        public String getSellerid() {
            return sellerid;
        }

        public String getSellerName() {
            return sellerName;
        }

        public List<?> getList() {
            return list;
        }
    }
}
