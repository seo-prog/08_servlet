package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.DAO.GesipanDAO;
import com.ohgiraffers.mvc.employee.model.DTO.GesipanDTO;

public class GesipanService {

    private final GesipanDAO empDAO;

    public GesipanService(){
        empDAO = new GesipanDAO();
    }

    public GesipanDTO getGesipan(int id){}
}
