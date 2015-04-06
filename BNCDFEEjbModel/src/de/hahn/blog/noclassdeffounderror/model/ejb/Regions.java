package de.hahn.blog.noclassdeffounderror.model.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries( { @NamedQuery(name = "Regions.findAll", query = "select o from Regions o") })
public class Regions implements Serializable {
    @Id
    @Column(name="REGION_ID", nullable = false)
    private Long regionId;
    @Column(name="REGION_NAME", length = 25)
    private String regionName;

    public Regions() {
    }

    public Regions(Long regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
