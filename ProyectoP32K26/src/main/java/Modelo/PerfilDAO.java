/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Perfil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Meilyn Garcia 9959-23-17838
 */
public class PerfilDAO {
    Connection con;

    public void insert(Perfil perfil){

        try{

            con = Conexion.getConnection();

            PreparedStatement ps = con.prepareStatement(
            "INSERT INTO perfiles (PerNombre, PerEstado) VALUES (?, ?)");

            ps.setString(1, perfil.getPerNombre());
            ps.setString(2, perfil.getPerEstado());

            ps.executeUpdate();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void update(Perfil perfil){

        try{

            con = Conexion.getConnection();

            PreparedStatement ps = con.prepareStatement(
            "UPDATE perfiles SET PerNombre=?, PerEstado=? WHERE PerCodigo=?");

            ps.setString(1, perfil.getPerNombre());
            ps.setString(2, perfil.getPerEstado());
            ps.setInt(3, perfil.getPerCodigo());

            ps.executeUpdate();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void delete(Perfil perfil){

        try{

            con = Conexion.getConnection();

            PreparedStatement ps = con.prepareStatement(
            "DELETE FROM perfiles WHERE PerCodigo=?");

            ps.setInt(1, perfil.getPerCodigo());

            ps.executeUpdate();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public List<Perfil> select(){

        List<Perfil> lista = new ArrayList<>();

        try{

            con = Conexion.getConnection();

            PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM perfiles");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Perfil perfil = new Perfil();

                perfil.setPerCodigo(rs.getInt("PerCodigo"));
                perfil.setPerNombre(rs.getString("PerNombre"));
                perfil.setPerEstado(rs.getString("PerEstado"));

                lista.add(perfil);
            }

        }catch(Exception e){
            System.out.println(e);
        }

        return lista;
    }

    public Perfil query(Perfil perfil){

        try{

            con = Conexion.getConnection();

            PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM perfiles WHERE PerCodigo=?");

            ps.setInt(1, perfil.getPerCodigo());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                perfil.setPerNombre(rs.getString("PerNombre"));
                perfil.setPerEstado(rs.getString("PerEstado"));

                return perfil;
            }

        }catch(Exception e){
            System.out.println(e);
        }

        return null;
    }
}
