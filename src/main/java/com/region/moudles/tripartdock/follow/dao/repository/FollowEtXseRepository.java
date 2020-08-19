package com.region.moudles.tripartdock.follow.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.region.moudles.tripartdock.follow.domain.FollowEtXse;


public interface FollowEtXseRepository extends JpaRepository<FollowEtXse, String> {

    @Query(value = "select * from (select t.*,ROWNUM rn from(" +
            "select b.* from blt_xsefsb b where b.sfsc != '1' or b.sfsc is null order by b.jbrq" +
            ") t where ROWNUM <= :pageSize * :pageNo) where rn > :pageSize * (:pageNo-1)", nativeQuery = true)
    List<FollowEtXse> getAll(@Param("pageNo") String pageNo, @Param("pageSize") String pageSize);

    @Query(value = "select count(*) from blt_xsefsb b where b.sfsc != '1' or b.sfsc is null", nativeQuery = true)
    int getCount();
    
    @Query(value = "select a.* from blt_xsefsb a where (a.sfsc != '1' or a.sfsc is null) and a.jmid = :jmId ", nativeQuery = true)
    List<FollowEtXse> getInfoByJmid(@Param("jmId") String jmId);
    
}
