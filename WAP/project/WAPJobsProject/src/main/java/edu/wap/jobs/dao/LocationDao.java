package edu.wap.jobs.dao;

import edu.wap.jobs.domain.Company;
import edu.wap.jobs.domain.Location;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LocationDao extends GenericDao<Location>{

    public LocationDao() {
        super(Location.class);
    }
}
