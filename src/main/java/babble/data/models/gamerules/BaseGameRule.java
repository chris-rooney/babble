package babble.data.models.gamerules;

import babble.data.models.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Base for semi-static data tables. The sorts of things that have an official state but could be house-ruled.
 * Another source of differences would be LRB versions & BB2016 versions.
 * TODO maybe should pull default+league_id out into RuleSets and have a reference back to those be the rule's FK
 */
@MappedSuperclass
public abstract class BaseGameRule extends BaseEntity {

    @Column(name = "default")
    private boolean isDefault;

    @Column(name = "league_id")
    private Long leagueId;

    public boolean isDefault() {
        return isDefault;
    }

    public BaseGameRule setDefault(final boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    public Long isLeagueId() {
        return leagueId;
    }

    public BaseGameRule setLeagueId(final Long leagueId) {
        this.leagueId = leagueId;
        return this;
    }
}
