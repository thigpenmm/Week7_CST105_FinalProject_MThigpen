/**Program: defensivePlayer Program
 *File: defensivePlayer.java
 *Summary: Identifies new defensive player info based on abstract NFLPlayerManager class 
 * and defensivePlayer subclass.
 *Author: Mercedes Thigpen
 *Date: March 30, 2018
 **/
package MyFinalProject;

import javafx.scene.control.CheckBox;

public class defensivePlayer extends NFLPlayerManager {//extending the abstract class
    int tackles;//identifying the new variables of the defensivePlayer subclass
    int sacks;
    int interceptions;
    private CheckBox pick;
    String names;
    String positions;
    
    public defensivePlayer(String name, String position, int tackles, int sacks, int interceptions, String names, String positions) {
        super(name, position);//inherited variables from the abstract NFLPlayerMgr class
        this.tackles = tackles;//new variables of the defensivePlayer class
        this.sacks = sacks;
        this.interceptions = interceptions;
        this.pick = new CheckBox();
        this.names = names;
        this.positions = positions;
        
        //getters and setters for each variable//
    }
 public String getNames(){
            return names;
    }
    public void setNames(String names){
        this.names = names;
    }
   public String getPositions(){
            return positions;
    }
    public void setPositions(String positions){
        this.positions = positions;
    }
    public int getTackles(){
            return tackles;
    }
    public void setTackles(int tackles){
        this.tackles = tackles;
    }              
    public int getSacks(){
            return sacks;
    }
    public void setSacks(int sacks){
        this.sacks = sacks;
    }
    public int getInterceptions(){
            return interceptions;
    }
    public void setInterceptions(int interceptions){
        this.interceptions = interceptions;
    }
    public CheckBox getPick(){
            return pick;
    }
    public void setPick(CheckBox pick){
        this.pick = pick;
    }
    
    
    
    @Override
    public void performance() {//abstract method for performance differences of defensive players
          
    }

    
}
