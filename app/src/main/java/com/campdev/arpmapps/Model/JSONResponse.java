package com.campdev.arpmapps.Model;

import java.util.List;

public class JSONResponse {

    public String response;
    String value;
    String message;
    List<DataMobil> result;

    public JSONResponse(String response, String value, String message, List<DataMobil> result) {
        this.response = response;
        this.value = value;
        this.message = message;
        this.result = result;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataMobil> getResult() {
        return result;
    }

    public void setResult(List<DataMobil> result) {
        this.result = result;
    }
}
