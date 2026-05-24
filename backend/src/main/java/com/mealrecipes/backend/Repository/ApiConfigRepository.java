package com.mealrecipes.backend.Repository;

import com.mealrecipes.backend.Entity.apiConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiConfigRepository extends JpaRepository<apiConfig,Long> {
    apiConfig findByName(String name);
}
