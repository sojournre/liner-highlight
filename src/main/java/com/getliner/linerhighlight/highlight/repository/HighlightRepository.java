package com.getliner.linerhighlight.highlight.repository;

import com.getliner.linerhighlight.highlight.entity.Highlight;
import com.getliner.linerhighlight.page.entity.Webpage;
import com.getliner.linerhighlight.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HighlightRepository extends JpaRepository<Highlight, Long>, HighlightCustomRepository {
//    @Query(value = "SELECT h FROM ")
//    Page<Highlight> findByUser(long userId);
    Page<Highlight> findByUserAndWebpage(User user, Webpage webpage, Pageable pageable);
}
