package fr.treeptik.leboncoinweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.treeptik.leboncoinweb.pojo.Region;

public interface RegionDAO extends JpaRepository<Region, Integer>{
	
	// TODO : mettre les @Query("select ...")
//	public List<Region>findAllRegionByPrixMoyenLocDesc()throws DAOException;
//	public Double findAvgFromRegion(Region r) throws DAOException;
}
