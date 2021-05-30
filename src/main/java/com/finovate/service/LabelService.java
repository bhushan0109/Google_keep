package com.finovate.service;

import com.finovate.dto.LabelDto;
import com.finovate.model.Label;
import com.finovate.model.Response;

import java.util.Set;

public interface LabelService {
    Label create(LabelDto labelDto, String token);
    Response update(LabelDto labelDto, int id, String token);
    Response delete(int id, String token);
    Set<Label> getAllLabels(String token);
    Label getLabel(int id, String token) ;
}
