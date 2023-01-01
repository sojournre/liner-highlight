package com.getliner.linerhighlight.page.repository;

import com.getliner.linerhighlight.page.entity.Webpage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PageRepository extends JpaRepository<Webpage, Long> {
    Optional<Webpage> findByPageUrl(String pageUrl);
}
