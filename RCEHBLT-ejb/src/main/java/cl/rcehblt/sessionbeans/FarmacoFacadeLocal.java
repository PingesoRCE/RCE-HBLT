/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Farmaco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface FarmacoFacadeLocal {

    void create(Farmaco farmaco);

    void edit(Farmaco farmaco);

    void remove(Farmaco farmaco);

    Farmaco find(Object id);

    List<Farmaco> findAll();

    List<Farmaco> findRange(int[] range);

    int count();

    public List<Farmaco> findNombre(String buscaFarmaco);
    
}
