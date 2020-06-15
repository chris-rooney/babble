package babble.data.access;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class RefreshableRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements RefreshableRepository<T, ID> {

    private final EntityManager entityManager;

    public RefreshableRepositoryImpl(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void refresh(final T t) {
        entityManager.refresh(t);
    }
}