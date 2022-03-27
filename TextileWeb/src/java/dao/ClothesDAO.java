/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Clothes;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import java.sql.ResultSet;

/**
 *
 * @author yalci
 */
public class ClothesDAO extends DBConnection {
    
    public void createClothes (Clothes cl) {
        
        try {
            Statement st = this.connect().createStatement();
            
            System.out.println("-------test");
            String query = "insert into clothes (cloth_name) values ('"+ cl.getCloth_name() + "')";
            
            System.out.println(query);
            int r = st.executeUpdate(query);
            
            System.out.println("-------test");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void delete(Clothes cl){
        
        try {
            Statement st = this.connect().createStatement();
            String query2 = "delete from clothes where cloth_id='"+cl.getCloth_id()+"'";
            int r = st.executeUpdate(query2);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void update(Clothes entity) {
        try {
            Statement st = this.connect().createStatement();
            String query2 = "update clothes set cloth_name='"+entity.getCloth_name()+"' where id= "+entity.getCloth_id();
            int r = st.executeUpdate(query2);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Clothes> getClothesList() {
        
        List<Clothes> clothesList = new ArrayList<>();
        
        try {

            Statement st = this.connect().createStatement();

            String query2 = "select * from clothes";
            ResultSet rs = st.executeQuery(query2);

            
            while (rs.next()) {
                clothesList.add(new Clothes(rs.getLong("cloth_id"),rs.getString("cloth_name")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return clothesList;
    }
}
