/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tanysha
 */
public class CommandHelper {
    private static CommandHelper reference;
     List<Command> commands = new ArrayList<Command>();
     
    private CommandHelper(){
        commands.add(new CShowAddCateF());
        commands.add(new CShowDeleteCateF());
        commands.add(new CShowSearchP());
    };
       public static CommandHelper getReference(){
         if (reference==null){
             reference = new CommandHelper();
         }
         return reference;
     }
       
    public void getCommandandDo(Command cm) {
        Command command ;
      
        for(int i=0; i<commands.toArray().length;i++){
       if( (cm instanceof CShowAddCateF) &&(commands.get(i) instanceof CShowAddCateF) ) {
        command= cm; command.execute();
  } 
      else if( (cm instanceof  CShowDeleteCateF) &&(commands.get(i) instanceof CShowDeleteCateF )) {
        command= cm; command.execute();
  } 
      else if( (cm instanceof CShowSearchP) &&(commands.get(i) instanceof CShowSearchP) ) {
        command= cm; command.execute();
  } 
        }
}
}
