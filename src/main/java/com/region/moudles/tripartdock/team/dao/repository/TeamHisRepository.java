package com.region.moudles.tripartdock.team.dao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.region.moudles.tripartdock.team.domain.SysTeamHis;

public interface TeamHisRepository extends JpaRepository<SysTeamHis, String> {
	
}
