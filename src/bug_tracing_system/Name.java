/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bug_tracing_system;

import java.sql.SQLException;

/**
 *
 * @author husse
 */
public interface Name  {
    
        public String getName(int id) throws SQLException, ClassNotFoundException;    
          
}
