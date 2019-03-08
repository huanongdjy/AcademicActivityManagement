package com.org.graduactionproject.service;

import com.org.graduactionproject.commons.InfoPageJSONBean;
import com.org.graduactionproject.domain.Essay;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface IEssayService {
    List<Map<String,Object>> findEssayByTitle(String title);
    int addEssay(String title, String author, String summary, Timestamp holdtime, String location,
                 String content, /*String precautions,*/ String fund, String organizer, Integer planned_attendance,
                 Integer type_id/*, boolean toshow*/);
    int updateIndex(int id, int index);
    List<Essay> findEssayByType_name(String type_name);
    InfoPageJSONBean getInfoPage(int size, int page, String type);
    int updateRead_num(int id);
}
