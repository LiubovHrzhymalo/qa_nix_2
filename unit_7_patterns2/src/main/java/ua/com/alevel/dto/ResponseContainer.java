package ua.com.alevel.dto;

public class ResponseContainer<DATA> {
    private DATA data;

    public ResponseContainer() {
    }

    public ResponseContainer(DATA data) {
        this.data = data;
    }

    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }
}
