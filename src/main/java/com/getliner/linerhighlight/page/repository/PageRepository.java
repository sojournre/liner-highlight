package com.getliner.linerhighlight.page.repository;

import com.getliner.linerhighlight.page.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PageRepository extends JpaRepository<Page, Long> {
    Optional<Page> findByPageUrl(String pageUrl);
}
