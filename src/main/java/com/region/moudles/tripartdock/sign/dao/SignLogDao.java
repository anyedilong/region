package com.region.moudles.tripartdock.sign.dao;

import javax.inject.Named;

import com.region.moudles.common.dao.BaseDao;
import com.region.moudles.tripartdock.sign.dao.repository.SignLogRepository;
import com.region.moudles.tripartdock.sign.domain.SignLog;


@Named
public class SignLogDao extends BaseDao<SignLogRepository, SignLog> {


}
