package babble.data.management;

import babble.data.models.BaseEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Applies bookkeeping updates for all Entity tables. Principally the creation/edit tracking data.
 * TODO pretty simple & incomplete implementation. Need a DRY way to have the "By" actor able to reference the current user session
 */
public class EntityBookkeepingListener {

    @PrePersist
    @PreUpdate
    private void beforeWrite(final BaseEntity entity) {
        final Date now = new Date();
        if (entity.getCreatedDateTime() == null) {
            entity.setCreatedDateTime(now);
        }
        if (entity.getCreatedBy() == null) {
            entity.setCreatedBy(BaseEntity.DEFAULT_ACTOR);
            entity.setChangedBy(BaseEntity.DEFAULT_ACTOR);
        }
        entity.setChangedDateTime(now);
    }
}
