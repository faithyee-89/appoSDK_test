package com.example.apposdk_app.bean;

/**
 * @desc:
 * @author: yewei
 * @data: 2023/3/22 14:41
 */
public class ResponseBean {
    private String type;
    private String splitScreen;
    private String contentId;
    private String playModel;
    private String command;
    private String url;
    private String contentName;
    private String downUrl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSplitScreen() {
        return splitScreen;
    }

    public void setSplitScreen(String splitScreen) {
        this.splitScreen = splitScreen;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getPlayModel() {
        return playModel;
    }

    public void setPlayModel(String playModel) {
        this.playModel = playModel;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }
}
