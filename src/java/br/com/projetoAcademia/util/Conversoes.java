/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoAcademia.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ERICMASSAITIUEMURA
 */
public class Conversoes {
    
    public static Date converterData(String data) throws Exception{
        if(data !=null || !data.trim().equals("")){
            try{
                Date fmt = new SimpleDateFormat("yyyy-MM-dd").parse(data);
                return fmt;
            }catch(Exception ex){
                throw new Exception(ex.getMessage());        
            }
        }else{
            return null;
        }
    }
}
  

