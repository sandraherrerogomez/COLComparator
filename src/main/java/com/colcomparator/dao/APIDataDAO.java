package com.colcomparator.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.colcomparator.model.APIDataDaoEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface APIDataDAO extends CrudRepository<APIDataDaoEntity, String> {

}
