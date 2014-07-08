/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Farmaco;
import cl.rcehblt.entities.FfFarmaco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface FfFarmacoFacadeLocal {

    void create(FfFarmaco ffFarmaco);

    void edit(FfFarmaco ffFarmaco);

    void remove(FfFarmaco ffFarmaco);

    FfFarmaco find(Object id);

    List<FfFarmaco> findAll();

    List<FfFarmaco> findRange(int[] range);

    int count();
    public List<FfFarmaco> findId(int idfarmaco);
    public List<FfFarmaco> findFarmacoId(Farmaco remedio);
    
}
