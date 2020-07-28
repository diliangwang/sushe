package DAO;

import beans.susheAndDm;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class susheAndDmDao {

    public List<susheAndDm> allAdmin(){

        ArrayList<susheAndDm> objects = new ArrayList<>();
//        String sql="select* from g_admin ";
        String sql="SELECT dormitory.num as dnum,dormitory.sushe_id as id ,sushe.num  as snum \n" +
                "FROM `dormitory`,sushe \n" +
                "where dormitory.sushe_id=sushe.id ";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDateSource());
        try {
            objects = (ArrayList<susheAndDm>) queryRunner.query(sql, new BeanListHandler<susheAndDm>(susheAndDm.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
