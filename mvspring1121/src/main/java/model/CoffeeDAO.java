package model;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.ResultSetExtractor;  
import org.springframework.jdbc.core.RowMapper;  
  
public class CoffeeDAO {  
private JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
  
public List<Coffee> getAllEmployeesRowMapper(){  
 return template.query("select * from classicmodels.Coffees",new RowMapper<Coffee>(){  
    @Override  
    public Coffee mapRow(ResultSet rs, int rownumber) throws SQLException {  
    	Coffee c=new Coffee();  
        c.setCofName(rs.getString("cof_Name"));
        c.setSupId(rs.getInt("SUP_ID"));
        c.setPrice(rs.getDouble("price"));
        c.setSales(rs.getInt("sales"));
        c.setTotal(rs.getInt("total"));
        return c;  
    }  
    });  
}  
}  

