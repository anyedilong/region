package com.region.moudles.inspectcenter.poct.service;

import com.region.moudles.inspectcenter.poct.domain.Poct;

import java.util.List;

public interface PoctService {

    List<Poct> getPoctList(Poct poct);

    Poct getPoct(String id);

}
