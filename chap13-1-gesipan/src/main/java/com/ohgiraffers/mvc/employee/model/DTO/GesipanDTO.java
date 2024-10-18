package com.ohgiraffers.mvc.employee.model.DTO;

public class GesipanDTO {

    String Id;

    String title;

    String contents;

    public GesipanDTO() {

    }

    public GesipanDTO(String id, String title, String contents) {
        Id = id;
        this.title = title;
        this.contents = contents;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "GesipanDTO{" +
                "Id='" + Id + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
