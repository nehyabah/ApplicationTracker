package com.pm.applicationtracker.repository;

import com.pm.applicationtracker.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository <Application,Long>{
}
