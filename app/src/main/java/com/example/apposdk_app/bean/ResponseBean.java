package com.example.apposdk_app.bean;

/**
 * @desc:
 * @author: yewei
 * @data: 2023/3/22 14:41
 */
public class ResponseBean {
    private String type;
    private String isSplitScreen;
    private String id;
    private String playModel;
    private String command;
    private String url;
    private String name;
    private String isDownUrl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsSplitScreen() {
        return isSplitScreen;
    }

    public void setIsSplitScreen(String isSplitScreen) {
        this.isSplitScreen = isSplitScreen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsDownUrl() {
        return isDownUrl;
    }

    public void setIsDownUrl(String isDownUrl) {
        this.isDownUrl = isDownUrl;
    }
}
