package web.model.Pcourse;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class AuditListener {

    @PrePersist
    public void onPrePersist() {  }

    @PreUpdate
    public void onPreUpdate() { }

    @PreRemove
    public void onPreRemove() {  }

}
