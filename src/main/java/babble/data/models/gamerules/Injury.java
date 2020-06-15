package babble.data.models.gamerules;

import javax.persistence.*;

@Entity
@Table(name = "injury")
public class Injury extends BaseGameRule {

    public enum Effect {
        NIGGLE, MA_BUST, ST_BUST, AG_BUST, AV_BUST // TODO Anything else?
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long injuryId;

    @Column(name = "name")
    private String name;

    @Column(name = "effect")
    @Enumerated(EnumType.STRING)
    private Effect effect;

    public Long getInjuryId() {
        return injuryId;
    }

    public String getName() {
        return name;
    }

    public Effect getEffect() {
        return effect;
    }
}
