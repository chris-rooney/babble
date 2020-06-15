package babble.data.models;

import babble.data.management.EntityBookkeepingListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Bookkeeping data that gets attached to each entity table. E.g. creation/editing tracking data
 */
@MappedSuperclass
@EntityListeners({EntityBookkeepingListener.class})
public abstract class BaseEntity {

    public static final String DEFAULT_ACTOR = "system";

    @Column(name = "created_date_time")
    private Date createdDateTime;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "changed_date_time")
    private Date changedDateTime;

    @Column(name = "changed_by")
    private String changedBy;

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public BaseEntity setCreatedDateTime(final Date createdDateTime) {
        this.createdDateTime = createdDateTime;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public BaseEntity setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getChangedDateTime() {
        return changedDateTime;
    }

    public BaseEntity setChangedDateTime(final Date changedDateTime) {
        this.changedDateTime = changedDateTime;
        return this;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public BaseEntity setChangedBy(final String changedBy) {
        this.changedBy = changedBy;
        return this;
    }
}
