package edu.upc.data;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.out;
import java.util.List;

import java.util.HashMap;

public class DAO {

    private String queryInsert() {
        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(this.getClass().getSimpleName());
        System.out.println(sb.toString());//substituir por log4java
        sb.append ( "(");
        Field[] misatributos = this.getClass().getDeclaredFields();
        Field atributo;
        int j=0; int totalAtributs = 0;
        StringBuffer values = new StringBuffer();

        for (int i=0; i+1 < misatributos.length; i++){
            atributo = misatributos[i];
            System.out.println(atributo.getName().toString());
            sb.append(atributo.getName().toString()+",");
            values.append("?,");

        }
        values.append("?");
        atributo = misatributos[misatributos.length -1];
        System.out.println(atributo.getName().toString());

        sb.append(atributo.getName().toString());
        sb.append(")VALUES("+values.toString()+")");
        System.out.println(sb);

        return sb.toString();
    }

    public String insert() {
        String theQuery = this.queryInsert(); //instalar mysql amb taules

        Connection con = this.getConnection();


        PreparedStatement pstm = con.prepareStatement(theQuery);

        pstm.setInt(1, 11);
        pstm.setString(2, "ddddd");

        pstm.execute();
        ResultSet rs = pstm.executeQuery();

//        rs.next(); rs.getString(1)

        // releaseConnectoin

    }

}
