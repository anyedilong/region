package com.region.moudles.tripartdock.follow.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.region.moudles.tripartdock.follow.domain.FollowEtJb;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FollowEtJbRepository extends JpaRepository<FollowEtJb, String> {

}
