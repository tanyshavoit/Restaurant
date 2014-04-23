/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

/**
 *
 * @author tanysha
 */
public class CShowAddPerssF implements Command {

    public void execute() {
       new AddPersonnelFrame().setVisible(true);
    }
    
}
