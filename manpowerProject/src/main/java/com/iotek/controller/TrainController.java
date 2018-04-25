package com.iotek.controller;

import com.iotek.biz.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2018/4/24.
 */
@Controller
public class TrainController {
    @Autowired
    private TrainService trainService;
}
