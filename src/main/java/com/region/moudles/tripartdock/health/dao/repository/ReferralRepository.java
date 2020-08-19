package com.region.moudles.tripartdock.health.dao.repository;

import com.region.moudles.tripartdock.health.bean.Referral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReferralRepository extends JpaRepository<Referral, String> {
    @Query("from Referral t where t.id=?1 ")
    Referral getById(String id);
}
