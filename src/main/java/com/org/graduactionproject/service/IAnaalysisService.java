package com.org.graduactionproject.service;

import org.springframework.web.bind.annotation.Mapping;

public interface IAnaalysisService {
    Integer getRangeReadNum(String begTime, String endTime);
}
