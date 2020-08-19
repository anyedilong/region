package com.region.moudles.tripartdock.team.dao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.region.moudles.tripartdock.team.domain.SysTeamUser;

public interface TeamUserRepository extends JpaRepository<SysTeamUser, String> {


}
