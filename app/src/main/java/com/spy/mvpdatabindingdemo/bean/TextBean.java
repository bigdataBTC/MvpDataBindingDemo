package com.xinmang.mvpdatabindingdemo.bean;

import java.util.List;



public class TextBean {

    /**
     * code : 200
     * message : success
     * data : [{"title":"测试1","picUrl":"https://pic-1256006121.cos.ap-beijing.myqcloud.com/pic/qidongye.png"},{"title":"测试2","picUrl":"https://pic-1256006121.cos.ap-beijing.myqcloud.com/pic/qidongye.png"},{"title":"测试3","picUrl":"https://pic-1256006121.cos.ap-beijing.myqcloud.com/pic/qidongye.png"},{"title":"测试4","picUrl":"https://pic-1256006121.cos.ap-beijing.myqcloud.com/pic/qidongye.png"},{"title":"测试5","picUrl":"https://pic-1256006121.cos.ap-beijing.myqcloud.com/pic/qidongye.png"}]
     */

    private String code;
    private String message;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 测试1
         * picUrl : https://pic-1256006121.cos.ap-beijing.myqcloud.com/pic/qidongye.png
         */

        private String title;
        private String picUrl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }
    }
}
