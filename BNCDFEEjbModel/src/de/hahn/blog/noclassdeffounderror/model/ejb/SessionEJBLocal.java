package de.hahn.blog.noclassdeffounderror.model.ejb;

import java.util.List;

import javax.ejb.Local;


@Local
public interface SessionEJBLocal {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    Regions persistRegions(Regions regions);

    Regions mergeRegions(Regions regions);

    void removeRegions(Regions regions);

    List<Regions> getRegionsFindAll();
}
