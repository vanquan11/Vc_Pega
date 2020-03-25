package com.example.vc_pega.Model;

import java.util.List;

public class ListDataPG {
    public List<DataPG> dataList;
    public int boxId;
    public int type;

    public ListDataPG(List<DataPG> dataList, int boxId, int type) {
        this.dataList = dataList;
        this.boxId = boxId;
        this.type = type;
    }

    public List<DataPG> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataPG> dataList) {
        this.dataList = dataList;
    }

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
