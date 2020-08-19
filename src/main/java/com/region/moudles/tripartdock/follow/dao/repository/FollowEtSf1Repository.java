package com.region.moudles.tripartdock.follow.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.region.moudles.tripartdock.follow.domain.FollowEtSf1;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FollowEtSf1Repository extends JpaRepository<FollowEtSf1, String> {

    @Query(value = "select * from (select t.*,ROWNUM rn from(" +
            "select b.* from blt_1synjkjcjlb b where b.sfsc != '1' or b.sfsc is null order by b.jbrq" +
            ") t where ROWNUM <= :pageSize * :pageNo) where rn > :pageSize * (:pageNo-1)", nativeQuery = true)
    List<FollowEtSf1> getAll(@Param("pageNo") String pageNo, @Param("pageSize") String pageSize);

    @Query(value = "select count(*) from blt_1synjkjcjlb b where b.sfsc != '1' or b.sfsc is null", nativeQuery = true)
    int getCount();
}
