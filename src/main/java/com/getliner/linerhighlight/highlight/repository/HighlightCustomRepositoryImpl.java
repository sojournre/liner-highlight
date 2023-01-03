package com.getliner.linerhighlight.highlight.repository;

import static com.getliner.linerhighlight.highlight.mapper.QHighlightSubSelect.highlightSubSelect;

import com.getliner.linerhighlight.highlight.entity.Highlight;
import com.getliner.linerhighlight.page.entity.QWebpage;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HighlightCustomRepositoryImpl implements HighlightCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Highlight> findByUser(long userId) {
        QWebpage webpage = QWebpage.webpage;

        return jpaQueryFactory.select(Projections.fields(Highlight.class,
                        highlightSubSelect.highlightId,
                        highlightSubSelect.user,
                        highlightSubSelect.rowNum,
                        highlightSubSelect.text,
                        highlightSubSelect.themeColor,
                        highlightSubSelect.webpage,
                        highlightSubSelect.updatedAt))
                .from(highlightSubSelect)
//                .leftJoin(webpage).on(highlightSubSelect.webpage.pageId.eq(webpage.pageId))
//                .fetchJoin()
                .where(highlightSubSelect.rowNum.lt(7L)
                        .and(highlightSubSelect.user.userId.eq(userId)))
                .orderBy(highlightSubSelect.updatedAt.desc())
                .fetch();
    }
}
